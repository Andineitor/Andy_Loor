package src.factura;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class retorno_fac extends JFrame {
    private JComboBox retorno_fac;
    private JButton regresarButton;
    private JButton buscarButton;
    private JPanel retorno;
    private static ArrayList<String> id_fac = new ArrayList<>();
    protected retorno_fac() {
carga_fac();

        setContentPane(retorno);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
menu_caja();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
buscar();
            }
        });
    }

    private void buscar(){
        factura facturas = new factura(id_fac.get(retorno_fac.getSelectedIndex()));
        this.dispose();
    }

    private void menu_caja(){
        menu_caja menuCajero = new menu_caja();
        this.dispose();
    }

    private void carga_fac(){

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;


        try{


            con= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                    "278455","Naruto2809");
            st=con.createStatement();
            String s="SELECT num_fac FROM facturacion";
            rs=st.executeQuery(s);
            retorno_fac.addItem("Ingrese o seleccione la factura...");
            id_fac.add("Ingrese o seleccione la factura...");
            while(rs.next()){

                retorno_fac.addItem(rs.getString(1));
                id_fac.add(rs.getString(1));
            }

            AutoCompleteDecorator.decorate(retorno_fac);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }
    }


}
