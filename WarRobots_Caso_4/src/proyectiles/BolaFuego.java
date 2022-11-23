package proyectiles;

import java.io.Serializable;

import common.robotBase.IProyectil;
import common.robotBase.ORIENTATION;

public class BolaFuego extends IProyectil implements Serializable{

	public BolaFuego(int pNivel, ORIENTATION pDireccion_Movimiento, int pPos_X, int pPos_Y, int pDistancia) {
		super(pNivel, pDireccion_Movimiento, pPos_X, pPos_Y, pDistancia, "/FireBall.png");
	}

}
