package mx.uam.dto;

import mx.uam.entity.Division;

public class CarreraDTO {

    private Long id;
    private String nombre;
    private Long divisiones_id;

    //Constructor vacio(Spring)
    public CarreraDTO(){
    }

    //Constructor Completo
    public CarreraDTO(Long id,String nombre, Long divisiones_id){
        this.id =id;
        this.nombre = nombre;
        this.divisiones_id = divisiones_id;
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

    public Long getDivisiones_id() {
        return divisiones_id;
    }

    public void setDivisiones_id(Long divisiones_id) {
        this.divisiones_id = divisiones_id;
    }
}
