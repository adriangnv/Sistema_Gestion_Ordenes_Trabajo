/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface IClienteDAO {
    
    public void agregar(Cliente cli) throws SQLException;
    
    public void actualizar(Cliente cli) throws SQLException;
    
    public List<Cliente> buscarTodo() throws SQLException;
    
    public Cliente buscarId(int idCli) throws SQLException;
    
}
