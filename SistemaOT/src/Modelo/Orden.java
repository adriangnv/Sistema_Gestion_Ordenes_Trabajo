/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.sql.Date;

public class Orden {
    private int idOrden;
    private Usuario usuario;
    private Equipo equipo;
    private Date fechaRecep;
    private Date fechaLimite;
    private Date fechaTrabajo;
    private Date fechaEntrega;
    private String remito;
    private String observacion;
    private int costoTrabajo;
    private Timestamp version;
    private String estado;

    public Orden(int idOrden, Usuario usuario, Equipo equipo, Date fechaRecep,
            Date fechaLimite, Date fechaTrabajo, Date fechaEntrega,String remito,
            String observacion, int costoTrabajo, Timestamp version, String estado) {
        
        this.idOrden = idOrden;
        this.usuario = usuario;
        this.equipo = equipo;
        this.fechaRecep = fechaRecep;
        this.fechaLimite = fechaLimite;
        this.fechaTrabajo = fechaTrabajo;
        this.fechaEntrega = fechaEntrega;
        this.remito = remito;
        this.observacion = observacion;
        this.costoTrabajo = costoTrabajo;
        this.version = version;
        this.estado = estado;
       }

    

    public Orden() {
    }

    /**
     * @return the idOrden
     */
    public int getIdOrden() {
        return idOrden;
    }

    /**
     * @param idOrden the idOrden to set
     */
    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the fechaRecep
     */
    public Date getFechaRecep() {
        return fechaRecep;
    }

    /**
     * @param fechaRecep the fechaRecep to set
     */
    public void setFechaRecep(Date fechaRecep) {
        this.fechaRecep = fechaRecep;
    }

    /**
     * @return the fechaLimite
     */
    public Date getFechaLimite() {
        return fechaLimite;
    }

    /**
     * @param fechaLimite the fechaLimite to set
     */
    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * @return the fechaTrabajo
     */
    public Date getFechaTrabajo() {
        return fechaTrabajo;
    }

    /**
     * @param fechaTrabajo the fechaTrabajo to set
     */
    public void setFechaTrabajo(Date fechaTrabajo) {
        this.fechaTrabajo = fechaTrabajo;
    }

    /**
     * @return the fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * @return the remito
     */
    public String getRemito() {
        return remito;
    }

    /**
     * @param remito the remito to set
     */
    public void setRemito(String remito) {
        this.remito = remito;
    }

    /**
     * @return the observaciones
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the presupuesto
     */
    public int getCostoTrabajo() {
        return costoTrabajo;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setCostoTrabajo(int costoTrabajo) {
        this.costoTrabajo = costoTrabajo;
    }

    /**
     * @return the version
     */
    public Timestamp getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Timestamp version) {
        this.version = version;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "idOrden=" + idOrden + ", usuario=" + usuario + ", equipo=" + 
                equipo + ", fechaRecep=" + fechaRecep + ", fechaLimite=" + 
                fechaLimite + ", fechaTrabajo=" + fechaTrabajo + ", fechaEntrega=" + 
                fechaEntrega + ", remito=" + remito + ", observaciones=" + 
                observacion + ", costoTrabajo=" + costoTrabajo + ", version=" + 
                version+ ", Estado=" ;
    }

   
}
