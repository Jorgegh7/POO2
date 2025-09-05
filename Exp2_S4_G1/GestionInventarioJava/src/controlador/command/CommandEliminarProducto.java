package controlador.command;

import modelo.Inventario;
import modelo.Producto;

public class CommandEliminarProducto implements Command{
    private Inventario inventario;
    private String codigo;

    public CommandEliminarProducto(Inventario inventario, String codigo) {
        this.inventario = inventario;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        if(inventario.eliminarProducto(codigo)){
            System.out.println("Producto codigo: " + codigo + " ha sido eliminado de forma correcta" );
            System.out.println();

        }else{
            System.out.println("Código invalido");
            System.out.println();
        }
    }
}
