package src.perfiles;

import src.Login1;
import src.factura.gen_fac;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cajero extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton buscarButton;
    private JButton borrarButton;
    private JButton guardarButton;
    private JButton actualizarButton;
    private JButton limpiarButton;
    private JPanel cajeroPanel;
    private JButton volverButton;

    private JButton ventasButton;
private String rol;
    public cajero(String rol) {
        this.rol=rol;


        setContentPane(cajeroPanel);
        setTitle("Bienvenido");
        setSize(1200, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnabled(false);
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnabled(false);
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnabled(false);
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnabled(false);
            }
        });
        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gen_fac generar =new gen_fac();
                generar.setVisible(true);
            }
        });
    }
    public void volver(){
        Login1 login =new Login1();
        login.setVisible(true);
    }
}
