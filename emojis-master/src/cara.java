import javax.swing.*;
import java.awt.*;

public class cara extends JPanel {
// Clase Cara nos permite hacer los procesos en funcion a un menu
  private int opcion;
  //
    public cara(int opcionUsuario) {
        opcion = opcionUsuario;


    }

    //Creacion de la clase que contiene la arquitectura de los Emojis
    public void paintComponent(Graphics g ){
             super.paintComponent( g );

             //Creacion de los Cases, para cada una de las aquitecturas de los Emojis

        switch (opcion) {
            case 1:
                // cara Feliz
                //apartado del ovalo que forma el emoji
                g.setColor(Color.YELLOW);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.BLACK);
                g.fillOval(55, 65, 30, 30);
                g.fillOval(135, 65, 30, 30);

                g.fillOval(50, 110, 120, 60);

                g.setColor(Color.YELLOW);
                g.fillRect(50, 110, 120, 30);
                g.fillOval(50, 120, 120, 40);

                break;
            case 2:
                //cara seria
                //apartado del ovalo que forma el emoji
                g.setColor(Color.YELLOW);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.BLACK);
                g.fillOval(55, 65, 30, 30);
                g.fillOval(135, 65, 30, 30);

                g.fillRect(80, 160, 60, 10);

                g.setColor(Color.YELLOW);
                g.fillRect(50, 110, 120, 30);
                g.fillOval(50, 120, 120, 40);

                break;

            case 3:
                //cara muy seria
                //apartado del ovalo que forma el emoji
                g.setColor(Color.YELLOW);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.BLACK);
                g.fillRect(50, 80, 40, 10);
                g.fillRect(130, 80, 40, 10);

                g.fillRect(80, 160, 60, 10);

                g.setColor(Color.YELLOW);
                g.fillRect(50, 110, 120, 30);
                g.fillOval(50, 120, 120, 40);

                break;
            case 4:
                //cara al revez
                //apartado del ovalo que forma el emoji
                g.setColor(Color.YELLOW);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.BLACK);
                g.fillOval(55, 140, 30, 30);
                g.fillOval(135, 140, 30, 30);

                g.fillOval(50, 30, 120, 60);

                g.setColor(Color.YELLOW);
                g.fillRect(50, 60, 120, 30);
                g.fillOval(50, 40, 120, 40);
                break;
            case 5:
                //cara fruncida
                //apartado del ovalo que forma el emoji
                g.setColor( Color.YELLOW );
                g.fillOval( 10, 10, 200, 200 );

                g.setColor( Color.BLACK );
                g.fillArc(108,25,70,80,16,9);
                g.fillArc(55,25,70,80,160,-10);


                g.fillOval( 55, 65, 30, 30 );
                g.fillOval( 135, 65, 30, 30 );

                g.fillOval(80,160,60,10);

        break;

            case 6:
                //cara Asombrada
                //apartado del ovalo que forma el emoji
                g.setColor(Color.YELLOW);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.BLACK);
                g.fillOval(55, 65, 30, 30);
                g.fillOval(135, 65, 30, 30);
                g.fillOval(83, 120, 55, 55);

                break;

            case 7:
                // cara enojada
                //apartado del ovalo que forma el emoji
                g.setColor(Color.orange);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.BLACK);
                g.fillOval(55, 65, 30, 30);
                g.fillOval(138, 65, 30, 30);

                g.fillArc(97,25,80,80,17,7);
                g.fillArc(50,25,80,80,160,-8);

                g.fillOval(65, 124, 90, 40);

                g.setColor(Color.orange);
                g.fillOval(65, 136, 90, 40);
                break;

            case 8:

                //cara sonrojada
                //apartado del ovalo que forma el emoji
                g.setColor(Color.yellow);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.white);
                g.fillOval(55, 65, 50, 50);
                g.fillOval(135, 65, 50, 50);  //----> color blanco ojos

                g.setColor(Color.black);
                g.fillRect(88, 140, 55, 12); //------>boca
                g.fillOval(77, 85, 10, 10);
                g.fillOval(154, 85, 10, 10); // ----> color negro ojos

                g.setColor(Color.pink);
                g.fillOval(48, 135, 20, 20);
                g.fillOval(170, 135, 20, 20);// --> color rosa de las mejillas
                break;

            case 9:
                //cara llorando
                //apartado del ovalo que forma el emoji
                g.setColor(Color.YELLOW);
                g.fillOval(10, 10, 200, 200); //---> base amarilla

                g.setColor(Color.BLACK);
                g.fillRect(50, 80, 40, 10);
                g.fillRect(130, 80, 40, 10); //color negro de los ojos

                g.setColor(Color.CYAN);
                g.fillRect(65, 90, 10, 60);
                g.fillRect(145, 90, 10, 60); //-->color celeste del llanto

                g.setColor(Color.black);
                g.fillOval(88, 135, 40, 50);// ---> boca color negra
                g.setColor(Color.white);
                g.fillOval(95, 135, 25, 15);//-->diente del emoji
                break;

            case 10:
                //cara sonrojada
                //apartado del ovalo que forma el emoji
                g.setColor(Color.yellow);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.white);
                g.fillOval(55, 65, 50, 50);
                g.fillOval(135, 65, 50, 50);  //----> color blanco ojos

                g.setColor(Color.black);
                g.fillRect(88, 140, 55, 12); //------>boca
                g.fillOval(73, 65, 16, 16);
                g.fillOval(154, 64, 16, 16); // ----> color negro ojos
                break;

            case 11:
                //apartado del ovalo que forma el emoji
                g.setColor(Color.yellow);
                g.fillOval(10, 10, 200, 200);

                g.setColor(Color.black);
                g.fillOval(55, 65, 30, 40);
                g.fillOval(135, 65, 30, 40);

                break;
            case 12:
                //apartado del ovalo que forma el emoji
                g.setColor(Color.YELLOW);
                g.fillOval(10, 10, 200, 200);


                g.setColor(Color.black);
                g.fillOval(45, 75, 50, 30);
                g.fillOval(130, 75, 50, 30);//--> parte negra ojos

                g.fillOval(65, 124, 90, 40);//parte negra boca

                g.setColor(Color.YELLOW);
                g.fillOval(45, 85, 50, 30);
                g.fillOval(130, 85, 50, 30);//--> parte amarilla ojos

                g.fillOval(65, 136, 90, 40);//parte amarilla boca

                break;

        }
    }

}
