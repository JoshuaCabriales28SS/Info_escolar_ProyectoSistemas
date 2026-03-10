package mx.uam.dto;

public class UnidadDTO {
    private Long id;
    private String nombre;


//Constructor Vacio (Spring)

    public UnidadDTO() {
    }

    //Constructor Completo
    public UnidadDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //Getterss and Setters


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
}