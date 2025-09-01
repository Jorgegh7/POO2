package modelo.decorator;

public class DecoradorTodoProducto extends Decorator{

    public DecoradorTodoProducto(Component component) {
        super(component);
    }


    @Override
    public double getPrecioBase() {
        return component.getPrecioBase();
    }

    @Override
    public int getDescuento() {
        return 10;
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
