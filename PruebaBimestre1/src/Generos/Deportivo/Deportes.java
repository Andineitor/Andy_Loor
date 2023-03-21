package Generos.Deportivo;
import Generos.Videojuegos; //importamos para poder utilizar la clase Videojuegos

public class Deportes extends Videojuegos {

    public Deportes (String nombre, String siglas, int anio, String genero, String empresa){super(nombre, siglas, anio, genero, empresa);}

    @Override//en este apartado usaremos el Override de la clase principal para poder almacenar datos acerca del juego
    public String toString(){
        return " " + getClass() + "\nEl nombre del videojuego es: " + getNombre() +
                "\nLa abreviatura del videojuego es: " + getSiglas() +
                "\nEl año de lanzamiento es: " + getAnio() +
                "\nEl videojuego pertenece al genero : " + getGenero() +
                "\nLa empresa que lo desarrollo: " + getEmpresa();
    }
}
