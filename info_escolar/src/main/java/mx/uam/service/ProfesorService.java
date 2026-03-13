package mx.uam.service;

import mx.uam.dto.ProfesorDTO;

import java.util.List;


public interface ProfesorService {


    List<ProfesorDTO>getProfesores();

    ProfesorDTO getProfesor(Long id);

    ProfesorDTO updateProfesor(Long id, ProfesorDTO profesorDTO);

    void deleteProfesor(Long id);

    ProfesorDTO createProfesor(ProfesorDTO profesorDTO);

    ProfesorDTO getProfesorById(Long id);
}
