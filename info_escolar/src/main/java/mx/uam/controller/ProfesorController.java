package mx.uam.controller;

import mx.uam.dto.ProfesorDTO;
import mx.uam.service.ProfesorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService){this.profesorService = profesorService;}

    //Create
    @PostMapping
    public ProfesorDTO createAlumno(@RequestBody ProfesorDTO profesorDTO) {
        return profesorService.createProfesor(profesorDTO);
    }

    // GET ALL
    @GetMapping
    public List<ProfesorDTO> getProfesor() {
        return profesorService.getProfesor();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ProfesorDTO getProfesorByID(@PathVariable Long id) {
        return profesorService.getProfesorById(id);
    }
    // UPDATE
    @PatchMapping("/{id}")
    public ProfesorDTO updateProfesor(@PathVariable Long id, @RequestBody ProfesorDTO profesorDTO) {
        return profesorService.updateProfesor(id, profesorDTO);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
    }

}











