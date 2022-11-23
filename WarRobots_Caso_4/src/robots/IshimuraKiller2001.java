package robots;

import java.awt.Graphics;
import java.time.LocalTime;
import java.util.ArrayList;

import common.robotBase.DamageLevel;
import common.robotBase.IRobot;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;

public class IshimuraKiller2001 extends IRobot {
	private int nivel;

	public IshimuraKiller2001(int pNnivel, int pEnergy) {
		super(ORIENTATION.SOUTH);
		
		this.nivel = pNnivel;
		this.energy = pEnergy;
	}

	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		LocalTime ahora = LocalTime.now();
		int tiempo_Transcurrido = pActionTime.getSecond() - ahora.getSecond();
		int casillas_Recorrer = tiempo_Transcurrido * this.speed;
		
		int [] array_X = {-1*casillas_Recorrer, casillas_Recorrer, 0, 0};
		int [] array_Y = {0, 0, casillas_Recorrer, -1*casillas_Recorrer};
		
		
		
		/*
		ArrayList <MOVEMENT> direccion_Movimiento = new ArrayList<MOVEMENT> ();
		direccion_Movimiento.add(MOVEMENT.LEFT);
		direccion_Movimiento.add(MOVEMENT.RIGHT);
		direccion_Movimiento.add(MOVEMENT.DOWN);
		direccion_Movimiento.add(MOVEMENT.UP);
		*/
	}
}
