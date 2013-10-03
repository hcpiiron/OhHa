
package ristinolla;


import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PopUp extends JDialog {
    JLabel label;
    
    public PopUp(JFrame frame){
        super(frame, "BOOM", true);
        setLayout(new FlowLayout());
        label = new JLabel("Peli ohi! Onnea voittajalle!");
        add(label);
    }
    
    
}