package mx.uam.controller;


import mx.uam.dto.DivisionDTO;
import mx.uam.service.DivisionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Divisiones")
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService){
        this.divisionService = divisionService;
    }

    //Create
    @PostMapping
    public DivisionDTO createDivision(@RequestBody DivisionDTO divisionDTO){
        return divisionService.createDivision(divisionDTO);
    }
    //Obtener todos
    @GetMapping
    public List<DivisionDTO> getDivisiones(){
        return divisionService.getDivisiones();
    }
    //Obtener por ID
    @GetMapping("/{id}")
    public DivisionDTO getDivisionByID(@PathVariable Long id){
        return divisionService.getDivisionById(id);
    }

    //Actualizar
    @PatchMapping("/{id}")
    public DivisionDTO updateDivision(@PathVariable Long id, @RequestBody DivisionDTO divisionDTO){
        return divisionService.updateDivision(id, divisionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDivision(@PathVariable Long id){
        divisionService.deleteDivision(id);
    }
}
