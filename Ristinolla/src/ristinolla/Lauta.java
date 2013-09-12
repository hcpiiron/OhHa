/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hcpiiron
 */
public class Lauta {
    
    private Map<Ruutu, Pelaaja> lauta;
    private int koko;
    private List<Pelaaja> pelaajat;
    
    
    public Lauta(int koko){
        this.koko=koko;
        this.lauta= new HashMap<>();
        this.pelaajat= new ArrayList<>();
    }
    
    public void lisaaPelaaja(Pelaaja pelaaja){
        pelaajat.add(pelaaja);
    }

    public List<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    
    
    
    
    
}
