package mx.uam.mapper;

import javax.annotation.processing.Generated;
import mx.uam.dto.ProfesorDTO;
import mx.uam.entity.Profesor;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-11T18:40:29-0600",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ProfesorMapperImpl implements ProfesorMapper {

    @Override
    public ProfesorDTO profesorToProfesorDTO(Profesor profesor) {
        if ( profesor == null ) {
            return null;
        }

        ProfesorDTO profesorDTO = new ProfesorDTO();

        profesorDTO.setId( profesor.getId() );
        profesorDTO.setNombre( profesor.getNombre() );

        return profesorDTO;
    }

    @Override
    public Profesor profesorDTOToProfesor(ProfesorDTO profesorDTO) {
        if ( profesorDTO == null ) {
            return null;
        }

        Profesor profesor = new Profesor();

        if ( profesorDTO.getId() != null ) {
            profesor.setId( profesorDTO.getId() );
        }
        profesor.setNombre( profesorDTO.getNombre() );

        return profesor;
    }
}
