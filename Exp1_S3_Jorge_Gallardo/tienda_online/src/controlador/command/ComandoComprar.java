package controlador.command;

import modelo.Carrito;
import modelo.Producto;
import modelo.RepositorioProductos;

//Clase que posee la logica de comprar un producto

public class ComandoComprar implements Command {
    Carrito carrito;
    private String productoSeleccionado;
    private int unidades;
    private RepositorioProductos repositorioProductos;

    //Buscamos por medio de un String la instancia de producto almacenada en el Repositorio
    //Luego agregamos el producto con sus respectivas unidades al carrito

    public ComandoComprar(String productoSeleccionado, int unidades, RepositorioProductos repositorioProductos, Carrito carrito) {
        this.productoSeleccionado = productoSeleccionado;
        this.unidades = unidades;
        this.repositorioProductos = repositorioProductos;
        this.carrito = carrito;
    }

    @Override
    public void ejecutar() {
        Producto productoBuscado = new Producto();
        boolean productoEncontrado = false;
        boolean productoEnCarro = false;
        int indexProducto = 0;

        //Verificamos si el producto se encuentra en el repositorio y la espectariva de compra es menor a las unidades disponibles
        for(Producto producto: repositorioProductos.getProductos()){
            if(producto.getNombre().equalsIgnoreCase(productoSeleccionado) && producto.getUnidades()>= unidades){
                productoBuscado = producto;
                productoEncontrado = true;
            }
        }
        //Logica para indicar que el producto no ha sido encontrado
        if(!productoEncontrado){
            System.out.println("El producto: " + productoSeleccionado + ", no se encuentra disponible" );
        }else{
            //Instanciamos un nuevo producto que vamos a agregar a Carrito
            Producto productoCarrito = new Producto(productoBuscado.getNombre(), productoBuscado.getMarca(),
                    productoBuscado.getPrecioBase(), productoBuscado.getCategoria(), unidades);

            //Verificamos la existencia del producto en Carrito para evitar una cascada de productos duplicado (sumamos las unidades)
            for(Producto producto : carrito.getProductosCarrito()){
                if(producto.getNombre().equalsIgnoreCase(productoSeleccionado)){
                    productoEnCarro = true;
                    indexProducto = carrito.getProductosCarrito().indexOf(producto);
                }
            }

            //Al no estar en Carrito agregamos el producto completo
            if(productoEnCarro == false){
                productoCarrito.setUnidades(unidades);
                carrito.agregarProducto(productoCarrito);
            }else{
                //Almacenamos en una variable el numero de unidades del producto anteriormente almacenado en Carrito para sumar las nuevas unidades.
                int unidadesProductoCarrito = carrito.getProductosCarrito().get(indexProducto).getUnidades();
                carrito.getProductosCarrito().get(indexProducto).setUnidades(unidadesProductoCarrito + unidades);
            }
            //Eliminamos el producto buscado(para modificar el numero de unidades)
            repositorioProductos.getProductos().remove(productoBuscado);

            //Seteamos el producto que vamos a agregar al ArrayList
            productoBuscado.setUnidades(productoBuscado.getUnidades()- unidades);
            repositorioProductos.getProductos().add(productoBuscado);

            System.out.println();
            System.out.println("Producto agregado de forma correcta al Carrito de Compras");
        }
    }
}
