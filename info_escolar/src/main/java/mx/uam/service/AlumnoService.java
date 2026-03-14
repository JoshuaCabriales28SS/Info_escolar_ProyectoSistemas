package mx.uam.service;


import mx.uam.dto.AlumnoDTO;

import java.util.List;

public interface AlumnoService {
    List<AlumnoDTO> getAlumnos();

    AlumnoDTO updateAlumno(Long id, AlumnoDTO alumnoDTO);

    void deleteAlumno(Long id);

    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);

    AlumnoDTO getAlumnoById(Long id);
}
