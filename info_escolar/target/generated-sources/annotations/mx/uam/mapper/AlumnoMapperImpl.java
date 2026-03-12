package mx.uam.mapper;

import javax.annotation.processing.Generated;
import mx.uam.dto.AlumnoDTO;
import mx.uam.entity.Alumno;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-12T11:18:48-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class AlumnoMapperImpl implements AlumnoMapper {

    @Override
    public AlumnoDTO alumnoToAlumnoDTO(Alumno alumno) {
        if ( alumno == null ) {
            return null;
        }

        AlumnoDTO alumnoDTO = new AlumnoDTO();

        alumnoDTO.setId( alumno.getId() );
        alumnoDTO.setNombre( alumno.getNombre() );
        alumnoDTO.setApellidoPaterno( alumno.getApellidoPaterno() );
        alumnoDTO.setApellidoMaterno( alumno.getApellidoMaterno() );
        alumnoDTO.setMatricula( alumno.getMatricula() );
        alumnoDTO.setNacionalidad( alumno.getNacionalidad() );
        alumnoDTO.setPromedio( (float) alumno.getPromedio() );
        alumnoDTO.setGraduado( alumno.isGraduado() );

        return alumnoDTO;
    }

    @Override
    public Alumno alumnoDTOToAlumno(AlumnoDTO alumno) {
        if ( alumno == null ) {
            return null;
        }

        Alumno alumno1 = new Alumno();

        if ( alumno.getId() != null ) {
            alumno1.setId( alumno.getId() );
        }
        alumno1.setNombre( alumno.getNombre() );
        alumno1.setApellidoPaterno( alumno.getApellidoPaterno() );
        alumno1.setApellidoMaterno( alumno.getApellidoMaterno() );
        if ( alumno.getMatricula() != null ) {
            alumno1.setMatricula( alumno.getMatricula() );
        }
        alumno1.setNacionalidad( alumno.getNacionalidad() );
        if ( alumno.getPromedio() != null ) {
            alumno1.setPromedio( alumno.getPromedio() );
        }
        if ( alumno.getGraduado() != null ) {
            alumno1.setGraduado( alumno.getGraduado() );
        }

        return alumno1;
    }
}
