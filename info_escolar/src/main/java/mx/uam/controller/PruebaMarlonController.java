package mx.uam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PruebaMarlonController {
    @GetMapping("/pruebaMarlon")
    public String prueba() {
        return "Hola desde el controlador de Marlon";
    }


}
