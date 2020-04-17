package Vista;

import Controlador.OyenteTablaVentas;
import Modelo.TMVenta;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaVenta extends JFrame {

    private TMVenta modeloDatos;
    JTable tablaResultados;
    private JLabel jlistas;

    public ListaVenta() {
        super("Reporte de ventas");
        setLocation(500, 50);
        setSize(450, 450);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.agregarComponentes();
        pack();
        setVisible(true);

    }

    public void agregarComponentes() {
        jlistas = new JLabel("Reporte  de ventas    ");
        JButton btn = new JButton("Realizar Consulta");
        btn.addActionListener(new OyenteTablaVentas(this));
        Box boxNorte = Box.createHorizontalBox();
        boxNorte.add(jlistas);
        boxNorte.add(btn);
        tablaResultados = new JTable();
        add(boxNorte, BorderLayout.NORTH);
        add(new JScrollPane(tablaResultados), BorderLayout.CENTER);

    }

    public void actualizarVenta(ArrayList lis) {
        modeloDatos = new TMVenta(lis);
        tablaResultados.setModel(modeloDatos);

    }
}
