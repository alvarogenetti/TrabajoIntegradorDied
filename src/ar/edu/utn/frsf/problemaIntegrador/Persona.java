package ar.edu.utn.frsf.problemaIntegrador;

public abstract class Persona implements CriterioBusqueda<Localidad> {

    protected static Integer id;
    protected String nombre;
    protected Localidad localidad;

    public Persona(){

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
        Persona.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @Override
    public Boolean esDeLocalidad(Localidad l) {

        return this.localidad.equals(l);
    }
}
