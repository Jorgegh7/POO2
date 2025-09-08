package controlador;

import controlador.command.CommandBuscarProducto;
import controlador.command.CommandEliminarProducto;
import controlador.command.CommandIngresarProducto;
import controlador.command.CommandModificarStock;
import modelo.Inventario;
import modelo.Producto;
import vista.MenuPrincipal;

public class ControladoInventario {
    private MenuPrincipal vista;
    private Inventario modelo;

    public ControladoInventario(MenuPrincipal vista, Inventario modelo) {
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

                case 2://Buscar Producto
                    String codigoProductoBuscado = vista.leerCodigoProducto();
                    CommandBuscarProducto buscarProducto = new CommandBuscarProducto(codigoProductoBuscado, modelo);
                    buscarProducto.ejecutar();
                    break;

                case 3: //Agregar Nuevo Producto
                    String codigoProducto = vista.leerCodigoProducto();
                    String nombreProducto = vista.leerNombreProducto();
                    double precio = vista.leerprecio();
                    int stock = vista.leerStockProducto();

                    Producto producto = new Producto(codigoProducto, nombreProducto, precio, stock);
                    CommandIngresarProducto ingresarProducto = new CommandIngresarProducto(modelo, producto);
                    ingresarProducto.ejecutar();
                    break;

                case 4://Eliminar Producto
                    String codigoEliminarProducto = vista.leerCodigoProducto();
                    CommandEliminarProducto eliminarProducto = new CommandEliminarProducto(modelo, codigoEliminarProducto);
                    eliminarProducto.ejecutar();
                    break;

                case 5: //Modificar Stock Producto
                    String codigoModificarStock = vista.leerCodigoProducto();
                    int nuevoStock = vista.leerStockProducto();
                    if(nuevoStock <0){
                        System.out.println("El Stock no puedo ser menor a 0");
                    }else{
                        CommandModificarStock modificarStock = new CommandModificarStock(modelo,codigoModificarStock, nuevoStock);
                        modificarStock.ejecutar();
                    }
                    break;

                case 6: //Salir Sistema
                    continuar = vista.salirSistema();
                    break;

                default:
                    vista.opcionInvalida();
            }
        }
    }
}
