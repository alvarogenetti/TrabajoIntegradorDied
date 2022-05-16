package ar.edu.utn.frsf.problemaIntegrador;

import ar.edu.utn.frsf.problemaIntegrador.exceptions.ProveedorOtroPaisException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {

    private final Integer CANT_MAX_BIENES=20;

    private static Integer id;
    private Double montoTotal;
    private List<Bien> bienes;
    private Responsable responsable;
    private Proveedor proveedor;
    private Date fecha;

    public Factura(){

        if(id == null)
            id=0;
        else
            id++;

        bienes= new ArrayList<>();
    }

    public List<Bien> getBienes(){
        return this.bienes;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void addBien(Bien bien) throws Exception {

        if(bienes.size()< CANT_MAX_BIENES){
            bienes.add(bien);
        }
        else {
            throw  new Exception("TAMAÑO MAXIMO DE BIENES SUPERADO");
        }
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) throws ProveedorOtroPaisException {

        if(proveedor.getLocalidad().getProvincia().getPais()
                .equals(this.responsable.getLocalidad().getProvincia().getPais())){

            this.proveedor=proveedor;
        }
        else{
            throw new ProveedorOtroPaisException("El proveedor no puede ser de un pais distinto al del responsable");
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void calcularMontoTotal(){

        Double monto= calcularMontoPagar();

        this.montoTotal= monto - calcularDescuento(monto);

    }

    private Double calcularMontoPagar(){
        Double monto= this.bienes.stream().mapToDouble(b -> b.getPrecio()).sum();

        if(this.proveedor.getLocalidad().equals(this.responsable.getLocalidad())){
                monto= monto + monto*0.1;
        }
        else if(this.proveedor.getLocalidad().getProvincia().equals(this.responsable.getLocalidad().getProvincia())){
                monto= monto + monto*0.3;
        }
        else{
            monto= monto + monto*0.7;
        }

        return monto;
    }

    private Double calcularDescuento(Double monto){

        if(this.bienes.size()>10){
            return monto*0.20;
        }

        if(this.bienes.size()>5){
            return monto*0.1;
        }

        return 0.0;
    }


}
