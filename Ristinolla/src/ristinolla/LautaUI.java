
package ristinolla;


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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LautaUI implements Runnable {

    private JFrame frame;
    private JFrame kentta;
    private JFrame asetukset;
    private JFrame tulokset;
    private Lauta lauta;
    private boolean vuoroX = true;
    private boolean freeze = false;
    private ArrayList<JButton> listaKentanNapeista;
    private Tilasto tilasto = new Tilasto();
    private boolean peliKaynnissa = false;
    private ArrayList<JLabel> rankingPaikat = new ArrayList<>();

    public LautaUI() {
    }

    @Override
    public void run() {
        listaKentanNapeista = new ArrayList<>();
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

        asetukset = new JFrame("Asetukset");
        asetukset.setPreferredSize(new Dimension(500, 200));
        asetukset.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        luoKomponentit(asetukset.getContentPane(), "asetukset");
        asetukset.pack();
        asetukset.setLocation(900, 300);
        asetukset.setVisible(false);

        tulokset = new JFrame("Hall of fame");
        tulokset.setPreferredSize(new Dimension(500, 700));
        tulokset.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        luoKomponentit(tulokset.getContentPane(), "tulokset");
        tulokset.pack();
        tulokset.setLocation(900, 300);
        tulokset.setVisible(false);



    }
    
    private void luoKomponentit(Container container, String mika) {
        if (mika.matches("valikko")) {
            container.add(luoValikko(), BorderLayout.NORTH);
        }
        if (mika.matches("kentta")) {
            container.add(luoKentta(), BorderLayout.CENTER);
        }
        if (mika.matches("asetukset")) {
            container.add(luoAsetukset(), BorderLayout.CENTER);
        }
        if (mika.matches("tulokset")) {
            container.add(luoTulokset(), BorderLayout.CENTER);
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    private Component luoTulokset() {
        JPanel panel = new JPanel(new GridLayout(10, 0));
        JLabel otsikko = new JLabel("      PLAYERZ & POINTZ");
        panel.add(otsikko);
        for (int i = 0; i < 10; i++) {
            JLabel paikka = new JLabel();
            rankingPaikat.add(paikka);
            panel.add(paikka);
        }
        return panel;
    }

    private Component luoAsetukset() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel pelaaja1Teksti = new JLabel("Pelaaja X: ");
        final JTextField pelaaja1 = new JTextField();
        JLabel pelaaja2Teksti = new JLabel("Pelaaja 0: ");
        final JTextField pelaaja2 = new JTextField();
        JLabel suoranPituusTeksti = new JLabel("Voittosuoran pituus (2-9): ");
        final JTextField suoranPituus = new JTextField();

        JButton tallennusNappi = new JButton("Tallenna");
        tallennusNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (!peliKaynnissa) {  // Asetuksia voi muuttaa vain jos peli ei ole kesken
                    String pelaajaX = "pelaajaX";
                    String pelaajaO = "pelaajaO";

                    if (!pelaaja1.getText().isEmpty()) {
                        pelaajaX = pelaaja1.getText();
                    }
                    if (!pelaaja2.getText().isEmpty()) {
                        pelaajaO = pelaaja2.getText();
                    }

                    if (!tilasto.onkoPelaaja(pelaajaX)) {
                        tilasto.lisaaPelaaja(pelaajaX);
                    }
                    if (!tilasto.onkoPelaaja(pelaajaO)) {
                        tilasto.lisaaPelaaja(pelaajaO);
                    }

                    lauta.uudetPelaajat(pelaajaX, pelaajaO);

                    if (!suoranPituus.getText().isEmpty() && suoranPituus.getText().length() == 1 && Character.isDigit(suoranPituus.getText().charAt(0))) {
                        lauta.muutaVoittosuoraa(Integer.parseInt(suoranPituus.getText()));
                    }
                    asetukset.setVisible(false);
                } else {
                    asetukset.setVisible(false);
                }
            }
        });
        panel.add(pelaaja1Teksti);
        panel.add(pelaaja1);
        panel.add(pelaaja2Teksti);
        panel.add(pelaaja2);
        panel.add(suoranPituusTeksti);
        panel.add(suoranPituus);
        panel.add(new JLabel(""));
        panel.add(tallennusNappi);

        return panel;
    }

    private Component luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton pelaa = new JButton("Pelaa");
        pelaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                alustaKentta();
                kentta.setVisible(true);
                peliKaynnissa = true;
            }

            private void alustaKentta() {
                if (!peliKaynnissa) {
                    freeze = false;
                    lauta.tyhjenna();
                    if (!listaKentanNapeista.isEmpty()) {
                        for (JButton nappi : listaKentanNapeista) {
                            nappi.setText(" ");
                        }
                    }
                }
            }
        });
        panel.add(pelaa);

        JButton tuloksetNappi = new JButton("Tulokset");
        tuloksetNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                int laskuri = 1;
                if (laskuri < 11) {
                    for (String pelaaja : tilasto.getPelaajat()) {
                        int pinnat = tilasto.getPisteLista().get(pelaaja);
                        rankingPaikat.get(laskuri).setText(pelaaja + ": " + pinnat + " points");
                        laskuri++;
                    }
                }
                tulokset.setVisible(true);
            }
        });
        panel.add(tuloksetNappi);

        JButton asetusNappi = new JButton("Asetukset");
        asetusNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                asetukset.setVisible(true);
            }
        });
        panel.add(asetusNappi);

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
                                int kumpi = 1;
                                if (vuoroX) {
                                    kumpi = 2;
                                }
                                tilasto.lisaaPiste(lauta.getVoittaja(kumpi));
                                PopUp gui = new PopUp(frame);
                                gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                                gui.setSize(400, 100);
                                gui.setLocation(1100, 500);
                                gui.setTitle("BOOM!");
                                gui.setVisible(true);
                                peliKaynnissa = false;
                                vuoroX = true;
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