package ar.edu.utn.frsf.problemaIntegrador;

import java.util.Objects;

public abstract class Ubicacion {

    protected static Integer id;
    protected String nombre;

    public Ubicacion(){

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
        Ubicacion.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return Objects.equals(nombre, ubicacion.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
