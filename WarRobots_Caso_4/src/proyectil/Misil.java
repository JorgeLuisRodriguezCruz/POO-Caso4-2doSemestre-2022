package proyectil;

import java.io.Serializable;

import common.robotBase.IProyectil;
import common.robotBase.ORIENTATION;

public class Misil extends IProyectil implements Serializable{
	public Misil(int pNivel, ORIENTATION pDireccion_Movimiento, int pPos_X, int pPos_Y, int pDistancia) {
		super(pNivel, pDireccion_Movimiento, pPos_X, pPos_Y, pDistancia, "/Misil.png");
	}

}
