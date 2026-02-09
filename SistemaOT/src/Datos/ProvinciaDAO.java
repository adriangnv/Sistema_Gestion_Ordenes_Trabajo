/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaDAO implements IProvinciaDAO {

    private final Conexion conexion = new Conexion();

    @Override
    public List<Provincia> buscarTodo() throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Provincia> resultado = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM Provincias ");
            rst = pstm.executeQuery();
            resultado = new ArrayList<Provincia>();

            while (rst.next()) {
                resultado.add(new Provincia(
                        rst.getInt("idProvincia"),
                        rst.getString("provincia")));
            }

        } //catch (SQLException e) {System.out.println(e);}
        finally {
            if (rst != null) {
                try {
                    rst.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
        return resultado;

    }

    @Override
    public Provincia buscarId(int idPro) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Provincia provincia = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM Provincias "
                    + "WHERE idProvincia = ?");
            pstm.setInt(1, idPro);
            rst = pstm.executeQuery();

            if (rst.next()) {
                provincia = new Provincia(
                        rst.getInt("idProvincia"),
                        rst.getString("provincia"));
            }

        } //catch (SQLException e) {System.out.println(e);}
        finally {
            if (rst != null) {
                try {
                    rst.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
        return provincia;

    }
}
