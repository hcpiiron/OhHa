/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

/**
 *
 * @author hcpiiron
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class LautaUI implements Runnable {

    private JFrame frame;

    public LautaUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(luoValikko(), BorderLayout.NORTH);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    

    private Component luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JButton("Pelaa"));
        panel.add(new JButton("Tulokset"));
        panel.add(new JButton("Asetukset"));
        return panel;
    }
}