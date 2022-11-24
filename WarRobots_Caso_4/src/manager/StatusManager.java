package manager;

import java.util.Scanner;

import common.robotBase.IRobot;
import common.robotBase.Weapon;
import customizedWeapon.WeaponsFactory;
import robot.PX0;
import serializer.BitsSeriazer;
import serializer.GsonSerialized;
import utils.IObserver;
import utils.Observable;

public class StatusManager implements IObserver{
	PX0 robot;
	Weapon[] traps= new Weapon[2];
	GsonSerialized gsonS;
	BitsSeriazer bits;
	
	public StatusManager() {
		gsonS= new GsonSerialized();
		bits= new BitsSeriazer();
		Weapon strike1= WeaponsFactory.create(gsonS.data.getStrike1(), gsonS.data.getSpeedS1(), gsonS.data.getLevelS1(), gsonS.data.getDistanceS1());
		Weapon strike2= WeaponsFactory.create(gsonS.data.getStrike2(), gsonS.data.getSpeedS2(), gsonS.data.getLevelS2(), gsonS.data.getDistanceS2());
		Weapon weapon= WeaponsFactory.create(gsonS.data.getWeapon(), gsonS.data.getSpeedW1(), gsonS.data.getLevelW1(), gsonS.data.getDistanceW1());
		
		robot=gsonS.robot;
		robot.addStrike(strike1);
		robot.addStrike(strike2);
		robot.addWeapon(weapon);
		
	}

	
	@Override
	public void update(Observable pObservable, Object args) {
		
		
	}

}
