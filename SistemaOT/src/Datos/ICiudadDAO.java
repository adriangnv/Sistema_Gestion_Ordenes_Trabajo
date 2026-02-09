/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Ciudad;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface ICiudadDAO {
    
    public void agregar(Ciudad ciu) throws SQLException;
    
    public void actualizar (Ciudad ciu) throws SQLException;
    
    public List<Ciudad> buscarTodo() throws SQLException;
    
    public Ciudad buscarId(int idCiu) throws SQLException;
    
}
