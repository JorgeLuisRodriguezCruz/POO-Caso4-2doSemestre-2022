package customizedWeapon;

import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class LanzaLlamas extends Weapon {

	public LanzaLlamas(int pLevel) {
		super(100, pLevel, 300);
	}

	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
}
