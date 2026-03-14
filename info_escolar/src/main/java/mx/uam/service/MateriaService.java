package mx.uam.service;

import mx.uam.dto.MateriaDTO;

import java.util.List;

public interface MateriaService  {
    List<MateriaDTO> getMaterias();

    MateriaDTO updateMateria(Long id, MateriaDTO materiaDTO);

    void deleteMateria(Long id);

    MateriaDTO createMateria(MateriaDTO materiaDTO);

    MateriaDTO getMateriaById(Long id);
}
