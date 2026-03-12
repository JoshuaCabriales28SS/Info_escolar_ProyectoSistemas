package mx.uam.service;

import mx.uam.dto.ProfesorDTO;

import java.util.List;

public interface ProfesorService {
    ProfesorDTO create(ProfesorDTO profesorDTO);

    ProfesorDTO createProfesor(ProfesorDTO profesorDTO);

    List<ProfesorDTO> getProfesor();

    ProfesorDTO getProfesorById(Long id);

    ProfesorDTO update(Long id, ProfesorDTO profesorDTO);

    void deleteProfesor(Long id);

    ProfesorDTO updateProfesor(Long id, ProfesorDTO profesorDTO);
}
