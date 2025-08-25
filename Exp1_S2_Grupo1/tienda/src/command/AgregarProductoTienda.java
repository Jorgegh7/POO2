package command;

import decorator.Producto;
import modelo.Tienda;

public class AgregarProductoTienda implements Command{
    private Tienda tienda;
    private Producto producto;
    private int unidades;

    public AgregarProductoTienda() {
    }

    public AgregarProductoTienda(Tienda tienda, Producto producto, int unidades) {
        this.tienda = tienda;
        this.producto = producto;
        this.unidades = unidades;
    }

    @Override
    public void ejecutar() {
        tienda.listaProductos.add(producto);
        System.out.println("Has agregado correctamente el producto: " + producto.getDescripcion() + " a la tienda");
        System.out.println("Numero de Unidades: " + unidades);

    }
}
