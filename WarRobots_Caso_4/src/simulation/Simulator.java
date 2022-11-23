package simulation;

import common.IConstants;
import serializer.GsonSerialized;
import simulation.SimulatorReport;
import utils.Observable;

public class Simulator extends Observable implements Runnable, IConstants{
	GsonSerialized g=new GsonSerialized();
	private boolean running = false;
	
	private static volatile Simulator instance = null;

    public static Simulator getInstance() {
        if (instance == null) {
            synchronized(Simulator.class) {
                if (instance == null) {
                    instance = new Simulator();
                }
            }
        }

        return instance;
    }
    
    
	@Override
	public void run() {
		running = true;
		while (running) {
			try {

				
				Thread.sleep(50);
				
				
				
				SimulatorReport report = new SimulatorReport();
				
				
				this.notifyObservers(report);
				
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

	public void stop() {
		running = false;
	}

	
	
}
