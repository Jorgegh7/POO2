package modelo;

import decorator.Producto;
import java.util.ArrayList;


public class Tienda {
    private Tienda tienda;
    public ArrayList<Producto> listaProductos = new ArrayList<>();

    public Tienda() {
    }

    public Tienda(Tienda tienda, ArrayList<Producto> listaProductos) {
        this.tienda = tienda;
        this.listaProductos = listaProductos;
    }

    public void mostrarProductos(){
        for(Producto producto: listaProductos){
            System.out.println(producto.getDescripcion());
        }
    }

}
