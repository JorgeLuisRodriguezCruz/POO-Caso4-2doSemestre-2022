package simulation;

import common.IConstants;

public class SimulatorReport implements IConstants{
	public int posX1;
	public int posY1;
	public boolean weapon1[]= new boolean[WEAPONS_PER_ROBOT];
	public boolean strikes1[]= new boolean[STRIKES_PER_ROBOT];
	
	public int posX2;
	public int posY2;
	public boolean weapon2[]= new boolean[WEAPONS_PER_ROBOT];
	public boolean strikes2[]= new boolean[STRIKES_PER_ROBOT];
	
	public int posTrapsX[]= new int[2];
	public int posTrapsY[]= new int[2];
}
