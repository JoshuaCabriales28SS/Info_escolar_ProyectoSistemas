package mx.uam.service.impl;

import mx.uam.dto.DivisionDTO;
import mx.uam.entity.Division;
import mx.uam.entity.Unidad;
import mx.uam.repository.DivisionRepository;
import mx.uam.repository.UnidadRepository;
import mx.uam.service.DivisionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;
    private final UnidadRepository unidadRepository;

    public DivisionServiceImpl(DivisionRepository divisionRepository,
                               UnidadRepository unidadRepository) {
        this.divisionRepository = divisionRepository;
        this.unidadRepository = unidadRepository;
    }

    @Override
    public DivisionDTO createDivision(DivisionDTO divisionDTO) {

        Division division = new Division();

        division.setNombre(divisionDTO.getNombre());

        Unidad unidad = unidadRepository.findById(divisionDTO.getUnidades_id())
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        division.setUnidad(unidad);

        Division divisionSaved = divisionRepository.save(division);

        divisionDTO.setId(divisionSaved.getId());

        return divisionDTO;
    }

    @Override
    public List<DivisionDTO> getDivisiones() {

        List<Division> divisiones = divisionRepository.findAll();

        return divisiones.stream().map(division -> {

            DivisionDTO dto = new DivisionDTO();

            dto.setId(division.getId());
            dto.setNombre(division.getNombre());
            dto.setUnidades_id(division.getUnidad().getId());

            return dto;

        }).toList();
    }

    @Override
    public DivisionDTO getDivisionById(Long id) {

        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division no encontrada"));

        DivisionDTO dto = new DivisionDTO();

        dto.setId(division.getId());
        dto.setNombre(division.getNombre());
        dto.setUnidades_id(division.getUnidad().getId());

        return dto;
    }

    @Override
    public DivisionDTO updateDivision(Long id, DivisionDTO divisionDTO) {

        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division no encontrada"));

        division.setNombre(divisionDTO.getNombre());

        Unidad unidad = unidadRepository.findById(divisionDTO.getUnidades_id())
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        division.setUnidad(unidad);

        Division divisionUpdate = divisionRepository.save(division);

        DivisionDTO dto = new DivisionDTO();

        dto.setId(divisionUpdate.getId());
        dto.setNombre(divisionUpdate.getNombre());
        dto.setUnidades_id(divisionUpdate.getUnidad().getId());

        return dto;
    }

    @Override
    public void deleteDivision(Long id) {

        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Division no encontrada"));

        divisionRepository.delete(division);
    }
}