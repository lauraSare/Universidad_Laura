package com.mycompany.universidad_laura.conexion;

import java.sql.*;

public class Main {
    private static Main instance;
    private Connection conexion;
    private Statement stm;
    private ResultSet rs;

    private Main() {
        try {
            // Obtener la conexión a PostgreSQL
            ConexionPostgree conexionPostgree = ConexionPostgree.getInstance();
            conexion = conexionPostgree.getConnection();
            System.out.println("Conexión establecida!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para obtener una instancia de la clase (implementación del patrón Singleton)
    public static synchronized Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    // Método para preparar una instrucción SQL (PreparedStatement)
    public PreparedStatement prepareStatement(String instruccionSQL) throws SQLException {
        if (conexion == null) {
            throw new SQLException("No hay conexión establecida.");
        }
        return conexion.prepareStatement(instruccionSQL);
    }

    // Método para ejecutar instrucciones DML (Data Manipulation Language)
    public boolean ejecutarInstruccionDML(String instruccionDML) {
        boolean res = false;
        try {
            stm = conexion.createStatement();
            if (stm.executeUpdate(instruccionDML) >= 1) {
                res = true;
            }
        } catch (SQLException e) {
            System.out.println("\tError en instrucción SQL");
            System.out.println(instruccionDML);
        }
        return res;
    }

    // Método para ejecutar consultas SQL y obtener un ResultSet
    public ResultSet ejecutarConsultaSQL(String consultaSQL) {
        rs = null;
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(consultaSQL);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en instrucción SQL");
        }
        return rs;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para hacer commit en la transacción
    public boolean commit() {
        try {
            conexion.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al hacer commit");
            return false;
        }
    }

    // Método para cerrar un ResultSet
    public void cerrarResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet: " + e.getMessage());
        }
    }

    // Método para crear un Statement
    public Statement createStatement() {
        try {
            stm = conexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stm;
    }
}