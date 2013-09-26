/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.Lauta;
import ristinolla.Pelaaja;

/**
 *
 * @author hcpiiron
 */
public class LautaTest {
    private Pelaaja pelaaja;
    private Lauta lauta;
    
    public LautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja= new Pelaaja("Matti");
        lauta = new Lauta();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaPelaaja(){
        lauta.lisaaPelaaja(pelaaja);
        assertTrue(lauta.getPelaajat().contains(pelaaja));
    }
    
    @Test
    public void ekaVaakaRistille(){
        lauta.asetaMerkki(1, 0, 0);
        lauta.asetaMerkki(1, 0, 1);
        lauta.asetaMerkki(1, 0, 2);
        assertEquals(1, lauta.testaaVoittoVaaka());
    }
    
    @Test
    public void tokaVaakaNollalle(){
        lauta.asetaMerkki(2, 1, 0);
        lauta.asetaMerkki(2, 1, 1);
        lauta.asetaMerkki(2, 1, 2);
        assertEquals(2, lauta.testaaVoittoVaaka());
    }
    
    @Test
    public void tyhjallaVaakaTasapeli(){
        assertEquals(0, lauta.testaaVoittoVaaka());
    }
    
    @Test
    public void muutamanMerkinTasapeli(){
        lauta.asetaMerkki(2, 0, 2);
        lauta.asetaMerkki(2, 2, 1);
        lauta.asetaMerkki(1, 0, 0);
        assertEquals(0, lauta.testaaVoittoVaaka());
        assertEquals(0, lauta.testaaVoittoPysty());
    }
    
    @Test
    public void tyhjallaPytsyTasapeli(){
        assertEquals(0, lauta.testaaVoittoPysty());
    }
    
    @Test
    public void ekaPystyRistille(){
        lauta.asetaMerkki(1, 0, 0);
        lauta.asetaMerkki(1, 1, 0);
        lauta.asetaMerkki(1, 2, 0);
        assertEquals(1, lauta.testaaVoittoPysty());
    }
    
    @Test
    public void tokaPystyNollalle(){
        lauta.asetaMerkki(2, 0, 1);
        lauta.asetaMerkki(2, 1, 1);
        lauta.asetaMerkki(2, 2, 1);
        assertEquals(2, lauta.testaaVoittoPysty());
    }
    
    @Test
    public void tilanne(){
        lauta.asetaMerkki(1, 0, 0);
        lauta.asetaMerkki(1, 0, 1);
        lauta.asetaMerkki(1, 1, 0);
        lauta.asetaMerkki(1, 2, 0);
        lauta.asetaMerkki(2, 1, 1);
        lauta.asetaMerkki(2, 1, 2);
        assertEquals(0, lauta.testaaVoittoVaaka());
        assertEquals(1, lauta.testaaVoittoPysty());
    }
    
    
    
    
    
}
