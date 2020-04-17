package Controlador;

import Modelo.BASE_DATOS;
import Modelo.Producto;
import Modelo.Venta;
import Vista.VVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class OyenteVerificarVenta implements ActionListener {

    Venta v;
    VVenta vv;
    BASE_DATOS bda;
    Producto p;

    public OyenteVerificarVenta(VVenta vv) {
        this.vv = vv;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        p = bda.buscarVenta(vv.verificarVenta());
        if (p.getCod_producto() == null) {
            //vv.limpiarCampos();
            vv.desactivar();
            vv.CargarDatos(p);
        } else {
            vv.bloquear();
            JOptionPane.showMessageDialog(vv, "El usuario " + p.getCod_producto() + "ya se encuentra registrado");
        }
    }
}
