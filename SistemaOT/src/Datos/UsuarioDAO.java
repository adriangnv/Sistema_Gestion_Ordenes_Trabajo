/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

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
public class UsuarioDAO implements IUsuarioDAO {
    
    private final Conexion conexion = new Conexion();

    @Override
    public void agregar(Usuario usu) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("INSERT INTO usuarios (usuario, password, "
                    + "apellido, nombre, version)"
                    + "VALUES ( ?, ?, ?, ?, ?)");
            pstm.setString(1, usu.getUsuario());
            pstm.setString(2, usu.getPassword());
            pstm.setString(3, usu.getApellido());
            pstm.setString(4, usu.getNombre());
            pstm.setTimestamp(5, new Timestamp((new java.util.Date()).getTime()));
            
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
    public void actualizar(Usuario usu) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("UPDATE usuarios SET usuario = ?, "
                    + "password = ?, apellido = ?, nombre = ?, version = ? "
                    + "WHERE idUsuario = ? AND version = ?");
            pstm.setString(1, usu.getUsuario());
            pstm.setString(2, usu.getPassword());
            pstm.setString(3, usu.getApellido());
            pstm.setString(4, usu.getNombre());
            pstm.setTimestamp(5, new Timestamp((new java.util.Date()).getTime()));
            pstm.setInt(6, usu.getIdUsuario());
            pstm.setTimestamp(7, usu.getVersion());
            
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
    public List<Usuario> buscarTodo() throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Usuario> resultado = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM usuarios");
            rst = pstm.executeQuery();
            resultado = new ArrayList<Usuario>();

            while (rst.next()) {
                
                resultado.add(new Usuario(
                        rst.getInt("idUsuario"),
                        rst.getString("usuario"),
                        rst.getString("password"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
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
    public Usuario buscarId(int idUsu) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Usuario usuario = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM usuarios WHERE idUsuario = ?");
            pstm.setInt(1, idUsu);
            rst = pstm.executeQuery();

            if (rst.next()) {
                
                usuario = new Usuario(
                        rst.getInt("idUsuario"),
                        rst.getString("usuario"),
                        rst.getString("password"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
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
        return usuario;
    }

    @Override
    public Usuario buscarUsuario(String usu) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Usuario usuario = null;
        try {
            con = conexion.getConnection();
            pstm = con.prepareStatement("SELECT * FROM usuarios WHERE usuario ='"+usu+"'");
           // pstm.setString(1, usu);
            
            rst = pstm.executeQuery();

            if (rst.next()) {
                
                usuario = new Usuario(
                        rst.getInt("idUsuario"),
                        rst.getString("usuario"),
                        rst.getString("password"),
                        rst.getString("apellido"),
                        rst.getString("nombre"),
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
        return usuario;
    }
    
     public boolean Validar(Usuario usuario) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        boolean usValido = false;
        
        try {
            con = conexion.getConnection();
           // rst.first();  
            String usuario1 = usuario.getUsuario();
            String contraseña = usuario.getPassword();
            System.out.println(contraseña);
           pstm = con.prepareStatement("SELECT usuario, password FROM usuarios WHERE usuario =? "
                   + "AND password=? " ); 
           pstm.setString(1,usuario1);
           pstm.setString(2,contraseña);
           rst = pstm.executeQuery();
           
           int x=0;
            
           while (rst.next())
           {
            x++;
            usValido =true;
            
           }
            if (x==0)
            {
            usValido = false;    
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
        return usValido;
    }
    
    
}
