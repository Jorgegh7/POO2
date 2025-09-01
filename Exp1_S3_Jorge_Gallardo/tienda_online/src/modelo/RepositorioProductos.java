package modelo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioProductos {
    private List<Producto> productos = new ArrayList<>();

    public RepositorioProductos() {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }


    public void mostrarProductos(){
        for(Producto producto: productos){
            System.out.println(producto.getDescripcion());
        }
    }

    public void mostrarProductosFormatoCompra(){
        int i = 0;
        for(Producto producto: productos){
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Precio: $" + producto.getPrecioBase());
            System.out.println("Unidades Disponibles: " + producto.getUnidades());
            System.out.println();
        }

    }

    public void cargarProductos(){
        productos.add(new Producto("Polera", "Nike",  10000, "Deportes", 5));
        productos.add(new Producto("Short","Nike",  15000, "Deportes", 5));
        productos.add(new Producto("Zapatillas","Addidas",  32000, "Calzado", 5));
        productos.add(new Producto("Bikini","Billabong",  17000, "Verano", 5));
    }

    public int totalProductos(){
        return productos.size();
    }




}
