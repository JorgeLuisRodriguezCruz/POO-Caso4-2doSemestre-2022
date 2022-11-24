package serializer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;

import common.IRobot;
import common.robotBase.Weapon;
import imagenes.GeneralData;
import robot.PX0;


public class GsonSerialized {
	public GeneralData data;
	public Gson gson;
	public PX0 robot;
	
	
	public GsonSerialized() {
		ArrayList <Weapon> arcenal = new ArrayList <Weapon>();
		
		
		gson = new GsonBuilder()
	            .setPrettyPrinting()
	            .serializeNulls()
	            .create();
		
		
		
		  
		
		
		//Deserializado
		/*
		try {
			p = gson.fromJson(new FileReader("C:\\Users\\Usuario\\Desktop\\Poo\\Caso #4\\POO-Caso4-2doSemestre-2022\\WarRobots_Caso_4\\src\\Robot.json"), IRobot.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		try {
			data = gson.fromJson(new FileReader("C:\\Users\\Usuario\\Desktop\\Poo\\Caso #4\\POO-Caso4-2doSemestre-2022\\WarRobots_Caso_4\\src\\imagenes\\Imagenes.json"), GeneralData.class);
			System.out.println("Background: "+ data.getBackground()+"\n Robot1: "+data.getRobot1());
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			((Throwable) e).printStackTrace();
			data = new GeneralData();
		}
		
		try {
			robot = gson.fromJson(new FileReader("C:\\Users\\Usuario\\Desktop\\POO-Caso4-2doSemestre-2022\\WarRobots_Caso_4\\src\\PX0.json"), PX0.class);
			System.out.println("Background: "+ data.getBackground()+"\n Robot1: "+data.getRobot1());
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			((Throwable) e).printStackTrace();
			robot = new PX0();
		}
		
		
		//Serializado
		
		String jsonString = gson.toJson(data);
		
		
		System.out.println("Converted ImageData object to JSON string:\n" + jsonString);
		//IRobot robot1 = gson.fromJson(jsonString, IRobot.class);
	
		
	}
	
	
	
}
