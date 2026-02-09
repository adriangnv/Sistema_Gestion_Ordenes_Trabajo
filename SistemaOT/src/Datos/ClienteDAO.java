/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO implements IClienteDAO
{
    private final Conexion conexion = new Conexion();
    
    @Override
    public void agregar(Cliente cli) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("INSERT INTO clientes "
                    + "(dni, apellido, nombre, direccion, idCiudad, telefono, "
                    + "celular, password, mail, responsable, version)"
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, cli.getDni());
            pstm.setString(2, cli.getApellido());
            pstm.setString(3, cli.getNombre());
            pstm.setString(4, cli.getDireccion());
            pstm.setInt(5, cli.getCiudad().getIdCiudad());
            pstm.setString(6, cli.getTelefono());
            pstm.setString(7, cli.getCelular());
            pstm.setString(8, cli.getPassword());
            pstm.setString(9, cli.getMail());
            pstm.setString(10, cli.getResponsable());
            
            pstm.setTimestamp(11, new Timestamp((new java.util.Date()).getTime()));
            
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
    public void actualizar(Cliente cli) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("UPDATE clientes SET dni = ?, apellido = ?, "
                    + "nombre = ?, direccion = ?, idCiudad = ?, telefono = ?, "
                    + "celular = ?, password = ?, mail = ?, responsable = ?, version = ? "
                    + "WHERE idCliente = ? AND version = ?");
            pstm.setString(1, cli.getDni());
            pstm.setString(2, cli.getApellido());
            pstm.setString(3, cli.getNombre());
            pstm.setString(4, cli.getDireccion());
            pstm.setInt(5, cli.getCiudad().getIdCiudad());
            pstm.setString(6, cli.getTelefono());
            pstm.setString(7, cli.getCelular());
            pstm.setString(8, cli.getPassword());
            pstm.setString(9, cli.getMail());
            pstm.setString(10, cli.getResponsable());
            pstm.setTimestamp(11, new Timestamp((new java.util.Date()).getTime()));
            pstm.setInt(12, cli.getIdCliente());
            pstm.setTimestamp(13, cli.getVersion());
            
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
    public List<Cliente> buscarTodo() throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> resultado = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM clientes AS CL, ciudades "
                    + "AS CI, provincias AS P WHERE CL.idCiudad = CI.idCiudad "
                    + "AND CI.idProvincia = P.idProvincia");
            rst = pstm.executeQuery();
            resultado = new ArrayList<Cliente>();

            while (rst.next()) {
                Provincia provincia = new Provincia(rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));
                
                Ciudad ciudad = new Ciudad(
                        rst.getInt("CI.idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version"));

                resultado.add(new Cliente(
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
    public Cliente buscarId(int idCli)  throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Cliente cliente = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM clientes AS CL, ciudades "
                    + "AS CI, provincias AS P WHERE CL.idCliente = ? "
                    + "AND CL.idCiudad = CI.idCiudad "
                    + "AND CI.idProvincia = P.idProvincia");
            pstm.setInt(1, idCli);
            
            rst = pstm.executeQuery();
            
            if (rst.next()) {
                Provincia provincia = new Provincia(rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));
                
                Ciudad ciudad = new Ciudad(rst.getInt("CI.idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version"));

                cliente = new Cliente(
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
        return cliente;
    }
    
    
    public List<Cliente> buscar(String idCliente, String idCiudad, String idProvincia) throws SQLException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> resultado = null;
        String condicion1= "";
        String condicion2= "";
        String condicion3= "";
        
        if (idCliente !=null){
            condicion1 = " CL.idCliente='"+idCliente+"' AND " ;
        }else{
            condicion1 ="";
        }
        
        if(idCiudad !=null){
            condicion2 = " CL.idCiudad='"+idCiudad+"' AND CI.idCiudad='"+idCiudad+"' AND ";
        } else {
            condicion2=" CL.idCiudad = CI.idCiudad AND "; 
               }
        if (idProvincia !=null){
            condicion3=" CI.idProvincia='"+idProvincia+"' AND P.idProvincia='"+idProvincia+"'";
        }else{
            condicion3=" CI.idProvincia = P.idProvincia";
        }
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM clientes AS CL, ciudades "
                    + "AS CI, provincias AS P WHERE "+condicion1+condicion2+condicion3+" ORDER BY idCliente");
            
            rst = pstm.executeQuery();
            resultado = new ArrayList<Cliente>();

            while (rst.next()) {
                Provincia provincia = new Provincia(rst.getInt("P.idProvincia"),
                        rst.getString("provincia"));
                
                Ciudad ciudad = new Ciudad(
                        rst.getInt("CI.idCiudad"),
                        rst.getInt("cp"),
                        rst.getString("ciudad"),
                        provincia,
                        rst.getTimestamp("version"));

                resultado.add(new Cliente(
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
    
}


