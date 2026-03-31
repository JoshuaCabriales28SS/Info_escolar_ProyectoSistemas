    let _cache = [];

    const renderTable = (data, area) => {
        if (!data.length) {
            area.innerHTML = '<div class="msg"><strong>Sin resultados</strong>No se encontraron registros.</div>';
            return;
        }
        const keys = Object.keys(data[0]);
        const head = '<tr>' + keys.map(k => `<th>${k}</th>`).join('') + '</tr>';
        const rows = data.map(item =>
            '<tr>' + keys.map(k => {
                const val = item[k];
                const str = (val === null || val === undefined) ? '—'
                          : Array.isArray(val) ? val.join(', ')
                          : typeof val === 'object' ? JSON.stringify(val)
                          : String(val);
                return `<td>${str}</td>`;
            }).join('') + '</tr>'
        ).join('');
        area.innerHTML = `<table><thead>${head}</thead><tbody>${rows}</tbody></table>`;
    };

    const buscar = () => {
        const area = document.getElementById('displayArea');
        area.innerHTML = '<div class="msg"><div class="spinner"></div><p>Cargando…</p></div>';

        fetch('http://localhost:8080/uni_api', { credentials: 'include' })
            .then(res => { if (!res.ok) throw new Error(`HTTP ${res.status}`); return res.json(); })
            .then(data => { _cache = Array.isArray(data) ? data : []; filtrar(); })
            .catch(() => {
                fetch('https://universities.hipolabs.com/search?country=Mexico')
                    .then(r => r.json())
                    .then(data => { _cache = Array.isArray(data) ? data : []; filtrar(); })
                    .catch(e => {
                        area.innerHTML = `<div class="msg"><strong>Error al obtener datos</strong>${e.message}<br><small>Verifica que el servidor esté activo en localhost:8080</small></div>`;
                    });
            });
    };

    const filtrar = () => {
        const texto = document.getElementById('searchInput').value.toLowerCase().trim();
        const area  = document.getElementById('displayArea');
        const lista = texto ? _cache.filter(i => JSON.stringify(i).toLowerCase().includes(texto)) : _cache;
        renderTable(lista, area);
    };

    document.getElementById('searchInput').addEventListener('input', () => { if (_cache.length) filtrar(); });
    document.getElementById('searchInput').addEventListener('keydown', e => { if (e.key === 'Enter') buscar(); });
