package mx.uam.controller;


import mx.uam.dto.CarreraDTO;
import mx.uam.service.CarreraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService){
        this.carreraService = carreraService;
    }

    //Create
    @PostMapping
    public CarreraDTO createCarrera(@RequestBody CarreraDTO carreraDTO){
        return carreraService.createCarrera(carreraDTO);
    }
    //Obtener todos
    @GetMapping
    public List<CarreraDTO> getCarrera(){
        return carreraService.getCarrera();
    }
    //Obtener por ID
    @GetMapping("/{id}")
    public CarreraDTO getCarreraByID(@PathVariable Long id){
        return carreraService.getCarreraById(id);
    }

    //Actualizar
    @PatchMapping("/{id}")
    public CarreraDTO updateCarrera(@PathVariable Long id, @RequestBody CarreraDTO carreraDTO){
        return carreraService.updateCarrera(id, new CarreraDTO());
    }

    @DeleteMapping("/{id}")
    public void deleteCarrera(@PathVariable Long id){
        carreraService.deleteCarrera(id);
    }
}
