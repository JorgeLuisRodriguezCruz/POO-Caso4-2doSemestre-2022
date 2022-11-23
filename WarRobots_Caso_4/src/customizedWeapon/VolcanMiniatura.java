package customizedWeapon;

import java.io.Serializable;

import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;
import proyectil.BolaFuego;

public class VolcanMiniatura extends Weapon implements Serializable{
	BolaFuego rocaFundida;

	public VolcanMiniatura(int pSpeed, int pNivel, int pAlcanse) {
		super(pSpeed, pNivel, pAlcanse);
		this.rocaFundida = null;
	}

	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		this.rocaFundida = new BolaFuego(this.level, pDirection, pPosX, pPosY, this.attackDistance);
		this.rocaFundida.move();
	
	}
}
