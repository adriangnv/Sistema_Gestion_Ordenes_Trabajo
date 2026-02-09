/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Ciudad;
import Modelo.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO implements ICiudadDAO
{
    private final Conexion conexion = new Conexion();

    @Override
    public void agregar(Ciudad ciu) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("INSERT INTO ciudades "
                    + "(cp, ciudad, idProvincia, version)"
                    + "VALUES ( ?, ?, ?, ?)");
            pstm.setInt(1, ciu.getCp());
            pstm.setString(2, ciu.getCiudad());
            pstm.setInt(3, ciu.getProvincia().getIdProvincia());
            pstm.setTimestamp(4, new Timestamp((new java.util.Date()).getTime()));
            
            pstm.executeUpdate();

        } //catch (SQLException e){System.out.println(e);
        //System.err.println(e.getMessage());}
        finally {
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
    }
    
    @Override
    public void actualizar (Ciudad ciu) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("UPDATE ciudades SET cp = ?, ciudad = ?,"
                    + "IdProvincia = ?, version = ? WHERE idCiudad = ? AND version = ?");
            pstm.setInt(1, ciu.getCp());
            pstm.setString(2, ciu.getCiudad());
            pstm.setInt(3, ciu.getProvincia().getIdProvincia());
            pstm.setTimestamp(4, new Timestamp((new java.util.Date()).getTime()));
            pstm.setInt(5, ciu.getIdCiudad());
            pstm.setTimestamp(6, ciu.getVersion());
            pstm.executeUpdate();

        } //catch (SQLException e){System.out.println(e);
        //System.err.println(e.getMessage());}
        finally {
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
    }
   

    @Override
    public List<Ciudad> buscarTodo() throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Ciudad> resultado = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM ciudades AS C, provincias "
                    + "AS P WHERE C.idProvincia = P.idProvincia");
            rst = pstm.executeQuery();
            resultado = new ArrayList<Ciudad>();

            while (rst.next()) {
                Provincia provincia = new Provincia(
                        rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));

                resultado.add(new Ciudad(
                        rst.getInt("idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version")));
            }

        } //catch (SQLException e){System.out.println(e);}
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
    public Ciudad buscarId(int idCiu) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Ciudad ciudad = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM ciudades AS C, provincias "
                    + "AS P WHERE idCiudad = ? AND  C.idProvincia = P.idProvincia");
            pstm.setInt(1, idCiu);
            rst = pstm.executeQuery();
            if (rst.next()) {
                Provincia provincia = new Provincia(rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));

                ciudad = new Ciudad(rst.getInt("idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version"));
            }
        } //catch (SQLException e){System.out.println(e);}
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
        return ciudad;

    }
}
