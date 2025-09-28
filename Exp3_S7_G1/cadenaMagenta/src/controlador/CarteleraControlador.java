package controlador;

import dao.PeliculaDao;
import modelo.Pelicula;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CarteleraControlador {
    private List<Pelicula> peliculaList = new ArrayList<>();

    private final PeliculaDao dao = new PeliculaDao();

    public List<Pelicula> listar(){
        return dao.listar();
    }

    public List<Pelicula> buscarPorNombre(String patron){
        List<Pelicula> peliculaList = new ArrayList<>();
        if (patron.isEmpty() || patron.isBlank() || patron.equalsIgnoreCase("Ingresa el nombre de la pelicula")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Nombre");
            return peliculaList;
        }

        String text = patron.trim();
        peliculaList = dao.buscarPorNombre(text);

        if(peliculaList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Pelicula " + patron + " no ha sido encontrada.");
        }
        return peliculaList;
    }

    public boolean eliminarPelicula(String id){
        return dao.eliminar(Integer.parseInt(id));
    }

    public int validarPelicula(String titulo, String director, String anio, String duracion, String genero) {
        return dao.validarGuardar(titulo, director, anio, duracion, genero);
    }

    public boolean guardarPelicula(String titulo, String director, String anio, String duracion, String genero){
        return dao.guardar(titulo, director, anio, duracion, genero);

    }

    public int validarID(String idPelicula){
        if(dao.validarId(idPelicula)==0){
            return 0;
        }else if(dao.validarId(idPelicula)==1){
            return 1;
        }
        return 2;
    }

    public Pelicula buscarPorId(String idPelicula){
        return dao.buscarPorId(idPelicula);
    }

    public boolean actualizar(Pelicula pelicula, String id){
        return dao.actualizar(pelicula, id);
    }

}
