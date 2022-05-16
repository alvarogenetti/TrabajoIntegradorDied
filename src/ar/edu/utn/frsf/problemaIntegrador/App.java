package ar.edu.utn.frsf.problemaIntegrador;

import ar.edu.utn.frsf.problemaIntegrador.exceptions.ProveedorOtroPaisException;

import java.util.Date;

public class App {

    public static void main(String[] args){

        //creo paises
        Pais pais1= new Pais();
        pais1.setNombre("ARG");//ARGENTINA

        Pais pais2= new Pais();
        pais2.setNombre("CHI");//CHILE

        //creo provincias
        //SANTA FE
        Provincia provincia1= new Provincia();
        provincia1.setNombre("Santa Fe");
        provincia1.setPais(pais1);

        //MAGALLANES
        Provincia provincia2= new Provincia();
        provincia2.setNombre("Magallanes");//PROVINCIA DE CHILE AL SUR DEL PERITO MORENO
        provincia2.setPais(pais2);

        //ENTRE RIOS
        Provincia provincia3= new Provincia();
        provincia3.setPais(pais1);
        provincia3.setNombre("Entre Rios");

        //creo Localdiades
        //SANTAFE CAPITAL
        Localidad localidad1= new Localidad();
        localidad1.setNombre("Santa Fe");
        localidad1.setProvincia(provincia1);

        //GALVEZ - PROV SANTA FE
        Localidad localidad2= new Localidad();
        localidad2.setNombre("Galvez");
        localidad2.setProvincia(provincia1);

        //PARANA - ENTRE RIOS
        Localidad localidad3= new Localidad();
        localidad3.setProvincia(provincia3);
        localidad3.setNombre("Parana");

        //PUERTO NATALES - MAGALLANES - CHILE
        Localidad localidad4= new Localidad();
        localidad4.setNombre("Puerto Natales");
        localidad4.setProvincia(provincia2);

        //creo proveedores
        Proveedor proveedor1= new Proveedor();
        proveedor1.setNombre("Botilleria Blanco Encalada");
        proveedor1.setLocalidad(localidad4);

        Proveedor proveedor2= new Proveedor();
        proveedor2.setNombre("Gin Mitos");
        proveedor2.setLocalidad(localidad3);

        Proveedor proveedor3= new Proveedor();
        proveedor3.setNombre("Maderera Raimondi");
        proveedor3.setLocalidad(localidad2);

        //creoResponsable
        Responsable responsable1= new Responsable();
        responsable1.setNombre("Maxi R");
        responsable1.setLocalidad(localidad1);

        //creoBien
        Bien gin= new Bien();
        gin.setAlias("Gin Mitos");
        gin.setDescripcion("Botella de 1L de Gin marca Mitos");
        gin.setResponsable(responsable1);
        gin.setPrecio(1000.0);
        proveedor2.addBien(gin);

        Bien silla= new Bien();
        silla.setAlias("Silla Raimondi");
        silla.setDescripcion("Silla de madera con tapizado color gris");
        silla.setPrecio(600.0);
        silla.setResponsable(responsable1);
        proveedor3.addBien(silla);

        //proveedor de otro pais
        /**
        * Mensaje == El proveedor no puede ser de un pais distinto al del responsable -> paso prueba
        * Mensaje == Excepcion no esperada -> no paso prueba
        * */
        Factura factura= new Factura();
        factura.setResponsable(responsable1);
        factura.setFecha(new Date());
        try{
            factura.setProveedor(proveedor1);
        }
        catch (ProveedorOtroPaisException pope){
            System.out.println(pope.getMessage());
        }
        catch (Exception e){
            System.out.println("Excepcion no esperada");
        }

        //calcular monto total enviado desde otra provincia
        /**
         * monto = 1000 + 1000*0.7 = 1700
         * Salida == monto a pagar = 1700.0 -> paso prueba
         * Salida == Excepcion no esperada || monto a pagar != 1700.0 -> no paso prueba
         * */
        try{
            factura.setProveedor(proveedor2);
            factura.addBien(gin);
        }
        catch (Exception e){
            System.out.println("Excepcion no esperada");
        }
        factura.calcularMontoTotal();
        System.out.println("Monto a pagar = "+factura.getMontoTotal());

        //calcular monto total enviado desde otra provincia + misma provincia otra localidad
        /**
         * monto= 600*4 + 600*4*0.3= 3120
         * Salida == monto a pagar = 3120.0 -> paso prueba
         * Salida == Excepcion no esperada || monto a pagar != 3120.0 -> no paso prueba
         * */
        Factura factura2= new Factura();
        factura2.setResponsable(responsable1);
        factura2.setFecha(new Date());
        try{
            factura2.setProveedor(proveedor3);
            for(int i=0; i<4; i++){
                factura2.addBien(silla);
            }
        }
        catch (Exception e){
            System.out.println("Excepcion no esperada");
        }
        factura2.calcularMontoTotal();
        System.out.println("Cantidad de sillas= "+factura2.getBienes().size());
        System.out.println("Monto a pagar = "+factura2.getMontoTotal());
    }
}
