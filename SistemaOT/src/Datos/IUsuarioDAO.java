/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface IUsuarioDAO {
    
    public void agregar(Usuario usu) throws SQLException;
    
    public void actualizar (Usuario usu) throws SQLException;
    
    public List<Usuario> buscarTodo() throws SQLException;
    
    public Usuario buscarId(int idUsu) throws SQLException;
    
    public Usuario buscarUsuario(String usu) throws SQLException;
}
