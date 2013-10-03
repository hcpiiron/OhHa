
package ristinolla;


public class Lauta {

    private int[][] lauta;
    private int voittosuora = 3;
    private String pelaajaX;
    private String pelaajaO;
    

    public Lauta() {
        this.lauta = new int[10][10];
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[i].length; j++) {
                lauta[i][j] = 0;
            }
        } // Voittoja etsiessä "tyhjät ruudut" ovat nollia
    }
    
    /**
     * Metodi muuttaa pelin voittamiseen tarvittavan 
     * voittosuoran pituutta
     * 
     * @param pituus pelaaja antaa asetuksissa halutun
     * voittosuoran pituuden, ja se annetaan metodille
     * parametrina
     */
    public void muutaVoittosuoraa(int pituus) {
        if (pituus == 2 || pituus == 3 || pituus == 4 || pituus == 5 || pituus == 6 || pituus == 7 || pituus == 8 || pituus == 9) {
            this.voittosuora = pituus;
        }
    }
    
    /**
     * Metodi tallentaa laudalle nimimerkit
     * pelaajista.
     * 
     * @param pelaaja1 ristiä pelaavan pelaajan nimimerkki
     * @param pelaaja2 nollaa pelaavan pelaajan nimimerkki
     */
    public void uudetPelaajat(String pelaaja1, String pelaaja2){
        pelaajaX = pelaaja1;
        pelaajaO = pelaaja2;
    }
    
    public void asetaMerkki(int merkki, int x, int y) {
        lauta[x][y] = merkki;
    }
    
    /**
     * Metodi palauttaa voittajan nimimerkin
     * 
     * @param kumpi kuvaa merkkiä jota pelaava pelaaja
     * voitti
     * @return palauttaa halutun nimimerkin
     */
    public String getVoittaja(int kumpi){
        if (kumpi == 1) {
            return pelaajaX;
        } else{
            return pelaajaO;
        }
    }
    
    /**
     * Metodi muokkaa String -muodossa annetun koordinaatin
     * asetaMerkki() -metodin haluamaan muotoon int x, int y
     * 
     * @param koordinaatti String -muodossa oleva luku, joka kuvaa
     * laudan koordinaattia
     * @param kumpi luku joka kuvaa ristiä tai nolla
     */
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
    
    /**
     * Metodi tarkistaa pelilaudalta löytyykö
     * halutun pituisia voittosuoria vaakatasossa
     * 
     * @return luku joka kuvaa joko ristin voittoa(1),
     * nollan voittoa(2) tai kertoo ettei voittosuoraa
     * löydy(0)
     */
    public int testaaVoittoVaaka() {
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
    
    /**
     * Metodi tarkistaa pelilaudalta löytyykö
     * halutun pituisia voittosuoria pystysuunnassa
     * 
     * @return luku joka kuvaa joko ristin voittoa(1),
     * nollan voittoa(2) tai kertoo ettei voittosuoraa
     * löydy(0)
     */
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
    
    /**
     * Metodi tarkistaa pelilaudalta löytyykö
     * halutun pituisia voittosuoria vinottain
     * 
     * @return luku joka kuvaa joko ristin voittoa(1),
     * nollan voittoa(2) tai kertoo ettei voittosuoraa
     * löydy(0)
     */
    public void testaaVoittoVino() {
        //WORK ON PROGRESS
    }
    
    /**
     * Metodi tyhjentää laudan, eli merkkaa
     * kaikki kentät kokonaislukutaulukossa
     * nollaksi.
     */
    void tyhjenna() {
         for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[i].length; j++) {
                lauta[i][j] = 0;
            }
        }
    }
}