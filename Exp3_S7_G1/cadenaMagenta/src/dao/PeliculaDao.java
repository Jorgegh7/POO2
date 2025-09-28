package dao;

import modelo.Pelicula;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDao {

    public boolean crear(Pelicula p) {
        String sql = "INSERT INTO Cartelera (titulo, director, año, duracion, genero) VALUES (?, ?, ?, ?, ?)";

        try {
            boolean var5;
            try (
                    Connection conn = DBConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);
            ) {
                ps.setString(1, p.getTitulo());
                ps.setString(2, p.getDirector());
                ps.setInt(3, Integer.parseInt(p.getAnio()));
                ps.setInt(4, Integer.parseInt(p.getDuracion()));
                ps.setString(5, p.getGenero());

                var5 = ps.executeUpdate() == 1;
            }

            return var5;
        } catch (SQLException e) {
            System.out.println("Error crear(): " + e.getMessage());
            return false;
        }
    }

    public List<Pelicula> listar() {
        List<Pelicula> out = new ArrayList();
        String sql = "SELECT id, titulo, director, anio, duracion, genero FROM Cartelera ORDER BY id";

        try (
                Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
        ) {
            while(rs.next()) {
                out.add(new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        Integer.toString(rs.getInt("anio")),
                        Integer.toString(rs.getInt("duracion")),
                        rs.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error listar(): " + e.getMessage());
        }

        return out;
    }

    public List<Pelicula> buscarPorNombre(String patron) {
        List<Pelicula> out = new ArrayList();
        String sql = "SELECT id, titulo, director, duracion, anio , genero FROM Cartelera WHERE titulo LIKE ? ORDER BY id";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, "%" + patron + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    out.add(new Pelicula(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("director"),
                            Integer.toString(rs.getInt("anio")),
                            Integer.toString(rs.getInt("duracion")),
                            rs.getString("genero")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error buscarPorNombre(): " + e.getMessage());
        }

        return out;
    }

    public Pelicula buscarPorId(String idPelicula){
        String sql = "SELECT id, titulo, director, anio, duracion, genero FROM Cartelera Where id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,Integer.parseInt(idPelicula));

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Pelicula(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("director"),
                            String.valueOf(rs.getInt("anio")),
                            String.valueOf(rs.getInt("duracion")),
                            rs.getString("genero")
                    );
                }
            }
        } catch (SQLException e){
            System.out.println("Error obtenerPorId(): " + e.getMessage());
        }
        return null;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Cartelera WHERE id = ?";

        try {
            boolean var5;
            try (
                    Connection conn = DBConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);
            ) {
                ps.setInt(1, id);
                var5 = ps.executeUpdate() == 1;
            }
            return var5;

        } catch (SQLException e) {
            System.out.println("Error eliminar(): " + e.getMessage());
            return false;
        }
    }

    public int validarGuardar (String titulo, String director, String anio, String duracion, String genero){
        if(titulo.isBlank() || titulo.isEmpty()){
            return 0;
        }else if(director.isBlank() || director.isEmpty()){
            return 0;
        }else if(anio.isBlank() || anio.isEmpty()){
            return 0;
        }else if(String.valueOf(duracion).isBlank() || String.valueOf(duracion).isEmpty()) {
            return 0;
        }else if(genero.isBlank() || genero.isEmpty()) {
            return 0;
        }

        try{
            Integer.parseInt(anio);
            Integer.parseInt(duracion);
            if(Integer.parseInt(anio) < 1990){
                return 1;
            }
        }catch (NumberFormatException e){
            return 1;
        }

        if(!buscarPorNombre(titulo.trim()).isEmpty()){
            return 2;
        }

        return 3;
    }

    public boolean guardar (String titulo, String director, String anio, String duracion, String genero){
        String sql = "INSERT INTO Cartelera (titulo, director, anio, duracion, genero) VALUES (?, ?, ?, ?, ?)";

        try {
            boolean var5;
            try (
                    Connection conn = DBConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);
            ) {
                ps.setString(1, titulo);
                ps.setString(2, director);
                ps.setInt(3, Integer.parseInt(anio));
                ps.setInt(4, Integer.parseInt(duracion));
                ps.setString(5, genero);

                var5 = ps.executeUpdate() == 1;
            }

            return var5;
        } catch (SQLException e) {
            System.out.println("Error crear(): " + e.getMessage());
            return false;
        }
    }

    public int validarId (String id){
        if(id.isEmpty() || id.isBlank()){
            return 0;
        }
        try{
            Integer.parseInt(id);
        }catch (NumberFormatException e){
            return 1;
        }
        return 2;
    }

    public boolean actualizar(Pelicula p, String id ){
        String sql = "UPDATE Cartelera SET titulo = ?, director = ?, anio = ?, duracion = ?, genero = ? WHERE id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            conn.setAutoCommit(false);

            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setInt(3, Integer.parseInt(p.getAnio()));
            ps.setInt(4, Integer.parseInt(p.getDuracion()));
            ps.setString(5, p.getGenero());
            ps.setInt(6, Integer.parseInt(id));


            boolean ok = ps.executeUpdate() == 1;
            conn.commit();
            return ok;

        }catch(SQLException e){
            System.out.println("Error actualizar(): " + e.getMessage());
            return false;
        }
    }

}
