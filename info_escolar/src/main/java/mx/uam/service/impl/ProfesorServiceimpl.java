package mx.uam.service.impl;

import mx.uam.dto.ProfesorDTO;
import mx.uam.entity.Profesor;
import mx.uam.repository.ProfesorRepository;
import mx.uam.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceimpl implements ProfesorService {
private final ProfesorRepository profesorRepository;

public ProfesorServiceimpl(ProfesorRepository profesorRepository){
    this.profesorRepository = profesorRepository;}

    private ProfesorDTO convertirADTO(Profesor profesor){
    ProfesorDTO dto = new ProfesorDTO();
    dto.setId(profesor.getId());
    dto.setNombre(profesor.getNombre());
    return dto;
    }

    private Profesor convertirAEntidad(ProfesorDTO dto){
    Profesor profesor = new Profesor();
    profesor.setId(dto.getId());
    profesor.setNombre(dto.getNombre());
    return profesor;
    }

    @Override
    public ProfesorDTO create(ProfesorDTO profesorDTO) {
        return null;
    }

    @Override
    public ProfesorDTO createProfesor(ProfesorDTO profesorDTO) {
        return null;
    }

    @Override
    public List<ProfesorDTO> getProfesor() {
        return profesorRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfesorDTO getProfesorById(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        return convertirADTO(profesor);
    }

    @Override
    public ProfesorDTO update(Long id, ProfesorDTO profesorDTO) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesor.setNombre(profesorDTO.getNombre());


        Profesor actualizado = profesorRepository.save(profesor);

        return convertirADTO(actualizado);
    }

    @Override
    public void deleteProfesor(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesorRepository.delete(profesor);

    }

    @Override
    public ProfesorDTO updateProfesor(Long id, ProfesorDTO profesorDTO) {
        return null;
    }
}
