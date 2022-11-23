package controller;

import javax.swing.JLabel;

import vista.PanelRobot;
import vista.Pantalla;

public class Controller {
	private Pantalla controlledFrame;
	
	public Controller () {
		this.controlledFrame = null;
	}
	
	public void setWindow (Pantalla pFrame) {
		controlledFrame = pFrame;
	}
	
	public void decimosHola () {
		System.out.println("Hola");
	}
	
	public void mover (int pCodigo, PanelRobot pPanel) {
		switch (pCodigo) {
			case 37: //Izquierda
				this.controlledFrame.moveRobot(pPanel.getPosicion_X() - 8 , pPanel.getPosicion_Y());//pFigura.setBounds(pFigura.getX() - 8, pFigura.getY(), 250, 20);
				//pPanel.rotar(90);
				break;
			case 39: //Derecha
				this.controlledFrame.moveRobot(pPanel.getPosicion_X() + 8 , pPanel.getPosicion_Y());//pFigura.setBounds(pFigura.getX() + 8, pFigura.getY(), 250, 20);
				pPanel.rotar(180);
				break;
			case 38: //Arriba
				this.controlledFrame.moveRobot(pPanel.getPosicion_X(), pPanel.getPosicion_Y() - 8);//pFigura.setBounds(pFigura.getX(), pFigura.getY() - 8, 250, 20);
				pPanel.rotar(90);
				break;
			case 40: //Abajo
				this.controlledFrame.moveRobot(pPanel.getPosicion_X(), pPanel.getPosicion_Y() + 8);//pFigura.setBounds(pFigura.getX(), pFigura.getY() + 8, 250, 20);
				//pPanel.rotar(270);
				break;
		}
		//this.controlledFrame.refrescar();
	}
}
