package mx.uam.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import mx.uam.dto.AlumnoDTO;
import mx.uam.entity.Alumno;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AlumnoMapper {

    AlumnoDTO alumnoToAlumnoDTO(Alumno alumno);

    Alumno alumnoDTOToAlumno(AlumnoDTO alumno);
    
}
