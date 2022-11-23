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
import imagenes.ImageData;


public class GsonSerialized {
	public ImageData image;
	
	public GsonSerialized() {
		
		
		ArrayList <Weapon> arcenal = new ArrayList <Weapon>();
		//IRobot p;
		
		Gson gson = new GsonBuilder()
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
			image = gson.fromJson(new FileReader("C:\\Users\\Usuario\\Desktop\\Poo\\Caso #4\\POO-Caso4-2doSemestre-2022\\WarRobots_Caso_4\\src\\imagenes\\Imagenes.json"), ImageData.class);
			System.out.println("Background: "+ image.getBackground()+"\n Robot1: "+image.getRobot1());
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			((Throwable) e).printStackTrace();
			image = new ImageData();
		}
		
		
		
		//Serializado
		
		String jsonString = gson.toJson(image);
		
		
		System.out.println("Converted ImageData object to JSON string:\n" + jsonString);
		//IRobot robot1 = gson.fromJson(jsonString, IRobot.class);
	
		
	}
	
}
