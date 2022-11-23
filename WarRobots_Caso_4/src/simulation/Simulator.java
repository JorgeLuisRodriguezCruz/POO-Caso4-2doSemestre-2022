package simulation;

import common.IConstants;
import serializer.GsonSerialized;
import utils.Observable;

public class Simulator extends Observable implements Runnable, IConstants{
	GsonSerialized g=new GsonSerialized();
	
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
		
		
	}



	
	
}
