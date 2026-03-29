package mx.uam.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.service.api.CarrerasService;

@RestController
public class CarrerasController {
    private final CarrerasService service;

    public CarrerasController(CarrerasService service) {
        this.service = service;
    }

    @GetMapping("/car_api")
    public String getData() {
        return service.obtenerCarreras();
    }
}
