package controlador.command;

import modelo.Inventario;
import modelo.Producto;

public class CommandBuscarProducto implements Command {
    private String codigo;
    private Inventario inventario;

    public CommandBuscarProducto(String codigo, Inventario inventario) {
        this.codigo = codigo;
        this.inventario = inventario;
    }

    @Override
    public void ejecutar() {
        if(inventario.existeProducto(codigo)){
            Producto productoBuscado = inventario.buscarProducto(codigo);
            productoBuscado.descripcionProducto(productoBuscado);
        }
    }
}
