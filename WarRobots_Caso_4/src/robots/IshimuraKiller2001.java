package robots;

import java.awt.Graphics;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import common.robotBase.IRobot;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;
import utils.IObserver;
import utils.Observable;

public class IshimuraKiller2001 extends IRobot implements IObserver, Serializable{
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
	
	
}


/*
 implements IObserver{
	ArrayList<MOVEMENT>  direcciones;
	ArrayList<ORIENTATION>  orientacion;
	int pix_recorridos;
	
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
		
		int randomDir= (int)(Math.random()*((ORIENTATION.values().length-1)-0+1)+0); //numero random entre la cantidad de direcciones (indices para directiondamage)
		
		int[][] array = {{1,2},{3,4,5,6,7,8},{9,10}};
		Arrays.stream(array[0]).filter(x->x==pLevel).forEach(x->this.energy-=x);
		Arrays.stream(array[1]).filter(x->x==pLevel).forEach(x->  damageAux(pLevel,randomDir) );
		Arrays.stream(array[2]).filter(x->x==pLevel).forEach(x->this.directionsdamage[ randomDir ].hitDamage(pLevel));
		
	}

	public void damageAux(int pLevel,int randomDir) {
		ArrayList<Weapon> weaponA= new ArrayList<Weapon>();
		Arrays.stream(weapons).forEach(x-> weaponA.add(x));
		Arrays.stream(strikes).forEach(x-> weaponA.add(x));
		int random= (int)(Math.random()*(2-0+1)+0); //random para elegir si se daña un arma, golpe o disparo
		int randomWeapon= (int)(Math.random()*((weapons.length+strikes.length-1)-0+1)+0);
		if(random<2){ 
			weaponA.get(randomWeapon).hitDamage(pLevel);  
		}else if(random==2){
			this.directionsdamage[ randomDir ].hitDamage(pLevel); 
		}
	}
	
	@Override
	public void update(Observable pObservable, Object args) {
		SimulatorReport simReport = (SimulatorReport)args;
		simReport.posX1= posX;
		simReport.posX1= posY; 
	}
 
 */

