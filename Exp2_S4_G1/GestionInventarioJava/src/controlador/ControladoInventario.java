package controlador;

import controlador.command.CommandEliminarProducto;
import controlador.command.CommandIngresarProducto;
import controlador.command.CommandModificarStock;
import modelo.Inventario;
import modelo.Producto;
import vista.VistaInventario;

public class ControladoInventario {
    private VistaInventario vista;
    private Inventario modelo;

    public ControladoInventario(VistaInventario vista, Inventario modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciarAplicacion(){
        modelo.cargarProductosBase();
        boolean continuar = true;


        while(continuar){
            vista.mostrarMenu();
            int opcionMenu = vista.leerOpcion();

            switch (opcionMenu){
                case 1: //Mostrar Productos
                    modelo.mostrarProductos();
                    break;

                case 2: //Agregar Nuevo Producto
                    String codigoProducto = vista.leerCodigoProducto();
                    String nombreProducto = vista.leerNombreProducto();
                    double precio = vista.leerprecio();
                    int stock = vista.leerStockProducto();

                    Producto producto = new Producto(codigoProducto, nombreProducto, precio, stock);
                    CommandIngresarProducto ingresarProducto = new CommandIngresarProducto(modelo, producto);
                    ingresarProducto.ejecutar();
                    break;

                case 3://Eliminar Producto
                    String codigoEliminarProducto = vista.leerCodigoProducto();
                    CommandEliminarProducto eliminarProducto = new CommandEliminarProducto(modelo, codigoEliminarProducto);
                    eliminarProducto.ejecutar();
                    break;

                case 4: //Modificar Stock Producto
                    String codigoModificarStock = vista.leerCodigoProducto();
                    int nuevoStock = vista.leerStockProducto();
                    CommandModificarStock modificarStock = new CommandModificarStock(modelo,codigoModificarStock, nuevoStock);
                    modificarStock.ejecutar();
                    break;

                case 5: //Salir Sistema
                    continuar = vista.salirSistema();
                    break;

                default:
                    vista.opcionInvalida();
            }
        }
    }
}
