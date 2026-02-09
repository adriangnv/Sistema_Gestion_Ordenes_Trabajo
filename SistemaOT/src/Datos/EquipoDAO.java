/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Equipo;
import Modelo.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class EquipoDAO implements IEquipoDAO {
    
    private final Conexion conexion = new Conexion();

    @Override
    public void agregar(Equipo equi) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("INSERT INTO equipos "
                    + "(nroserie, marca, modelo, descripcion, "
                    + "idCliente, version, nroEquipo) VALUES ( ?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, equi.getNroSerie());
            pstm.setString(2, equi.getMarca());
            pstm.setString(3, equi.getModelo());
            pstm.setString(4, equi.getDescripcion());
            pstm.setInt(5, equi.getCliente().getIdCliente());
            pstm.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            pstm.setString(7, equi.getNroEquipo());
            pstm.executeUpdate();

        } 
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
    public void actualizar(Equipo equi) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("UPDATE equipos SET nroserie = ?, "
                    + "marca = ?, modelo = ?, descripcion = ?, "
                    + "idCliente = ?, version = ?, nroEquipo =? WHERE idEquipo = ? AND version = ?");
            pstm.setString(1, equi.getNroSerie());
            pstm.setString(2, equi.getMarca());
            pstm.setString(3, equi.getModelo());
            pstm.setString(4, equi.getDescripcion());
            pstm.setInt(5, equi.getCliente().getIdCliente());
            pstm.setTimestamp(6, new Timestamp((new java.util.Date()).getTime()));
            pstm.setString(7, equi.getNroEquipo());
            pstm.setInt(8, equi.getIdEquipo());
            pstm.setTimestamp(9, equi.getVersion());
            
            pstm.executeUpdate();

        } 
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
    public List<Equipo> buscarTodo() throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Equipo> resultado = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM equipos AS E, clientes AS CL, "
                    + "ciudades AS CI, provincias AS P WHERE E.idCliente = CL.idCliente "
                    + "AND CL.idCiudad = CI.idCiudad AND CI.idProvincia = P.idProvincia ORDER BY idEquipo");
            rst = pstm.executeQuery();
            resultado = new ArrayList<Equipo>();

            while (rst.next()) {
                Provincia provincia = new Provincia(rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));
                
                Ciudad ciudad = new Ciudad(rst.getInt("CI.idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version"));

                Cliente cliente = new Cliente(
                        rst.getInt("idCliente"),
                        rst.getString("dni"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
                        rst.getString("direccion"),
                        ciudad,
                        rst.getString("telefono"),
                        rst.getString("celular"),
                        rst.getString("password"),
                        rst.getString("mail"),
                        rst.getString("responsable"),
                        rst.getTimestamp("version"));

                resultado.add(new Equipo(
                        rst.getInt("idequipo"),
                        rst.getString("nroSerie"),
                        rst.getString("nroEquipo"),
                        rst.getString("marca"),
                        rst.getString("modelo"),
                        rst.getString("descripcion"),
                        cliente,
                        rst.getTimestamp("version")));
            }

        }
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
    public Equipo buscarId(int idEqui) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Equipo equipo = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM equipos AS E, clientes AS CL, "
                    + "ciudades AS CI, provincias AS P WHERE idEquipo = ? AND "
                    + "E.idCliente = CL.idCliente AND CL.idCiudad = CI.idCiudad AND "
                    + "CI.idProvincia = P.idProvincia ORDER BY idEquipo");
            pstm.setInt(1, idEqui);
            rst = pstm.executeQuery();
            
            if (rst.next()) {
                Provincia provincia = new Provincia(rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));
                
                Ciudad ciudad = new Ciudad(rst.getInt("CI.idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version"));

                Cliente cliente = new Cliente(
                        rst.getInt("idCliente"),
                        rst.getString("dni"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
                        rst.getString("direccion"),
                        ciudad,
                        rst.getString("telefono"),
                        rst.getString("celular"),
                        rst.getString("password"),
                        rst.getString("mail"),
                        rst.getString("responsable"),
                        rst.getTimestamp("version"));
                
                equipo = new Equipo(
                        rst.getInt("idequipo"),
                        rst.getString("nroSerie"),
                        rst.getString("nroEquipo"),
                        rst.getString("marca"),
                        rst.getString("modelo"),
                        rst.getString("descripcion"),
                        cliente,
                        rst.getTimestamp("version"));
            }
        }
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
        return equipo;
    }
    
     public List<Equipo> buscar(String nroEquipo, String idCliente) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Equipo> resultado = null;
        String condicion1= "";
        String condicion2= "";
        
        if (idCliente !=null){
            condicion1 = " E.idCliente ='"+idCliente+"' AND CL.idCliente='"+idCliente+"' ";
        }else{
            condicion1 =" E.idCliente = CL.idCliente  ";
        }
        
        if(nroEquipo !=null){
            condicion2 = " AND E.nroEquipo ='"+nroEquipo+"' ";
        } else {
            condicion2=""; 
               }
        
        
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM equipos AS E, clientes AS CL, "
                    + "ciudades AS CI, provincias AS P WHERE "+condicion1+condicion2+"AND CL.idCiudad = CI.idCiudad AND CI.idProvincia = P.idProvincia ORDER BY idEquipo");
            rst = pstm.executeQuery();
            resultado = new ArrayList<Equipo>();

            while (rst.next()) {
                Provincia provincia = new Provincia(rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));
                
                Ciudad ciudad = new Ciudad(rst.getInt("CI.idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version"));

                Cliente cliente = new Cliente(
                        rst.getInt("idCliente"),
                        rst.getString("dni"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
                        rst.getString("direccion"),
                        ciudad,
                        rst.getString("telefono"),
                        rst.getString("celular"),
                        rst.getString("password"),
                        rst.getString("mail"),
                        rst.getString("responsable"),
                        rst.getTimestamp("version"));

                resultado.add(new Equipo(
                        rst.getInt("idequipo"),
                        rst.getString("nroSerie"),
                        rst.getString("nroEquipo"),
                        rst.getString("marca"),
                        rst.getString("modelo"),
                        rst.getString("descripcion"),
                        cliente,
                        rst.getTimestamp("version")));
            }

        }
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
    
}
