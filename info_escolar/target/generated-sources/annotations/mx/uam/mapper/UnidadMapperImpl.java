package mx.uam.mapper;

import javax.annotation.processing.Generated;
import mx.uam.dto.UnidadDTO;
import mx.uam.entity.Unidad;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-11T14:23:04-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class UnidadMapperImpl implements UnidadMapper {

    @Override
    public UnidadDTO unidadToUnidadDTO(Unidad unidad) {
        if ( unidad == null ) {
            return null;
        }

        UnidadDTO unidadDTO = new UnidadDTO();

        unidadDTO.setId( unidad.getId() );
        unidadDTO.setNombre( unidad.getNombre() );

        return unidadDTO;
    }

    @Override
    public Unidad unidadDTOToUnidad(UnidadDTO unidadDTO) {
        if ( unidadDTO == null ) {
            return null;
        }

        Unidad unidad = new Unidad();

        unidad.setId( unidadDTO.getId() );
        unidad.setNombre( unidadDTO.getNombre() );

        return unidad;
    }
}
