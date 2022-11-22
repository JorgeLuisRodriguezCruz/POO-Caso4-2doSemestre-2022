package robots;

import java.awt.Graphics;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.IRobot;
import common.robotBase.DamageLevel;
import common.robotBase.MOVEMENT;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class PX0 extends IRobot{
	ArrayList<MOVEMENT>  direcciones;
	ArrayList<ORIENTATION>  orientacion;
	/*
	int energy;
	protected int posX;
	protected int posY;
	protected int strikeIndex;
	protected int weaponIndex;
	protected int speed;
	protected Weapon weapons[];
	protected Weapon strikes[];
	protected DamageLevel directionsdamage[];
	protected ORIENTATION currentOrientation;
	*/
	
	public PX0(){
		direcciones.add(MOVEMENT.UP);
		direcciones.add(MOVEMENT.DOWN);
		direcciones.add(MOVEMENT.RIGHT);
		direcciones.add(MOVEMENT.LEFT);
		orientacion.add(ORIENTATION.NORTH);
		orientacion.add(ORIENTATION.SOUTH);
		orientacion.add(ORIENTATION.EAST);
		orientacion.add(ORIENTATION.WEST);
		
		DamageLevel up = new DamageLevel();
		DamageLevel down = new DamageLevel();
		DamageLevel right = new DamageLevel();
		DamageLevel left = new DamageLevel();
		
		directionsdamage[0]= up;
		directionsdamage[1]= down;
		directionsdamage[2]= right;
		directionsdamage[3]= left;
	}
	
	
	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		int actTime= LocalTime.now().getSecond()- pActionTime.getSecond();
	}

	@Override
	public void damage(int pLevel) {
		
		directionsdamage[ orientacion.indexOf(currentOrientation) ].hitDamage(pLevel);
		
	}
	
	
}
