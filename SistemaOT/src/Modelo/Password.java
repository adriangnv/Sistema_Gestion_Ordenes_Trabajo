/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;


public class Password {
private Random pass;
    public Password() {
        pass = new Random();
    }
    
    public String generar(){
      
        return  "" + pass.nextInt(100000);
    }
    
}
