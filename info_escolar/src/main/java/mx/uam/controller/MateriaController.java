package mx.uam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import mx.uam.dto.MateriaDTO;
import mx.uam.service.MateriaService;

@RestController
public class MateriaController {
    // Atributos
    private final MateriaService materiaService;

    // Constructor
    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    // POST
    @PostMapping("/materias")
    public MateriaDTO createAlumno(@RequestBody MateriaDTO materiaDTO) {
        MateriaDTO materiaDTOS = materiaService.create(materiaDTO);
        return materiaDTOS;
    }

    // GET
    @GetMapping("/materias")
    public List<MateriaDTO> getAll() {
        return materiaService.getAll();
    }

    // GET
    @GetMapping("/materias/{id}")
    public MateriaDTO getMateria(@PathVariable Long id) {
        return materiaService.get(id);
    }

    // PATCH
    @PatchMapping("/materias/{id}")
    public MateriaDTO updateMateria(@PathVariable Long id, @RequestBody MateriaDTO materiaDTO) {
        return materiaService.update(id, materiaDTO);
    }

    // DELETE
    @DeleteMapping("/materias/{id}")
    public void deleteMateria(@PathVariable Long id) {
        materiaService.delete(id);
    }
}
