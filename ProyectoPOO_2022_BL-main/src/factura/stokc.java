package src.factura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class stokc extends JFrame{
    private JPanel stock;
    private JButton OKButton;
    private JTable table1;

    public stokc() {
        tabla_produc();
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_caja();
            }
        });
        setContentPane(stock);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,600);
        setLocationRelativeTo(null);
        setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_caja();
            }
        });
    }

    private void menu_caja(){
        this.dispose();
        menu_caja menuCajero = new menu_caja();
    }

    public JPanel getRootPanel(){
        return stock;
    }
    public  void  tabla_produc(){
        table1.setModel(new DefaultTableModel(buildTableModel(),columnas()));
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }

    public static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("NOMBRE");
        columnNames.add("PRECIO UNITARIO");
        columnNames.add("DESCRIPCION");
        columnNames.add("STOCK");
        return columnNames;
    }

    public  Vector<Vector<Object>> buildTableModel()  {

        try{

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                    "278455","Naruto2809");
            Statement stmt= conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

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
