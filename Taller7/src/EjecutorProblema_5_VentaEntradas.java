
/**
 * Problema 5 - Venta de entradas al teatro
 * Se desea gestionar la venta de entradas para un espectáculo en un teatro. 
 * El patio de butacas del teatro se divide en varias zonas, cada una identificada por su nombre. 
 * Los datos de las zonas son los mostrados en la siguiente tabla:

NOMBRE ZONA	NÚMERO DE LOCALIDADES	PRECIO NORMA	PRECIO ABONADO
Principal               200                 25$              17.5$
PalcoB                  40                  70$               40$
Central             	400                 20$               14$
Lateral                 100                 15.5$               10$
* 
* 
Para realizar la compra de una entrada, un espectador debe indicar la zona que desea y presentar al 
vendedor el documento que justifique que tiene algún tipo de descuento (estudiante, abonado o pensionista). 
El vendedor sacará la entrada del tipo apropiado y de la zona indicada, 
en el momento de la compra se asignará a la entrada un identificador (un número entero) 
que permitirá la identificación de la entrada en todas las operaciones que posteriormente se desee realizar con ella.
Una entrada tiene como datos asociados su identificador, la zona a la que pertenece y el nombre del comprador.

Los precios de las entradas dependen de la zona y del tipo de entrada según lo explicado a continuación:

Entradas normales: su precio es el precio normal de la zona elegida sin ningún tipo de descuento.
Entradas reducidas (para estudiantes o pensionistas): su precio tiene una rebaja del 15% sobre el precio normal de la zona elegida.
Entradas abonado: su precio es el precio para abonados de la zona elegida.
La interacción entre el vendedor y la aplicación es la descrita en los siguientes casos de usos.
 * @author sebas
 */
class Zona{
    public String nombreZona;
    public int cantLocalidades;
    public double precioNormal, precioAbonado;

    public Zona(String nombreZona, int cantLocalidades, double precioNormal, double precioAbonado) {
        this.nombreZona = nombreZona;
        this.cantLocalidades = cantLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombreZona=" + nombreZona + ", cantLocalidades=" + cantLocalidades + ", precioNormal=" + precioNormal + ", precioAbonado=" + precioAbonado + '}';
    }
    
    
}
class Entrada{
    public int idEntrada, cantEntradas;
    public Zona zonas;
    public String nombreComprador;
    public double costoEntrada;

    public Entrada(int idEntrada, int cantEntradas, Zona zonas, String nombreComprador) {
        this.idEntrada = idEntrada;
        this.cantEntradas = cantEntradas;
        this.zonas = zonas;
        this.nombreComprador = nombreComprador;
    }
    
    
    public double calcularCostoEntrada(double precioEntrada){
        this.costoEntrada = this.cantEntradas * precioEntrada;
        return this.costoEntrada;
    }

    @Override
    public String toString() {
        return "Entrada{" + "idEntrada=" + idEntrada + ", cantEntradas=" + cantEntradas + ", zonas=" + zonas + ", nombreComprador=" + nombreComprador + ", costoEntrada=" + costoEntrada + '}';
    }
    
}
class Entrada_Normal extends Entrada{

    public Entrada_Normal(int idEntrada, int cantEntradas, Zona zonas, String nombreComprador) {
        super(idEntrada, cantEntradas, zonas, nombreComprador);
    }
    
    public double calcularCostoEntrada(){
        this.costoEntrada = super.calcularCostoEntrada(this.zonas.precioNormal);
        return this.costoEntrada;
    }
    
}
class Entrada_Reducida extends Entrada{
    public double porcentajeRebaja;

    public Entrada_Reducida(double porcentajeRebaja, int idEntrada, int cantEntradas, Zona zonas, String nombreComprador) {
        super(idEntrada, cantEntradas, zonas, nombreComprador);
        this.porcentajeRebaja = porcentajeRebaja;
    }
    
    public double calcularCostoEntrada(){
        this.costoEntrada = super.calcularCostoEntrada(this.zonas.precioNormal - (this.zonas.precioNormal * (this.porcentajeRebaja / 100)));
        return this.costoEntrada;
    }

    @Override
    public String toString() {
        return "Entrada_Reducida{" + "porcentajeRebaja=" + porcentajeRebaja + '}' + super.toString();
    }
    
}
class Entrada_Abonado extends Entrada{

    public Entrada_Abonado(int idEntrada, int cantEntradas, Zona zonas, String nombreComprador) {
        super(idEntrada, cantEntradas, zonas, nombreComprador);
    }
    
    public double calcularCostoEntrada(){
        this.costoEntrada = super.calcularCostoEntrada(this.zonas.precioAbonado);
        return this.costoEntrada;
    }

    @Override
    public String toString() {
        return "Entrada_Abonado{" + '}';
    }
    
    
}
public class EjecutorProblema_5_VentaEntradas {
    public static void main(String[] args) {
        Zona zona1 = new Zona("Principal", 200, 25, 17.5);
        Zona zona2 = new Zona("PalcoB", 40, 70, 40);
        Zona zona3 = new Zona("Central", 400, 20, 14);
        Zona zona4 = new Zona("Lateral", 100, 15.5, 10);
        Entrada_Normal entnormal1 = new Entrada_Normal(1, 2, zona1, "Daniela");
        Entrada_Reducida entRedu1 = new Entrada_Reducida(15, 2, 1, zona2, "Gaby");
        Entrada_Abonado entAbo1 = new Entrada_Abonado(3, 1, zona4, "Allyson");
        
        entnormal1.calcularCostoEntrada();
        entRedu1.calcularCostoEntrada();
        entAbo1.calcularCostoEntrada();
        
        System.out.println(entnormal1);
        System.out.println(entRedu1);
        System.out.println(entAbo1);           
    }
}
