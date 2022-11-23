package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PruebaCopia extends JFrame {
    PanelTest panel;
    JLabel label;
    public PruebaCopia(String pTitle){
        this.panel = new PanelTest();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle(pTitle);
        this.setBackground(Color.GREEN);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
