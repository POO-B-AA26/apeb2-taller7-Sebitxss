
/**
 * Problema 1: Jerarquía de clases para el capítulo de libro
 * Dibuje un diagrama de clases que muestre la estructura de un capítulo de libro;
 * un capítulo está compuesto por varias secciones, cada una de las cuales comprende varios párrafos y figuras.
 * Un párrafo incluye varias sentencias, cada una de las cuales contiene varias palabras.
 *
 * @author sebas
 */

class componenteSeccion {

    public String titulo;
    public int numero;

    public componenteSeccion(String titulo, int numero) {
        this.titulo = titulo;
        this.numero = numero;
    }

    public void mostrar() {
        System.out.println("Título: " + titulo);
    }
}

class Seccion {

    public String titulo;
    public int cantComponentes;
    public componenteSeccion[] componentes;

    public Seccion(int numero, String titulo) {
        this.titulo = titulo;
        this.cantComponentes = 0;
        componentes = new componenteSeccion[10];
    }

    public void agregarComponente(componenteSeccion comp) {
        componentes[cantComponentes++] = comp;
    }

    @Override
    public String toString() {
        String texto = "Sección: " + titulo + "\n";

        for (int i = 0; i < cantComponentes; i++) {
            texto += "   - " + componentes[i].titulo + "\n";
        }
        return texto;
    }
}

class Capitulo extends componenteSeccion {

    public int cantSecciones; 
    public Seccion[] secciones;

    public Capitulo(int numero, String titulo) {
        super(titulo, numero);
        cantSecciones = 0;
        secciones = new Seccion[10];
    }

    public void agregarSeccion(Seccion sec) {
        secciones[cantSecciones++] = sec;
    }

    @Override
    public void mostrar() {
        System.out.println("CAPÍTULO " + numero + ": " + titulo);

        for (int i = 0; i < cantSecciones; i++) {
            System.out.println(secciones[i]);
        }
    }
}

class Palabra {

    public String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return "Palabra{" + "texto=" + texto + '}';
    }
}

class Sentencia {

    public int cantPalabras;
    public Palabra[] palabras;
    public int tamano;

    public Sentencia(int tamano) {
        this.cantPalabras = 0;
        palabras = new Palabra[tamano];
    }

    public void agregarPalabra(Palabra pal) {
        palabras[cantPalabras] = pal;
        cantPalabras++;
    }

    @Override
    public String toString() {
        return "Sentencia{" + "cantPalabras=" + cantPalabras + ", palabras=" + palabras + ", tamano=" + tamano + '}';
    }
}
class Parrafo extends componenteSeccion {

    public int cantSentencias;
    public Sentencia[] sentencias;

    public Parrafo(int capacidad) {
        super("Párrafo", 0);
        cantSentencias = 0;
        sentencias = new Sentencia[capacidad];
    }

    public void agregarParrafo(Sentencia sent) {
            sentencias[cantSentencias++] = sent;
    }
}

class Figura extends componenteSeccion {

    public String url;
    public String descripcion;

    public Figura(String url, String descripcion) {
        super("Figura", 0);
        this.url = url;
       this.descripcion = descripcion;
    }
}

public class EjecutorProblema_1_CapituloLibro {

    public static void main(String[] args) {
        Palabra el = new Palabra("El");
        Palabra es = new Palabra("es");
        Sentencia sent1 = new Sentencia(4);
        sent1.agregarPalabra(el);
        sent1.agregarPalabra(new Palabra("helado"));
        sent1.agregarPalabra(es);
        sent1.agregarPalabra(new Palabra("rico"));
        Sentencia sent2 = new Sentencia(3);
        sent2.agregarPalabra(new Palabra("El"));
        sent2.agregarPalabra(new Palabra("idioma"));
        sent2.agregarPalabra(new Palabra("latino"));
        Parrafo par1 = new Parrafo(2);
        par1.agregarParrafo(sent1);
        par1.agregarParrafo(sent2);
        Figura fig1 = new Figura("img1/maps.com", "Mapa de Sudamérica");
        Seccion sec1 = new Seccion(1, "Origen del español");
        sec1.agregarComponente(par1);
        sec1.agregarComponente(fig1);
        Capitulo capitulo = new Capitulo(1, "Introducción al español");
        capitulo.agregarSeccion(sec1);
        capitulo.mostrar();
    }
}
/***
 * run:
CAPÍTULO 1: Introducción al español
Sección: Origen del español
   - Párrafo
   - Figura

BUILD SUCCESSFUL (total time: 0 seconds)
 */