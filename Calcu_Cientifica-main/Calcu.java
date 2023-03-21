import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calcu {
    private JPanel MainPanel;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton x2Button;
    private JButton a1XButton;
    private JButton iButton;
    private JButton btnpunto;
    private JButton btnsigno;
    private JButton btnigual;
    private JButton btnsuma;
    private JButton btnresta;
    private JButton btnmulti;
     private JButton btndivision;
    private JButton btnporcentaje;
    private JButton btnborrar;
    private JButton btnreinicio;
    private JButton btnx3;
    private JTextField Display;
    private JButton sen;
    private JButton cos;
    private JButton tan;
    private String valor;
    private String x;
    private String y;
    int o;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcu");
        frame.setContentPane(new Calcu().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Calcu() {
        JFrame aplicacion = new JFrame();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.add(MainPanel);
        aplicacion.setSize(230,250);
        aplicacion.setVisible(false);

        //Boton 0
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor =Display.getText();
                if(valor.length()== 1 && valor.equals("0")){
                    Display.setText("0");
                }
                else {
                    Display.setText(valor+"0");
                }
            }
        });


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("1");
                }
                else{
                    Display.setText(valor+"1");
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("2");
                }
                else{
                    Display.setText(valor+"2");
                }
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("3");
                }
                else{
                    Display.setText(valor+"3");
                }
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("4");
                }
                else{
                    Display.setText(valor+"4");
                }
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("5");
                }
                else{
                    Display.setText(valor+"5");
                }
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("6");
                }
                else{
                    Display.setText(valor+"6");
                }
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("7");
                }
                else{
                    Display.setText(valor+"7");
                }
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("8");
                }
                else{
                    Display.setText(valor+"8");
                }
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.equals("0")){

                    Display.setText("9");
                }
                else{
                    Display.setText(valor+"9");
                }
            }
        });

        btnpunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Display.getText();
                if(valor.contains(".")){
                    Display.setText(valor+".");
                }

            }
        });
        btnsigno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor =Display.getText();
                int longitud =valor.length();
                int m = longitud;
                if(valor.contains("-")){
                    Display.setText(valor.substring(1,m));
                }
                else{
                    Display.setText("-"+valor);
                }
            }
        });
        btnborrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor= Display.getText();
                int longitud =valor.length();
                int m =longitud - 1;
                if(m>1){
                    Display.setText(valor.substring(0,m));
                }
                else {
                    Display.setText("0");
                }
            }
        });
        btnsuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                x =Display.getText();
                Display.setText("0");
                o =1;
            }
        });

        btnresta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                x =Display.getText();
                Display.setText("0");
                o =2;
            }

        });

        btnmulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                x =Display.getText();
                Display.setText("0");
                o =3;
            }

        });
        btndivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                x =Display.getText();
                Display.setText("0");
                o =4;
            }

        });
        x2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o = 7;
            }
        });
        a1XButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o = 6;
            }
        });
        iButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o = 8;
            }
        });
        btnx3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o = 9;
            }
        });
        btnigual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y =Display.getText();
                if(o == 1){
                    float x1 =Float.parseFloat(x);
                    float y1 =Float.parseFloat(y);
                    float z = (x1+y1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 2){
                    float x1 =Float.parseFloat(x);
                    float y1 =Float.parseFloat(y);
                    float z = (x1-y1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 3){
                    float x1 =Float.parseFloat(x);
                    float y1 =Float.parseFloat(y);
                    float z = (x1*y1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 4){
                    float x1 =Float.parseFloat(x);
                    float y1 =Float.parseFloat(y);
                    float z = (x1/y1);
                    Display.setText(String.valueOf(z));
                }


                if(o == 5){
                    float x1 =Float.parseFloat(x);
                    float y1 =Float.parseFloat(y);
                    float z = ((x1*y1)/100);
                    Display.setText(String.valueOf(z));
                }

                if(o == 6){
                    float y1 =Float.parseFloat(y);
                    float z = (1/y1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 7){
                    float x1 =Float.parseFloat(x);
                    float z = (x1*x1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 8){
                    float x1 =Float.parseFloat(x);
                    float z = (float) Math.sqrt(x1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 9){
                    float x1 =Float.parseFloat(x);
                    float z = (float) Math.pow(x1,3);
                    Display.setText(String.valueOf(z));
                }
                if(o == 10){
                    float x1 =Float.parseFloat(x);
                    float z = (float) Math.sin(x1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 11){
                    float x1 =Float.parseFloat(x);
                    float z = (float) Math.cos(x1);
                    Display.setText(String.valueOf(z));
                }
                if(o == 12){
                    float x1 =Float.parseFloat(x);
                    float z = (float) Math.tan(x1);
                    Display.setText(String.valueOf(z));
                }
            }
        });

        btnreinicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor= Display.getText();
                int longitud =valor.length();
                int m =longitud - longitud;
                Display.setText(valor.substring(0,m));
            }
        });
        btnporcentaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o =5;
            }
        });
        sen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o =10;
            }
        });
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o =11;
            }
        });
        tan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x =Display.getText();
                Display.setText("0");
                o =12;
            }
        });
    }
}
