package mx.uam.controller;

import mx.uam.dto.UnidadDTO;
import mx.uam.service.UnidadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")

public class UnidadController {

    private final UnidadService unidadService;

    public UnidadController(UnidadService unidadService){
        this.unidadService = unidadService;
    }

    //Create
    @PostMapping
    public UnidadDTO createUnidad(@RequestBody UnidadDTO unidadDTO){
        return unidadService.createUnidad(unidadDTO);
    }
    //Obtener todos
    @GetMapping
    public List<UnidadDTO> getUnidades(){
        return unidadService.getUnidades();
    }
    //Obtener por ID
    @GetMapping("/{id}")
    public UnidadDTO getUnidadByID(@PathVariable Long id){
        return unidadService.getUnidadById(id);
    }

    //Actualizar
    @PatchMapping("/{id}")
    public UnidadDTO updateUnidad(@PathVariable Long id, @RequestBody UnidadDTO unidadDTO){
        return unidadService.updateUnidad(id, unidadDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUnidad(@PathVariable Long id){
        unidadService.deleteUnidad(id);
    }
}
