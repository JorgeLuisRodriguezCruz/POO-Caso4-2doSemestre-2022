package vista;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DibujadoLinea extends JPanel{
	
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.drawLine(20, 20, 20, 120);
		//g.drawLine(70, 70, 70, 190);
	}
	
	public static void main (String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame vent = new JFrame("Dibujoo");
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setBackground(Color.WHITE);
		vent.setSize(200, 200);
		
		DibujadoLinea panel = new DibujadoLinea();
		vent.add (panel);
		vent.setVisible(true);
	}

}
