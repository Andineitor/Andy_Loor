import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends  JDialog{
    private JTextField email;
    private JButton salirButton;
    private JButton ingresarButton;
    private JPanel login;
    private JPasswordField contra;

    public login(){

        setTitle("Login Usuario");
        setContentPane(login);
        setSize(2000,2000);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Email = email.getText();
                String Contra = String.valueOf(contra.getPassword());

                User user = getAuthenticationUser(email,contra);
                if (user!=null){
                    dispose();
                    Menu menu = new Menu(user);
                }
                else{
                    JOptionPane.showMessageDialog(
                            Usuarios.this,"Datos invalidos",
                            "intenta de nuevo",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(user.nombre);
            }
        });


        class User extends JDialog {

            public String Nombre_Usuario;
            public String Email_Usuario;
            public String Celular_Usuario;
            public String contrasenia_Usuario;
        }
        private User getAuthenticationUser(String email, String contra){
            User user = null;
            final String DB_URL="jdbc:mysql://localhost/misproductos?serverTimezone=UTC";
            final String USERNAME="root";
            final String PASSWORD="";

            try{
                System.out.println("Autentificación");
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stnt = conn.createStatement();
                String sql = "SELECT * FROM usuarios WHERE email=? AND contrasenia=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, contra);
                System.out.println("Conexion exitosa");
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()) {
                    user = new User();
                    user.Email_Usuario = resultSet.getString("email");
                    user.contrasenia_Usuario = resultSet.getString("contrasenia");
                    user.Celular_Usuario = resultSet.getString("Telefono");
                    user.Nombre_Usuario = resultSet.getString("Nombre");
                }
                stnt.close();
                conn.close();

            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Autentificación fallida");
            }
            return user;
        }
    }


    public static void main(String[] args) {

        Usuarios usuario = new Usuarios(null);
    }
}