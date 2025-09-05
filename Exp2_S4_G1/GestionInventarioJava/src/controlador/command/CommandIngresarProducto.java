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
        inventario.agregarProducto(producto);
    }
}
