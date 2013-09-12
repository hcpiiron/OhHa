/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.io.Serializable;

/**
 *
 * @author hcpiiron
 */
public class Pelaaja implements Serializable{
    String nimi;
    int pisteet;
    
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
    }
    
    
    
    public void lisaaPiste(){
        this.pisteet++;
    }
    
    public void nollaaTulokset(){
        this.pisteet=0;
    }
    
    public int getPisteet(){
        return pisteet;
    }

    public String getNimi() {
        return nimi;
    }
    
    
}
    
    
    
    
    
    
    