package controlador;

import controlador.command.*;
import modelo.Carrito;
import modelo.RepositorioProductos;
import vista.VistaCliente;

//Controla el flujo de la aplicacion

public class ControladorTienda {
    private VistaCliente vista;
    private RepositorioProductos modelo;
    private Carrito carrito;

    public ControladorTienda(VistaCliente vista, RepositorioProductos modelo, Carrito carrito) {
        this.vista = vista;
        this.modelo = modelo;
        this.carrito = carrito;
    }

    public void iniciarAplicacion(){
    boolean continuar = true;

    //Cargamos los productoa a la app. Se ejecuta fuera del while
    modelo.cargarProductos();

    while(continuar){

        //Menu principal
        vista.mostrarMenuPrincipal();

        int opcion = vista.leerOpcion();

        switch (opcion){
            case 1: //Descuentos
                vista.mostrarDescuentos();
                break;

            case 2: //Mostrar Productos
                vista.mostrarProductos(modelo);
                break;

            case 3: //Comprar
                modelo.totalProductos();
                vista.mostrarSeccionCompra(modelo);

                String opcionProducto = vista.leerProducto();
                int unidades = vista.leerUnidadesProducto();

                ComandoComprar comprar = new ComandoComprar(opcionProducto, unidades, modelo, carrito);
                comprar.ejecutar();

                ComandoTotalCarrito totalCarrito = new ComandoTotalCarrito(carrito);
                totalCarrito.ejecutar();
                break;

            case 4: //Mostrar Carrito
                ComandoMostrarCarrito mostrarCarrito = new ComandoMostrarCarrito(carrito);
                mostrarCarrito.ejecutar();

                totalCarrito = new ComandoTotalCarrito(carrito);
                totalCarrito.ejecutar();
                carrito.mostrarTotal();
                break;

            case 5: //Eliminar Compra
                vista.mostrarEliminarCompra();
                String productoEliminar = vista.leerProducto();
                int unidadesEliminar = vista.leerUnidadesProducto();

                ComandoEliminarCompra eliminarCompra = new ComandoEliminarCompra(carrito, productoEliminar, unidadesEliminar, modelo);
                eliminarCompra.ejecutar();

                break;

            case 6: //Finalizar Carrito - Aqui se aplican los descuentos a los productos para entregar el valor final
                vista.mostrarFinalizarCompra(carrito);
                carrito.mostrarProductosCarrito();
                carrito.mostrarTotal();
                ComandoAplicarDescuento aplicarDescuento = new ComandoAplicarDescuento(carrito);
                aplicarDescuento.ejecutar();
                break;

            case 7: //Salir de la aplicacion
                vista.salir();
                continuar = false;
                break;

            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");

        }
    }
}


}
