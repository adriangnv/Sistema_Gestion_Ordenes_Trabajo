/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

public class Cliente {
    private int idCliente;
    private String dni;
    private String apellido;
    private String nombre;
    private String direccion;
    private Ciudad ciudad;
    private String telefono;
    private String celular;
    private String password;
    private String mail;
    private String responsable;
    private Timestamp version;

    public Cliente(int idCliente, String dni, String apellido, String nombre,
            String direccion, Ciudad ciudad, String telefono, String celular,
            String password, String mail, String responsable, Timestamp version) {
        
        this.idCliente = idCliente;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.celular = celular;
        this.password = password;
        this.mail = mail;
        this.responsable = responsable;
        this.version = version;
    }

    public Cliente() {
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
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

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
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
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
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
        return nombre;
                /*"idCliente=" + idCliente + ", dni=" + dni + ", apellido=" + 
                apellido + ", nombre=" + nombre + ", direccion=" + direccion + 
                ", ciudad=" + ciudad + ", telefono=" + telefono + ", password=" + 
                password + ", mail=" + mail + ", responsable=" + responsable + 
                ", version=" + version;*/
                
    }

}
