package mx.uam.service.impl;

import mx.uam.dto.MateriaDTO;
import mx.uam.entity.Materia;
import mx.uam.repository.MateriaRepository;
import mx.uam.service.MateriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaServiceImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public MateriaDTO createMateria(MateriaDTO materiaDTO) {

        Materia materia = new Materia();

        materia.setNombre(materiaDTO.getNombre());

        Materia materiaSaved = materiaRepository.save(materia);

        materiaDTO.setId(materiaSaved.getId());

        return materiaDTO;
    }

    @Override
    public List<MateriaDTO> getMaterias() {

        List<Materia> materias = materiaRepository.findAll();

        return materias.stream().map(materia -> {

            MateriaDTO dto = new MateriaDTO();

            dto.setId(materia.getId());
            dto.setNombre(materia.getNombre());

            return dto;

        }).toList();
    }

    @Override
    public MateriaDTO getMateriaById(Long id) {

        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        MateriaDTO dto = new MateriaDTO();

        dto.setId(materia.getId());
        dto.setNombre(materia.getNombre());

        return dto;
    }

    @Override
    public MateriaDTO updateMateria(Long id, MateriaDTO materiaDTO) {

        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setNombre(materiaDTO.getNombre());

        Materia materiaUpdated = materiaRepository.save(materia);

        MateriaDTO dto = new MateriaDTO();

        dto.setId(materiaUpdated.getId());
        dto.setNombre(materiaUpdated.getNombre());

        return dto;
    }

    @Override
    public void deleteMateria(Long id) {

        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materiaRepository.delete(materia);
    }
}