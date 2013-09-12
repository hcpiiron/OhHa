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
import ristinolla.Pelaaja;
import ristinolla.Tilasto;

/**
 *
 * @author hcpiiron
 */
public class TilastoTest {
    private Pelaaja pelaaja;
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
        pelaaja = new Pelaaja("Matti");
        tilasto = new Tilasto();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pelaajanLisaaminen(){
        tilasto.lisaaPelaaja(pelaaja);
        assertTrue(tilasto.getLista().contains(pelaaja));
    }
    
    @Test
    public void pelaajanPoistaminen(){
        tilasto.lisaaPelaaja(pelaaja);
        assertTrue(tilasto.getLista().contains(pelaaja));
        tilasto.poistaPelaaja(pelaaja.getNimi());
        assertFalse(tilasto.getLista().contains(pelaaja));
    }
}
