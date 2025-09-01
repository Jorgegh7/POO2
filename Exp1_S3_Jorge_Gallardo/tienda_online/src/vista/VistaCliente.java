package vista;

import modelo.Carrito;
import modelo.RepositorioProductos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaCliente {
    private Scanner scanner;

    public VistaCliente() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal(){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         TIENDA DE ROPA ONLINE");
        System.out.println("=".repeat(40));
        System.out.println("1. Promociones Disponibles");
        System.out.println("2. Ver Productos");
        System.out.println("3. Comprar");
        System.out.println("4. Ver Carrito");
        System.out.println("5. Eliminar Producto");
        System.out.println("6. Finalizar Compra");
        System.out.println("7. Salir");
        System.out.println("=".repeat(40));
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion(){
        try{
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println();
            return -1;
        }

    }

    public String leerProducto(){
        scanner.nextLine();
        System.out.print("Indica el nombre del Producto: ");
        try{
            return scanner.nextLine().strip();
        } catch (Exception e) {
            System.out.println("Error al leer el producto. Intenta de nuevo.");
            return "";
        }
    }
    public int leerUnidadesProducto(){
        try{
            System.out.print("Ingresa las unidades: ");
            int unidades = scanner.nextInt();
            return unidades;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarDescuentos(){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         DESCUENTOS DISPONIBLES");
        System.out.println("=".repeat(40));
        System.out.println("10% de descuento en toda la Tienda");
        System.out.println("20% de descuento sobre la categoria VERANO");
        System.out.println("10% de descuento al comprar 3 unidades o mas de un producto");

    }

    public void mostrarProductos(RepositorioProductos repositorioProductos){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         PRODUCTOS DISPONIBLES");
        System.out.println("=".repeat(40));
        repositorioProductos.mostrarProductos();
    }

    public void mostrarSeccionCompra(RepositorioProductos repositorioProductos){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         COMPRAR PRODUCTO");
        System.out.println("=".repeat(40));
        listaProductosDiponibles(repositorioProductos);
    }
    public void listaProductosDiponibles(RepositorioProductos repositorioProductos){
        repositorioProductos.mostrarProductosFormatoCompra();
    }

    public void mostrarEliminarCompra(){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         ELIMINAR PRODUCTO");
        System.out.println("=".repeat(40));

    }

    public void mostrarFinalizarCompra(Carrito carrito){
        if(carrito.getProductosCarrito().isEmpty()){
            System.out.println();
            System.out.println("Aun no posees compras ingresadas en tu Carrito");
        }else{
            System.out.println("\n" + "=".repeat(40));
            System.out.println("         FINALIZAR COMPRA");
            System.out.println("=".repeat(40));
        }
    }

    public void salir(){
        System.out.println("Gracias por comprar en nuestra Tienda Online.");
        System.out.println("Cerrando Sistema...");
    }




}
