package mx.uam.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.service.api.EmpresaService;

@RestController
public class EmpresaController {
    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @GetMapping("/emp_api")
    public String getData() {
        return service.obtenerEmpresas();
    }
}
