package app;

import controlador.ControladorTienda;
import modelo.Carrito;
import modelo.RepositorioProductos;
import vista.VistaCliente;

public class Main {
    public static void main(String[] args) {

        RepositorioProductos repositorioProductos = new RepositorioProductos();
        VistaCliente vistaCliente = new VistaCliente();
        Carrito carrito = new Carrito();

        ControladorTienda controladorTienda = new ControladorTienda(vistaCliente, repositorioProductos, carrito);
        controladorTienda.iniciarAplicacion();
    }
}