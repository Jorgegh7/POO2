package controlador.command;

import modelo.Inventario;

public class CommandModificarStock implements Command{
    private Inventario inventario;
    private String codigo;
    private int stock;

    public CommandModificarStock(Inventario inventario, String codigo, int stock) {
        this.inventario = inventario;
        this.codigo = codigo;
        this.stock = stock;
    }

    @Override
    public void ejecutar() {
        if(inventario.existeProducto(codigo)){
            inventario.modificarStock(codigo, stock);
            System.out.println("El Stock ha sido modificado de forma correcta");
            System.out.println();
        }else{
            System.out.println("Código Invalido");
        }
    }
}
