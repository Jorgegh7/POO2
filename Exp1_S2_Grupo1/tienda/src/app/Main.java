package app;

import command.AgregarProducto;
import command.AgregarProductoTienda;
import command.Carrito;
import command.EliminarProducto;
import decorator.DecoradorCategoria;
import decorator.DecoratorCantidad;
import decorator.Producto;
import modelo.Tienda;
import singleton.DiscountManager;

import java.lang.management.ThreadInfo;

public class Main {
    public static void main(String[] args) {
        //En una implementacion posterior es importante diferenciar Producto de compra para poder asociar al objeto
        //El numero de unidades de su compra. De igual manera poder implementar la clase tienda para poder listar de
        //Forma clara los productos.

        //Patron Singleton
        DiscountManager dm = DiscountManager.getInstance();

        //Instancia de producto
        Producto prenda1 = new Producto("Bikini Sunset", 20000, "Bikini", 3);

        //Decorador descuento por unidades
        DecoratorCantidad cantidadProducto = new DecoratorCantidad(prenda1);


        //Decorador descuento por categoria
        DecoradorCategoria categoriaProducto = new DecoradorCategoria(prenda1);

        //Singleton reuniendo los descuentos aplicados
        System.out.println("Total: $" + dm.aplicarDescuento(cantidadProducto.getPrecioBase(), (cantidadProducto.getDescuento() +categoriaProducto.getDescuento())));

        //Instancia de carrito para agregar productos
        Carrito carrito1 = new Carrito();

        //Command agregar productos a la instancia de carrito
        AgregarProducto agregarProducto = new AgregarProducto(carrito1, prenda1, 3);

        //Commando eliminar producto de la instancia de carrito
        EliminarProducto eliminarProducto = new EliminarProducto();

        //Nueva instancia de Tienda
        Tienda tienda = new Tienda();

        //Commando agregar producto a Tienda
        AgregarProductoTienda agregarProductoTienda = new AgregarProductoTienda(tienda, prenda1, 5);


        carrito1.ejecutar();
        agregarProducto.ejecutar();
        carrito1.ejecutar();
        eliminarProducto.eliminarProducto(carrito1, prenda1, 1);

        System.out.println();
        agregarProductoTienda.ejecutar();

        System.out.println();
        tienda.mostrarProductos();



    }
}