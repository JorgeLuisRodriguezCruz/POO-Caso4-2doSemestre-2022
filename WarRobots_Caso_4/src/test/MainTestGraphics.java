package test;

import controller.Controller;
import vista.PanelRobot;
import vista.Pantalla;

public class MainTestGraphics {
	public static void main(String[] args) {
		System.out.println("Inicio");
		
		Controller contol = new Controller();
		PanelRobot panel = new PanelRobot();
		Pantalla ves = new Pantalla(panel, contol);
		contol.setWindow(ves);
		
		//ves.moveRobot(150, 300);
		
		System.out.println("Final");
		
	}
}
