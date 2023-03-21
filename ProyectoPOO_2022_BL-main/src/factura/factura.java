package src.factura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class factura extends JFrame {

    private JTable table1;
    private JLabel numero_fac;
    private JLabel cedula_cli;
    private JLabel nombre_cli;
    private JButton Listo;
    private JLabel iva_fac;
    private JPanel facturas;
    private JLabel total_fac;

    private DefaultTableModel tabla;
    private static ArrayList<String> id_fac = new ArrayList<>();
    public  factura(String num){

cargar_facturas(num);
crear_tabla(num);
        setContentPane(facturas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(400,500);
        setLocationRelativeTo(null);
        setVisible(true);
        Listo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
            }
        });

    }




    public void menu(){
        menu_caja men=new menu_caja();
        this.dispose();
   }

    private void cargar_facturas(String num){
        try{

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                    "278455","Naruto2809");
            Statement stmt= conn.createStatement();
            String sql="SELECT num_fac, id_cli,nom_cli,iva_fac, total_factura FROM facturacion WHERE num_fac= ?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,num);
            ResultSet rs=pst.executeQuery();
            rs.next();

            numero_fac.setText(rs.getString(1));
            cedula_cli.setText(rs.getString(2));
            nombre_cli.setText(rs.getString(3));
            iva_fac.setText(rs.getString(4));
            total_fac.setText(rs.getString(5));
            numero_fac.setText(num);

        }catch (Exception e ){
            System.out.println(e);
        }
    }

    public  void crear_tabla(String num){
        tabla= new DefaultTableModel(modelo_tabla(num),columnas());
        table1.setModel(tabla);
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }
    public static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("PRODUCTO");
        columnNames.add("CANTIDAD");
        columnNames.add("PRECIO UNITARIO");
        columnNames.add("TOTAL A PAGAR");
        return columnNames;
    }

    public  Vector<Vector<Object>> modelo_tabla(String numero)  {

        try{

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                    "278455","Naruto2809");
            Statement stmt= conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("SELECT productos.nom_produc,factura.can_produc,factura.precio_produc,factura.total_fac FROM factura,facturacion,productos WHERE facturacion.num_fac=? AND factura.num_fac=facturacion.num_fac AND factura.id_produc=productos.id_produc");
            pst.setString(1,numero);

            ResultSet rs = pst.executeQuery();




            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            int columnCount = metaData.getColumnCount();

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }

            return data;

        }catch (Exception e ){
            System.out.println(e);
            return  null;
        }
    }




}
