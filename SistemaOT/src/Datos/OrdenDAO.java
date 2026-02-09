/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Equipo;
import Modelo.Orden;
import Modelo.Provincia;
import Modelo.Usuario;
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
public class OrdenDAO implements IOrdenDAO {

    private final Conexion conexion = new Conexion();
    
    @Override
    public void agregar(Orden ord) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("INSERT INTO ordenes "
                    + "(idUsuario, idEquipo, fechaRecep, fechaLimite, fechaTrabajo, "
                    + "fechaEntrega, remito, observacion, costoTrabajo, version, estado) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstm.setInt(1, ord.getUsuario().getIdUsuario());
            pstm.setInt(2, ord.getEquipo().getIdEquipo());
            pstm.setDate(3, ord.getFechaRecep());
            pstm.setDate(4, ord.getFechaLimite());
            pstm.setDate(5, ord.getFechaTrabajo());
            pstm.setDate(6, ord.getFechaEntrega());
            pstm.setString(7, ord.getRemito());
            pstm.setString(8, ord.getObservacion());
            pstm.setInt(9, ord.getCostoTrabajo());
            pstm.setTimestamp(10, new Timestamp((new java.util.Date()).getTime()));
            pstm.setString(11, ord.getEstado());
            
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
    public void actualizar(Orden ord) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("UPDATE ordenes SET idUsuario = ?, "
                    + "idEquipo = ?, fechaRecep = ?, fechaLimite = ?, fechaTrabajo = ?, "
                    + "fechaEntrega = ?, remito = ?, observacion = ?, costoTrabajo = ?, "
                    + "version = ?, estado = ? WHERE  idOrden = ? AND version = ?");
            pstm.setInt(1, ord.getUsuario().getIdUsuario());
            pstm.setInt(2, ord.getEquipo().getIdEquipo());
            pstm.setDate(3, ord.getFechaRecep());
            pstm.setDate(4, ord.getFechaLimite());
            pstm.setDate(5, ord.getFechaTrabajo());
            pstm.setDate(6, ord.getFechaEntrega());
            pstm.setString(7, ord.getRemito());
            pstm.setString(8, ord.getObservacion());
            pstm.setInt(9, ord.getCostoTrabajo());
            pstm.setTimestamp(10, new Timestamp((new java.util.Date()).getTime()));
            pstm.setString(11, ord.getEstado());
            pstm.setInt(12, ord.getIdOrden());
            pstm.setTimestamp(13, ord.getVersion());
            
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
    public List<Orden> buscarTodo() throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Orden> resultado = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM ordenes AS O, equipos AS E, "
                    + "clientes AS CL, ciudades AS CI, provincias AS P, usuarios AS U "
                    + "WHERE O.idEquipo = E.idEquipo AND E.idCliente = CL.idCliente "
                    + "AND CL.idCiudad = CI.idCiudad AND CI.idProvincia = P.idProvincia "
                    + " AND O.idUsuario = U.idUsuario ORDER BY idOrden");
            rst = pstm.executeQuery();
            resultado = new ArrayList<Orden>();

            while (rst.next()) {
                
                Usuario usuario = new Usuario(
                        rst.getInt("idUsuario"),
                        rst.getString("usuario"),
                        rst.getString("password"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
                        rst.getTimestamp("version"));
                
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
                
                Equipo equipo = new Equipo(
                        rst.getInt("idequipo"),
                        rst.getString("nroSerie"),
                        rst.getString("nroEquipo"),
                        rst.getString("marca"),
                        rst.getString("modelo"),
                        rst.getString("descripcion"),
                        cliente,
                        rst.getTimestamp("version"));
                
                                    

                resultado.add(new Orden(
                        rst.getInt("idOrden"),
                        usuario,
                        equipo,
                        rst.getDate("fechaRecep"),
                        rst.getDate("fechaLimite"),
                        rst.getDate("fechaTrabajo"),
                        rst.getDate("fechaEntrega"),
                        rst.getString("remito"),
                        rst.getString("observacion"),
                        rst.getInt("costoTrabajo"),
                        rst.getTimestamp("version"),
                        rst.getString("estado")));
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
    public Orden buscarId(int idOrd) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Orden orden = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM ordenes AS O, equipos AS E, "
                    + "clientes AS CL, ciudades AS CI, provincias AS P "
                    + "WHERE O.idOrden = ? AND O.idEquipo = E.idEquipo AND "
                    + "E.idCliente = CL.idCliente AND CL.idCiudad = CI.idCiudad AND "
                    + "CI.idProvincia = P.idProvincia ");
            pstm.setInt(1, idOrd);
            rst = pstm.executeQuery();

            if (rst.next()) {
                
                Usuario usuario = new Usuario(
                        rst.getInt("idUsuario"),
                        rst.getString("usuario"),
                        rst.getString("password"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
                        rst.getTimestamp("version"));
                
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
                
                Equipo equipo = new Equipo(
                        rst.getInt("idequipo"),
                        rst.getString("nroSerie"),
                        rst.getString("nroEquipo"),
                        rst.getString("marca"),
                        rst.getString("modelo"),
                        rst.getString("descripcion"),
                        cliente,
                        rst.getTimestamp("version"));
                
           

                orden = new Orden(
                        rst.getInt("idOrden"),
                        usuario,
                        equipo,
                        rst.getDate("fechaRecep"),
                        rst.getDate("fechaLimite"),
                        rst.getDate("fechaTrabajo"),
                        rst.getDate("fechaEntrega"),
                        rst.getString("remito"),
                        rst.getString("observacion"),
                        rst.getInt("costoTrabajo"),
                        rst.getTimestamp("version"),
                        rst.getString("estado"));
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
        return orden;
    }
    
    
       public List<Orden> buscar(String ot, String cliente1, String equipo1, String estado, String fr1, String fr2, String fc1, String fc2, String fe1, String fe2) throws SQLException { 
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Orden> resultado = null;
        String condicion1= "";
        String condicion2= "";
        String condicion3= "";
        String condicion4="";
        String condicion5="";
        String condicion6="";
        String condicion7="";
        String condicion8="";
        String condicion9="";
        String condicion10="";
        
        //condicion para determnar OT...  
        if (ot!=null){
        condicion1 = "O.idOrden ='"+ot+"'AND ";
        }else{
        condicion1="";    
        }
        // condicion para determinar equipos... 
        
        if(equipo1 != null){
            condicion2= " O.idEquipo = '" +equipo1+ "' AND E.idEquipo = '"+equipo1+"' AND ";
        }else{
            condicion2= " O.idEquipo = E.idEquipo AND "; 
             }
        // condicion para determinar cliente... 
        
        if(cliente1!= null){
            condicion3=" E.idCliente = '" + cliente1+ "' AND CL.idCliente='"+cliente1+ "' AND ";
       }else{
            condicion3=" E.idCliente = CL.idCliente AND ";
            }
       
         if (estado!=null){
             condicion4=" O.estado = '"+estado+"'AND ";
         }else{
             condicion4="";            
         } 
          
       //condicion para fecha de recepcion...
         
         if (fr1 != null){
          condicion5 = " AND O.fechaRecep >= '" + fr1+ "'";
         }else{
          condicion5="";   
         }
         if(fr2 != null){
         condicion6=" AND O.fechaRecep <= '" + fr2+ "'";
         }else{
         condicion6="";    
         }
         //condicion para fecha de trabajo...
         if (fc1 != null){
          condicion7 = " AND O.fechaTrabajo >= '" + fc1+ "'";
         }else{
          condicion7="";   
         }
         if(fc2 != null){
         condicion8=" AND O.fechaTrabajo <= '" + fc2+ "'";
         }else{
         condicion8="";    
         }
         //condicion para fecha de concluido...
         if (fe1 != null){
          condicion9 = " AND O.fechaEntrega >= '" + fe1+ "'";
         }else{
          condicion9="";   
         }
         if(fe2 != null){
         condicion10=" AND O.fechaEntrega <= '" + fe2+ "'";
         }else{
         condicion10="";    
         }

        System.out.println("SELECT * FROM ordenes AS O, equipos AS E, "
                    + "clientes AS CL, ciudades AS CI, provincias AS P, usuarios AS U "
                    + "WHERE "+condicion1+condicion2+condicion3+"CL.idCiudad = CI.idCiudad AND "
                    + "CI.idProvincia = P.idProvincia AND"+condicion4+" O.idUsuario = U.idUsuario "
                    + condicion5+condicion6+condicion7+condicion8+condicion9+condicion10+" ORDER BY idOrden");
        try {
            con = conexion.getConnection();
          
            pstm = con.prepareStatement("SELECT * FROM ordenes AS O, equipos AS E, "
                    + "clientes AS CL, ciudades AS CI, provincias AS P, usuarios AS U "
                    + "WHERE "+condicion1+condicion2+condicion3+"CL.idCiudad = CI.idCiudad AND "
                    + "CI.idProvincia = P.idProvincia AND"+condicion4+" O.idUsuario = U.idUsuario "
                    + condicion5+condicion6+condicion7+condicion8+condicion9+condicion10+" ORDER BY idOrden");
          
            rst = pstm.executeQuery();
            resultado = new ArrayList<Orden>();

            while (rst.next()) {
                
                Usuario usuario = new Usuario(
                        rst.getInt("idUsuario"),
                        rst.getString("usuario"),
                        rst.getString("password"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
                        rst.getTimestamp("version"));
                
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
                
                Equipo equipo = new Equipo(
                        rst.getInt("idequipo"),
                        rst.getString("nroSerie"),
                        rst.getString("nroEquipo"),
                        rst.getString("marca"),
                        rst.getString("modelo"),
                        rst.getString("descripcion"),
                        cliente,
                        rst.getTimestamp("version"));
                
               
   

                resultado.add(new Orden(
                        rst.getInt("idOrden"),
                        usuario,
                        equipo,
                        rst.getDate("fechaRecep"),
                        rst.getDate("fechaLimite"),
                        rst.getDate("fechaTrabajo"),
                        rst.getDate("fechaEntrega"),
                        rst.getString("remito"),
                        rst.getString("observacion"),
                        rst.getInt("costoTrabajo"),
                        rst.getTimestamp("version"),
                        rst.getString("estado")));
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
