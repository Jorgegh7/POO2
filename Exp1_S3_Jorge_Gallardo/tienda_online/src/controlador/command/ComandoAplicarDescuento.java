package controlador.command;

import modelo.Carrito;
import modelo.Producto;
import modelo.decorator.DecoradorCategoria;
import modelo.decorator.DecoradorNumeroUnidades;
import modelo.decorator.DecoradorTodoProducto;
import modelo.singleton.DiscountManager;

//Clase encargada de aplicar los descuentos por medio de Singleton

public class ComandoAplicarDescuento implements Command{
    DiscountManager discountManager = DiscountManager.getInstance();
    Carrito carrito;
    ComandoTotalCarrito totalCarrito;


    public ComandoAplicarDescuento( Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public void ejecutar() {

        double totalFinal = 0; //Sumamos el total de cada producto procesado con descuento

        ComandoTotalCarrito totalCarrito = new ComandoTotalCarrito(carrito);
        totalCarrito.ejecutar();

        //Verificamos cada producto para aplicar los descuentos respectivos
        for(Producto producto: carrito.getProductosCarrito()){
            //sumamos todos los descuentos que van a ser aplicado a cada producto
            //Esta variable se resetea por cada ciclo del for.

            int descuento = 0;

            DecoradorTodoProducto todoProducto = new DecoradorTodoProducto(producto);
            DecoradorCategoria decoradorCategoria = new DecoradorCategoria(producto);
            DecoradorNumeroUnidades numeroUnidades = new DecoradorNumeroUnidades(producto);

            descuento += todoProducto.getDescuento();
            descuento += decoradorCategoria.getDescuento();
            descuento += numeroUnidades.getDescuento();

            totalFinal += discountManager.aplicarDescuento(producto.getPrecioBase()* producto.getUnidades(), descuento);
        }
        System.out.println();
        System.out.println("Aplicando descuentos a tu compra...");
        System.out.println();
        System.out.println("Descuentos Totales Aplicados: $" + (carrito.getTotal() - totalFinal));
        System.out.println("El total de tu compra es: $" + totalFinal);
        carrito.setTotalFinal(totalFinal);
    }
}
