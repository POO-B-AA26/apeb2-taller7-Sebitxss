/**
 * Problema 6 - Sistema Un Banco
 * El banco UN BANCO mantiene las cuentas de varios clientes. 
 * Los datos que describen a cada una de las cuentas consisten en el número de cuenta,
 * el nombre del cliente y el balance actual. 
 * Escriba una clase para implementar dicha cuenta bancaria. 
 * El método constructor debe aceptar como parámetros el número de cuenta y el nombre. 
 * Debe proporcionarse métodos para depositar o retirar una cantidad de dinero 
 * y obtener el balance actual.El banco ofrece a sus clientes dos tipos de cuentas, 
 * una de CHEQUES y una de AHORROS. Una cuenta de cheques puede sobregirarse 
 * (el balance puede ser menor que cero), pero una cuenta de ahorros no. 
 * Al final de cada mes, se calcula el interés sobre la cantidad que tenga la cuenta de ahorros. 
 * Este interés se suma al balance. 
 * Escriba clases para describir cada uno de estos tipos de cuentas, 
 * haciendo un máximo uso de la herencia. 
 * La clase de la cuenta de ahorros debe proporcionar un método que sea invocado para calcular el interés. 
 * Además, el banco está pensando en implementar una cuenta PLATINO 
 * que viene siendo similar a los otros dos tipos anteriores de cuentas bancarias, 
 * ésta tiene el interés del 10%, sin cargos ni castigos por sobregiro.
 * @author sebas
 */
class Cuenta{
    public String numCuenta, nomCliente;
    public double balance;

    public Cuenta(String numCuenta, String nomCliente) {
        this.numCuenta = numCuenta;
        this.nomCliente = nomCliente;
    }
    
    public void depositar(double cantidad){
        balance = balance + cantidad;
        System.out.println("Deposito de $ " + cantidad);
    }
    
    public void retirar(double cantidad){
        balance = balance - cantidad;
        System.out.println("Retiro de $ " + cantidad);
    }
    
    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", nomCliente=" + nomCliente + ", balance=" + balance + '}';
    }
}
class CuentaCheques extends Cuenta{

    public CuentaCheques(String numCuenta, String nomCliente) {
        super(numCuenta, nomCliente);
    }

    @Override
    public String toString() {
        return "CuentaCheques{" + '}' + super.toString();
    }
}
class CuentaAhorros extends Cuenta{
    public double tasaInteres;

    public CuentaAhorros(double tasaInteres, String numCuenta, String nomCliente) {
        super(numCuenta, nomCliente);
        this.tasaInteres = tasaInteres;
    }
    
    @Override
    public void retirar(double cantidad) {
        if (cantidad > balance) {
            System.out.println("ERROR! no hay suficiente saldo. Balance actual: $" + balance);
        } else {
            balance = balance - cantidad;
            System.out.println("Retiro de $" + cantidad + " realizado.");
        }
    }
    
    public void calcularInteres(){
        double interes;
        interes = balance * tasaInteres;
        balance = balance + interes;
        System.out.println("Interes = " + interes + " sumado al balance");
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" + super.toString() + "tasaInteres=" + tasaInteres * 100+  "%" + '}';
    }  
}
class CuentaPlatino extends Cuenta{
    public double tasaInteres = 0.10;

    public CuentaPlatino(String numCuenta, String nomCliente) {
        super(numCuenta, nomCliente);
    }
    
    public void calcularInteres(){
        double interes = balance * tasaInteres;
        balance = balance + interes;
        System.out.println("Interes Platino (10%) $" + interes);
    }

    @Override
    public String toString() {
        return "CuentaPlatino{" + super.toString()+"tasaInteres=" + tasaInteres + '}';
    }
    
}
public class EjecutorProblema_5_Banco {
    public static void main(String[] args) {
        CuentaCheques c1 = new CuentaCheques("2202483920393", "Juan Perez");
        c1.depositar(500);
        c1.retirar(700);
        System.out.println(c1);
        
        CuentaAhorros c2 = new CuentaAhorros(0.10, "2204949334", "Lupe Loyola");
        c2.depositar(500);
        c2.retirar(200);
        c2.retirar(450);
        c2.calcularInteres();
        System.out.println(c2);
        
        CuentaPlatino c3 = new CuentaPlatino("2204493938495", "Carlos Vaca");
        c3.depositar(1200);
        c3.retirar(1500);
        c3.calcularInteres();
        System.out.println(c3);

    }
}
/***
 * run:
Deposito de $ 500.0
Retiro de $ 700.0
CuentaCheques{}Cuenta{numCuenta=2202483920393, nomCliente=Juan Perez, balance=-200.0}
Deposito de $ 500.0
Retiro de $200.0 realizado.
ERROR! no hay suficiente saldo. Balance actual: $300.0
Interes = 30.0 sumado al balance
CuentaAhorros{Cuenta{numCuenta=2204949334, nomCliente=Lupe Loyola, balance=330.0}tasaInteres=10.0%}
Deposito de $ 1200.0
Retiro de $ 1500.0
Interes Platino (10%) $-30.0
CuentaPlatino{Cuenta{numCuenta=2204493938495, nomCliente=Carlos Vaca, balance=-330.0}tasaInteres=0.1}
BUILD SUCCESSFUL (total time: 0 seconds)
 */