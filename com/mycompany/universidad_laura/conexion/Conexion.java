/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.universidad_laura.conexion;

import java.net.URL;
import java.sql.*;

/**
 *
 * @author laura
 */

public class Conexion {
    private static Conexion instance;
    private Connection conexion;
    private Statement stm;
    private ResultSet rs;

    
    
    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/Univeersidaad";
            conexion = DriverManager.getConnection(URL, "laura", "laura");
            conexion.setAutoCommit(false);//desabilita el modo de autocommit
            System.out.println("Conexión establecida!!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Singleton
    public static synchronized Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    //AGREGAR
    public PreparedStatement prepareStatement(String instruccionSQL) throws SQLException {
        if (conexion == null) {
            throw new SQLException("No hay conexión establecida.");
        }
        return conexion.prepareStatement(instruccionSQL);
    }

    public boolean ejecutarInstruccioDML(String instruccionDML) {
        boolean res = false;
        try {
            stm = conexion.createStatement();
            if (stm.executeUpdate(instruccionDML) >= 1)
                res = true;
        } catch (SQLException e) {
            System.out.println("\tError en instruccion SQL");
            System.out.println(instruccionDML);
        }
        return res;
    }

    public ResultSet ejecutarConsultaSQL(String consultaSQL) {
        rs = null;
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(consultaSQL);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en instruccion SQL");
        }
        return rs;
    }

    public void cerrarConexion() {
        // Implementar el cierre de la conexión si es necesario
    }

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

    // Método para obtener la conexión
    public Connection getConnection() {
        return conexion;
    }

    //ELIMINAR
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

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     
}



  






    
