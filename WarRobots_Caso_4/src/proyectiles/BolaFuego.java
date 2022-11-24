package proyectiles;

import java.io.Serializable;

import common.robotBase.IProyectil;
import common.robotBase.ORIENTATION;

public class BolaFuego extends IProyectil implements Serializable{
	private String imagen;

	public BolaFuego(int pNivel, ORIENTATION pDireccion_Movimiento, int pPos_X, int pPos_Y, int pDistancia) {
		super(pNivel, pDireccion_Movimiento, pPos_X, pPos_Y, pDistancia, "/FireBall.png");
		this.imagen = "C:/Users/Usuario/Documents/GitHub/POO-Caso4-2doSemestre-2022/WarRobots_Caso_4/src/FireBall.png";
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
