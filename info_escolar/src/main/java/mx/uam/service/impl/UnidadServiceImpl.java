package mx.uam.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.uam.dto.UnidadDTO;
import mx.uam.entity.Unidad;
import mx.uam.repository.UnidadRepository;
import mx.uam.service.UnidadService;

@Service
public class UnidadServiceImpl implements UnidadService {

    private final UnidadRepository unidadRepository;

    public UnidadServiceImpl(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    @Override
    public UnidadDTO create(UnidadDTO unidadDTO) {

        Unidad unidad = new Unidad();

        unidad.setNombre(unidadDTO.getNombre());

        Unidad unidadSaved = unidadRepository.save(unidad);

        unidadDTO.setId(unidadSaved.getId());

        return unidadDTO;
    }

    @Override
    public List<UnidadDTO> getUnidades() {

        List<Unidad> unidades = unidadRepository.findAll();

        return unidades.stream().map(unidad -> {

            UnidadDTO dto = new UnidadDTO();

            dto.setId(unidad.getId());
            dto.setNombre(unidad.getNombre());

            return dto;

        }).toList();
    }

    @Override
    public UnidadDTO getUnidad(Long id) {

        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        UnidadDTO dto = new UnidadDTO();

        dto.setId(unidad.getId());
        dto.setNombre(unidad.getNombre());

        return dto;
    }

    @Override
    public UnidadDTO updateUnidad(Long id, UnidadDTO unidadDTO) {

        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        unidad.setNombre(unidadDTO.getNombre());

        Unidad unidadUpdated = unidadRepository.save(unidad);

        UnidadDTO dto = new UnidadDTO();

        dto.setId(unidadUpdated.getId());
        dto.setNombre(unidadUpdated.getNombre());

        return dto;
    }

    @Override
    public void deleteUnidad(Long id) {

        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        unidadRepository.delete(unidad);
    }
}