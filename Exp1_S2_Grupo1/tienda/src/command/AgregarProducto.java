package command;

import decorator.Producto;
import modelo.Tienda;

public class AgregarProducto implements Command {
    Carrito carrito;
    Producto producto;
    int unidades;

    public  AgregarProducto(){}

    public AgregarProducto(Carrito carrito, Producto producto, int unidades) {
        this.carrito = carrito;
        this.producto = producto;
        this.unidades = unidades;
    }


    @Override
    public void ejecutar() {
        carrito.listaProductos.add(producto);
        System.out.println("Has agregado correctamente el producto: " + producto.getDescripcion() + " a tu carrito de compras");
        System.out.println("Numero de Unidades: " + unidades);
    }

}
