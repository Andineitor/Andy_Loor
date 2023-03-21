package src;

import src.factura.menu_caja;
import src.menus.menu_admin;
import src.perfiles.administrador;
import src.perfiles.bodeguero;
import src.perfiles.cajero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login1 extends JFrame {
    private JPanel login1;
    private JTextField nombre_usuario;
    private JTextField id_usuario;
    private JPasswordField clave_usuario;
    private JComboBox rol_usuario;
    private JButton aceptarButton;
    private JButton cancelButton;

    public Login1() {
        setContentPane(login1);
        setTitle("Bienvenido");
        setSize(1200, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ingresar();}
        });
    }

    public void ingresar(){
        final String DB_URL = "jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
        final String USERNAME = "278455";
        final String PASSWORD = "Naruto2809";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "SELECT id_usu,nom_usu,contra_usu,rol_usu FROM usuarios WHERE id_usu=? and nom_usu=?  and contra_usu=? and rol_usu=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,id_usuario.getText());
            preparedStatement.setString(2,nombre_usuario.getText());
            preparedStatement.setString(3,clave_usuario.getText());
            preparedStatement.setString(4,(String)rol_usuario.getSelectedItem());
            System.out.println("Exitosamente");
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()){

                String rol=String.valueOf(rol_usuario.getSelectedItem());

                switch (rol){
                    case "Administrador":
                    {
                        menu_admin menu= new menu_admin();
                        this.dispose();
                        break;
                    }
                    case "Cajero":
                    {
                        menu_caja caja=new menu_caja();
                        this.dispose();
                        break;
                    }
                    case "Bodeguero":
                    {
                        bodeguero bodega = new bodeguero(rol);
                        this.dispose();
                        break;
                    }

                }
            }else {
                JOptionPane.showMessageDialog(null,"Dato/s   Incorrecto/s","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se autentico");
        }

    }
    public static void main(String[] args) {
        Login1 login1 = new Login1();
        login1.setVisible(true);
    }
}