package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;

import vista.PantallaArena;

public class ControllerArena extends Thread {
	private PantallaArena controlledFrame;
	
	public ControllerArena () {
		this.controlledFrame = null;
	}
	
	public void setWindow (PantallaArena pFrame) {
		controlledFrame = pFrame;
	}
	
	public void decimosHola () {
		System.out.println("Hola");
	}
	
	public void mover (int pCodigo, JLabel pFigura) {
		switch (pCodigo) {
			case 37: //Izquierda
				//Graphics g = null;
				//Graphics2D g2D = (Graphics2D) g;
		        //Toolkit toolkit = Toolkit.getDefaultToolkit();
		        //Image fireball = toolkit.getImage("C:\\Users\\Usuario\\Documents\\GitHub\\POO-Caso4-2doSemestre-2022\\WarRobots_Caso_4\\Ruffus.png");
		        //this.controlledFrame.painRobot(fireball, g2D);
		        
		        //g2D.drawImage(fireball, pFigura.getX() , pFigura.getY(),this);
				
				pFigura.setBounds(pFigura.getX() - 8, pFigura.getY(), 250, 20);
				break;
			case 39: //Derecha
				pFigura.setBounds(pFigura.getX() + 8, pFigura.getY(), 250, 20);
				break;
			case 38: //Arriba
				this.controlledFrame.actionPerformed(null);
				pFigura.setBounds(pFigura.getX(), pFigura.getY() - 8, 250, 20);
				break;
			case 40: //Abajo
				pFigura.setBounds(pFigura.getX(), pFigura.getY() + 8, 250, 20);
				break;
		}
		this.controlledFrame.refrescar();
	}
	
}
