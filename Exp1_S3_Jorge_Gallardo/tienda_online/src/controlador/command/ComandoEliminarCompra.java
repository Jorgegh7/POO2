package controlador.command;

import modelo.Carrito;
import modelo.Producto;
import modelo.RepositorioProductos;

//Clase encargada de eliminar Productos de Carrito

public class ComandoEliminarCompra implements Command{
    private Carrito carrito;
    private String productoBuscado;
    private int unidades;
    private RepositorioProductos repositorioProductos;


    public ComandoEliminarCompra(Carrito carrito, String productoBuscado, int unidades, RepositorioProductos repositorioProductos) {
        this.carrito = carrito;
        this.productoBuscado = productoBuscado;
        this.unidades = unidades;
        this.repositorioProductos = repositorioProductos;
    }

    @Override
    public void ejecutar() {
        try{
            boolean productoEncontrado = false;
            Producto producto = new Producto();

            int indexProducto = 0;
            int indexProductoRepositorio = 0;

            //Confirmamos que el carrito no este vacio
            if(!carrito.getProductosCarrito().isEmpty()) {
                for(Producto productoFor: carrito.getProductosCarrito()){
                    if(productoFor.getNombre().equalsIgnoreCase(productoBuscado.strip())){
                        producto = productoFor; //rescatamos el producto
                        productoEncontrado = true;
                    }else{
                        System.out.println("El producto no ha sido encontrado");
                    }
                }
            }else{
                System.out.println("El producto no ha sido encontrado!");
            }

            if(productoEncontrado){

                //Verificamos que el no se ingrese una Unidad mayor a la existente
                if(unidades<=producto.getUnidades() && unidades !=0){

                    for(Producto productoRepositorio: repositorioProductos.getProductos()){

                        if(productoRepositorio.getNombre().equalsIgnoreCase(productoBuscado)){
                            Producto nuevoProductoRepositorio = new Producto(productoRepositorio.getNombre(), productoRepositorio.getMarca(),
                                    productoRepositorio.getPrecioBase(), productoRepositorio.getCategoria(), productoRepositorio.getUnidades() + unidades);
                            repositorioProductos.getProductos().remove(productoRepositorio);
                            repositorioProductos.getProductos().add(nuevoProductoRepositorio);

                            System.out.println();
                            System.out.println("Producto actualizado en Base de datos!");
                        }
                    }

                    if(producto.getUnidades()>unidades) {
                        carrito.getProductosCarrito().remove(producto);
                        producto.setUnidades(producto.getUnidades() - unidades);
                        carrito.agregarProducto(producto);
                        System.out.println("Producto " + producto.getNombre() + ", ha sido modificado de forma correcta!");

                    } else if (producto.getUnidades()==unidades) {
                        carrito.getProductosCarrito().remove(producto);
                        System.out.println("Producto " + producto.getNombre() + ", ha sido modificado de forma correcta!");
                    }else{
                        System.out.println("El valor ingresado supera el total de unidades del producto en tu Carrito!");
                    }
                }

            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
