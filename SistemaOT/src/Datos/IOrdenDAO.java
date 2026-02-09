/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Orden;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface IOrdenDAO {
    
    public void agregar(Orden ord) throws SQLException;
    
    public void actualizar(Orden ord) throws SQLException;
    
    public List<Orden> buscarTodo() throws SQLException;
    
    public Orden buscarId(int idOrd) throws SQLException;
}
