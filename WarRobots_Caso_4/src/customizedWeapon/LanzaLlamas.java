package customizedWeapon;

import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class LanzaLlamas extends Weapon {

	public LanzaLlamas(int pSpeed, int pLevel, int pAttackDistance) {
		super(pSpeed, pLevel, pAttackDistance);
	}

	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
}
