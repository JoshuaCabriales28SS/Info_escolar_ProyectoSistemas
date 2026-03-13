package mx.uam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.uam.dto.MateriaDTO;
import mx.uam.entity.Materia;
import mx.uam.repository.MateriaRepository;
import mx.uam.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService {
    // Atributos
    private final MateriaRepository materiaRepository;

    // Constructor
    public MateriaServiceImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public MateriaDTO create(MateriaDTO materiaDTO) {
        Materia materia =new Materia();

        materia.setNombre(materiaDTO.getNombre());

        Materia materiaS = materiaRepository.save(materia);

        materiaDTO.setId(materiaS.getId());
        
        return materiaDTO;
    }

    @Override
    public List<MateriaDTO> getAll() {
        List<Materia> materias = materiaRepository.findAll();

        List<MateriaDTO> materiaDTOs = new ArrayList<>();

        for (Materia materia: materias) {
            MateriaDTO materiaDTO = new MateriaDTO();

            materiaDTO.setId(materia.getId());
            materiaDTO.setNombre(materia.getNombre());

            materiaDTOs.add(materiaDTO);
        }
        
        return materiaDTOs;
    }

    @Override
    public MateriaDTO get(Long id) {
        Materia materia = materiaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
            
            MateriaDTO materiaDTO = new MateriaDTO();
            
            materiaDTO.setNombre(materia.getNombre());
        materiaDTO.setId(materia.getId());
        
        return materiaDTO;
    }

    @Override
    public MateriaDTO update(Long id, MateriaDTO materiaDTO) {
        Materia materia = materiaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setNombre(materiaDTO.getNombre());

        Materia actualizado = materiaRepository.save(materia);

        materiaDTO.setId(actualizado.getId());
        materiaDTO.setNombre(actualizado.getNombre());

        return materiaDTO;
    }
    
    @Override
    public void delete(Long id) {
        Materia materia = materiaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materiaRepository.delete(materia);

    }

}
