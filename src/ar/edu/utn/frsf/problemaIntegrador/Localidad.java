package ar.edu.utn.frsf.problemaIntegrador;

import java.util.Objects;

public class Localidad extends Ubicacion{

    Provincia provincia;

    public Localidad(){
        super();
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad localidad = (Localidad) o;
        return this.nombre.equals(localidad.getNombre()) &&
                localidad.provincia.equals(this.provincia) &&
                localidad.provincia.getPais().equals(this.provincia.getPais());
    }

    @Override
    public int hashCode() {
        return Objects.hash(provincia);
    }
}
