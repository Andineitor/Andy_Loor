package src.factura;

import src.Login1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_caja extends JFrame{
    private JPanel menu;
    private JButton realizarVentaButton;
    private JButton productosButton;
    private JButton facturasButton;
    private JButton regresar;

    public menu_caja() {
        setContentPane(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,600);
        setLocationRelativeTo(null);
        setVisible(true);
        facturasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
buscar_fac();
            }
        });
        realizarVentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            venta();
            }
        });
        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ver_stock();
            }
        });
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
exit();
            }
        });
    }
    private void ver_stock(){
        stokc ver_stock=new stokc();
        this.dispose();
    }
    private void factura_produc(){
      // factura fac=new factura();
        this.dispose();
    }
    private void venta(){
        gen_fac gen = new gen_fac();
        this.dispose();
    }
    private void buscar_fac(){
        retorno_fac retorno=new retorno_fac();
this.dispose();
    }

    private void exit(){
        Login1 log1=new Login1();
        this.dispose();
    }
}
