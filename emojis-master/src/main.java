import javax.swing.*;
public class main { //--> Funcion principal
    public static void main(String[] args) {
        //
        String entrada = JOptionPane.showInputDialog

                // Creacion de el menu para la seleccionde las caras a mostrar
                ("----Bienvenido al menu de seleccion de Emojis---" +
                        "\n**Digite un numero para elegir su emoji**"+
                        "\n\n1.-Cara Feliz" +
                        "\n2.-Cara Seria"  +
                        "\n3.-Cara muy Seria"+
                        "\n4.-Cara Al revez"+
                        "\n5.-Cara Fruncida"+
                        "\n6.-Cara Asombrada"+
                        "\n7.-Cara Enojada"+
                        "\n8.-Cara Sonrojada"+
                        "\n9.-Cara llorando"+
                        "\n10.-Cara molesta"+
                        "\n11.-Cara sin boca"+
                        "\n12.-Cara Agotada"
                );

        //permite atrapar la opcion que ingresa el usuario
        int opcion = Integer.parseInt(entrada);
        cara panel =new cara(opcion);
        //creacion del panel JFrame
        JFrame aplicacion = new JFrame();
        //apartado para el mensaje de Default en caso de que se presente error al mostrar la ventana
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.add(panel);

        // Medidad que tendra la ventana emergente que mostrara el menu y los Emojis
        aplicacion.setSize(230,250);
        aplicacion.setVisible(true);
    }
}

