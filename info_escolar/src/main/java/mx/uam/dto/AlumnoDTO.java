package mx.uam.dto;

public class AlumnoDTO {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long matricula;
    private String nacionalidad;
    private Float promedio;
    private Boolean graduado;
    private Long grupos_id;

    //Constructor Vacio (para Spring)
    public AlumnoDTO(){
    }
// Constructor Completo
    public AlumnoDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno,
                     Long matricula, String nacionalidad, Float promedio, Boolean graduado, Long grupos_id){
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.nacionalidad = nacionalidad;
        this.promedio = promedio;
        this.graduado = graduado;
        this.grupos_id = grupos_id;
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

    public Boolean getGraduado() {
        return graduado;
    }
    
    public void setGraduado(Boolean graduado) {
        this.graduado = graduado;
    }
    
    public Long getGrupos_id() {
        return grupos_id;
    }

    public void setGrupos_id(Long grupos_id) {
        this.grupos_id = grupos_id;
    }
}
