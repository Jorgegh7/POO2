package modelo.singleton;

public class DiscountManager {

    //Variable Singleton
    private static DiscountManager instance;

    //Constructor privado vacio
    private DiscountManager(){}

    //Metodo para verificar si existe una instancia y crear en el caso de no existir
    public static DiscountManager getInstance(){
        if(instance == null){
            instance = new DiscountManager();
        }
        return instance;
    }

    //Metodo que aplica el descuento
    public double aplicarDescuento (double precioProducto, double descuento){
        double total = precioProducto *(1-(descuento/100));
        return total;
    }
}
