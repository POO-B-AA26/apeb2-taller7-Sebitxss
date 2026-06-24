/***
 * Problema 2: Alquiler de Películas
 * Un videoclub dispone de una serie de películas que pueden estar en DVD (con capacidad en Gb.) 
 * o en VHS (una sola cinta por película y con cierto tipo de cinta magnetica). 
 * De las películas interesa guardar el título, el autor, el año de edición 
 * y el idioma (o los idiomas, en caso de DVD). El precio de alquiler de las películas varía 
 * en función del tipo de película. Las DVD siempre son 10% mas caras que las de VHS.
 * @author sebas
 */
class Soporte{
    public Pelicula pelicula;
    public int cantidad;
    public double costoAlquiler, precio;

    public Soporte(Pelicula pelicula, int cantidad, double precio) {
        this.pelicula = pelicula;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public double calcularCosto(){
        this.costoAlquiler = (this.cantidad * this.precio);
        return this.costoAlquiler;
    }

    @Override
    public String toString() {
        return "Soporte{" + "pelicula=" + pelicula + ", cantidad=" + cantidad + ", costoAlquiler=" + costoAlquiler + ", precio=" + precio + '}';
    }
    
    
    
}
class Pelicula{
    public Soporte soporte;
    public String titulo;
    public String autor;
    public int anio;

    public Pelicula(Soporte soporte, String titulo, String autor, int anio) {
        this.soporte = soporte;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }
     

    @Override
    public String toString() {
        return "Pelicula{" + "soporte=" + soporte + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + '}';
    }
    
    
}
class DVD extends Soporte{
    public String idiomas[];
    public double porcentajeRecargo;

    public DVD(String[] idiomas, double porcentajeRecargo, Pelicula pelicula, int cantidad, double precio) {
        super(pelicula, cantidad, precio);
        this.idiomas = idiomas;
        this.porcentajeRecargo = porcentajeRecargo;
    }

    public double calcularCosto(){
        this.costoAlquiler = super.calcularCosto() + (this.costoAlquiler * (this.porcentajeRecargo / 100));
        return this.costoAlquiler;
    }

    @Override
    public String toString() {
        return "DVD{" + "idiomas=" + idiomas + ", descuento=" + porcentajeRecargo + '}';
    } 
}
class VHS extends Soporte{
    public String idioma;

    public VHS(String idioma, int costoAlquiler) {
        super(costoAlquiler);
        this.idioma = idioma;
    }
    
    @Override
    public double calcularCosto(){
        return costoAlquiler;
    }

    @Override
    public String toString() {
        return "VHS{" + "idioma=" + idioma + '}';
    }

}
public class EjecutorProblema_2_AlquilerPeliculas {
    public static void main(String[] args) {
        double total = 0;
        System.out.println("ALQUILER DE PELICULAS");
        VHS vhs1 = new VHS("Ingles", 30);
        VHS vh2 = new VHS("Español", 20);
        
        String[] idiomasDVD1 = {"Ingles", "Español","Portugues"};
        DVD dvd1 = new DVD(idiomasDVD1, total, pelicula, 0, total);
        String[] idiomasDVD2 = {"Ingles", "Español","Portugues"};
        Pelicula p1 = new Pelicula(vhs1, "Star Wars", "George Lucas", 1977);
        Pelicula p2 = new Pelicula(dvd1, "Harry Potter", "J.K Rowling", 1990);
        Pelicula p3 = new Pelicula(vhs1, "Dia de la Independencia", "Ronald Emmerich", 1996);
        Pelicula p4 = new Pelicula(dvd2, "Cars", "Jhon Lasseter", 2010);
        Pelicula[] peliculas = {p1, p2, p3, p4};
        
    }
}
/***
 * 
 */
