package test;

import robots.IshimuraKiller2001;
import serializer.BitsSeriazer;

public class TestBitSerealizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Waaaaght");
		
		BitsSeriazer bitSerializador = new BitsSeriazer();
		IshimuraKiller2001 kk = bitSerializador.getIshimuraRobot();
		
		if (kk!=null) {
			System.out.println("He visto la luz ->" + kk.getNivel());
		}
		System.out.println("End");

	}

}
