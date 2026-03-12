package mx.uam.mapper;

import javax.annotation.processing.Generated;
import mx.uam.dto.ProfesorDTO;
import mx.uam.entity.Profesor;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-11T14:23:04-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class ProfesorMapperImpl implements ProfesorMapper {

    @Override
    public ProfesorDTO profesorToDTO(Profesor profesor) {
        if ( profesor == null ) {
            return null;
        }

        ProfesorDTO profesorDTO = new ProfesorDTO();

        profesorDTO.setId( profesor.getId() );
        profesorDTO.setNombre( profesor.getNombre() );

        return profesorDTO;
    }

    @Override
    public Profesor profesorDTOToProfesor(Profesor profesorDTO) {
        if ( profesorDTO == null ) {
            return null;
        }

        Profesor profesor = new Profesor();

        profesor.setId( profesorDTO.getId() );
        profesor.setNombre( profesorDTO.getNombre() );

        return profesor;
    }
}
