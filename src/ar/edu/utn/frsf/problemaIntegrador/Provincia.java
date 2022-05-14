package ar.edu.utn.frsf.problemaIntegrador;

import java.util.Objects;

public class Provincia extends  Ubicacion{

    private Pais pais;

    public Provincia(){
        super();
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return this.nombre.equals(provincia.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(pais);
    }
}
