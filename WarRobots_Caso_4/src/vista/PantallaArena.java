package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
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

public class PantallaArena extends JFrame implements KeyListener, ActionListener{

	private static final long serialVersionUID = 1L;
	private ControllerArena controller;
	private JLabel robot;
	private ArrayList <JLabel> figuras;
	private Graphics2D robotico;
	
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
    
    public void painRobot (Image pImagen, Graphics2D pImagen2d)
    {
    	this.robotico = pImagen2d;
    	this.robotico.drawImage(pImagen, 30, 50, this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graphics g = null;
		Graphics2D g2D = (Graphics2D) g;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image fireball = toolkit.getImage("C:\\Users\\Usuario\\Documents\\GitHub\\POO-Caso4-2doSemestre-2022\\WarRobots_Caso_4\\Ruffus.png");
        this.painRobot(fireball, g2D);
		
	}
}
