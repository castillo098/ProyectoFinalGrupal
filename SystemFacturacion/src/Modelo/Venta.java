package Modelo;

public class Venta {

    String id_venta, cod_producto, ced_comprador, nom_producto, mate_producto, tipo_producto, cantidad, precio, fecha, pre_Total;

    public Venta() {
    }

    public Venta(String id_venta, String cod_producto, String ced_comprador, String nom_producto, String mate_producto, String tipo_producto, String cantidad, String precio, String fecha, String pre_Total) {
        this.id_venta = id_venta;
        this.cod_producto = cod_producto;
        this.ced_comprador = ced_comprador;
        this.nom_producto = nom_producto;
        this.mate_producto = mate_producto;
        this.tipo_producto = tipo_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.pre_Total = pre_Total;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getCed_comprador() {
        return ced_comprador;
    }

    public void setCed_comprador(String ced_comprador) {
        this.ced_comprador = ced_comprador;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getMate_producto() {
        return mate_producto;
    }

    public void setMate_producto(String mate_producto) {
        this.mate_producto = mate_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPre_Total() {
        return pre_Total;
    }

    public void setPre_Total(String pre_Total) {
        this.pre_Total = pre_Total;
    }
}