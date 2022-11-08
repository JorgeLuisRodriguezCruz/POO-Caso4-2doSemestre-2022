package common;

import java.awt.Graphics;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import common.robotBase.DamageLevel;
import common.robotBase.MOVEMENT;
import common.robotBase.Weapon;

public class IRobot implements IConstants{
	private int energy;
	private int posX;
	private int posY;
	private int strikeIndex;
	private int weaponIndex;
	private Weapon weapons[];
	private Weapon strikes[];
	private DamageLevel directionsdamage[];
	
	public IRobot(Weapon pdirections, DamageLevel pweapons) {
		directionsdamage = new DamageLevel[MOVEMENT.values().length];
		weapons = new Weapon[WEAPONS_PER_ROBOT];
		strikes = new Weapon[STRIKES_PER_ROBOT];
		
		strikeIndex = 0;
		weaponIndex = 0;
	}
	
	/*
	 * el move es la dirección que el jugador está presionando, con eso y la hora del accion
	 * versus la hora actual se sabe cuanto tiempo ha transcurrido por ende
	 * dada la velocidad del robot, se puede saber cuanto hay que desplazarlo, 
	 * a que velocidad lo desplazo, actualizo el X, Y
	 * reduzco la energía
	 * refresco la pantalla con el graphics
	 */
	public void move(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		int Move= pMove.getValue();
		int TimeDif = (int)ChronoUnit.MILLIS.between(pActionTime, LocalTime.now());
		if(Move==0){ //left
			posX-= ROBOT_MOVEMENT_LENGTH*TimeDif;
		}else if(Move==1){ //right
			posX+= ROBOT_MOVEMENT_LENGTH*TimeDif;
		}else if(Move==2){ //up
			posY-= ROBOT_MOVEMENT_LENGTH*TimeDif;
		}else if(Move==3){ //down
			posY+= ROBOT_MOVEMENT_LENGTH*TimeDif;
		}
		energy-=ENERGY_PER_MOVEMENT;
	}
	
	public void hit(int pStrikeId, LocalTime pActionTime, Graphics g ) {
		
	}
	
	public void fire(int pWeaponId, LocalTime pActionTime, Graphics g) {
		
	}
	
	/*
	 * @pLevel, número del nivel del arma que le acertó
	 * este es el nivel del arma o golpe que le acertó a este robot
	 * entonces ahora hay que dado el nivel escoger la regla que aplica
	 * actualizar el damage respectivo
	 */
	public void damage(int pLevel) {
		
	}
	
	public void addStrike(Weapon pStrike) {
		strikes[strikeIndex] = pStrike;
		strikeIndex=++strikeIndex%STRIKES_PER_ROBOT;
	}
	
	public void addWeapon(Weapon pStrike) {
		weapons[weaponIndex] = pStrike;
		weaponIndex=++weaponIndex%WEAPONS_PER_ROBOT;
	}

}
