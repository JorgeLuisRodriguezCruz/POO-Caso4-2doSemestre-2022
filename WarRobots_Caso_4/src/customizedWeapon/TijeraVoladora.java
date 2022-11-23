package customizedWeapon;

import java.io.Serializable;

import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;
import proyectil.BolaFuego;

public class TijeraVoladora extends Weapon implements Serializable{
	BolaFuego tijeraQuemada;

	public TijeraVoladora(int pSpeed, int pNivel) {
		super(pSpeed, pNivel, 5);
		this.tijeraQuemada = null;
	}

	@Override
	protected void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		this.tijeraQuemada = new BolaFuego(this.level, pDirection, pPosX, pPosY, this.attackDistance);
		//this.tijeraQuemada.move();
	
	}
}
