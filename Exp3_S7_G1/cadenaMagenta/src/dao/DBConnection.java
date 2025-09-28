package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final java.lang.String URL = "jdbc:mysql://localhost:3306/Peliculas_DB";
    private static final java.lang.String USER = "root";
    private static final java.lang.String PASS = "Kaspa998877!";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Conexion establecida con la base de datos");
        return conn;
    }

}
