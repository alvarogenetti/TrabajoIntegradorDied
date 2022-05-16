package ar.edu.utn.frsf.problemaIntegrador;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona {

    private List<Bien> bienes;

    public Proveedor(){
        super();
        bienes= new ArrayList<>();
    }

    public void addBien(Bien b){
        bienes.add(b);
    }
}
