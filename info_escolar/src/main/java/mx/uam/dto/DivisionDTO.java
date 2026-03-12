package mx.uam.dto;

public class DivisionDTO {

    private Long id;
    private String nombre;
    private Long unidades_id;

    //Contructor Vacio(Spring)
    public DivisionDTO(){}

    //Constructor Completo
    public DivisionDTO(Long id, String nombre, Long unidades_id){
        this.id = id;
        this.nombre = nombre;
        this.unidades_id = unidades_id;
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

    public Long getUnidades_id() {
        return unidades_id;
    }

    public void setUnidades_id(Long unidades_id) {
        this.unidades_id = unidades_id;
    }
}
