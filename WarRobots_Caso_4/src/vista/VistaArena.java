package vista;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerAreaBatalla;

public class VistaArena extends JFrame implements KeyListener {
	private ControllerAreaBatalla controlador;
	private String NOMBRE_ARCHIVO_ROBOT;
	private String NOMBRE_ARCHIVO_PROYECTIL;
	private JLabel robot;
	private JLabel proyectil;
	
//	private JPanel panel_Principal;

	public VistaArena (String pNombreArchivoRobot, String pNombreArchivoProyectil, ControllerAreaBatalla pControlador) {
		super("Area batalla");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setSize(1080, 720); 
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		
		this.controlador = pControlador;
		this.NOMBRE_ARCHIVO_ROBOT = pNombreArchivoRobot;
		this.NOMBRE_ARCHIVO_PROYECTIL = pNombreArchivoProyectil;
		this.robot = new JLabel();
		this.proyectil = new JLabel();
		
		this.add(this.proyectil);
		this.add(this.robot);
		
		this.inicializar();
    	this.addKeyListener(this);
	}
	
	public void inicializar () {
		this.proyectil.setBounds(60, 90, 30, 30);
		this.robot.setBounds(60, 60, 60, 60);
		
		BufferedImage imagen_Robot = null;
		BufferedImage imagen_Proyectil = null;
		
		try {
			imagen_Proyectil = ImageIO.read(new File ( this.NOMBRE_ARCHIVO_PROYECTIL ));
			imagen_Proyectil = this.controlador.redimencionar(imagen_Proyectil, 30, 30);
			
			imagen_Robot = ImageIO.read(new File ( this.NOMBRE_ARCHIVO_ROBOT ));
			imagen_Robot = this.controlador.redimencionar(imagen_Robot, 60, 60);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.robot.setIcon(new ImageIcon( imagen_Robot ));
		this.proyectil.setIcon(new ImageIcon( imagen_Proyectil ));//this.remove(this.proyectil);
	}

	public JLabel getRobot() {
		return robot;
	}

	public void setRobot(JLabel robot) {
		this.robot = robot;
	}

	public JLabel getProyectil() {
		return proyectil;
	}

	public void setProyectil(JLabel proyectil) {
		this.proyectil = proyectil;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//this.control.mover(e.getKeyCode(), this.panel);
		this.remove(this.robot);
		this.remove(this.proyectil);
		
		
		this.controlador.mover(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//this.control.mover(e.getKeyCode(), this.panel);
		//this.remove(this.robot);
		//this.remove(this.proyectil);
		//this.controlador.mover(e.getKeyCode());
	}

}
