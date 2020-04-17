package Controlador;

import Modelo.BASE_DATOS;
import Modelo.Venta;
import Vista.VVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class OyenteBuscarVenta implements ActionListener {

    BASE_DATOS bda = new BASE_DATOS();

    @Override
    public void actionPerformed(ActionEvent ae) {
        bda.buscarVenta(null);
    }
}
