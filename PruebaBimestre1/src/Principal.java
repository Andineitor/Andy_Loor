//Importamos  librerias
// y tambien las librerias que nos ayudaran a crear nuestro archivo de texto
import Generos.Videojuegos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static int dato (){
        Scanner leer = new Scanner(System.in);
        int aux;
        System.out.print("Ingresa la cantidad de videojuegos: ");//le preguntamos al usuario el numero
        aux = leer.nextInt();                                    //de videojuegos que desea ingresar al programa
        return aux;
    }
    private static void Entrada(Videojuegos a[]){
        Scanner leer=new Scanner(System.in);
        //creamos variables para poder usarlas en
        String nombre;
        String siglas;
        int anio ;
        String genero;
        String empresa;

        //Ingresamos la informacion de los videojuegos que deseamos crear
        for(int i=0; i<a.length;i++ ){
            System.out.println("----Videojuego----- ["+(i+1)+"]");
            System.out.print("Ingrese el nombre del videojuego: ");
            nombre=leer.nextLine();
            System.out.print("Ingrese la abreviatura del juego: ");
            siglas=leer.nextLine();
            System.out.print("Ingrese el año de lanzamiento del videojuego: ");
            anio=leer.nextInt();
            System.out.print("Ingrese el genero al que pertenece: ");
            genero=leer.nextLine();
            leer.nextLine();
            System.out.print("Ingrese el nombre de la empresa que lo desarrollo: ");
            empresa=leer.nextLine();

            a[i]=new Videojuegos(nombre,siglas,anio,genero,empresa);
        }
        //Impimimos la informacion de los videojuegos ingresados
        for(int i=0;i<a.length;i++){
            System.out.println("----Videojuego----- ["+(i+1)+"]");
            System.out.println(a[i].toString());
        }
    }
    public static void guardar(Videojuegos b[]){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\ProyectsIntellij\\PruebaBimestre1\\Generos.Videojuegos.txt"))){
            for (int i=0;i< b.length;i++){
                bw.write("----Videojuego----- ["+(i+1)+"]");
                bw.write(b[i].toString());
            }
            System.out.println("Escritura Correcta");
        }catch (IOException e){
            System.out.println("Error en el direccionamiento");
        }
    }
    public static void main(String[] args) {
        int num=dato();
        Videojuegos aux1[]= new Videojuegos[num];
        Entrada(aux1);
        guardar(aux1);
    }
}
