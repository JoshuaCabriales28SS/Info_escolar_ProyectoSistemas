package mx.uam.dto;

public class MateriaDTO {

    private Long id;
    private String nombre;

    //Constructor Vacio(Spring)
    public MateriaDTO(){}

    //Contructor Completo
    public MateriaDTO(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

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

