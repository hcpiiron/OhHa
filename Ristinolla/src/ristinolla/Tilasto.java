package ristinolla;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Tilasto implements Serializable {

    private ArrayList<String> pelaajat;
    private HashMap<String, Integer> pisteet;

    public Tilasto() {
        pelaajat = new ArrayList<>();
        pisteet = new HashMap<>();

    }

    public static Tilasto lueTiedostosta(String polku) throws IOException, ClassNotFoundException {
        FileInputStream f_in;
        f_in = new FileInputStream(polku);
        ObjectInputStream obj_in =
                new ObjectInputStream(f_in);
        return (Tilasto) obj_in.readObject();
    }

    public void tallennaTiedostoon(String polku) throws IOException {
        FileOutputStream f_out;
        try {
            f_out = new FileOutputStream(polku);
        } catch (FileNotFoundException e) {
            File file = new File(polku);
            file.createNewFile();
            f_out = new FileOutputStream(polku);
        }
        ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
        obj_out.writeObject(this);
    }

    public ArrayList<String> getPelaajat() {
        return pelaajat;
    }

    public HashMap<String, Integer> getPisteLista() {
        return pisteet;
    }

    /**
     * Metodi lisää pelaajat -listaan parametrina annetun nimimerkin
     *
     * @param pelaaja pelaajan syöttämä nimimerkki
     */
    public void lisaaPelaaja(String pelaaja) {
        pelaajat.add(pelaaja);
        pisteet.put(pelaaja, 0);
    }

    /**
     * Metodi tyhjentää pistelistan, jonka jälkeen yhdistää pistelistassa kaikki
     * nimimerkit nollaan pisteeseen.
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
    public void tyhjennaTilastot() {
        pelaajat.clear();
        pisteet.clear();
    }

    /**
     * Metodi tarkistaa sisältääkö pelaajat- lista parametrina annetun
     * nimimerkin
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
     * Metodi lisää pisteen parametrina annetulle nimimerkille
     *
     * @param voittaja pelikenttä kutsuu metodia ja antaa kierroksen voittaneen
     * pelaajan nimimerkin parametrina
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