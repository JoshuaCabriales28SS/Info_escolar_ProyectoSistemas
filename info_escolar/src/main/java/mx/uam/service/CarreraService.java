package mx.uam.service;

import mx.uam.dto.CarreraDTO;

import java.util.List;

public interface CarreraService {

    List<CarreraDTO>getCarrera();

    CarreraDTO updateCarrera(Long id, CarreraDTO carreraDTO);

    void deleteCarrera(Long id);

    CarreraDTO createCarrera(CarreraDTO carreraDTO);

    CarreraDTO getCarreraById(Long id);


}
