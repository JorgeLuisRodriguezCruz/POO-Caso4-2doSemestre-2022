package controller;

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
				pFigura.setBounds(pFigura.getX() - 8, pFigura.getY(), 250, 20);
				break;
			case 39: //Derecha
				pFigura.setBounds(pFigura.getX() + 8, pFigura.getY(), 250, 20);
				break;
			case 38: //Arriba
				pFigura.setBounds(pFigura.getX(), pFigura.getY() - 8, 250, 20);
				break;
			case 40: //Abajo
				pFigura.setBounds(pFigura.getX(), pFigura.getY() + 8, 250, 20);
				break;
		}
		this.controlledFrame.refrescar();
	}
	
}
