package robots;

import java.awt.Graphics;
import java.time.LocalTime;

import common.robotBase.DamageLevel;
import common.robotBase.IRobot;
import common.robotBase.MOVEMENT;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class IshimuraKiller2001 extends IRobot {
	private int nivel;

	public IshimuraKiller2001(int pNnivel, int pEnergy, int pVelocidad) {
		super(ORIENTATION.SOUTH, pVelocidad);
		
		this.nivel = pNnivel;
		this.energy = pEnergy;
	}

	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
