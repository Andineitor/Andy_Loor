package Generos;

public class Videojuegos {
    //primero declararemos las variables que usaremos
    private String nombre;

    private String siglas;

    private int anio;

    private String genero;

    private String empresa;

    //Creamos los constructores
    public Videojuegos(String nombre, String siglas, int anio, String genero, String empresa) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.anio = anio;
        this.genero = genero;
        this.empresa = empresa;
    }

    //y creamos los setters y getters para usarlos en las clases
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    //Este apartado nos servira para poder almacenar los getters de las variables y lo podremos usar en las otras clases
    @Override
    public String toString() {
        return " " + getClass() + "\nEl nombre del videojuego es: " + getNombre() +
                "\nLa abreviatura del videojuego es: " + getSiglas() +
                "\nEl año de lanzamiento es: " + getAnio() +
                "\nEl videojuego pertenece al genero : " + getGenero() +
                "\nLa empresa que lo desarrollo: " + getEmpresa();
    }
}



