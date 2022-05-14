package ar.edu.utn.frsf.problemaIntegrador;

public class Bien {

    private static Integer id;
    private String alias;
    private String descripcion;
    private Double precio;
    private Responsable responsable;

    public Bien(){

        if(id == null){
            id=0;
        }
        else{
            id++;
        }
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Bien.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
