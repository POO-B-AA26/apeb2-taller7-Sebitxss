
/**
 * Problema 3 - Sistema de envío de mensajes a móviles
 * Implemente un sistema de envío de mensajes a móviles. 
 * Existen dos tipos de mensajes que se pueden enviar entre móviles, 
 * mensajes de texto (SMS) y mensajes que contienen imágenes (MMS). 
 * Por un lado, los mensajes de texto contienen un mensaje en caracteres 
 * que se desea enviar de un móvil a otro. Por otro lado, los mensajes que contienen 
 * imágenes almacenan información sobre la imagen a enviar, 
 * la cual se representará por el nombre del fichero que la contiene. 
 * Independientemente del tipo de mensaje, cada mensaje tendrá asociado un remitente 
 * de dicho mensaje y un destinatario. Ambos estarán definidos obligatoriamente 
 * por un número de móvil, y opcionalmente se podrá guardar información sobre su nombre. 
 * Además, los métodos enviarMensaje y visualizarMensaje deben estar definidos.
 * @author sebas
 */
class Movil{
    public String numero;
    public String nombre;

    public Movil(String numero) {
        this.numero = numero;
        this.nombre = "";
    }

    public Movil(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "movil{" + "numero=" + numero + ", nombre=" + nombre + '}';
    }   
}
class Mensaje{
    public Movil remitente;
    public Movil destinatario;

    public Mensaje(Movil remitente, Movil destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }
    
    public void enviarMSM(){
        System.out.println("Enviando mensaje... ");
        remitente.toString();
        System.out.print(" para ");
        destinatario.toString();
    }
    
    public void verMSM(){
        System.out.println("MSM de... ");
        remitente.toString();
        System.out.println("Para... ");
        destinatario.toString();
    }
}
class SMS extends Mensaje{
    public String texto;

    public SMS(String texto, Movil remitente, Movil destinatario) {
        super(remitente, destinatario);
        this.texto = texto;
    }
    
    @Override
    public void enviarMSM(){
        System.out.println("(SMS) Enviado de ");
        remitente.toString();
        System.out.print(" para ");
        destinatario.toString();
    }
    
    @Override
    public void verMSM(){
        System.out.println("--SMS--");
        super.verMSM();
        System.out.println("Mensaje... " + texto);
    }
}
class MMS extends Mensaje{
    public String nombreFichero;

    public MMS(String nombreFichero, Movil remitente, Movil destinatario) {
        super(remitente, destinatario);
        this.nombreFichero = nombreFichero;
    }
    
    @Override
    public void enviarMSM(){
        System.out.print("(MMS) Enviando de ");
        remitente.toString();
        System.out.print(" para ");
        destinatario.toString();
    }
    
    @Override
    public void verMSM(){
        System.out.println("--MMS--");
        super.verMSM();
        System.out.println("Imagen " + nombreFichero);
    }
}
public class EjecutorProblema_3_EnvioMensajes {
    public static void main(String[] args) {
        Movil cel1 = new Movil("0967343280", "Sebas");
        Movil cel2 = new Movil("0975434893");
        
        SMS sms1 = new SMS("Hola, que tal?", cel1, cel2);
        MMS mms1 = new MMS("imagen1.jpg", cel2, cel1);
        
        sms1.enviarMSM();
        sms1.verMSM();
        
        mms1.enviarMSM();
        mms1.verMSM();
    }
}
