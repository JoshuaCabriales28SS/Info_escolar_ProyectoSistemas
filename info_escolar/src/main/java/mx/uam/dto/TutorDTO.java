package mx.uam.dto;

public class TutorDTO {

    private Long id;
    private Long profesores_id;

    //Constructor Vacio(Spring)
    public TutorDTO(){}

    //Constructor Completo

    public TutorDTO(Long id,Long profesores_id){
        this.id = id;
        this.profesores_id = profesores_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfesores_id() {
        return profesores_id;
    }

    public void setProfesores_id(Long profesores_id) {
        this.profesores_id = profesores_id;
    }
}
