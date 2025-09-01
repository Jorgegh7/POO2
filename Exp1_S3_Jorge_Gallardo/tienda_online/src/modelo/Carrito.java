package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productosCarrito;
    double total;
    double totalFinal;

    public Carrito() {
        this.productosCarrito = new ArrayList<>();
    }

    public List<Producto> getProductosCarrito() {
        return productosCarrito;
    }

    public double getTotal() {
        return total;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void agregarProducto(Producto producto){
        productosCarrito.add(producto);
    }

    public void mostrarProductosCarrito(){
        for(Producto producto: getProductosCarrito()){
            System.out.println(producto.getDescripcion());
        }
    }
    public void mostrarTotal(){
        System.out.println("Total: $" + total);
    }

}
