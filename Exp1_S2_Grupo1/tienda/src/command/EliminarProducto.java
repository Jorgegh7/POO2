package command;

import decorator.Producto;

public class EliminarProducto {
    private Carrito carrito;
    private Producto producto;

    public EliminarProducto() {
    }

    public EliminarProducto(Carrito carrito, Producto producto) {
        this.carrito = carrito;
        this.producto = producto;

    }

    public void eliminarProducto(Carrito carrito, Producto productoBuscado, int unidades){
        if(carrito.listaProductos.contains(productoBuscado)){
            if(productoBuscado.getUnidades()< unidades){
                System.out.println("El valor ingresado excede el valor de unidades");
            } else if (productoBuscado.getUnidades()>unidades) {
                productoBuscado.setUnidades(productoBuscado.getUnidades()-unidades);
            } else if (productoBuscado.getUnidades() == unidades) {
                carrito.listaProductos.remove(productoBuscado);
            }
            System.out.println(productoBuscado.getDescripcion());

            System.out.println("Total de productos en Carrito: " + carrito.listaProductos.size());
        }
    }

}
