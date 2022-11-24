package test;

import controller.ControllerAreaBatalla;
import manager.StatusManager;
import serializer.GsonSerialized;
import simulation.Simulator;

public class Main2 {

	public static void main(String[] args) {
		StatusManager manager = new StatusManager();
		ControllerAreaBatalla controller = new ControllerAreaBatalla(manager);

		//UIWindow ejemplo = new UIWindow();
		//ejemplo.Simular();
		
		
		Simulator sim = Simulator.getInstance();
		sim.addObserver(manager);
		sim.addObserver(controller);
		
		Thread simThread = new Thread(sim);
		simThread.start();
		
		
		
		
	}
}
