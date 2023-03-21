package src.factura;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class gen_fac extends JFrame {
    private JPanel gen_fac;
    private JTextField ci_clie;
    private JTextField nom_cli;
    private JComboBox ci_usu;
    private JTextField cantidadTXT;
    private JComboBox producto;
    private JButton agregarButton;
    private JButton limpiarButton;
    private JLabel iva;
    private JLabel total;
    private JButton cancelarButton;
    private JButton generarFacturaButton;
    private JTable table1;
    private static ArrayList<String> id_pro = new ArrayList<>();
    private static ArrayList<String> id_usu = new ArrayList<>();

    private static ArrayList<Integer> stock = new ArrayList<>();
    private DefaultTableModel tabla;
    private static String num_factura;
    public gen_fac(){

        selec_usuario();
        subir_produc();
        cracion_tabla();
        setContentPane(gen_fac);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLocationRelativeTo(null);
        setVisible(true);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nueva_fac();
                sumaTotal();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar_campos();
                sumaTotal();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venta_stock();

            }
        });
        generarFacturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crear_factura();
            }
        });
    }

 private void subir_produc(){
     Connection con=null;
     Statement st=null;
     ResultSet rs=null;

     try{

         con= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                 "278455","Naruto2809");
         st=con.createStatement();
         String s="select id_produc,nom_produc, stock_produc from productos";
         rs=st.executeQuery(s);
         producto.addItem("Selecciones producto..");
         id_pro.add("");
         stock.add(100);


         while(rs.next()){

             producto.addItem(rs.getString(2));
             id_pro.add(rs.getString(1));
             stock.add(Integer.parseInt(rs.getString(3)));

         }

         ver_stock();
         AutoCompleteDecorator.decorate(producto);

     }
     catch (Exception e){
         JOptionPane.showMessageDialog(null,"Error");
     }finally {
         try{
             st.close();
             rs.close();
             con.close();
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error cierre");
         }
     }



}
    private void guardar_produc(){


        try {

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                    "278455","Naruto2809");
            Statement stmt = conn.createStatement();


            for(int i = 0; i< tabla.getRowCount(); i++){

                String sql="iNSERT INTO factura (num_fac , id_produc,can_produc, precio_produc, total_fac) VALUES (?,?,?,?,?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, num_factura);
                pst.setString(2, tabla.getValueAt(i,0).toString());
                pst.setString(3, tabla.getValueAt(i,2).toString());
                pst.setString(4, tabla.getValueAt(i,3).toString());
                pst.setString(5, tabla.getValueAt(i,4).toString());


                pst.executeUpdate();

            }

            System.out.println( " Detalles Insertados ");
            stmt.close();
            conn.close();

           factura factura = new factura(num_factura);
            JOptionPane.showMessageDialog(null,"Factura creada con exito","Exito",JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/comprobado.png",64,64));

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }



        double precio=0,total=0,iva,pagar;

        for (int i = 0; i< tabla.getRowCount(); i++){
            precio=Double.parseDouble(tabla.getValueAt(i,4).toString());
            total+=precio;
        }

        iva = total*0.12;
        pagar = iva+total;

        this.iva.setText(""+redondeo(iva,2));
        this.total.setText(""+redondeo(pagar,2));


    }
    private Icon icono(String direccion, int wid, int heig){
        Icon img=new ImageIcon(new ImageIcon(getClass().getResource(direccion)).getImage().getScaledInstance(wid,heig, Image.SCALE_SMOOTH));
        return img;
    }

    private void obtenerFactura(){

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try{

            con= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                    "278455","Naruto2809");

            st=con.createStatement();

            String s="SELECT num_fac FROM facturacion ORDER BY num_fac DESC ";

            rs=st.executeQuery(s);
            rs.next();

            num_factura = rs.getString(1);

            System.out.println(num_factura);

            guardar_produc();


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }
    }


  private void selec_usuario(){

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;


        try{


            con= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                    "278455","Naruto2809");

            st=con.createStatement();
            String s="select id_usu  from usuarios";
            rs=st.executeQuery(s);
            ci_usu.addItem("Seleccione el empleado...");
            id_usu.add("Seleccione el empleado...");
            while(rs.next()){

                ci_usu.addItem(rs.getString(1));
                id_usu.add(rs.getString(1));

            }

            AutoCompleteDecorator.decorate(ci_usu);

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }
    }

    private void crear_factura(){

        String ci_cli, nombre_cli, ced_emple;
        ci_cli =ci_clie.getText();
        nombre_cli = nom_cli.getText();
        ced_emple = id_usu.get(ci_usu.getSelectedIndex());


        if (ci_cli.equals("") || nombre_cli.equals("") || ced_emple.equals("Seleccione ID cajero...")   ) {

            JOptionPane.showMessageDialog(null,"llene todos los campos.","LLenar todos los campos",JOptionPane.ERROR_MESSAGE);

        }
        else {
            if ( !test(ci_cli) ){
                JOptionPane.showMessageDialog(null,"Numero de Cedula incorrecto.","Advertencia con el IC",JOptionPane.WARNING_MESSAGE);
            }else {
                if (!test(cantidadTXT.getText())){
                    JOptionPane.showMessageDialog(null,"Escribe solo números en cantidad.","Advertencia en Cantidad",JOptionPane.WARNING_MESSAGE);
                }else {
                    if (Integer.parseInt(cantidadTXT.getText())<1){
                        JOptionPane.showMessageDialog(null,"Escribe una cantidad correcta.","Advertencia en Cantidad",JOptionPane.WARNING_MESSAGE);
                    }else {
                        if (tabla.getRowCount()<1){
                            JOptionPane.showMessageDialog(null,"No existen productos agregados","Productos",JOptionPane.ERROR_MESSAGE);
                        }else {

                            try {
                                Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC",
                                        "278455","Naruto2809");
                                Statement stmt = conn.createStatement();

                                String sql="INSERT INTO facturacion (id_usu, id_cli, nom_cli,total_factura, iva_fac  ) VALUES (?,?,?,?,?)";

                                PreparedStatement pst = conn.prepareStatement(sql);

                                pst.setString(1, ced_emple);
                                pst.setString(2, ci_cli);
                                pst.setString(3, nombre_cli);
                                pst.setString(4, total.getText());
                                pst.setString(5, iva.getText());

                                pst.executeUpdate();
                                stmt.close();
                                conn.close();
                                obtenerFactura();
                                this.dispose();



                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                System.out.println(ex);
                            }
                        }
                    }
                }
            }
        }
    }

    private void sumaTotal(){
        double precio=0,total=0,iva,pagar;

        for (int i = 0; i< tabla.getRowCount(); i++){
            precio=Double.parseDouble(tabla.getValueAt(i,4).toString());
            total+=precio;
        }

        iva=total*0.12;
        pagar=iva+total;
        this.iva.setText(""+redondeo(iva,2));
        this.total.setText(""+redondeo(pagar,2));
    }
    public  double redondeo(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
    private void limpiar_campos( ){

        int aux1;

        try{
            aux1 =table1.getSelectedRow();
            if (aux1 ==-1){
                JOptionPane.showMessageDialog(null,"Seleccione el producto!","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else {

                String id = (String) tabla.getValueAt(aux1,0);
                int cant = Integer.parseInt((String) tabla.getValueAt(aux1,2));
                System.out.printf("id>>>>"+id+">>>>"+cant);
                stock.set(indice(id),stock.get(indice(id))+cant);

                ver_stock();

                tabla.removeRow(aux1);


            }

        }catch (Exception e ){
            System.out.println(e);
        }
    }

    private  int indice(String id){

        int cont=0;

        for(String a: id_pro){
            if (a.equals(id)){
                return cont;
            }else {
                cont++;
            }
        }
        return -1;
    }
    private void venta_stock(){
        menu_caja menuCajero = new menu_caja();
        this.dispose();
    }
    public  void nueva_fac(){

        int op = producto.getSelectedIndex();

        String cantidad = cantidadTXT.getText();

        boolean comprobacion=test(cantidad);

        if (op==0){
            JOptionPane.showMessageDialog(null,"Elija un producto.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }else {

            int cantidad2=Integer.parseInt(cantidad);

            if (!comprobacion ){
                JOptionPane.showMessageDialog(null,"Cantidad incorrecta.","Error",JOptionPane.ERROR_MESSAGE);
            }else {
                if(cantidad2<1 ){
                    JOptionPane.showMessageDialog(null,"Cantidad incorrecta.","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    try{
                        final String DB_URL = "jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
                        final String USERNAME = "278455";
                        final String PASSWORD = "Naruto2809";

                        Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                        Statement stmt= conn.createStatement();
                        String sql="SELECT id_produc,nom_produc,precio_produc,stock_produc FROM productos where id_produc=?";

                        PreparedStatement pst=conn.prepareStatement(sql);

                        pst.setString(1,id_pro.get(op));

                        ResultSet rs=pst.executeQuery();
                        rs.next();
                        int stocks;

                        stocks=Integer.parseInt(rs.getString(4));



                        if( stock.get(op)>=Integer.parseInt(cantidadTXT.getText()) ){

                            Object [] nuevaFila = new Object[5];


                            nuevaFila[0]=rs.getString(1);
                            nuevaFila[1]=rs.getString(2);
                            nuevaFila[2]=cantidadTXT.getText();
                            nuevaFila[3]=rs.getString(3);

                            double total_detalle = Double.parseDouble((String)nuevaFila[2])*Double.parseDouble((String)nuevaFila[3]);

                            nuevaFila[4]= ""+total_detalle;

                            tabla.addRow(nuevaFila);

                            stmt.close();
                            conn.close();

                            stock.set(op,stock.get(op)-Integer.parseInt(cantidadTXT.getText()));

                            System.out.println("Stock despues");
                            ver_stock();



                        }else{

                            JOptionPane.showMessageDialog(null,"Stock no dispobible.\n" +
                                    "Stock dispobilbe: "+stock.get(ci_usu.getSelectedIndex()),"Error",JOptionPane.WARNING_MESSAGE);
                        }

                        cantidadTXT.setText("0");
                        producto.setSelectedIndex(0);


                    } catch(SQLException ex){
                        ex.printStackTrace();
                        System.out.println("SQL incorrecto");

                    }
                }

            }
        }
    }

    private static void  ver_stock(){
        int aux=0;
        for (Integer a: stock ){
            System.out.println(id_pro.get(aux)+"-->"+stock.get(aux));
            aux++;
        }


    }

    private void crear_stok(String id,int stock){

        try{

            final String DB_URL = "jdbc:mysql://mysql-andineitor.alwaysdata.net/andineitor_farmacia?serverTimezone=UTC";
            final String USERNAME = "278455";
            final String PASSWORD = "Naruto2809";

            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();

            String sql="UPDATE productos SET stock_product = ? WHERE id_produc = ? ";

            PreparedStatement pst=conn.prepareStatement(sql);

            pst.setInt(1,stock);
            pst.setString(2,id);
            pst.executeUpdate();
            stmt.close();
            conn.close();

        } catch(Exception e){

            System.out.println("e");

        }
    }
    public Boolean test(String numero){
        try{

            Integer.parseInt(numero);

            return true;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public  void  cracion_tabla(){
        tabla = new DefaultTableModel(null,columnas_tabla());
        table1.setModel(tabla);
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }
    public static Vector<String> columnas_tabla(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Producto");
        columnNames.add("Cantidad");
        columnNames.add("P. Unitario");
        columnNames.add("T. Pagar");
        return columnNames;
    }



    public static void main(String[] args) {
        gen_fac generarFactura= new gen_fac();

    }
}