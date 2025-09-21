package dao;

import modelo.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDao {

    public boolean crear(Pelicula p) {
        String sql = "INSERT INTO Pelicula (titulo, director, año) VALUES (?, ?, ?)";

        try {
            boolean var5;
            try (
                    Connection conn = DBConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);
            ) {
                ps.setString(1, p.getTitulo());
                ps.setString(2, p.getDirector());
                ps.setInt(3, Integer.parseInt(p.getAnio()));
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
        String sql = "SELECT id, titulo, director, año FROM Pelicula ORDER BY id";

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
                        rs.getString("año")));
            }
        } catch (SQLException e) {
            System.out.println("Error listar(): " + e.getMessage());
        }

        return out;
    }

    public List<Pelicula> buscarPorNombre(String patron) {
        List<Pelicula> out = new ArrayList();
        String sql = "SELECT id, titulo, director, año FROM Pelicula WHERE titulo LIKE ? ORDER BY id";

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
                            rs.getString("año")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error buscarPorNombre(): " + e.getMessage());
        }

        return out;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Pelicula WHERE id = ?";

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


}
