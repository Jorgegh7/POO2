package controlador.command;

import modelo.Inventario;
import modelo.Producto;

public class CommandIngresarProducto implements Command{
    private Inventario inventario;
    private Producto producto;

    public CommandIngresarProducto(Inventario inventario, Producto producto) {
        this.inventario = inventario;
        this.producto = producto;

    }

    @Override
    public void ejecutar() {
        if(inventario.existeProducto(producto.getCodigo())){
            System.out.println("El codigo del producto ingresado ya existe.");
            System.out.println("Ingresa un nuevo codigo");
        }else{
            inventario.agregarProducto(producto);
            System.out.println("Producto Agregado de forma correcta al Inventario");
            System.out.println();
        }

    }
}
