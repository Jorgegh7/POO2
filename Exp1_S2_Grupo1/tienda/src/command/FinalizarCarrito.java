package command;

import decorator.Producto;

public class FinalizarCarrito implements Command {
    Carrito carrito;
    double totalCompra;


    @Override
    public void ejecutar() {
        for(int i = 0; i < carrito.listaProductos.size(); i++){
            Producto productoConsulta = carrito.listaProductos.get(i);
            totalCompra += productoConsulta.getPrecioBase();
        }
        System.out.println();
    }
}
