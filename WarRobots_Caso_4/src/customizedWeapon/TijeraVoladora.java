package customizedWeapon;

import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class TijeraVoladora extends Weapon {

	public TijeraVoladora(int pSpeed, int pNivel, int pAttackDistance) {
		super(pSpeed, pNivel, pAttackDistance);
	}

	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
		
	}

}
