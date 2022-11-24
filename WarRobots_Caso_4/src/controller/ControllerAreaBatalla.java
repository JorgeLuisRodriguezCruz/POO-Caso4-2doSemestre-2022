package controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import simulation.SimulatorReport;
import utils.IObserver;
import utils.Observable;
import vista.VistaArena;

public class ControllerAreaBatalla implements IObserver{
	private VistaArena vista_Controlada;
	
	public ControllerAreaBatalla  () {
		this.vista_Controlada = null;
	}
	
	public void setWindow (VistaArena pFrame) {
		this.vista_Controlada = pFrame;
	}
	
	public BufferedImage redimencionar (BufferedImage pImagen, int pAncho, int pAlto) {
	    Image nuevas_Dimensiones = pImagen.getScaledInstance(pAncho, pAlto, Image.SCALE_SMOOTH);
	    
	    BufferedImage dimg = new BufferedImage(pAncho, pAlto, BufferedImage.TYPE_INT_ARGB);
	    
	    dimg = new BufferedImage(pAncho, pAlto, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(nuevas_Dimensiones, 0, 0, null);
	    g2d.dispose();
		return dimg;
	}
	
	public void mover (int pCodigo) {
		switch (pCodigo) {
			case 32:
				this.vista_Controlada.getProyectil().setLocation(this.vista_Controlada.getRobot().getBounds().x-30, this.vista_Controlada.getRobot().getBounds().y);
				
				this.vista_Controlada.add(this.vista_Controlada.getRobot());
				this.vista_Controlada.add(this.vista_Controlada.getProyectil());
				
				this.vista_Controlada.repaint();
				break;
			case 37: //Izquierda
				this.vista_Controlada.getRobot().setBounds(this.vista_Controlada.getRobot().getX() - 8, this.vista_Controlada.getRobot().getY(), this.vista_Controlada.getRobot().getWidth(), this.vista_Controlada.getRobot().getHeight());
				this.vista_Controlada.add(this.vista_Controlada.getRobot());
				this.vista_Controlada.repaint();
				break;
			case 39: //Derecha
				this.vista_Controlada.getRobot().setBounds(this.vista_Controlada.getRobot().getX() + 8, this.vista_Controlada.getRobot().getY(), this.vista_Controlada.getRobot().getWidth(), this.vista_Controlada.getRobot().getHeight());
				this.vista_Controlada.add(this.vista_Controlada.getRobot());
				this.vista_Controlada.repaint();
				break;
			case 38: //Arriba
				this.vista_Controlada.getRobot().setBounds(this.vista_Controlada.getRobot().getX(), this.vista_Controlada.getRobot().getY() - 8, this.vista_Controlada.getRobot().getWidth(), this.vista_Controlada.getRobot().getHeight());
				this.vista_Controlada.add(this.vista_Controlada.getRobot());
				this.vista_Controlada.repaint();
				break;
			case 40: //Abajo
				this.vista_Controlada.getRobot().setBounds(this.vista_Controlada.getRobot().getX(), this.vista_Controlada.getRobot().getY() + 8, this.vista_Controlada.getRobot().getWidth(), this.vista_Controlada.getRobot().getHeight());
				this.vista_Controlada.add(this.vista_Controlada.getRobot());
				this.vista_Controlada.repaint();
				break;
		}
	}

	
	
	private int robotX;
	private int robotY;
	private int proyectilX;
	private int proyectilY;
	@Override
	public void update(Observable pObservable, Object args) {
		SimulatorReport simReport = (SimulatorReport)args;
		robotX= simReport.posX1;
		robotY= simReport.posX2;
		proyectilX=simReport.proyectil1X;
		proyectilY=simReport.proyectil1Y;
		
	}

}
