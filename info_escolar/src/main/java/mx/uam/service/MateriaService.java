package mx.uam.service;

import java.util.List;

import mx.uam.dto.MateriaDTO;

public interface MateriaService {
    MateriaDTO create(MateriaDTO materiaDTO);

    List<MateriaDTO> getAll();

    MateriaDTO get(Long id);

    MateriaDTO update(Long id, MateriaDTO materiaDTO);

    void delete(Long id);
}
