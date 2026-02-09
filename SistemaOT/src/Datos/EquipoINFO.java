/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

//import java.awt.Dialog.ModalExclusionType;
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
public class EquipoINFO {
    private final Conexion conexion = new Conexion();
    //JasperViewer visor;
    JRViewer jrv;
    public void startReport(String idCliente, String nroEquipo){
           Connection con = null;
           
        try{
            
            con = conexion.getConnection();
            javax.swing.JOptionPane.showMessageDialog(null,"Conexion establecida");
            
            String template="C:\\Users\\Marcos\\Documents\\NetBeansProjects\\SistemaOT\\src\\Informes\\infoEquipo.jasper";
                   // "C:\\Documents and Settings\\Gisela\\Mis documentos\\NetBeansProjects\\MiAplicacion\\src\\Informes\\infoEquipo.jasper";
            JasperReport reporte=null;
            reporte=(JasperReport) JRLoader.loadObjectFromFile(template);

            Map param=new HashMap();
           
            param.put("idCliente", idCliente);
            param.put("nroEquipo", nroEquipo); 
           
            

            JasperPrint jasperprint= JasperFillManager.fillReport(reporte,param,con);
            //JasperExportManager.exportReportToPdfFile(jasperprint, "C:\\Documents and Settings\\Gisela\\Escritorio\\infoOreden.pdf");
             //Para visualizar el pdf directamente desde java
            //JasperViewer.viewReport(jasperprint, false);
            jrv = new JRViewer(jasperprint); 
              //visor=new JasperViewer(jasperprint,false);
              //visor.setTitle("Informes de Ordenes de Trabajo:");
              //visor.setVisible(true);
             
              


        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);

        }
        
    }
    public JRViewer verVisor(){
        
        return jrv;
    }
    
    }



    

