/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

public class Usuario {
    private int idUsuario;
    private String usuario;
    private String password;
    private String apellido;
    private String nombre;
    private Timestamp version;
    
    public Usuario() {
    }
    
    public Usuario(int idUsuario, String usuario, String password, String apellido,
            String nombre, Timestamp version) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.apellido = apellido;
        this.nombre = nombre;
        this.version = version;
    }
    

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" +
                password + ", apellido=" + apellido + ", nombre=" + nombre +
                ", version=" + version;
    }
    
}
