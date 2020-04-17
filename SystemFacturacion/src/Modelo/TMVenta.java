package Modelo;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;
import jdk.nashorn.internal.ir.BreakNode;

public class TMVenta implements TableModel {

    private List<Venta> ve;

    public TMVenta(List<Venta> Lista) {
        ve = Lista;

    }

    @Override
    public int getRowCount() {
        return ve.size();

    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String titulo = null;
        switch (columnIndex) {
            case 0: {
                titulo = "id venta";
                break;
            }
            case 1: {
                titulo = "Codigo producto";
                break;
            }
            case 2: {
                titulo = "Cedula comprador";
                break;

            }
            case 3: {
                titulo = "Nombre producto";
                break;
            }
            case 4: {
                titulo = "Material producto";
                break;
            }
            case 5: {
                titulo = "Tipo producto";
                break;

            }
            case 6: {
                titulo = "Cantidad";
                break;
            }

            case 7: {
                titulo = "Precio";
                break;
            }
            case 8: {

                titulo = "Fecha";
                break;
            }
            case 9: {
                titulo = "Precio Total";
                break;
            }
        }
        return titulo;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta v = ve.get(rowIndex);
        String valor = null;

        switch (columnIndex) {
            case 0: {
                valor = v.getId_venta();
                break;
            }
            case 1: {
                valor = v.getCod_producto();
                break;
            }
            case 2: {
                valor = v.getCed_comprador();
                break;
            }
            case 3: {
                valor = v.getNom_producto();
                break;
            }
            case 4: {
                valor = v.getMate_producto();
                break;
            }
            case 5: {
                valor = v.getTipo_producto();
                break;
            }
            case 6: {
                valor = v.getCantidad();
                break;

            }
            case 7: {
                valor = v.getPrecio();
                break;
            }
            case 8: {
                valor = v.getFecha();
                break;
            }
            case 9: {
                valor = v.getPre_Total();
                break;
            }

        }
        return valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener t) {

    }
}
