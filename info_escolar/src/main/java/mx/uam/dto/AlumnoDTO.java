package mx.uam.dto;

public class AlumnoDTO {

    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long matricula;
    private String nacionalidad;
    private Float promedio;
    private Long materias_id;
    private Boolean graduado;

    //Constructor Vacio (para Spring)
    public AlumnoDTO(){
    }
// Constructor Completo
    public AlumnoDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno,
                     Long matricula, String nacionalidad, Float promedio, Long materias_id, Boolean graduado){
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.nacionalidad = nacionalidad;
        this.promedio = promedio;
        this.materias_id = materias_id;
        this.graduado = graduado;
    }
    //Getters And Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Float getPromedio() {
        return promedio;
    }

    public void setPromedio(Float promedio) {
        this.promedio = promedio;
    }

    public Long getMaterias_id() {
        return materias_id;
    }

    public void setMaterias_id(Long materias_id) {
        this.materias_id = materias_id;
    }

    public Boolean getGraduado() {
        return graduado;
    }

    public void setGraduado(Boolean graduado) {
        this.graduado = graduado;
    }
}
