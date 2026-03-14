package mx.uam.controller;


import mx.uam.dto.MateriaDTO;
import mx.uam.service.MateriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService){
        this.materiaService = materiaService;
    }

    //Create
    @PostMapping
    public MateriaDTO createMateria(@RequestBody MateriaDTO materiaDTO){
        return materiaService.createMateria(materiaDTO);
    }
    //Obtener todos
    @GetMapping
    public List<MateriaDTO> getMaterias(){
        return materiaService.getMaterias();
    }
    //Obtener por ID
    @GetMapping("/{id}")
    public MateriaDTO getMateriaByID(@PathVariable Long id){
        return materiaService.getMateriaById(id);
    }

    //Actualizar
    @PatchMapping("/{id}")
    public MateriaDTO updateMateria(@PathVariable Long id, @RequestBody MateriaDTO materiaDTO){
        return materiaService.updateMateria(id, materiaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMateria(@PathVariable Long id){
        materiaService.deleteMateria(id);
    }
}
