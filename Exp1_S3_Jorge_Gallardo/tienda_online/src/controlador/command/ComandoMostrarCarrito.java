package controlador.command;

import modelo.Carrito;

//Clase encargada de mostrar los Productos de Carrito

public class ComandoMostrarCarrito implements Command {
    Carrito carrito;

    public ComandoMostrarCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public void ejecutar() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         CARRITO DE COMPRAS");
        System.out.println("=".repeat(40));
        if(carrito.getProductosCarrito().isEmpty()){
            System.out.println("El Carrito se encuentra vacio");
        }else{

            carrito.mostrarProductosCarrito();
        }
    }
}
