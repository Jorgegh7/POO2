package command;

import decorator.Producto;

import java.util.ArrayList;

public class Carrito implements Command {
    Carrito carrito;
    ArrayList<Producto> listaProductos = new ArrayList<>();

    public Carrito(){}

    public Carrito(Carrito carrito, ArrayList listaProductos) {
        this.carrito = carrito;
        this.listaProductos = listaProductos;
    }

    @Override
    public void ejecutar() {
        if (listaProductos.isEmpty()) {
            System.out.println("El carrito se encuentra vacio");
            System.out.println("No posees productos agregados");
        }
        for(int i = 0; i < listaProductos.size(); i++){
            Producto productoConsulta = listaProductos.get(i);
            System.out.println(productoConsulta.getDescripcion());
        }

    }
}
