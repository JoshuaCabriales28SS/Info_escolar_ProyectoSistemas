    const API = "http://localhost:8080";

    const buscar = () => {
        const entidad = document.getElementById("entitySelect").value;
        const texto   = document.getElementById("searchInput").value.toLowerCase().trim();
        const area    = document.getElementById("displayArea");

        area.innerHTML = '<div class="msg"><div class="spinner"></div><p>Cargando…</p></div>';

        fetch(`${API}/${entidad}`)
            .then(res => { if (!res.ok) throw new Error(`HTTP ${res.status}`); return res.json(); })
            .then(data => {
                const lista = texto ? data.filter(i => JSON.stringify(i).toLowerCase().includes(texto)) : data;
                renderTable(lista, area);
            })
            .catch(err => {
                area.innerHTML = `<div class="msg"><strong>Error al obtener datos</strong>${err.message}<br><small>Verifica que el servidor esté activo en localhost:8080</small></div>`;
            });
    };

    const renderTable = (data, area) => {
        if (!data.length) {
            area.innerHTML = '<div class="msg"><strong>Sin resultados</strong>No se encontraron registros.</div>';
            return;
        }
        const keys = Object.keys(data[0]);
        const head = "<tr>" + keys.map(k => `<th>${k}</th>`).join("") + "</tr>";
        const rows = data.map(item => "<tr>" + keys.map(k => `<td>${item[k] ?? "—"}</td>`).join("") + "</tr>").join("");
        area.innerHTML = `<table><thead>${head}</thead><tbody>${rows}</tbody></table>`;
    };

    document.getElementById("searchInput").addEventListener("keydown", e => { if (e.key === "Enter") buscar(); });