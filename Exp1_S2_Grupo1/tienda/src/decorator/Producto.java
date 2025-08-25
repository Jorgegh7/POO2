package decorator;

public class Producto implements Component {

    private String nombre;
    private double precioBase;
    private String categoria;
    private int unidades;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precioBase = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre, double precioBase, String categoria, int unidades) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
        this.unidades = unidades;
    }

    @Override
    public double getPrecioBase() {
        return precioBase;
    }

    @Override
    public String getDescripcion() {
        return "Nombre Producto: " + nombre + ", Categoria: " + categoria + ", Precio Base: $" + precioBase + ", Unidades: " + unidades;
    }

    @Override
    public int getDescuento() {
        return 0;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
