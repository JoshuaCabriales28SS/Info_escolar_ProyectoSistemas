package mx.uam.service.impl;

import mx.uam.dto.CarreraDTO;
import mx.uam.entity.Carrera;
import mx.uam.entity.Division;
import mx.uam.repository.CarreraRepository;
import mx.uam.repository.DivisionRepository;
import mx.uam.service.CarreraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {

    private final CarreraRepository carreraRepository;
    private final DivisionRepository divisionRepository;

    public CarreraServiceImpl(CarreraRepository carreraRepository,
                              DivisionRepository divisionRepository){
        this.carreraRepository = carreraRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public CarreraDTO createCarrera(CarreraDTO carreraDTO){

        Carrera carrera = new Carrera();

        carrera.setNombre(carreraDTO.getNombre());

        Division division = divisionRepository.findById(carreraDTO.getDivisiones_id())
                .orElseThrow(() -> new RuntimeException("Division no encontrada"));

        carrera.setDivision(division);

        Carrera carreraSaved = carreraRepository.save(carrera);

        carreraDTO.setId(carreraSaved.getId());

        return carreraDTO;
    }

    @Override
    public List<CarreraDTO> getCarrera() {

        List<Carrera> carreras = carreraRepository.findAll();

        return carreras.stream().map(carrera -> {

            CarreraDTO dto = new CarreraDTO();

            dto.setId(carrera.getId());
            dto.setNombre(carrera.getNombre());
            dto.setDivisiones_id(carrera.getDivision().getId());

            return dto;

        }).toList();
    }

    @Override
    public CarreraDTO getCarreraById(Long id) {

        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        CarreraDTO dto = new CarreraDTO();

        dto.setId(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setDivisiones_id(carrera.getDivision().getId());

        return dto;
    }

    @Override
    public CarreraDTO updateCarrera(Long id, CarreraDTO carreraDTO) {

        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        carrera.setNombre(carreraDTO.getNombre());

        Division division = divisionRepository.findById(carreraDTO.getDivisiones_id())
                .orElseThrow(() -> new RuntimeException("Division no encontrada"));

        carrera.setDivision(division);

        Carrera carreraUpdated = carreraRepository.save(carrera);

        CarreraDTO dto = new CarreraDTO();

        dto.setId(carreraUpdated.getId());
        dto.setNombre(carreraUpdated.getNombre());
        dto.setDivisiones_id(carreraUpdated.getDivision().getId());

        return dto;
    }

    @Override
    public void deleteCarrera(Long id) {

        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        carreraRepository.delete(carrera);
    }
}