package mx.uam.service;



import mx.uam.dto.GrupoDTO;

import java.util.List;

public interface GrupoService {
    List<GrupoDTO> getGrupos();

    GrupoDTO updateGrupo(Long id, GrupoDTO grupoDTO);

    void deleteGrupo(Long id);

    GrupoDTO createGrupo(GrupoDTO grupoDTO);

    GrupoDTO getGrupoById(Long id);
}
