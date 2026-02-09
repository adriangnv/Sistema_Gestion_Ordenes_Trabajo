/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import javax.swing.table.DefaultTableModel;
 
public class ModeloTabla extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        
        return false;
    }
}