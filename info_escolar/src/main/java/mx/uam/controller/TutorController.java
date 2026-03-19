package mx.uam.controller;

import mx.uam.dto.TutorDTO;
import mx.uam.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")

public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    //Create
    @PostMapping
    public TutorDTO createTutor(@RequestBody TutorDTO tutorDTO){
        return tutorService.createTutor(tutorDTO);
    }
    //Obtener todos
    @GetMapping
    public List<TutorDTO> getTutores(){
        return tutorService.getTutores();
    }
    //Obtener por ID
    @GetMapping("/{id}")
    public TutorDTO getTutorByID(@PathVariable Long id){
        return tutorService.getTutorById(id);
    }

    //Actualizar
    @PatchMapping("/{id}")
    public TutorDTO updateTutor(@PathVariable Long id, @RequestBody TutorDTO tutorDTO){
        return tutorService.updateTutor(id, tutorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTutor(@PathVariable Long id){
        tutorService.deleteTutor(id);
    }
}
