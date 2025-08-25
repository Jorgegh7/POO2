package decorator;

public class DecoradorCategoria extends Decorator{
    String categoriaDescuento;

    public DecoradorCategoria(Component component) {
        super(component);
    }

    @Override
    public double getPrecioBase() {
        return 0;
    }

    @Override
    public int getDescuento() {
        categoriaDescuento = "Bikini";
        int descuentoCategoria = 0;

        if(component.getCategoria().equalsIgnoreCase(categoriaDescuento)){
            descuentoCategoria = 20;
        }
        return descuentoCategoria;
    }

    @Override
    public String getCategoria() {
        return component.getCategoria();
    }

    @Override
    public int getUnidades() {
        return 0;
    }

}
