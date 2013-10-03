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
import ristinolla.Tilasto;

/**
 *
 * @author hcpiiron
 */
public class TilastoTest {
    private String pelaaja;
    private Tilasto tilasto;
    
    public TilastoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = "Matti";
        tilasto = new Tilasto();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pelaajanLisaaminen(){
        tilasto.lisaaPelaaja(pelaaja);
        assertTrue(tilasto.getPelaajat().contains(pelaaja));
    }
    
    @Test 
    public void pelaajalistanHakeminen(){
        tilasto.lisaaPelaaja(pelaaja);
        assertFalse(tilasto.getPelaajat().isEmpty());
    }
    
    @Test
    public void pelaajallePiste(){
        tilasto.lisaaPelaaja(pelaaja);
        tilasto.lisaaPiste(pelaaja);
        assertTrue(tilasto.getPisteLista().get(pelaaja) == 1);
    }
    
    @Test
    public void pisteidenNollaus(){
        tilasto.lisaaPelaaja(pelaaja);
        tilasto.lisaaPiste(pelaaja);
        assertTrue(tilasto.getPisteLista().get(pelaaja) == 1);
        tilasto.nollaaTulokset();
        assertTrue(tilasto.getPisteLista().get(pelaaja) == 0);
    }
    
    @Test
    public void tilastonNollaus(){
        tilasto.lisaaPelaaja(pelaaja);
        tilasto.lisaaPiste(pelaaja);
        tilasto.tyhjennaTilastot();
        assertTrue(tilasto.getPelaajat().isEmpty());
        assertTrue(tilasto.getPisteLista().isEmpty());
    }
}
