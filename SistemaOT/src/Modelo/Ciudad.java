/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author Adrian
 */
public class Ciudad
{
    private int idCiudad;
    private int cp;
    private String ciudad;
    private Provincia provincia;
    private Timestamp version;
    
    public Ciudad (int idCiudad, int cp, String ciudad, Provincia provincia,
            Timestamp version) {
        this.idCiudad = idCiudad;
        this.cp = cp;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.version = version;
    }
    
    public Ciudad(){
    }

    /**
     * @return the idCiudad
     */
    public int getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the cp
     */
    public int getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the provincia
     */
    public Provincia getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
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
        return ciudad;
                //"idCiudad=" + idCiudad + ", cp=" + cp + ", ciudad=" + ciudad + 
               // ", provincia=" + provincia + ", version=" + version;
    }
}
