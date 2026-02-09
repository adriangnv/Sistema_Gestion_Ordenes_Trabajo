/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Equipo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface IEquipoDAO {
    
    public void agregar(Equipo equi) throws SQLException;
    
    public void actualizar(Equipo equi) throws SQLException;
    
    public List<Equipo> buscarTodo() throws SQLException;
    
    public Equipo buscarId(int idEqui) throws SQLException;
    
}
