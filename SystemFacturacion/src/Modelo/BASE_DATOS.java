package Modelo;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BASE_DATOS {

    private static ArrayList<String> listaNombres;
    private static ArrayList<Cliente> listacliente;
    private static ArrayList<Venta> listaConsulta;

    //Guardar un registro en la base de datos tabla cliente
    public static void guardarClienteBD(Cliente cliente) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion establecida!");

            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("insert into cliente values('" + cliente.getCedula()
                    + "','" + cliente.getNombres() + "','" + cliente.getApellidos() + "','" + cliente.getTelefono() + "','"
                    + cliente.getBarrio() + "','" + cliente.getNcasa() + "','" + cliente.getDireccion() + "','" + cliente.getCorreo() + "')");
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
    }

    //Guardar registro producto en la base de datos
    public static void guardarVentaBD(Venta venta) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion establecida!");

            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("insert into venta values('" + venta.getId_venta()
                    + "','" + venta.getCod_producto() + "','" + venta.getCed_comprador() + "','" + venta.getNom_producto() + "','"
                    + venta.getMate_producto() + "','" + venta.getTipo_producto() + "','" + venta.getCantidad() + "','" + venta.getPrecio() + "','"
                    + venta.getFecha() + "','" + venta.getPre_Total() + "')");
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
    }

    //Guardar registro en la base de datos de la tabla producto
    public static void guardarProductoBD(Producto producto) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion establecida!");

            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("insert into producto values('" + producto.getCod_producto()
                    + "','" + producto.getPrecios() + "','" + producto.getTipo_producto() + "','" + producto.getMate_producto() + "','"
                    + producto.getNom_producto() + "','" + producto.getStock() + "')");
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
    }

    //Eliminar un registro de la tabla cliente
    public static void eliminarCliente(String cedula) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion Establecida");
            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("delete from estudiante where cedula = '" + cedula + "'");
            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.print("Error en la conexion" + e);
        }
    }

    //Eliminar un registro de la tabla producto
    public static void eliminarProducto(String cedula) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion Establecida");
            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("delete from estudiante where cedula = '" + cedula + "'");
            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.print("Error en la conexion" + e);
        }
    }

    //Buscar un registro de tabla cliente 
    public static Cliente buscarCliente(String cedula) {

        Cliente cliente = new Cliente();;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            //System.out.print("Conexion Establecida");
            Statement sentencia = conexion.createStatement();
            ResultSet encontrar = sentencia.executeQuery("select * cliente "
                    + "where cedula = '" + cedula + "'");

            while (encontrar.next()) {
                String cedul = encontrar.getString("cedula");
                String nombre = encontrar.getString("nombres");
                String apellido = encontrar.getString("apellidos");
                String tel = encontrar.getString("telefono");
                String barrio = encontrar.getString("barrio");
                String ncasa = encontrar.getString("Ncasa");
                String dir = encontrar.getString("direccion");
                String corr = encontrar.getString("correo electronico");

                cliente.setCedula(cedul);
                cliente.setNombres(nombre);
                cliente.setApellidos(apellido);
                cliente.setTeléfono(tel);
                cliente.setBarrio(barrio);
                cliente.setNcasa(ncasa);
                cliente.setDireccion(dir);
            }
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
        return cliente;
    }
//BUSCAR LA VENTA EN LA BASE DE DATOS

    public static Producto buscarVenta(String cod_producto) {

        Producto pro = new Producto();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            //System.out.print("Conexion Establecida");
            Statement sentencia = conexion.createStatement();
            ResultSet encontrar = sentencia.executeQuery("select * from facturacion.producto "
                    + "where cod_producto = '" + cod_producto + "'");

            while (encontrar.next()) {

                String nom_producto = encontrar.getString("nom_producto");
                String precio = encontrar.getString("precios");
                String mate_pro = encontrar.getString("mate_producto");
                String tipo_pro = encontrar.getString("tipo_producto");

                pro.setNom_producto(nom_producto);
                pro.setPrecios(precio);
                pro.setMate_producto(mate_pro);
                pro.setTipo_producto(tipo_pro);
            }
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
        return pro;
    }

    public static ArrayList consutaVenta() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            //System.out.print("Conexion Establecida");
            Statement sentencia = conexion.createStatement();
            ResultSet buscar = sentencia.executeQuery("select * from facturacion.venta ");
            // + "where fecha = '" + fecha + "'");

            listaConsulta = new ArrayList<>();
            while (buscar.next()) {
                String id_venta = buscar.getString("id_venta");
                String cod_producto = buscar.getString("cod_producto");
                String cedu_comprador = buscar.getString("ced_comprador");
                String nom_producto = buscar.getString("nom_producto");
                String mate_producto = buscar.getString("mate_producto");
                String tipo_producto = buscar.getString("tipo_producto");
                String canti = buscar.getString("cantidad");
                String precio = buscar.getString("precio");
                String fec = buscar.getString("fecha");
                String pre_Total = buscar.getString("pre_Total");

                Venta venta = new Venta();
                
                venta.setId_venta(id_venta);
                venta.setCod_producto(cod_producto);
                venta.setCed_comprador(cedu_comprador);
                venta.setNom_producto(nom_producto);
                venta.setMate_producto(mate_producto);
                venta.setTipo_producto(tipo_producto);
                venta.setCantidad(canti);
                venta.setPrecio(precio);
                venta.setFecha(fec);
                venta.setPre_Total(pre_Total);

                listaConsulta.add(venta);

            }

            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en la conexion: " + e);
        }
        return listaConsulta;
    }

    public static ArrayList cargarNombres() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion establecida!");
            Statement sentencia = conexion.createStatement();
            ResultSet necesario = sentencia.executeQuery("select nombres,apellidos from cliente");

            listaNombres = new ArrayList<>();
            while (necesario.next()) {

                String nom = necesario.getString("nombres");
                String ape = necesario.getString("apellidos");

                listaNombres.add(nom + " " + ape);
            }
            sentencia.close();
            conexion.close();

        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
        return listaNombres;

    }

    public static ArrayList cargarVenta(String cedula) {
        Cliente cliente = new Cliente();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion establecida!");
            Statement sentencia = conexion.createStatement();
            ResultSet necesario = sentencia.executeQuery("select * from ventas where cedula= " + cedula);

            listaNombres = new ArrayList<>();
            while (necesario.next()) {

                String ced = necesario.getString("cedula");
                String cod_pro = necesario.getString("cod_producto");

                listaNombres.add(ced + " " + cod_pro);
            }
            sentencia.close();
            conexion.close();

        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
        return listaNombres;

    }

    //actualizar datos del cliente
    public void actualizarCliente(Cliente cliente) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion establecida!");

            Statement sentencia = conexion.createStatement();

            int update = sentencia.executeUpdate("update alumno.alumno set Nombre='" + cliente.getNombres() + "' ,'" + cliente.getApellidos() + "' ,'" + cliente.getTelefono() + "' ,'" + cliente.getBarrio() + "','" + cliente.getNcasa() + "' , '" + cliente.getDireccion() + "' ,'" + cliente.getCorreo() + "' where ( Cedula = '" + cliente.getCedula() + "')");

            sentencia.close();
            conexion.close();
        } catch (Exception t) {
            System.out.print("Error en la conexion" + t);
        }
    }

    //Metodo para obtener los nombres guardados en la base de datos de la tabal cliente
    public static ArrayList cargarCliente() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "root");
            System.out.print("Conexion establecida!");
            Statement sentencia = conexion.createStatement();
            ResultSet encontrar = sentencia.executeQuery("select * from estudiante");
            Cliente cliente;

            listaNombres = new ArrayList<>();
            while (encontrar.next()) {

                String ced = encontrar.getString("cedula");
                String nom = encontrar.getString("nombres");
                String ape = encontrar.getString("apellidos");
                String tel = encontrar.getString("telefono");
                String bar = encontrar.getString("barrio");
                String casa = encontrar.getString("Ncasa");
                String dir = encontrar.getString("direccion");
                String corr = encontrar.getString("correo");

                cliente = new Cliente();

                cliente.setCedula(ced);
                cliente.setNombres(nom);
                cliente.setApellidos(ape);
                cliente.setTeléfono(tel);
                cliente.setBarrio(bar);
                cliente.setNcasa(casa);
                cliente.setDireccion(dir);
                cliente.setCorreo(corr);

                listacliente.add(cliente);
            }
            sentencia.close();
            conexion.close();

        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
        return listacliente;

    }
//		
//		public static Object buscar(String cedula){
//			ListasEstudiantesBD r = new ListasEstudiantesBD();
//			listaE=new ArrayList<>();
//			listaE = r.cargar();	
//			for(int i = 0;i<listaE.size();i++){
//				Estudiante con = (Estudiante)listaE.get(i);
//				if(con.getCedula().equals(cedula)){
//					return con;
//				}
//			}
//			return null;
//		}
}
