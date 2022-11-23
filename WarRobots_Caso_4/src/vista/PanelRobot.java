package vista;
 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon; 
import javax.swing.JPanel;

public class PanelRobot extends JPanel{
	private String NOMBRE_IMAGEN_ENTRADA = "/Rufuss.png";
	private BufferedImage imagen_Robot;
	private Image fondo;
	private int posicion_X;
	private int posicion_Y;
	

	public PanelRobot () {
		this.fondo = new ImageIcon(getClass().getResource( this.NOMBRE_IMAGEN_ENTRADA )).getImage();
		this.posicion_X = 450;
		this.posicion_Y = 500;
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g; 
        imagen_Robot = new BufferedImage(80, 80, BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2Oculta = imagen_Robot.createGraphics();
        g2Oculta.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2Oculta.drawImage(fondo, 0, 0, 80, 80, null);
        g2D.drawImage(imagen_Robot, this.posicion_X, this.posicion_Y, 80, 80, this); 
        
        this.repaint();
	}
	
	public void rotar (int pAngulo) {
		
		//this.fondo = new ImageIcon(getClass().getResource("/Rufuss.png")).getImage();
		
		int ancho = this.imagen_Robot.getWidth();
		int alto = this.imagen_Robot.getHeight();
		
		BufferedImage rotated = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphic = rotated.createGraphics();
	    graphic.rotate(Math.toRadians(pAngulo), ancho/2, alto/2);
	    graphic.drawImage (this.imagen_Robot, null, 0, 0);
	    //graphic.drawImage(this.fondo, this.posicion_X, this.posicion_Y, 80, 80, null);
	    //graphic.dispose();
	    //this.repaint();
	    try {
	    	File imagenRotada = new File("C:/Users/Usuario/Documents/GitHub/POO-Caso4-2doSemestre-2022/WarRobots_Caso_4/src/RufussRotado.png"); 
            this.imagen_Robot = rotated;
            ImageIO.write(rotated, "png", imagenRotada);
            
            this.fondo = new ImageIcon(getClass().getResource("/RufussRotado.png")).getImage();
            this.repaint();
            
	    }catch(IOException e){
	    	System.out.println("Fallo la rotacion");
	    }
	    
	}

	public int getPosicion_X() {
		return posicion_X;
	}

	public void setPosicion_X(int pPosicion_X) {
		this.posicion_X = pPosicion_X;
	}

	public int getPosicion_Y() {
		return posicion_Y;
	}

	public void setPosicion_Y(int pPosicion_Y) {
		this.posicion_Y = pPosicion_Y;
	}
	
	
}
