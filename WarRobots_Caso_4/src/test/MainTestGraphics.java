package test;

import java.util.ArrayList;

import controller.Controller;
import controller.ControllerAreaBatalla;
import vista.PanelProyectil;
import vista.PanelRobot;
import vista.Pantalla;
import vista.VistaArena;

public class MainTestGraphics {
	public static void main(String[] args) {
		System.out.println("Inicio");
		
		//PanelProyectil proy = new PanelProyectil();
		/*
		Controller contol = new Controller();
		PanelRobot panel = new PanelRobot();
		Pantalla ves = new Pantalla(panel, contol);
		//ves.add(proy);
		contol.setWindow(ves);
		*/
		
		//ves.moveRobot(150, 300);
		String direccion_Robot = "C:/Users/Usuario/Documents/GitHub/POO-Caso4-2doSemestre-2022/WarRobots_Caso_4/src/Rufuss.png";
		String direccion_Proyetil = "C:/Users/Usuario/Documents/GitHub/POO-Caso4-2doSemestre-2022/WarRobots_Caso_4/src/FireBall.png";
		ControllerAreaBatalla control = new ControllerAreaBatalla();
		
		VistaArena area = new VistaArena( direccion_Robot, direccion_Proyetil, control );
		control.setWindow(area);
		area.setVisible(true);
		
		System.out.println("Final");
		
	}
}
