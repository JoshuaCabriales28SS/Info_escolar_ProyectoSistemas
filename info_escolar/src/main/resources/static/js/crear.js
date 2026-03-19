const API = "http://localhost:8080";

const campos = {
    unidades:   [["nombre","Nombre","text","Ej. Cálculo Diferencial",true]],
    materias:   [["nombre","Nombre","text","Ej. Álgebra Lineal",true]],
    profesores: [["nombre","Nombre","text","Ej. Dr. Juan López",true]],
    tutores:    [["profesores_id","ID Profesor","number","FK → profesores.id",true]],
    divisiones: [["nombre","Nombre","text","Ej. CBS",true], ["unidades_id","ID Unidad","number","FK → unidades.id"]],
    carreras:   [["nombre","Nombre","text","Ej. Ing. en Computación",true], ["divisiones_id","ID División","number","FK → divisiones.id"]],
    grupos:     [
        ["grupo","Nombre del Grupo","text","Ej. Grupo A"],
        ["trimestre","Trimestre","text","Ej. 25-O"],
        ["carreras_id","ID Carrera","number","FK → carreras.id"],
        ["profesores_id","ID Profesor","number","FK → profesores.id"],
        ["materias_id","ID Materia","number","FK → materias.id"]
    ],
    alumnos: [
        ["nombre","Nombre","text","Ej. María"],
        ["apellidoPaterno","Apellido Paterno","text","Ej. García"],
        ["apellidoMaterno","Apellido Materno","text","Ej. Martínez"],
        ["matricula","Matrícula","number","Ej. 2210001"],
        ["nacionalidad","Nacionalidad","text","Ej. Mexicana"],
        ["promedio","Promedio","number","Ej. 8.5"],
        ["grupos_id","ID Grupo","number","FK → grupos.id"],
        ["graduado","Graduado","number","0 = No, 1 = Sí"]
    ]
};

const cambiarFormulario = () => {
    const entidad = document.getElementById("entitySelect").value;
    document.getElementById("formArea").innerHTML = campos[entidad]
        .map(([id, label, type, ph, full]) => `
            <div class="${full ? "full" : ""}">
                <label>${label}</label>
                <input id="${id}" type="${type}" placeholder="${ph}">
            </div>`).join("");
    ocultarMsg();
};

const crear = () => {
    const entidad = document.getElementById("entitySelect").value;
    const body = {};
    for (const [id, label, type] of campos[entidad]) {
        const val = document.getElementById(id).value.trim();
        if (!val) return mostrarMsg(`El campo "${label}" es obligatorio.`, false);
        body[id] = type === "number" ? Number(val) : val;
    }
    fetch(`${API}/${entidad}`, { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(body) })
        .then(res => { if (!res.ok) throw new Error(`HTTP ${res.status}`); return res.json(); })
        .then(() => { mostrarMsg("✓ Registro creado correctamente.", true); limpiar(); })
        .catch(err => mostrarMsg(`Error: ${err.message}`, false));
};

const limpiar    = () => { document.querySelectorAll("#formArea input").forEach(i => i.value = ""); ocultarMsg(); };
const ocultarMsg = () => { document.getElementById("msg").style.display = "none"; };
const mostrarMsg = (txt, ok) => { const el = document.getElementById("msg"); el.textContent = txt; el.className = ok ? "ok" : "err"; el.style.display = "block"; };

cambiarFormulario();
