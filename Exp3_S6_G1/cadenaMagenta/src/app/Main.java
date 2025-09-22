package app;

import dao.PeliculaDao;
import modelo.Pelicula;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        PeliculaDao peliculaDao = new PeliculaDao();

        //Pelicula nuevaPelicula = new Pelicula("El Gladiador", "Ridley Scott", "2000");
        //peliculaDao.crear(nuevaPelicula);


        System.out.println((peliculaDao.buscarPorNombre("El Gladiador")));

        for(Pelicula pelicula: peliculaDao.listar()){
            System.out.println(pelicula);
        }
        peliculaDao.eliminar(5);


        for(Pelicula pelicula: peliculaDao.listar()){
            System.out.println(pelicula);
        }

        Pelicula nuevaPelicula = new Pelicula("El Gladiador", "Ridley Scott", "2000");
        peliculaDao.crear(nuevaPelicula);

        System.out.println();

        for(Pelicula pelicula: peliculaDao.listar()){
            System.out.println(pelicula);
        }



    }
}