package mx.uam.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import mx.uam.dto.ProfesorDTO;
import mx.uam.entity.Profesor;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProfesorMapper {

    ProfesorDTO profesorToProfesorDTO(Profesor profesor);

    Profesor profesorDTOToProfesor(ProfesorDTO profesorDTO);
}
