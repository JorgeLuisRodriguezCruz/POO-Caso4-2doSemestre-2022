package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.ls.LSOutput;

import controller.ControllerArena;

public class PantallaArena extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private ControllerArena controller;
	private JLabel robot;
	private ArrayList <JLabel> figuras;
	
	public PantallaArena (String pTitle, ControllerArena pController) {

		super(pTitle);
		this.controller = pController;
		this.controller.setWindow(this);
		this.figuras = new ArrayList <JLabel> ();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, 1080, 720);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(Color.white);
		this.initComponents();
		
		this.setVisible(true);		
	}
    
    private void initComponents() {
    	JLabel labelEjemplar = new JLabel("Label ejemplar");
    	labelEjemplar.setBounds(10, 20, 160, 20);
    	this.add(labelEjemplar);
    	this.figuras.add(labelEjemplar);
    	
    	
    	this.robot = new JLabel("Esta se deberia de mover");
    	this.robot.setBounds(50, 55, 250, 20);
    	this.addKeyListener(this);
    	
    	this.add(this.robot);
    }
    
    public void refrescar () {
    	this.add(this.robot);
    	this.revalidate();
    	this.repaint();
    }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		this.remove(this.robot);
		controller.mover(e.getKeyCode(), this.robot);
	}
}
