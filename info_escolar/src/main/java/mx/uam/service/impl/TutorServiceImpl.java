package mx.uam.service.impl;

import mx.uam.dto.TutorDTO;
import mx.uam.entity.Profesor;
import mx.uam.entity.Tutor;
import mx.uam.repository.ProfesorRepository;
import mx.uam.repository.TutorRepository;
import mx.uam.service.TutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;
    private final ProfesorRepository profesorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository,
                            ProfesorRepository profesorRepository) {
        this.tutorRepository = tutorRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public TutorDTO createTutor(TutorDTO tutorDTO) {

        Tutor tutor = new Tutor();

        Profesor profesor = profesorRepository.findById(tutorDTO.getProfesores_id())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        tutor.setProfesor(profesor);

        Tutor tutorSaved = tutorRepository.save(tutor);

        tutorDTO.setId(tutorSaved.getId());

        return tutorDTO;
    }

    @Override
    public List<TutorDTO> getTutores() {

        List<Tutor> tutores = tutorRepository.findAll();

        return tutores.stream().map(tutor -> {

            TutorDTO dto = new TutorDTO();

            dto.setId(tutor.getId());
            dto.setProfesores_id(tutor.getProfesor().getId());

            return dto;

        }).toList();
    }

    @Override
    public TutorDTO getTutorById(Long id) {

        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        TutorDTO dto = new TutorDTO();

        dto.setId(tutor.getId());
        dto.setProfesores_id(tutor.getProfesor().getId());

        return dto;
    }

    @Override
    public TutorDTO updateTutor(Long id, TutorDTO tutorDTO) {

        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        Profesor profesor = profesorRepository.findById(tutorDTO.getProfesores_id())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        tutor.setProfesor(profesor);

        Tutor tutorUpdated = tutorRepository.save(tutor);

        TutorDTO dto = new TutorDTO();

        dto.setId(tutorUpdated.getId());
        dto.setProfesores_id(tutorUpdated.getProfesor().getId());

        return dto;
    }

    @Override
    public void deleteTutor(Long id) {

        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        tutorRepository.delete(tutor);
    }
}