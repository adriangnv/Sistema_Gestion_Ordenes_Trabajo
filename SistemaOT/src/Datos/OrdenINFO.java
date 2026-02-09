/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

/**
 *
 * @author Gisela
 */
public class OrdenINFO {
    private final Conexion conexion = new Conexion();
    JRViewer jrv;
    public void startReport(String idOrden, String idEquipo, String idCliente, String estado, String fr1, String fr2, String fc1, String fc2, String fe1, String fe2){
           Connection con = null;
           
        try{
            
            con = conexion.getConnection();
            javax.swing.JOptionPane.showMessageDialog(null,"Conexion establecida");
            
            String template="C:\\Users\\Marcos\\Documents\\NetBeansProjects\\SistemaOT\\src\\Informes\\infoOrden.jasper";
                    //"C:\\Documents and Settings\\Gisela\\Mis documentos\\NetBeansProjects\\MiAplicacion\\src\\Informes\\infoOrden.jasper";
            JasperReport reporte=null;
            reporte=(JasperReport) JRLoader.loadObjectFromFile(template);

            Map param=new HashMap();
            param.put("idOrden", idOrden);
            param.put("idEquipo", idEquipo);
            param.put("idCliente", idCliente);
            param.put("estado", estado);
            param.put("fr1", fr1);
            param.put("fr2", fr2);
            param.put("fc1", fc1);
            param.put("fc2", fc2);
            param.put("fe1", fe1);
            param.put("fe2", fe2);
            
            JasperPrint jasperprint= JasperFillManager.fillReport(reporte,param,con);
            jrv = new JRViewer(jasperprint); 
            
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);

        }
        
    }
    public JRViewer verVisor(){
        
        return jrv;
    }
    
    }



    

