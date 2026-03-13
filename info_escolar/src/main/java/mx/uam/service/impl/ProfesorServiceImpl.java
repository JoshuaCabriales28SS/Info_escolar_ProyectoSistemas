package mx.uam.service.impl;

import mx.uam.dto.ProfesorDTO;
import mx.uam.entity.Profesor;
import mx.uam.repository.ProfesorRepository;
import mx.uam.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public ProfesorDTO createProfesor(ProfesorDTO profesorDTO) {

        Profesor profesor = new Profesor();
        profesor.setNombre(profesorDTO.getNombre());

        Profesor profesorSaved = profesorRepository.save(profesor);

        profesorDTO.setId(profesorSaved.getId());

        return profesorDTO;
    }

    @Override
    public List<ProfesorDTO> getProfesores() {

        List<Profesor> profesores = profesorRepository.findAll();

        return profesores.stream().map(profesor -> {
            ProfesorDTO dto = new ProfesorDTO();
            dto.setId(profesor.getId());
            dto.setNombre(profesor.getNombre());
            return dto;
        }).toList();
    }

    @Override
    public ProfesorDTO getProfesorById(Long id) {

        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombre());

        return dto;
    }

    @Override
    public ProfesorDTO updateProfesor(Long id, ProfesorDTO profesorDTO) {

        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesor.setNombre(profesorDTO.getNombre());

        Profesor profesorUpdated = profesorRepository.save(profesor);

        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesorUpdated.getId());
        dto.setNombre(profesorUpdated.getNombre());

        return dto;
    }

    @Override
    public void deleteProfesor(Long id) {

        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesorRepository.delete(profesor);
    }

    @Override
    public ProfesorDTO getProfesor(Long id) {
        return getProfesorById(id);
    }
}