/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://192.168.1.33/ordenesbd";
    private static final String USUARIO = "admin";
    private static final String PASS = "12345678";
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USUARIO,PASS);
    }
}