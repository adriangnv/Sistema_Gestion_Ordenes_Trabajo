/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Timestamp;

public class Equipo {
    private int idEquipo;
    private String nroSerie;
    private String nroEquipo;
    private String marca;
    private String modelo;
    private String descripcion;
    private Cliente cliente;
    private Timestamp version;

    public Equipo(int idEquipo, String nroSerie, String nroEquipo, String marca, String modelo,
            String descripcion, Cliente cliente, Timestamp version) {
        this.idEquipo = idEquipo;
        this.nroSerie = nroSerie;
        this.nroEquipo = nroEquipo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.version = version;
    }

    

    public Equipo() {
    }

    /**
     * @return the idEquipo
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * @param idEquipo the idEquipo to set
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * @return the nroSerie
     */
    public String getNroSerie() {
        return nroSerie;
    }

    /**
     * @param nroSerie the nroSerie to set
     */
    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }
    
    public String getNroEquipo() {
        return nroEquipo;
    }

    public void setNroEquipo(String nroEquipo) {
        this.nroEquipo = nroEquipo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    @Override
    public String toString() {
        return nroEquipo;
                /*"idEquipo=" + idEquipo + ", nroSerie=" + nroSerie +", nroEquipo=" + nroEquipo +", marca=" +
                marca + ", modelo=" + modelo + ", descripcion=" + descripcion +
                ", fechaVenc=" + fechaVenc + ", cliente=" + cliente + 
                ", version=" + version;*/
    }
    
}
