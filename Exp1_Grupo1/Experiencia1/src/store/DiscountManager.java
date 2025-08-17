package store;

public class DiscountManager {

    //variable Singleton
    private static DiscountManager instance;

    //Descuento aplicables de la tienda
    private double descuentoGlobal = 0.10;
    private String cuponValido = "PROMO15";
    private double descuentoCupon = 0.15;

    private String categoriaDescuento = "Electronica";
    private double descuentoCategoria = 0.05;

    //Constructor privado
    private DiscountManager() {}

    //metodo que verifica la instancia del Singleton
    public static DiscountManager getInstance(){
        if (instance == null){
            instance = new DiscountManager();
        }
        return instance;
    }

    //Metodo que aplica el descuento
    public double aplicarDescuento (double precioProducto, String categoria, String cuponDecuento){
        double descuentoTotal = 0.0;

        descuentoTotal += descuentoGlobal;

        if(categoria != null && categoria.equalsIgnoreCase(cuponValido)){
            descuentoTotal += descuentoCupon;
        }
        if(categoriaDescuento != null && categoriaDescuento.equalsIgnoreCase(categoriaDescuento)){
            descuentoTotal += descuentoCategoria;
        }

        return precioProducto * (1-descuentoTotal);
    }

}
