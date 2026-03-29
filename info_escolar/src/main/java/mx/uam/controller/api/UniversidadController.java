package mx.uam.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.service.api.UniversidadService;

@RestController
public class UniversidadController {
    private final UniversidadService service;

    public UniversidadController(UniversidadService service) {
        this.service = service;
    }

    @GetMapping("/uni_api")
    public String getData() {
        return service.obtenerDatos();
    }
}
