package Controladoor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author laura
 */

import Modelo.Donador;
import com.mycompany.universidad_laura.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AlumnoDAO {
  

/**
 * Clase que maneja las operaciones de acceso a datos para la entidad Donador.
 */
public class DonadorDAO {

    private Conexion conexion;

    // Constructor
    public DonadorDAO() {
        this.conexion = new Conexion();
    }

    // Método para realizar la alta de un donador
    public boolean altaDonador(Donador d) {
        String sql = "INSERT INTO Donadores (nombre, direccion, categoria, anio_graduacion, "
                + "fecha_garantia_donativo, cantidad_garantizada, cantidad_enviada, "
                + "metodo_pago, num_pagos_elegidos, num_tarjeta_credito, "
                + "nombre_corporacion_emisora, direccion_corporacion_emisora, nombre_conyuge) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, d.getNombre());
            pstmt.setString(2, d.getDireccion());
            pstmt.setString(3, d.getCategoria());
            pstmt.setInt(4, d.getAnioGraduacion());
            pstmt.setDate(5, d.getFechaGarantiaDonativo());
            pstmt.setBigDecimal(6, d.getCantidadGarantizada());
            pstmt.setBigDecimal(7, d.getCantidadEnviada());
            pstmt.setString(8, d.getMetodoPago());
            pstmt.setInt(9, d.getNumPagosElegidos());
            pstmt.setString(10, d.getNumTarjetaCredito());
            pstmt.setString(11, d.getNombreCorporacionEmisora());
            pstmt.setString(12, d.getDireccionCorporacionEmisora());
            pstmt.setString(13, d.getNombreConyuge());

            // Ejecutar la inserción
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejar la excepción
            e.printStackTrace();
            return false;
        }
    }

    // Método para realizar la baja de un donador
    public boolean bajaDonador(int idDonador) {
        String sql = "DELETE FROM Donadores WHERE ID_donador = ?";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, idDonador);

            // Ejecutar la eliminación
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejar la excepción
            e.printStackTrace();
            return false;
        }
    }

    // Método para realizar la modificación de un donador
    public boolean modificarDonador(Donador d) {
        String sql = "UPDATE Donadores SET nombre=?, direccion=?, categoria=?, anio_graduacion=?, "
                + "fecha_garantia_donativo=?, cantidad_garantizada=?, cantidad_enviada=?, "
                + "metodo_pago=?, num_pagos_elegidos=?, num_tarjeta_credito=?, "
                + "nombre_corporacion_emisora=?, direccion_corporacion_emisora=?, nombre_conyuge=? "
                + "WHERE ID_donador=?";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, d.getNombre());
            pstmt.setString(2, d.getDireccion());
            pstmt.setString(3, d.getCategoria());
            pstmt.setInt(4, d.getAnioGraduacion());
            pstmt.setDate(5, d.getFechaGarantiaDonativo());
            pstmt.setBigDecimal(6, d.getCantidadGarantizada());
            pstmt.setBigDecimal(7, d.getCantidadEnviada());
            pstmt.setString(8, d.getMetodoPago());
            pstmt.setInt(9, d.getNumPagosElegidos());
            pstmt.setString(10, d.getNumTarjetaCredito());
            pstmt.setString(11, d.getNombreCorporacionEmisora());
            pstmt.setString(12, d.getDireccionCorporacionEmisora());
            pstmt.setString(13, d.getNombreConyuge());
            pstmt.setInt(14, d.getIdDonador());

            // Ejecutar la modificación
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Manejar la excepción
            e.printStackTrace();
            return false;
        }
    }

    // Método para realizar la consulta de un donador por su ID
    public Donador consultarDonador(int idDonador) {
        String sql = "SELECT * FROM Donadores WHERE ID_donador=?";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, idDonador);

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Verificar si hay resultados
            if (rs.next()) {
                // Construir y devolver el objeto Donador
                return construirDonadorDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            // Manejar la excepción
            e.printStackTrace();
        }
        return null; // Retorna null si no se encuentra el donador
    }

    // Método para obtener todos los donadores
    public List<Donador> obtenerDonadores() {
        String sql = "SELECT * FROM Donadores";
        List<Donador> donadores = new ArrayList<>();
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Recorrer los resultados y construir la lista de donadores
            while (rs.next()) {
                Donador donador = construirDonadorDesdeResultSet(rs);
                donadores.add(donador);
            }
        } catch (SQLException e) {
            // Manejar la excepción
            e.printStackTrace();
        }
        return donadores;
    }

    // Método para construir un objeto Donador desde un ResultSet
    private Donador construirDonadorDesdeResultSet(ResultSet rs) throws SQLException {
        // Implementa la construcción del objeto Donador a partir de los resultados del ResultSet
        // Puedes usar el constructor Donador(int idDonador, String nombre, ...) para construirlo
        // No olvides manejar los tipos de datos adecuadamente (por ejemplo, BigDecimal y Date)
        // Retorna un nuevo objeto Donador construido
        return new Donador(
                rs.getInt("ID_donador"),
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getString("categoria"),
                rs.getInt("anio_graduacion"),
                rs.getDate("fecha_garantia_donativo"),
                rs.getBigDecimal("cantidad_garantizada"),
                rs.getBigDecimal("cantidad_enviada"),
                rs.getString("metodo_pago"),
                rs.getInt("num_pagos_elegidos"),
                rs.getString("num_tarjeta_credito"),
                rs.getString("nombre_corporacion_emisora"),
                rs.getString("direccion_corporacion_emisora"),
                rs.getString("nombre_conyuge")
        );
    }

}

    
}