package Controlador;

import Modelo.Cliente;
import Modelo.BASE_DATOS;
import Vista.VRegistrarCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteActualizarCliente implements ActionListener {

    VRegistrarCliente rcliente;
    BASE_DATOS bda;
    Cliente c;

    public OyenteActualizarCliente(VRegistrarCliente rcliente) {
        this.rcliente = rcliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        bda= BASE_DATOS();
        bda.actualizarCliente(rcliente.guardarCliente());

        rcliente.limpiarCampos();
        rcliente.bloquearCampos();

    }

    private BASE_DATOS BASE_DATOS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
