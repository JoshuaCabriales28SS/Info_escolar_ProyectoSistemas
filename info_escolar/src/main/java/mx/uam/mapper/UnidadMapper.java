package mx.uam.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import mx.uam.dto.UnidadDTO;
import mx.uam.entity.Unidad;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UnidadMapper {
    UnidadDTO unidadToUnidadDTO(Unidad unidad);

    Unidad unidadDTOToUnidad(UnidadDTO unidadDTO);

    
}
