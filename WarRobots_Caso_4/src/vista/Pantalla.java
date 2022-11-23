package vista;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;

public class Pantalla extends JFrame implements KeyListener{
	private PanelRobot panel;
	private Controller control;
	
	public Pantalla(PanelRobot pPanel, Controller pControlador) {
		super("Arena");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setSize(1080, 720);

		this.control = pControlador;
		this.panel = pPanel;
		this.add(this.panel);
		this.setVisible(true);

    	this.addKeyListener(this);
		
	}
	
	public void moveRobot (int pDireccionX, int pDireccionY) {
		this.panel.setPosicion_X(pDireccionX);
		this.panel.setPosicion_Y(pDireccionY);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		this.control.mover(e.getKeyCode(), this.panel);
	}
}
