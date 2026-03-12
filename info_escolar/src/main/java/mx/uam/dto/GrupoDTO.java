package mx.uam.dto;

public class GrupoDTO {
    private Long id;
    private String grupo;
    private Long carreras_id;
    private Long profesores_id;
    private Long materias_id;
    private String trimeste;

    //Constructor vacio(Spring)
    public GrupoDTO(){}

    //Constructor Completo
    public GrupoDTO(Long id, String grupo,Long carreras_id, Long profesores_id, Long materias_id, String trimeste){
        this.id = id;
        this.grupo = grupo;
        this.carreras_id = carreras_id;
        this.profesores_id = profesores_id;
        this.materias_id = materias_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Long getCarreras_id() {
        return carreras_id;
    }

    public void setCarreras_id(Long carreras_id) {
        this.carreras_id = carreras_id;
    }

    public Long getProfesores_id() {
        return profesores_id;
    }

    public void setProfesores_id(Long profesores_id) {
        this.profesores_id = profesores_id;
    }

    public Long getMaterias_id() {
        return materias_id;
    }

    public void setMaterias_id(Long materias_id) {
        this.materias_id = materias_id;
    }

    public String getTrimeste() {
        return trimeste;
    }

    public void setTrimeste(String trimeste) {
        this.trimeste = trimeste;
    }
}
