package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
    private JTextField id_usuario;
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel loginPanel;
    private JPasswordField clave_usuario;
    private JTextField nombre_usuario;
    private JButton loginButton;
    private JTextField rol;

    public Login(){
        setContentPane(loginPanel);
        setTitle("Bienvenido");
        setSize(1200,600);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrar_usuario();
                dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login1 log = new Login1();
                log.setVisible(true);
                dispose();
            }
        });
    }
    public void registrar_usuario(){
        String usuario, id, password, roles;
        usuario = nombre_usuario.getText();
        id = id_usuario.getText();
        roles=rol.getText();
        password = String.valueOf(clave_usuario.getPassword());



        if (id.equals("") || usuario.equals("") || password.equals("") ) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            final String DB_URL="jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
            final String USERNAME="278455";
            final String PASSWORD="Naruto2809";

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();

                String sql="INSERT INTO usuarios( id_usu ,nom_usu,rol_usu, contra_usu) VALUES(?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, id);
                pst.setString(2, usuario);
                pst.setString(3, roles);
                pst.setString(4, password);


                pst.executeUpdate();
                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null,
                        "\nNombre Usuario: " + usuario +
                                "\nID : " + id +

                                "\nActualizado"+ JOptionPane.PLAIN_MESSAGE);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
                JOptionPane.showMessageDialog(null,
                        "\nEl usuario: " + nombre_usuario+" ya existe!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Login log=new Login();
    }
}

