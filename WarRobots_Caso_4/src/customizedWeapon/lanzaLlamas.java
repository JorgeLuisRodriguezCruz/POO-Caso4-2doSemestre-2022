package customizedWeapon;

import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class lanzaLlamas extends Weapon {

	public lanzaLlamas(int pSpeed, int pLevel) {
		super(pSpeed, pLevel);
	}

	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	
}
