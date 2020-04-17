package Controlador;

import Modelo.BASE_DATOS;
import Vista.VRegistrarCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteEliminarAlumno implements ActionListener {

    VRegistrarCliente Rcliente;
    BASE_DATOS base;

    public OyenteEliminarAlumno(VRegistrarCliente c) {
        this.Rcliente = c;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        base.eliminarCliente(Rcliente.eliminarCliente());
    }

}
