package modelo;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void actualizarPrecio(Producto producto, double nuevoPrecio){
        producto.setPrecio(nuevoPrecio);
        System.out.println("El precio del producto " + producto.getNombre() + "ha sido actualizado de forma correcta");
    }

    public void actualizarStock(Producto producto, int stock){
        producto.setStock(stock);
    }

    public void descripcionProducto(Producto producto){
        System.out.println();
        System.out.println("Nombre Producto: " +  producto.getNombre());
        System.out.println("Codigo Producto: " + producto.getCodigo());
        System.out.println("Precio producto: $" + producto.precio);
        System.out.println("Stock: " + producto.stock);
    }

}
