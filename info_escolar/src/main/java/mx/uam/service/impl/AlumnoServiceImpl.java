package mx.uam.service.impl;

import mx.uam.dto.AlumnoDTO;
import mx.uam.entity.Alumno;
import mx.uam.entity.Grupo;
import mx.uam.repository.AlumnoRepository;
import mx.uam.repository.GrupoRepository;
import mx.uam.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final GrupoRepository grupoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, GrupoRepository grupoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.grupoRepository = grupoRepository;
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

        Grupo grupo = grupoRepository.findById(alumnoDTO.getGrupos_id())
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        alumno.setGrupo(grupo);

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
            dto.setGrupos_id(alumno.getGrupo().getId());
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
        dto.setGrupos_id(alumno.getGrupo().getId());
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

        Grupo grupo = grupoRepository.findById(alumnoDTO.getGrupos_id())
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        alumno.setGrupo(grupo);

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
        dto.setGrupos_id(alumno.getGrupo().getId());
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