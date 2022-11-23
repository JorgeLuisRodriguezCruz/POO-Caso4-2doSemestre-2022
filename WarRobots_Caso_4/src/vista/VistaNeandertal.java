package vista;

import java.awt.Color;

import javax.swing.JFrame;

public class VistaNeandertal extends JFrame{
	private DibujadoLinea panel;
	
	public VistaNeandertal(DibujadoLinea pPanel) {
		super("Papas brabas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setSize(200, 200);

		this.panel = pPanel;
		this.add(this.panel);
	}

}
