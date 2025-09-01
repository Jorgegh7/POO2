package modelo;

import modelo.decorator.Component;

public class Producto implements Component {
    private String nombre;
    private double precioBase;
    private String categoria;
    private String marca;
    private int unidades;

    public Producto() {}

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precioBase = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre, String marca,  double precioBase, String categoria, int unidades) {
        this.nombre = nombre;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoria = categoria;
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecioBase() {
        return precioBase;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String getDescripcion() {
        return "Nombre Producto: " + nombre +", Marca: " + marca + ", Categoria: " + categoria + ", Precio Base: $" + precioBase + ", Unidades: " + unidades;
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
