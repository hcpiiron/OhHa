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

/**
 *
 * @author hcpiiron
 */
public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    private Pelaaja pelaaja; 
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Matti");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void nimenHaku(){
        assertEquals("Matti", pelaaja.getNimi());
    }
    
    @Test
    public void pisteetAlussa(){
        assertEquals(0, pelaaja.getPisteet());
    }
    
    @Test
    public void kasvataPisteita(){
        for (int i = 0; i < 10; i++) {
            pelaaja.lisaaPiste();
            assertEquals(i+1, pelaaja.getPisteet());
        }
    }
    
    @Test
    public void pisteidenNollaus(){
        pelaaja.lisaaPiste();
        pelaaja.nollaaTulokset();
        assertEquals(0, pelaaja.getPisteet());
    }
    
}
