package mx.uam.controller;


import mx.uam.dto.GrupoDTO;
import mx.uam.service.GrupoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService){
        this.grupoService = grupoService;
    }

    //Create
    @PostMapping
    public GrupoDTO createGrupo(@RequestBody GrupoDTO grupoDTO){
        return grupoService.createGrupo(grupoDTO);
    }
    //Obtener todos
    @GetMapping
    public List<GrupoDTO> getGrupos(){
        return grupoService.getGrupos();
    }
    //Obtener por ID
    @GetMapping("/{id}")
    public GrupoDTO getGrupoByID(@PathVariable Long id){
        return grupoService.getGrupoById(id);
    }

    //Actualizar
    @PatchMapping("/{id}")
    public GrupoDTO updateGrupo(@PathVariable Long id, @RequestBody GrupoDTO grupoDTO){
        return grupoService.updateGrupo(id, grupoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGrupo(@PathVariable Long id){
        grupoService.deleteGrupo(id);
    }
}
