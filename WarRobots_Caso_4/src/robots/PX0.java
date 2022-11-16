package robots;

import java.awt.Graphics;
import java.time.LocalTime;

import common.IRobot;
import common.robotBase.DamageLevel;
import common.robotBase.MOVEMENT;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class PX0 extends IRobot{

	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		
	}

	@Override
	public void damage(int pLevel) {
		this.currentOrientation=ORIENTATION.;
	}
	
	
}
