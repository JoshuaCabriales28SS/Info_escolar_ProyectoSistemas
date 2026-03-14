package mx.uam.controller;

import mx.uam.dto.AlumnoDTO;
import mx.uam.service.AlumnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    //Create
    @PostMapping
    public AlumnoDTO createAlumno(@RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.createAlumno(alumnoDTO);
    }
    //Obtener todos
    @GetMapping
    public List<AlumnoDTO>getAlumnos(){
        return alumnoService.getAlumnos();
    }
    //Obtener por ID
    @GetMapping("/{id}")
    public AlumnoDTO getAlumnoByID(@PathVariable Long id){
        return alumnoService.getAlumnoById(id);
    }

    //Actualizar
    @PatchMapping("/{id}")
    public AlumnoDTO updateAlumno(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO){
    return alumnoService.updateAlumno(id, alumnoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable Long id){
        alumnoService.deleteAlumno(id);
    }

}
