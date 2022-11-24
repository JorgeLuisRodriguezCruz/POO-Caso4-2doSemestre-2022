package robots;

import java.awt.Graphics;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import common.robotBase.IRobot;
import common.robotBase.MOVEMENT;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;
import utils.IObserver;
import utils.Observable;

public class IshimuraKiller2001 extends IRobot implements IObserver, Serializable{
	private String imagen;
	private int nivel;

	public IshimuraKiller2001(int pNnivel, int pEnergy, int pVelocidad) {
		super(ORIENTATION.SOUTH, pVelocidad);
		
		this.nivel = pNnivel;
		this.energy = pEnergy;
		this.imagen = "C:/Users/Usuario/Documents/GitHub/POO-Caso4-2doSemestre-2022/WarRobots_Caso_4/src/Rufuss.png";
	}

	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		LocalTime ahora = LocalTime.now();
		int tiempo_Transcurrido = pActionTime.getSecond() - ahora.getSecond();
		int casillas_Recorrer = tiempo_Transcurrido * this.speed;
		
		int [] array_X = {-1*casillas_Recorrer, casillas_Recorrer, 0, 0};
		int [] array_Y = {0, 0, casillas_Recorrer, -1*casillas_Recorrer};
		
		this.posX = array_X [pMove.getValue()];
		this.posY = array_Y [pMove.getValue()];
	}
	
	public void damageAux(int pLevel) {
		
		ArrayList<Weapon> weapon_And_Strikes= new ArrayList<Weapon>();
		
		Arrays.stream(weapons).forEach(x->weapon_And_Strikes.add(x));
		Arrays.stream(strikes).forEach(x->weapon_And_Strikes.add(x));
		
		int indiceRandom_WAS = (int)(Math.random()*(weapon_And_Strikes.size()+1)+0);
		
		if (indiceRandom_WAS > weapon_And_Strikes.size()) {
			weapon_And_Strikes.get(indiceRandom_WAS).hitDamage(pLevel);
		} else {
			int indiceRandom_Dir = (int)(Math.random()*(4)+0);
			this.directionsdamage[indiceRandom_Dir].hitDamage(pLevel);
		}
	}

	@Override
	public void damage (int pLevel) {

		int indiceRandom_Dir = (int)(Math.random()*(4)+0);
		int[][] array = {{1,2},{3,4,5,6,7,8},{9,10}};
		Arrays.stream(array[0]).filter(x->x==pLevel).forEach(x->this.energy-=x);
		Arrays.stream(array[1]).filter(x->x==pLevel).forEach(x->damageAux(pLevel));
		Arrays.stream(array[2]).filter(x->x==pLevel).forEach(x->this.directionsdamage[ indiceRandom_Dir ].hitDamage(pLevel));
	}

	@Override
	public void update(Observable pObservable, Object args) {
		/*
		SimulatorReport simReport = (SimulatorReport)args;
		simReport.posX1= posX;
		simReport.posX1= posY;
		*/
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
}

