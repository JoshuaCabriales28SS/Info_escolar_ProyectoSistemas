const API = "http://localhost:8080";

const dependencias = {
    unidades:   [{ entidad: "divisiones",  fk: "unidades_id",   label: "Divisiones"  }],
    divisiones: [{ entidad: "carreras",    fk: "divisiones_id", label: "Carreras"    }],
    carreras:   [{ entidad: "grupos",      fk: "carreras_id",   label: "Grupos"      }],
    materias:   [{ entidad: "grupos",      fk: "materias_id",   label: "Grupos"      }],
    profesores: [
                  { entidad: "tutores",    fk: "profesores_id", label: "Tutores"     },
                  { entidad: "grupos",     fk: "profesores_id", label: "Grupos"      }
                ],
    grupos:     [{ entidad: "alumnos",     fk: "grupos_id",     label: "Alumnos"     }],
    tutores:    [], 
    alumnos:    [], 
};

const cambiarFormulario = () => {
    const entidad = document.getElementById("entitySelect").value;
    const info    = infoEntidad(entidad);

    document.getElementById("formArea").innerHTML = `
        <div class="full buscar-bar">
            <label>ID de ${info.nombre} a eliminar</label>
            <div class="buscar-row">
                <input id="buscarId" type="number" placeholder="Ej. 3" min="1">
                <button class="btn-buscar" onclick="buscar()">Buscar</button>
            </div>
        </div>
        <div id="preview" class="preview-box" style="display:none"></div>
    `;
    ocultarMsg();
};

const infoEntidad = (entidad) => {
    const map = {
        alumnos:    { nombre: "Alumno"},
        materias:   { nombre: "Materia"},
        carreras:   { nombre: "Carrera"},
        divisiones: { nombre: "División"},
        grupos:     { nombre: "Grupo"},
        profesores: { nombre: "Profesor"},
        tutores:    { nombre: "Tutor"},
        unidades:   { nombre: "Unidad"},
    };
    return map[entidad] || { nombre: entidad};
};

const buscar = async () => {
    const entidad = document.getElementById("entitySelect").value;
    const id      = document.getElementById("buscarId").value.trim();
    const preview = document.getElementById("preview");

    if (!id) return mostrarMsg("Ingresa un ID para buscar.", false);

    ocultarMsg();
    preview.style.display = "none";

    try {
        const res = await fetch(`${API}/${entidad}/${id}`);
        if (res.status === 404) throw new Error("Registro no encontrado.");
        if (!res.ok)            throw new Error(`HTTP ${res.status}`);
        const data = await res.json();

        const deps = dependencias[entidad] || [];
        const conflictos = [];

        for (const dep of deps) {
            try {
                const depRes  = await fetch(`${API}/${dep.entidad}`);
                if (!depRes.ok) continue;
                const depData = await depRes.json();

                const lista = Array.isArray(depData) ? depData : (depData.content ?? []);
                const relacionados = lista.filter(item => item[dep.fk] == id);

                if (relacionados.length > 0) {
                    conflictos.push({ label: dep.label, cantidad: relacionados.length, entidad: dep.entidad });
                }
            } catch (_) {  }
        }

        const filas = Object.entries(data)
            .map(([k, v]) => `<tr><td class="preview-key">${k}</td><td>${v ?? "—"}</td></tr>`)
            .join("");

        let avisoHTML = "";
        if (conflictos.length > 0) {
            const lista = conflictos
                .map(c => `<li><strong>${c.label}</strong>: ${c.cantidad} registro(s) relacionado(s)</li>`)
                .join("");
            avisoHTML = `
                <div class="aviso-dependencias">
                    <p><strong>No se puede eliminar este registro.</strong><br>
                    Primero elimina las siguientes relaciones:</p>
                    <ul>${lista}</ul>
                </div>`;
        }

        preview.innerHTML = `
            <p class="preview-titulo">Registro encontrado:</p>
            <table class="preview-table"><tbody>${filas}</tbody></table>
            ${avisoHTML}
        `;
        preview.style.display = "block";

        preview.dataset.bloqueado = conflictos.length > 0 ? "true" : "false";

        if (conflictos.length === 0) {
            mostrarMsg("Registro listo para eliminar. Presiona el botón Eliminar.", true);
        }

    } catch (err) {
        mostrarMsg(`Error: ${err.message}`, false);
    }
};

const eliminar = async () => {
    const entidad = document.getElementById("entitySelect").value;
    const id      = document.getElementById("buscarId").value.trim();
    const preview = document.getElementById("preview");

    if (!id) return mostrarMsg("Primero busca un registro por ID.", false);

    if (preview.dataset.bloqueado === "true") {
        return mostrarMsg("Elimina primero los registros relacionados antes de continuar.", false);
    }

    if (!confirm(`¿Estás seguro de eliminar este ${infoEntidad(entidad).nombre} con ID ${id}? Esta acción no se puede deshacer.`)) return;

    try {
        const res = await fetch(`${API}/${entidad}/${id}`, { method: "DELETE" });

        if (res.status === 409) {
            mostrarMsg("El backend reportó un conflicto de clave foránea. Elimina primero los registros relacionados.", false);
            return;
        }
        if (!res.ok) throw new Error(`HTTP ${res.status}`);

        mostrarMsg(`✓ ${infoEntidad(entidad).nombre} con ID ${id} eliminado correctamente.`, true);
        limpiar();

    } catch (err) {
        mostrarMsg(`Error: ${err.message}`, false);
    }
};

const limpiar = () => {
    document.getElementById("buscarId").value  = "";
    const preview = document.getElementById("preview");
    if (preview) { preview.style.display = "none"; preview.dataset.bloqueado = "false"; }
    ocultarMsg();
};

const ocultarMsg = () => { document.getElementById("msg").style.display = "none"; };
const mostrarMsg = (txt, ok) => {
    const el      = document.getElementById("msg");
    el.textContent = txt;
    el.className   = ok ? "ok" : "err";
    el.style.display = "block";
};

cambiarFormulario();