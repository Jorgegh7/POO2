package store;

public class Store {
    public static void main(String[] args) {

        DiscountManager dm = DiscountManager.getInstance();

        //Caso 1: Refrigerador
        String nombreProducto = "Refrigerador LG 2334";
        double precioBase = 235000;
        String categoriaProducto = "Linea Blanca";
        String cupon = "Promo15";

        double precioFinal = dm.aplicarDescuento(precioBase, categoriaProducto, cupon);


        System.out.println();
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Categia: " + categoriaProducto);
        System.out.println("Cupon: " + cupon);
        System.out.println("Precio Base: $" + precioBase);
        System.out.println("Precio Final: $" + precioFinal);


        //Caso 2: Notebook
        nombreProducto = "Notebook Lenovo 4459";
        precioBase = 750000;
        categoriaProducto = "electronica";
        cupon = "Promo15";

        precioFinal = dm.aplicarDescuento(precioBase, categoriaProducto, cupon);


        System.out.println();
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Categia: " + categoriaProducto);
        System.out.println("Cupon: " + cupon);
        System.out.println("Precio Base: $" + precioBase);
        System.out.println("Precio Final: $" + precioFinal);
    }
}