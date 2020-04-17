package Controlador;

import Modelo.BASE_DATOS;
import Vista.ListaVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteTablaVentas implements ActionListener {

    ListaVenta lv;
    BASE_DATOS bd;

    public OyenteTablaVentas(ListaVenta lv) {
        this.lv = lv;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        lv.actualizarVenta(bd.consutaVenta());
        
    }

}
