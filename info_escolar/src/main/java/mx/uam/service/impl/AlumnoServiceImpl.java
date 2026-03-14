package mx.uam.service.impl;

import mx.uam.dto.AlumnoDTO;
import mx.uam.entity.Alumno;
import mx.uam.repository.AlumnoRepository;
import mx.uam.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {

        Alumno alumno = new Alumno();

        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
        alumno.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
        alumno.setMatricula(alumnoDTO.getMatricula());
        alumno.setNacionalidad(alumnoDTO.getNacionalidad());
        alumno.setPromedio(alumnoDTO.getPromedio());
        alumno.setGrupos_id(alumnoDTO.getGrupos_id());
        alumno.setGraduado(alumnoDTO.getGraduado());

        Alumno alumnoSaved = alumnoRepository.save(alumno);

        alumnoDTO.setId(alumnoSaved.getId());

        return alumnoDTO;
    }

    @Override
    public List<AlumnoDTO> getAlumnos() {

        List<Alumno> alumnos = alumnoRepository.findAll();

        return alumnos.stream().map(alumno -> {

            AlumnoDTO dto = new AlumnoDTO();

            dto.setId(alumno.getId());
            dto.setNombre(alumno.getNombre());
            dto.setApellidoPaterno(alumno.getApellidoPaterno());
            dto.setApellidoMaterno(alumno.getApellidoMaterno());
            dto.setMatricula(alumno.getMatricula());
            dto.setNacionalidad(alumno.getNacionalidad());
            dto.setPromedio((float) alumno.getPromedio());
            dto.setGrupos_id(alumno.getGrupo_id());
            dto.setGraduado(alumno.getGraduado());

            return dto;

        }).toList();
    }

    @Override
    public AlumnoDTO getAlumnoById(Long id) {

        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        AlumnoDTO dto = new AlumnoDTO();

        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setApellidoPaterno(alumno.getApellidoPaterno());
        dto.setApellidoMaterno(alumno.getApellidoMaterno());
        dto.setMatricula(alumno.getMatricula());
        dto.setNacionalidad(alumno.getNacionalidad());
        dto.setPromedio((float) alumno.getPromedio());
        dto.setGrupos_id(alumno.getGrupo_id());
        dto.setGraduado(alumno.getGraduado());

        return dto;
    }

    @Override
    public AlumnoDTO updateAlumno(Long id, AlumnoDTO alumnoDTO) {

        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
        alumno.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
        alumno.setMatricula(alumnoDTO.getMatricula());
        alumno.setNacionalidad(alumnoDTO.getNacionalidad());
        alumno.setPromedio(alumnoDTO.getPromedio());
        alumno.setGrupos_id(alumnoDTO.getGrupos_id());
        alumno.setGraduado(alumnoDTO.getGraduado());

        alumno = alumnoRepository.save(alumno);

        AlumnoDTO dto = new AlumnoDTO();

        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setApellidoPaterno(alumno.getApellidoPaterno());
        dto.setApellidoMaterno(alumno.getApellidoMaterno());
        dto.setMatricula(alumno.getMatricula());
        dto.setNacionalidad(alumno.getNacionalidad());
        dto.setPromedio((float) alumno.getPromedio());
        dto.setGrupos_id(alumno.getGrupo_id());
        dto.setGraduado(alumno.getGraduado());

        return dto;
    }

    @Override
    public void deleteAlumno(Long id) {

        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumnoRepository.delete(alumno);
    }
}