public class Usuario {
    private String nombre;
    private String cargo;
    private int id;

    private int edad;


    public void setNombre(){
        nombre="Rodolfo";
    }

    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }

    String getNombre(){
        return nombre ;

    }

    public void setCargo(){
        cargo="Vendedor";
    }

    public void setCargo(String nuevoCargo){
        cargo = nuevoCargo;
    }

    String getCargo(){
        return cargo ;

    }

    public void setId(){
        id=1750253187;
    }

    public void setId(int nuevoid){
        id = nuevoid;
    }

    int getid(){
        return id ;

    }

    public void setEdad(){
        edad=18;
    }

    public void setEdad(int nuevoid){
        edad = nuevoid;
    }

    int getEdad(){
        return id ;

    }
}
