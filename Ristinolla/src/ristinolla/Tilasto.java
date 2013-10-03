
package ristinolla;

import java.util.ArrayList;
import java.util.HashMap;


public class Tilasto {

    private ArrayList<String> pelaajat;
    private HashMap<String, Integer> pisteet;

    public Tilasto() {
        pelaajat = new ArrayList<>();
        pisteet = new HashMap<>();
    }
    
    public ArrayList<String> getPelaajat(){
        return pelaajat;
    }
    
    public HashMap<String, Integer> getPisteLista(){
        return pisteet;
    }
    
    /**
     * Metodi lisää pelaajat -listaan
     * parametrina annetun nimimerkin
     * 
     * @param pelaaja pelaajan syöttämä nimimerkki
     */
    public void lisaaPelaaja(String pelaaja) {
        pelaajat.add(pelaaja);
        pisteet.put(pelaaja, 0);
    }
    
    /**
     * Metodi tyhjentää pistelistan, jonka jälkeen
     * yhdistää pistelistassa kaikki nimimerkit
     * nollaan pisteeseen.
     */
    public void nollaaTulokset() {
        pisteet.clear();
        for (String pelaaja : pelaajat) {
            pisteet.put(pelaaja, 0);
        }
    }
    
    /*
     * Metodi tyhjentää pelaajalistan
     * sekä pisteet
     */
    public void tyhjennaTilastot(){
        pelaajat.clear();
        pisteet.clear();
    }
    
    /**
     * Metodi tarkistaa sisältääkö pelaajat-
     * lista parametrina annetun nimimerkin
     * 
     * @param pelaaja pelaajan antama nimimerkki
     * 
     * @return totuusarvo true / false, onko pelaaja listalla
     */
    public boolean onkoPelaaja(String pelaaja) {
        if (pelaajat.contains(pelaaja)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Metodi lisää pisteen parametrina annetulle
     * nimimerkille
     * 
     * @param voittaja pelikenttä kutsuu metodia ja antaa kierroksen
     * voittaneen pelaajan nimimerkin parametrina
     */
    public void lisaaPiste(String voittaja) {
        if (pisteet.containsKey(voittaja)) {
            int pointsit = pisteet.get(voittaja);
            pointsit++;
            pisteet.remove(voittaja);
            pisteet.put(voittaja, pointsit);
        }
    }
    
    
}