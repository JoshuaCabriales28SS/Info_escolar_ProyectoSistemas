package mx.uam.service;

import java.util.List;

import mx.uam.dto.UnidadDTO;

public interface UnidadService {

    UnidadDTO createUnidad(UnidadDTO unidadDTO);

    List<UnidadDTO> getUnidades();

    UnidadDTO getUnidadById(Long id);

    UnidadDTO updateUnidad(Long id, UnidadDTO unidadDTO);

    void deleteUnidad(Long id);

}
