package Controlador;

import Modelo.BASE_DATOS;
import Vista.VVerCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteListasClientes implements ActionListener {

    VVerCliente ver;
    BASE_DATOS base;

    public OyenteListasClientes(VVerCliente v) {
        this.ver = v;
    }

    public void actionPerformed(ActionEvent arg0) {
        // ver.actualizarEstudiante(ver.cargarCliente());
    }

}
