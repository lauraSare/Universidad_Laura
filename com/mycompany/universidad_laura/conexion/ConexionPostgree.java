package com.mycompany.universidad_laura.conexion;

import java.sql.*;

public class ConexionPostgree {
    private static ConexionPostgree instance;
    private Connection conexion;

    private ConexionPostgree() {
        try {
            // Conexión a PostgreSQL
            System.out.println("Estableciendo conexión con la base de datos PostgreSQL...");
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/Universidad";
            String usuario = "postgres";
            String contrasena = "laura";
            conexion = DriverManager.getConnection(URL, usuario, contrasena);
            System.out.println("Conexión establecida con PostgreSQL con éxito!");
            conexion.setAutoCommit(false); // Desabilita el modo de autocommit
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Singleton
    public static synchronized ConexionPostgree getInstance() {
        if (instance == null) {
            instance = new ConexionPostgree();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return conexion;
    }

    // Otros métodos necesarios (prepareStatement, ejecutarInstruccionDML, ejecutarConsultaSQL, etc.)
    // Puedes copiarlos de la clase Conexion y adaptarlos según sea necesario
}