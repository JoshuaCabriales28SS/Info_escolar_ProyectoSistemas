package mx.uam.service;



import mx.uam.dto.TutorDTO;

import java.util.List;

public interface TutorService {
    List<TutorDTO> getTutores();

    TutorDTO updateTutor(Long id, TutorDTO tutorDTO);

    void deleteTutor(Long id);

    TutorDTO createTutor(TutorDTO tutorDTO);

    TutorDTO getTutorById(Long id);
}
