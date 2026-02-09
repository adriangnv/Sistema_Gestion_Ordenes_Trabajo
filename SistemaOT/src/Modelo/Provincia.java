/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Adrian
 */
public class Provincia {

    private int idProvincia;
    private String provincia;

    public Provincia(int idProvincia, String provincia) {
        this.idProvincia = idProvincia;
        this.provincia = provincia;
    }

    public Provincia() {
    }

    /**
     * @return the idProvincia
     */
    public int getIdProvincia() {
        return idProvincia;
    }

    /**
     * @param idProvincia the idProvincia to set
     */
    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return provincia;
    }
   
}
