package robots;

import common.robotBase.DamageLevel;
import common.robotBase.IRobot;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class IshimuraKiller2001 extends IRobot {
	private int nivel;

	public IshimuraKiller2001(int pNnivel, int pEnergy) {
		super(ORIENTATION.SOUTH);
		
		this.nivel = pNnivel;
		this.energy = pEnergy;
	}
	
	
	
}