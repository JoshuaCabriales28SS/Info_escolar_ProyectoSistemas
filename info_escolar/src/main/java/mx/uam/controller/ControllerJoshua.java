package mx.uam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerJoshua {

    public ControllerJoshua() {
        
    }

    @GetMapping("/prueba")
    public String getMensaje(){
        return "Hola Joshua prueba";
    }
}
