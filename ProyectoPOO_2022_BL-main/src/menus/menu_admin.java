package src.menus;

import src.Login;
import src.Login1;
import src.factura.menu_caja;
import src.perfiles.administrador;
import src.perfiles.bodeguero;
import src.perfiles.cajero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_admin extends JFrame {
    private JButton accederbodegaButton;
    private JButton accederCajeroButton;
    private JButton agregarUsuarioButton;
    private JButton volverButton;
    private JPanel menu;
    private String rol;
    public menu_admin() {
        this.rol = rol;
        setContentPane(menu);
        setTitle("Bienvenido");
        setSize(400, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        accederbodegaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
    acceder();
            }
        });
        agregarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
agregar();
            }
        });
        accederCajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajero();

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {volver();}
        });
    }

    public void acceder(){
        administrador bod=new administrador(rol);
        this.dispose();
    }
    public void volver(){
        Login1 login =new Login1();
        this.dispose();
    }
    public void agregar(){
        Login log=new Login();
        this.dispose();
    }
    public void cajero(){
        menu_caja menu=new menu_caja();
        this.dispose();
    }
}
