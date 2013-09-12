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
        lauta = new Lauta(3);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaPelaaja(){
        lauta.lisaaPelaaja(pelaaja);
        assertTrue(lauta.getPelaajat().contains(pelaaja));
    }
    
    
}
