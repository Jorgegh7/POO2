package controlador.command;

import modelo.Carrito;
import modelo.Producto;

//Clase encargada de sumar todos los productos para ser integrados a Carrito

public class ComandoTotalCarrito implements Command{
    Carrito carrito;

    public ComandoTotalCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public void ejecutar() {
        double totalCompra = 0;

        if(!carrito.getProductosCarrito().isEmpty()){
            for(Producto producto: carrito.getProductosCarrito()){
                totalCompra += producto.getPrecioBase() * producto.getUnidades();
            }
        }else{
            System.out.println("No posees Productos en el Carrito");
        }
        carrito.setTotal(totalCompra);
        //carrito.mostrarTotal();
    }
}
