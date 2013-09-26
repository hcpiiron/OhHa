/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hcpiiron
 */
public class Lauta {

    private int[][] lauta;
    private List<Pelaaja> pelaajat;
    private int voittosuora = 3;

    public Lauta() {

        this.lauta = new int[10][10];
        this.pelaajat = new ArrayList<Pelaaja>();

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[i].length; j++) {
                lauta[i][j] = 0;
            }
        } // Voittoja etsiessä "tyhjät ruudut" ovat nollia
    }

    public void muutaVoittosuoraa(int pituus) {
        this.voittosuora = pituus;
    }

    public void lisaaPelaaja(Pelaaja pelaaja) {
        pelaajat.add(pelaaja);
    }

    public List<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    public void asetaMerkki(int merkki, int x, int y) {
        lauta[x][y] = merkki;
    }

    public void asetaMerkki(String koordinaatti, int kumpi) {
        int x;
        int y;
        if (koordinaatti.startsWith("0")) {
            x = 0;
            y = Integer.parseInt(koordinaatti);
        } else {
            String xx = "" + koordinaatti.charAt(0);
            String yy = "" + koordinaatti.charAt(1);
            x = Integer.parseInt(xx);
            y = Integer.parseInt(yy);
        }
        asetaMerkki(kumpi, x, y);
    }

    public int testaaVoittoVaaka() { // ketällä X merkataan 1, 0 merkataan 2, ja tyhjä ruutu 0. Palauttaa voittajan symbolin 
        int counter = 0;
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[i].length; j++) {
                if (lauta[i][j] != 0) {
                    if (j + voittosuora <= lauta[i].length) {
                        int etsittava = lauta[i][j];
                        counter++;
                        for (int k = j + 1; k < j + voittosuora; k++) {
                            if (lauta[i][k] == etsittava) {
                                counter++;
                            }
                        }
                        if (counter == voittosuora) {
                            return etsittava;
                        } else {
                            counter = 0;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int testaaVoittoPysty() {
        int counter = 0;
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[i].length; j++) {
                if (lauta[i][j] != 0) {
                    if (i + voittosuora <= lauta.length) {
                        int etsittava = lauta[i][j];
                        counter++;
                        for (int k = i + 1; k < i + voittosuora; k++) {
                            if (lauta[k][j] == etsittava) {
                                counter++;
                            }
                        }
                        if (counter == voittosuora) {
                            return etsittava;
                        } else {
                            counter = 0;
                        }
                    }
                }
            }
        }
        return 0;

    }

    public void testaaVoittoVino() {
    }
}