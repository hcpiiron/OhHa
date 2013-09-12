/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author hcpiiron
 */
public class Tilasto implements Serializable{
    private ArrayList<Pelaaja>lista;
    
    public Tilasto(){
        lista = new ArrayList<>();
    }
    
    public void lisaaPelaaja(Pelaaja pelaaja){
        lista.add(pelaaja);
    }

    public ArrayList<Pelaaja> getLista() {
        return lista;
    }
    
    public void poistaPelaaja(String pelaaja){
        for (Iterator<Pelaaja> it = lista.iterator(); it.hasNext();) {
            Pelaaja pelaaja1 = it.next();
            if (pelaaja1.getNimi().equals(pelaaja)) {
                it.remove();
                return;
            }
        }
    }
    
    
    
}
