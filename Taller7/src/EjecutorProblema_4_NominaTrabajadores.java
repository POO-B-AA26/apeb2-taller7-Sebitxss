/**
 * Problema 4 - Sistema de nómina para trabajadores
 * 
 * Se desea desarrollar un sistema de nómina para los trabajadores de una empresa.
 * Los datos personales de los trabajadores son nombre y apellidos, dirección y DNI.
 * Además, existen diferentes tipos de trabajadores:
 * Fijos Mensuales: que cobran una cantidad fija al mes.
 * Comisionistas: cobran un porcentaje fijo por las ventas que han realizado
 * Por Horas: cobran un precio por cada una de las horas que han realizado durante el mes. 
 * El precio es fijo para las primeras 40 horas y es otro para las horas realizadas a partir de la 40 hora mensual.
 * Jefe: cobra un sueldo fijo (no hay que calcularlo). 
 * Cada empleado tiene obligatoriamente un jefe (exceptuando los jefes que no tienen ninguno). 
 * El programa debe permitir dar de alta a trabajadores, 
 * así como fijar horas o ventas realizadas e imprimir la nómina correspondiente al final de mes.
* @author sebas
*/
class Trabajador{
    public String nombre, apellido, direccion, dni;
    public Jefe jefe;
    public Trabajador(String nombre, String apellido, String direccion, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = null;
    }
    public void ponerJefe(Jefe jefe){
        this.jefe = jefe;
    }
    public double calcularSueldo(){
        return 0;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", jefe=" + jefe + '}';
    }
     
    
}
class Jefe extends Trabajador{
    public double sueldoFijo;

    public Jefe(double sueldoFijo, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.sueldoFijo = sueldoFijo;
    }
    
    @Override
    public double calcularSueldo(){
        return sueldoFijo;
    }

    @Override
    public String toString() {
        return "Jefe{" + "sueldoFijo=" + sueldoFijo + '}';
    }
}
class FijoMensual extends Trabajador{
    public double sueldoMensual;

    public FijoMensual(double sueldoMensual, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.sueldoMensual = sueldoMensual;
    }
    
    @Override
    public double calcularSueldo(){
        return sueldoMensual;
    }

    @Override
    public String toString() {
        return "FijoMensual{" + "sueldoMensual=" + sueldoMensual + '}';
    }
    
}
class Comisionista extends Trabajador{
    public double porcentaje, ventas;

    public Comisionista(double porcentaje, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.porcentaje = porcentaje;
        this.ventas = 0;
    }
    
    public void fijarVenta(double ventas){
        this.ventas = ventas;
    }
    
     @Override
    public double calcularSueldo(){
        return porcentaje;
    }

    @Override
    public String toString() {
        return "Comisionista{" + "porcentaje=" + porcentaje + ", ventas=" + ventas + '}';
    }
    
}
class Horas extends Trabajador{
    public double precioHoraNormal, precioHoraExtra, horasTrabajadas;

    public Horas(double precioHoraNormal, double precioHoraExtra,String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.precioHoraNormal = precioHoraNormal;
        this.precioHoraExtra = precioHoraExtra;
        this.horasTrabajadas = 0;
    }
    
    public void fijarHoras(double horas){
        this.horasTrabajadas = horas;
    }
    
    @Override
    public double calcularSueldo() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * precioHoraNormal;
        } else {
            double sueldoNormal = 40 * precioHoraNormal;
            double sueldoExtra  = (horasTrabajadas - 40) * precioHoraExtra;
            return sueldoNormal + sueldoExtra;
        }
    }

    @Override
    public String toString() {
        return "Horas{" + "precioHoraNormal=" + precioHoraNormal + ", precioHoraExtra=" + precioHoraExtra + ", horasTrabajadas=" + horasTrabajadas + '}';
    }
}
public class EjecutorProblema_4_NominaTrabajadores {
    public static void main(String[] args) {
        Jefe jefe = new Jefe(500, "Carlos", "Chavez", "Miguel Riofrio", "1103557365");
        
        FijoMensual fm1 = new FijoMensual(450.80, "Romina", "Plata", "Av. Occidental", "1905842957");
        fm1.ponerJefe(jefe);
        
        Comisionista cm1 = new Comisionista(0.15, "Carlos", "Machado", "Av. 24 de Mayo", "1105882457");
        cm1.ponerJefe(jefe);
        cm1.fijarVenta(8500);
        
        Horas h1 = new Horas(5, 8, "Diana", "Loaiza", "18 de Noviembre", "190267849");
        h1.ponerJefe(jefe);
        h1.fijarHoras(50);
        
        fm1.toString();
        cm1.toString();
        h1.toString();
    }
}
