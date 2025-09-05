package modelo;

import java.util.HashMap;
import java.util.Iterator;

public class Inventario {
    private HashMap<String, Producto> productos;

    public Inventario(){
        productos = new HashMap<>();
    }

    public void cargarProductosBase(){
        productos.put("E001", new Producto("E001", "SmartPhone Samsung A32", 100000, 5));
        productos.put("E002", new Producto("E002", "SmartPhone Xiaomi X10 Mini", 125000, 5));
        productos.put("E003", new Producto("E003", "SmartPhone Huawei HW6", 150000, 5));
        productos.put("E004", new Producto("E004", "SmartPhone Honor H32", 95000, 5));
        productos.put("E005", new Producto("E005", "SmartPhone Apple 15S", 200000, 5));

    }

    public void agregarProducto(Producto producto){
        productos.put(producto.getCodigo(), producto);
    }

    public boolean eliminarProducto(String codigo){
        if(productos.remove(codigo)!= null){
            return true;
        }
        return false;
    }

    public void modificarStock(String codigo, int stock){
        try{
            buscarProducto(codigo).setStock(stock);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    public Producto buscarProducto(String codigo){
        if(productos.containsKey(codigo)){
            return  productos.get(codigo);
        }else{
            System.out.println("Codigo invalido");
            return null;
        }
    }

    public void mostrarProductos(){
        System.out.println("=".repeat(40));
        System.out.println("            LISTA PRODUCTOS");
        System.out.println("=".repeat(40));

        Iterator<Producto> iterator = productos.values().iterator();
        while (iterator.hasNext()){
            Producto producto = iterator.next();
            producto.descripcionProducto(producto);
        }
    }

    public boolean existeProducto(String codigo){
        if(productos.containsKey(codigo)){
            return true;
        }else{
            System.out.println("Codigo invalido");
            return false;
        }
    }
}
