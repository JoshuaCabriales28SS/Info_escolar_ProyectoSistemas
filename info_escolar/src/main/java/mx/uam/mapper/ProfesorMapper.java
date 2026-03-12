package mx.uam.mapper;

import mx.uam.dto.ProfesorDTO;
import mx.uam.entity.Profesor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProfesorMapper {
    ProfesorDTO profesorToDTO(Profesor profesor);

    Profesor profesorDTOToProfesor(Profesor profesorDTO);
}
