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
import simulation.SimulatorReport;
import utils.IObserver;
import utils.Observable;

public class PX0 extends IRobot implements IObserver{
	ArrayList<MOVEMENT>  direcciones;
	ArrayList<ORIENTATION>  orientacion;
	int pix_recorridos;
	
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
		SimulatorReport simReport = (SimulatorReport)arg;
		simReport.posX1= posX;
		simReport.posX1= posY; 
	}
	
	
}
