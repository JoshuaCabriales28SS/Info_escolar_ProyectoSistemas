package mx.uam.dto;

public class ProfesorDTO {

    private Long id;
    private String nombre;

    //Constructor vacio (Spring)
    public ProfesorDTO(){

    }

    public ProfesorDTO(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;

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
}
