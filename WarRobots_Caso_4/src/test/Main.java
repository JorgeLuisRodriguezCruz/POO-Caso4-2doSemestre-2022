package test;

import Interface.UIWindow;
import controller.Controller;
import serializer.GsonSerialized;
import simulation.Simulator;

import java.util.ArrayList;
import java.util.Arrays;

import serializer.GsonSerialized;

public class Main {

	public static void main(String[] args) {
		//ControllerArena controlador = new ControllerArena();
		//PantallaArena vista = new PantallaArena("Titulo de ejemplo", controlador);
		
		//GsonSerialized g=new GsonSerialized();

		UIWindow ejemplo = new UIWindow();
		ejemplo.Simular();
		
		
		
		
		
		/*
		//StatusManager manager = new StatusManager();
		Simulator sim = Simulator.getInstance();
		
		
		//sim.addObserver(manager);
		//sim.addObserver(controller);
		
		Thread simThread = new Thread(sim);
		simThread.start();
		
		*/
		
		
		
		
		
		
		
		/*
		System.out.println("Di las palabras.");
		
		int clave_prueba = 12;
		boolean bandera = false;
		boolean bandera_Dos = false;
		
		ArrayList<Integer> numeros = new ArrayList<Integer> ();
		
		numeros.add(1);
		numeros.add(5);
		numeros.add(14);
		numeros.add(55);
		numeros.add(13);
		
		int [] intArray = {2, 4, 6};
		
		clave_prueba = numeros.stream().filter(numero->numero==14).findFirst().orElse(-1);
		
		System.out.println("Esto ers lo que encontramoh -> "+clave_prueba);
		bandera = numeros.stream().anyMatch(numero->numero==1);
		
		bandera_Dos = Arrays.stream(intArray).anyMatch(entero->entero==32);
		
		if(bandera)
			System.out.println("SI");
		else
			System.out.println("NO");
		
		if(bandera_Dos)
			System.out.println("SI_Dos");
		else
			System.out.println("NO_Dos");
		//Arrays.stream(int_array).filter(x->x==clave_prueba).forEach(x->bandera=0);
		*/
	}
}
