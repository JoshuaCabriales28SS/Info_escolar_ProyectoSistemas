const API = "http://localhost:8080";

const campos = {
    unidades:   [["nombre","Nombre","text","Ej. Cuajimalpa",true]],
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
        ["matricula","Matrícula","number","Ej. 2233030310"],
        ["nacionalidad","Nacionalidad","text","Ej. Mexicana"],
        ["promedio","Promedio","number","Ej. 8.50"],
        ["grupos_id","ID Grupo","number","FK → grupos.id"],
        ["graduado","Graduado","number","0 = No, 1 = Sí"]
    ]
};

const cambiarFormulario = () => {
    const entidad = document.getElementById("entitySelect").value;

    document.getElementById("formArea").innerHTML = `
        <div class="full buscar-bar">
            <label>ID del registro a editar</label>
            <div class="buscar-row">
                <input id="buscarId" type="number" placeholder="Ej. 3" min="1">
                <button class="btn-buscar" onclick="buscar()">Buscar</button>
            </div>
        </div>
        <hr class="separador">
        ${campos[entidad].map(([id, label, type, ph, full]) => `
            <div class="${full ? "full" : ""}">
                <label>${label}</label>
                <input id="${id}" type="${type}" placeholder="${ph}" disabled>
            </div>`).join("")}
    `;
    ocultarMsg();
};

const buscar = () => {
    const entidad = document.getElementById("entitySelect").value;
    const id = document.getElementById("buscarId").value.trim();

    if (!id) return mostrarMsg("Ingresa un ID para buscar.", false);

    fetch(`${API}/${entidad}/${id}`)
        .then(res => {
            if (res.status === 404) throw new Error("Registro no encontrado.");
            if (!res.ok) throw new Error(`HTTP ${res.status}`);
            return res.json();
        })
        .then(data => {
            for (const [fieldId, , type] of campos[entidad]) {
                const input = document.getElementById(fieldId);
                if (input) {
                    input.value = data[fieldId] ?? "";
                    input.disabled = false;
                }
            }
            mostrarMsg(`Registro encontrado. Modifica los campos y presiona Editar.`, true);
        })
        .catch(err => {
            campos[entidad].forEach(([fieldId]) => {
                const input = document.getElementById(fieldId);
                if (input) { input.value = ""; input.disabled = true; }
            });
            mostrarMsg(`Error: ${err.message}`, false);
        });
};

const editar = () => {
    const entidad = document.getElementById("entitySelect").value;
    const id = document.getElementById("buscarId").value.trim();

    if (!id) return mostrarMsg("Primero busca un registro por ID.", false);

    const body = {};
    for (const [fieldId, label, type] of campos[entidad]) {
        const val = document.getElementById(fieldId).value.trim();
        if (!val) return mostrarMsg(`El campo "${label}" es obligatorio.`, false);
        body[fieldId] = type === "number" ? Number(val) : val;
    }

    fetch(`${API}/${entidad}/${id}`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    })
        .then(res => {
            if (!res.ok) throw new Error(`HTTP ${res.status}`);
            return res.json();
        })
        .then(() => {
            mostrarMsg("Registro actualizado correctamente.", true);
            limpiar();
        })
        .catch(err => mostrarMsg(`Error: ${err.message}`, false));
};

const limpiar = () => {
    document.getElementById("buscarId").value = "";
    campos[document.getElementById("entitySelect").value].forEach(([id]) => {
        const input = document.getElementById(id);
        if (input) { input.value = ""; input.disabled = true; }
    });
    ocultarMsg();
};

const ocultarMsg = () => { document.getElementById("msg").style.display = "none"; };
const mostrarMsg = (txt, ok) => {
    const el = document.getElementById("msg");
    el.textContent = txt;
    el.className = ok ? "ok" : "err";
    el.style.display = "block";
};

cambiarFormulario();