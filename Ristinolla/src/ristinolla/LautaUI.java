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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class LautaUI implements Runnable {

    private JFrame frame;
    private JFrame kentta;
    private Lauta lauta;
    private boolean vuoroX = true;
    private boolean freeze = false;
    private ArrayList<JButton> listaKentanNapeista;

    public LautaUI() {
    }

    @Override
    public void run() {
        listaKentanNapeista = new ArrayList<JButton>();
        lauta = new Lauta();

        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane(), "valikko");
        frame.pack();
        frame.setLocation(300, 300);
        frame.setVisible(true);

        kentta = new JFrame("Ristinolla");
        kentta.setPreferredSize(new Dimension(650, 650));
        kentta.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        luoKomponentit(kentta.getContentPane(), "kentta");
        kentta.pack();
        kentta.setLocation(900, 300);
        kentta.setVisible(false);


    }

    private void luoKomponentit(Container container, String mika) {
        if (mika.matches("valikko")) {
            container.add(luoValikko(), BorderLayout.NORTH);
        }
        if (mika.matches("kentta")) {
            container.add(luoKentta(), BorderLayout.CENTER);
        }


    }

    public JFrame getFrame() {
        return frame;
    }

    private Component luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton pelaa = new JButton("Pelaa");
        pelaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                alustaKentta();
                kentta.setVisible(true);
            }

            private void alustaKentta() {
                freeze = false;
                lauta.tyhjenna();
                if (!listaKentanNapeista.isEmpty()) {
                    for (JButton nappi : listaKentanNapeista) {
                        nappi.setText(" ");
                    }
                }

            }
        });
        panel.add(pelaa);
        panel.add(new JButton("Tulokset"));
        
        
        panel.add(new JButton("Asetukset"));
        return panel;
    }

    private Component luoKentta() {
        JPanel panel = new JPanel(new GridLayout(10, 10));
        int count = 0;
        int rivit = 0;
        int sarake = 0;
        for (int i = 0; i < 100; i++) {
            final JButton nappi = new JButton("");
            lauta.asetaMerkki(0, rivit, sarake);
            nappi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    if (!freeze) {

                        if (nappi.getText().matches(" ")) {
                            String koordinaatti = nappi.getName();
                            if (vuoroX) {
                                nappi.setText("X");
                                vuoroX = false;
                                lauta.asetaMerkki(koordinaatti, 1);
                            } else if (!vuoroX) {
                                nappi.setText("0");
                                vuoroX = true;
                                lauta.asetaMerkki(koordinaatti, 2);
                            }
                            if (lauta.testaaVoittoPysty() != 0 || lauta.testaaVoittoVaaka() != 0) {
                                freeze = true;

                                //lisää piste voittavalle pelaajalle

                                LoppuIkkuna gui = new LoppuIkkuna(frame);
                                gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                gui.setSize(400, 100);
                                gui.setLocation(1100, 500);
                                gui.setTitle("BOOM!");
                                gui.setVisible(true);




                            }
                        }
                    }
                }
            });
            nappi.setText(" ");
            nappi.setName(rivit + "" + sarake);
            listaKentanNapeista.add(nappi);
            panel.add(nappi);
            
            count++;
            sarake++;
            if (count == 10) {
                count = 0;
                rivit++;
                sarake = 0;
            }
        }
        return panel;
    }
}