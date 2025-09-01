package modelo.decorator;

public class DecoradorNumeroUnidades extends Decorator {


    public DecoradorNumeroUnidades(Component component) {
        super(component);
    }

    @Override
    public double getPrecioBase() {
        return component.getPrecioBase();
    }

    @Override
    public int getDescuento() {
        int descuento=0;
        if(component.getUnidades() >= 3){descuento=10;}
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
