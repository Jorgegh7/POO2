package controlador;

import dao.PeliculaDao;
import modelo.Pelicula;

import java.util.List;

public class CarteleraControlador {
    private final PeliculaDao dao = new PeliculaDao();

    public List<Pelicula> listar(){
        return dao.listar();
    }

    public List<Pelicula> buscarPorNombre(String patron){
        if(patron == null) patron = "";
        return patron.isBlank() ? dao.listar()  : dao.buscarPorNombre(patron);
    }

    public String crear(String titulo, String director, String anio) {
        String v = validarPelicula(titulo, director, anio);
        if (v != null) {
            return v;
        } else {
            return dao.crear(new Pelicula(titulo, director, anio)) ? "Contacto creado." : "No se pudo crear el contacto.";
        }
    }

    private String validarPelicula(String titulo, String director, String anio) {
        if (titulo == null || titulo.isBlank()) {
            return "El título está vacío";
        }
        if (director == null || director.isBlank()) {
            return "El director está vacío";
        }
        if (anio == null || anio.isBlank()) {
            return "El año está vacío";
        }
        try {
            int anioInt = Integer.parseInt(anio);
            int anioActual = java.time.Year.now().getValue();
            if (anioInt < 1900 || anioInt > anioActual) {
                return "El año debe estar entre 1900 y " + anioActual;
            }
        } catch (NumberFormatException e) {
            return "El año debe ser un número entero";
        }
        return null;
    }



}
