/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import javax.swing.SwingUtilities;

/**
 *
 * @author hcpiiron
 */
public class Ristinolla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LautaUI lauta = new LautaUI();
        
        SwingUtilities.invokeLater(lauta);
    }
}
