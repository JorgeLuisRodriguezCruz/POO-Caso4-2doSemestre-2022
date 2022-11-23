package robots;

import java.awt.Graphics;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import common.IRobot;
import common.robotBase.DamageLevel;
import common.robotBase.MOVEMENT;
import common.robotBase.ORIENTATION;
import common.robotBase.Weapon;
import simulation.SimulatorReport;
import utils.IObserver;
import utils.Observable;

import com.google.common.primitives.Booleans;

public class PX0 extends IRobot implements IObserver{
	int pixRecorridos;
	int numeroRobot;
	
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
		
		DamageLevel up = new DamageLevel();
		DamageLevel down = new DamageLevel();
		DamageLevel right = new DamageLevel();
		DamageLevel left = new DamageLevel();
		
		directionsdamage[0]= left;
		directionsdamage[1]= right;
		directionsdamage[2]= up;
		directionsdamage[3]= down;
	}
	
	
	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		if(directionsdamage[pMove.getValue()].isEnabled()) {
			
			int actTime= LocalTime.now().getSecond()- pActionTime.getSecond();
			int pixMov = actTime*this.speed;
			
			int [] arrayX = {-1*pixMov, pixMov, 0, 0};
			int [] arrayY = {0, 0, -1*pixMov, pixMov};
			
			
			int oldX = posX;
			int oldY = posY;
			
			this.posX += arrayX [pMove.getValue()];
			this.posY += arrayY [pMove.getValue()];
			int [] pos = {posX,posY};
			Arrays.stream(pos).filter(x->x<0).forEach(x->x=0);	
			if(posX>ARENA_WIDTH) {
				posX = ARENA_WIDTH;
			}else if(posY>ARENA_HEIGTH){
				posY = ARENA_HEIGTH;
			}
			
			
			pixRecorridos+= Math.abs(posX-oldX)+Math.abs(posY-oldY);
		}
		gastoEnergia();
	}

	private void gastoEnergia() {
		while(pixRecorridos>=1000) {
			pixRecorridos-=1000;
			this.energy-=1;
		}
		
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
		if(numeroRobot==1) {
			Stream<Boolean> stream = new AbstractList<Boolean>() {
				  public Boolean get(int index) {return (simReport.strikes1[index]);}
				  public int size() {return simReport.strikes1.length;}
				}.stream();
			stream.forEach(x-> x= strikes[Booleans.indexOf(simReport.strikes1, x)].isEnabled() ); //
			//simReport.weapons1=;
		}else if(numeroRobot==2){
			
		}
		//simReport.strikes1.stream().;
		//simReport.weapon1=;
		
	}
	
	
}
