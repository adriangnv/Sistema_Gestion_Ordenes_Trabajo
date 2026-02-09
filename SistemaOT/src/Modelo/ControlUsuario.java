/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ControlUsuario {
    boolean valido;
    public boolean login (Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        try {
            valido = usuarioDao.Validar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valido;
    }
    
    public boolean existe (Usuario usuario) {
        return true;
    }
}
