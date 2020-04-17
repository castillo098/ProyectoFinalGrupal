package Vista;

import Controlador.OyenteBuscarVenta;
import Controlador.OyenteCrearVenta;
import Controlador.OyenteVerificarVenta;
import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Venta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VVenta extends JFrame {

    JTextField tfid_venta = new JTextField(20);
    JTextField tfPrecio = new JTextField(20);
    JTextField tfCantidad = new JTextField(20);
    JTextField tfMate_producto = new JTextField(20);
    JTextField tfced_comprador = new JTextField(20);
    JTextField tfcod_procucto = new JTextField(20);
    JTextField tfnom_producto = new JTextField(20);
    JTextField tftipo_producto = new JTextField(20);
    JTextField tfPrecio_Total = new JTextField(20);
    JTextField tffecha = new JTextField(20);
    JLabel etiqueta = new JLabel();
    JButton aceptar;
    JButton buscar;
    Venta venta;

    Producto producto;
    ImageIcon image = new ImageIcon(getClass().getResource("/imagen/moda.png"));
    // JCalendar calendario = new JCalendar();

    //calendario = new DateChooserPanel();
    public VVenta() {
        super("REGISTRAR VENTA");
        setLocation(200, 100);
        etiqueta.setIcon(image);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        agregarComponentes();
        pack();
        setResizable(false);
        setVisible(true);
        setLayout(new FlowLayout());
    }

    private void agregarComponentes() {

        JPanel contentpane, panel, panel2 = null;
        panel = new JPanel(new GridBagLayout());
        contentpane = new JPanel(new GridBagLayout());
        panel2 = new JPanel();
        GridBagConstraints op = new GridBagConstraints();
        GridBagConstraints a = new GridBagConstraints();
        op.anchor = GridBagConstraints.WEST;

        op.insets = new Insets(10, 15, 10, 15);
        //etiqueta de alquiler de ventas
        op.gridx = 2;
        op.gridy = 0;
        panel.add(etiqueta, op);
        //nombre
        op.gridx = 2;
        op.gridy = 1;
        panel.add(new JLabel("Codigo del producto"), op);
        //texfield de nombre
        op.gridx = 3;
        op.gridy = 1;
        panel.add(tfcod_procucto, op);
        //
        op.gridx = 0;
        op.gridy = 1;
        panel.add(new JLabel("ID Venta"), op);
        //
        op.gridx = 1;
        panel.add(tfid_venta, op);
        //etiqueta de nombres
        /*op.gridx = 1;
        op.gridy = 1;
        panel.add(new JLabel("Nombres"), op);*/
        //etiqueta comprador
        op.gridx = 0;
        op.gridy = 2;
        panel.add(new JLabel("Cedula del comprador"), op);
        //Texfield de comprador
        op.gridx = 1;
        op.gridy = 2;
        panel.add(tfced_comprador, op);

        //etiqueta cantidad
        op.gridx = 0;
        op.gridy = 4;
        panel.add(new JLabel("Cantidad"), op);
        //textfild de casa
        op.gridy = 4;
        op.gridx = 1;
        panel.add(tfCantidad, op);

        op.gridx = 0;
        op.gridy = 5;
        panel.add(new JLabel("Precio Total"), op);
        op.gridx = 1;
        op.gridy = 5;
        panel.add(tfPrecio_Total, op);

        //etiqueta de producto
        op.gridx = 0;
        op.gridy = 3;
        panel.add(new JLabel("Material producto"), op);
        //textfild de estado de producto
        op.gridx = 1;
        op.gridy = 3;
        panel.add(tfMate_producto, op);
        //etiqueta nombre de producto
        op.gridx = 2;
        op.gridy = 2;
        panel.add(new JLabel("Nombre de producto"), op);
        //textfild nombre de producto
        op.gridy = 2;
        op.gridx = 3;
        panel.add(tfnom_producto, op);

        //etiqueta tipo de producto
        op.gridx = 2;
        op.gridy = 3;
        panel.add(new JLabel("Tipo de producto"), op);
        //textfild nombre de producto
        op.gridy = 3;
        op.gridx = 3;
        panel.add(tftipo_producto, op);
        //etiqueta precio
        op.gridx = 2;
        op.gridy = 4;
        panel.add(new JLabel("Precio"), op);
        //textfild precio
        op.gridy = 4;
        op.gridx = 3;
        panel.add(tfPrecio, op);
        //boton Aceptar
        aceptar = new JButton("ACEPTAR");
        JButton eliminar = new JButton("ELIMINAR");
        panel2.add(aceptar);
        /*panel2.add(eliminar);*/
        panel2.add(aceptar);
        a.gridx = 0;
        a.gridy = 0;
        contentpane.add(panel, a);
        a.gridx = 0;
        a.gridy = 2;
        contentpane.add(panel2, a);
        setContentPane(contentpane);
        buscar = new JButton("BUSCAR");
        a.gridx = 1;
        a.gridy = 0;
        panel2.add(buscar, a);
        FlowLayout horizontal = new FlowLayout();
        
        op.gridx=2;
        op.gridy=5;
        panel.add(new JLabel("Fecha: DD/MM/AAAA"),op);
        op.gridx=3;
        op.gridy=5;
        panel.add(tffecha,op);
        
        buscar.addActionListener(new OyenteVerificarVenta(this));

        aceptar.addActionListener(new OyenteCrearVenta(this));
        eliminar.addActionListener((ae) -> {
            dispose();

        }
        );
        bloquear();
    }

    public Venta guardarVenta() {
        venta = new Venta();
        venta.setId_venta(tfid_venta.getText());
        venta.setCod_producto(tfcod_procucto.getText());
        venta.setCed_comprador(tfced_comprador.getText());
        venta.setNom_producto(tfnom_producto.getText());
        venta.setMate_producto(tfMate_producto.getText());
        venta.setTipo_producto(tftipo_producto.getText());
        venta.setCantidad(tfCantidad.getText());
        venta.setPrecio(tfPrecio.getText());
        venta.setFecha(tffecha.getText());
        venta.setPre_Total(tfPrecio_Total.getText());
        return venta;

    }

    public void limpiarCampos() {
        tfid_venta.setText("");
        tfcod_procucto.setText("");
        tfced_comprador.setText("");
        tfnom_producto.setText("");
        tfMate_producto.setText("");
        tftipo_producto.setText("");
        tfCantidad.setText("");
        tfPrecio.setText("");
        tffecha.setText("");
    }

    public void bloquear() {
        tfced_comprador.setEditable(false);
        tfnom_producto.setEditable(false);
        tfMate_producto.setEditable(false);
        tftipo_producto.setEditable(false);
        tfPrecio.setEditable(false);

    }

    public void desactivar() {
        tfced_comprador.setEditable(true);
        tfnom_producto.setEditable(true);
        tfMate_producto.setEditable(true);
        tftipo_producto.setEditable(true);
        tfCantidad.setEditable(true);
        tfPrecio.setEditable(true);
    }

    public String verificarVenta() {
        return tfcod_procucto.getText();
    }

    public void CargarDatos(Producto producto) {
        tfnom_producto.setText(producto.getNom_producto());
        tfMate_producto.setText(producto.getMate_producto());
        tftipo_producto.setText(producto.getTipo_producto());
        tfPrecio.setText(producto.getPrecios());

    }

    public static void main(String[] args) {
        VVenta w = new VVenta();
    }

}
