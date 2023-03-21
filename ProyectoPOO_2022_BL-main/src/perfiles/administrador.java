package src.perfiles;

import src.Login1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class administrador extends JFrame {
    private JTextField nom_produc;
    private JTextField id_produc;
    private JTextField precio_produc;
    private JTextField stock_produc;
    private JButton buscarButton;
    private JButton borrarButton;
    private JButton guardarButton;
    private JButton actualizarButton;
    private JButton limpiarButton;
    private JPanel stock_productos;
    private JButton volverButton;
private String rol;
    public administrador(String rol) {
        this.rol=rol;





        setContentPane(stock_productos);
        setTitle("Bienvenido");
        setSize(1200, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresar();
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrar();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {volver();}
        });
    }

    public void volver(){
        Login1 login =new Login1();
        login.setVisible(true);
    }
    public void ingresar() {
        String id, nombre, precio, stock;

        id = id_produc.getText();
        nombre = nom_produc.getText();
        precio = precio_produc.getText();
        stock = stock_produc.getText();

        if (id.equals("") || nombre.equals("") || precio.equals("") || stock.equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            final String DB_URL = "jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
            final String USERNAME = "278455";
            final String PASSWORD = "Naruto2809";

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();

                String sql = "INSERT INTO productos( id_produc,nom_produc,precio_produc,stock_produc) VALUES(?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, id);
                pst.setString(2, nombre);
                pst.setString(3, precio);
                pst.setString(4, stock);

                pst.executeUpdate();
                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null,
                        "\nID Producto: " + nombre +
                                "\nNombre : " + id +
                                "\nPrecio : " + precio +
                                "\nStock : " + stock,
                        "Actualizado", JOptionPane.PLAIN_MESSAGE);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
                JOptionPane.showMessageDialog(null,
                        "\nEl ID: " + id + " ya existe!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

    public void borrar() {
        String id, nombre, precio, stock;

        id = id_produc.getText();
        nombre = nom_produc.getText();
        precio = precio_produc.getText();
        stock = stock_produc.getText();

        if (id.equals("") || nombre.equals("") || precio.equals("") || stock.equals("")) {
            JOptionPane.showMessageDialog(null, "Llena todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            final String DB_URL = "jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
            final String USERNAME = "278455";
            final String PASSWORD = "Naruto2809";
            String id_delete = id_produc.getText();

            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();
                String sql = "DELETE FROM productos where id_produc=?";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, id_delete);

                pst.executeUpdate();

                //pst.executeUpdate();
                stmt.close();
                conn.close();
                JOptionPane.showMessageDialog(null,
                        "\nID Producto: " + id +
                                "\nNombre : " + nombre +
                                "\nPrecio : " + precio +
                                "\nStock : " + stock, "Eliminado correctamente", JOptionPane.PLAIN_MESSAGE);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
                JOptionPane.showMessageDialog(null,
                        "\nError Base de Datos!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public void buscar() {
        String id = "0";
        id = id_produc.getText();

        final String DB_URL = "jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
        final String USERNAME = "278455";
        final String PASSWORD = "Naruto2809";

        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Escribe el ID del Producto.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();
                String sql = "SELECT id_produc,nom_produc,precio_produc,stock_produc FROM productos where id_produc=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);

                ResultSet rs = pst.executeQuery();

                if (rs.next() == true) {
                    String nombre, precio, stock;
                    nombre = rs.getString(2);
                    precio = rs.getString(3);
                    stock = rs.getString(4);


                    System.out.println();
                    nom_produc.setText(nombre);
                    precio_produc.setText(precio);
                    stock_produc.setText(stock);

                } else {
                    //textMensaje.setText("no se encuentra el producto")  ;
                    JOptionPane.showMessageDialog(null, "Producto no registrado!! ", "Error", JOptionPane.PLAIN_MESSAGE);
                    limpiar();
                }
                stmt.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL incorrecto");

            }
        }
    }


    public void limpiar() {
        id_produc.setText("");
        nom_produc.setText("");
        precio_produc.setText("");
        stock_produc.setText("");
    }

    public void actualizar() {
        String id, nombre, precio, stock;

        id = id_produc.getText();
        nombre = nom_produc.getText();
        precio = precio_produc.getText();
        stock = stock_produc.getText();

        if (id.equals("") || nombre.equals("") || precio.equals("") || stock.equals("")) {
            JOptionPane.showMessageDialog(null, "Llena todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            final String DB_URL = "jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
            final String USERNAME = "278455";
            final String PASSWORD = "Naruto2809";


            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();

                String sql = "UPDATE productos SET id_produc =?,nom_produc =?, precio_produc =?, stock_produc=? WHERE id_produc=?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, id);
                pst.setString(2, nombre);
                pst.setString(3, precio);
                pst.setString(4, stock);
                pst.setString(5, id);

                pst.executeUpdate();
                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null,
                        "\nID Producto: " + id +
                                "\nNombre : " + nombre +
                                "\nPrecio : " + precio +
                                "\nStock : " + stock, "Actualizado", JOptionPane.PLAIN_MESSAGE);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL incorrecto");

                JOptionPane.showMessageDialog(null,
                        "\nError Base de Datos!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}
