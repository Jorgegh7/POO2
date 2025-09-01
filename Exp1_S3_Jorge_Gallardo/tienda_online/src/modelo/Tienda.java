package modelo;

import java.util.ArrayList;

public class Tienda {
    protected RepositorioProductos repositorio;

    public Tienda(RepositorioProductos repositorio) {
        this.repositorio = repositorio;
    }

    public void agregarProducto(Producto producto){
        repositorio.getProductos().add(producto);
    }

    public void eliminarProducto(Producto producto){
        repositorio.getProductos().remove(producto);
    }

}
