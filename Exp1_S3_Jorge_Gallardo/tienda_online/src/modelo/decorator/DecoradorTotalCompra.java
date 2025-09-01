package modelo.decorator;

import modelo.Carrito;

public class DecoradorTotalCompra extends Decorator{
    Carrito carrito;

    public DecoradorTotalCompra(Component component) {
        super(component);
    }

    public DecoradorTotalCompra(Component component, Carrito carrito) {
        super(component);
        this.carrito = carrito;
    }

    @Override
    public double getPrecioBase() {
        return 0;
    }

    @Override
    public int getDescuento() {
        int descuento =0;
        if(carrito.getTotal()>30000){
            descuento= 10;
        }
        return descuento;
    }

    @Override
    public String getCategoria() {
        return "";
    }

    @Override
    public int getUnidades() {
        return 0;
    }
}
