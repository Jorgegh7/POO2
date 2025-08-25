package decorator;

public class DecoratorCantidad extends Decorator {


    public DecoratorCantidad(Component component) {
        super(component);
    }

    @Override
    public double getPrecioBase() {
        return component.getUnidades()* component.getPrecioBase();
    }

    @Override
    public int getDescuento() {
        int descuento=0;
        if(component.getUnidades() > 2){descuento=10;}
        return descuento;
    }

    @Override
    public String getCategoria() {
        return component.getCategoria();
    }

    @Override
    public int getUnidades() {
        return component.getUnidades();
    }
}
