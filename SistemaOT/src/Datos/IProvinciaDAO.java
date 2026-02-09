/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Provincia;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface IProvinciaDAO {
    
    public List<Provincia> buscarTodo() throws SQLException;
    
    public Provincia buscarId(int idPro) throws SQLException;
}
