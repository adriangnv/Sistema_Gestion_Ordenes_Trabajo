/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Adrian
 */
public class Valida {

    public boolean isCampoVacio(String cadena) {
        if (cadena.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNumero(Character caracter) {
        if (Character.isDigit(caracter)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isCaracter(Character caracter) {
        if (Character.isDigit(caracter)|| Character.isLetter(caracter)) {
            return true;
        } else {
            return false;
        }
    }
}
