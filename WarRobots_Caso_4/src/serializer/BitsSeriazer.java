package serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import customizedWeapon.LatigoElemental;
import customizedWeapon.TijeraVoladora;
import customizedWeapon.VolcanMiniatura;
import proyectil.BolaFuego;
import robot.IshimuraKiller2001;

public class BitsSeriazer {
	private String direccion_RobotIshimura;
	private String direccion_TijeraVoladora;
	private String direccion_LatigoElemental;
	private String direccion_VolcanMiniatura;
	
	private IshimuraKiller2001 ishimura;
	private TijeraVoladora tijeras;
	private LatigoElemental latigo;
	private VolcanMiniatura volcan;
	
	public BitsSeriazer() {
		this.direccion_RobotIshimura = "IshimuraKiller2001.txt";
		this.direccion_TijeraVoladora = "TijerasVoladora.txt";
		this.direccion_LatigoElemental = "LatigoElemental.txt";
		this.direccion_VolcanMiniatura = "VolcanMiniatura.txt";
		
		this.ishimura = new IshimuraKiller2001(10, 1000, 5);
		this.tijeras = new TijeraVoladora(7, 6);
		this.latigo = new LatigoElemental(10, 4);
		this.volcan = new VolcanMiniatura(7, 8, 7);
		
		inicializar ();
	}
	
	public void inicializar() {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( this.direccion_RobotIshimura ));
            file.writeObject(this.ishimura);
            file.close();
            
            file = new ObjectOutputStream(new FileOutputStream( this.direccion_TijeraVoladora));
            file.writeObject(this.tijeras);
            file.close();
            
            file = new ObjectOutputStream(new FileOutputStream( this.direccion_LatigoElemental ));
            file.writeObject(this.latigo);
            file.close();
            
            file = new ObjectOutputStream(new FileOutputStream( this.direccion_VolcanMiniatura ));
            file.writeObject(this.volcan);
            file.close();
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public IshimuraKiller2001 getIshimuraRobot ()
    {
    	
        try {
        	ObjectInputStream file = new ObjectInputStream(new FileInputStream( this.direccion_RobotIshimura ));
            IshimuraKiller2001 ishimura = (IshimuraKiller2001) file.readObject();
            file.close();
            return ishimura;
            
        } catch (ClassNotFoundException ex) {
             System.out.println(ex);
             return null;
        } catch (IOException ex) {
             System.out.println(ex);
             return null;
        }
    }
    
    public TijeraVoladora getTijeras () {	
        try {
        	ObjectInputStream file = new ObjectInputStream(new FileInputStream( this.direccion_TijeraVoladora ));
        	TijeraVoladora tijera = (TijeraVoladora) file.readObject();
            file.close();
            return tijera;
            
        } catch (ClassNotFoundException ex) {
             System.out.println(ex);
             return null;
        } catch (IOException ex) {
             System.out.println(ex);
             return null;
        }
    }
    
    public LatigoElemental getLatigo () {
        try {
        	ObjectInputStream file = new ObjectInputStream(new FileInputStream( this.direccion_LatigoElemental));
        	LatigoElemental latigo = (LatigoElemental) file.readObject();
            file.close();
            return latigo;
            
        } catch (ClassNotFoundException ex) {
             System.out.println(ex);
             return null;
        } catch (IOException ex) {
             System.out.println(ex);
             return null;
        }
    }
    
    public VolcanMiniatura getVolcan () {
        try {
        	ObjectInputStream file = new ObjectInputStream(new FileInputStream( this.direccion_VolcanMiniatura));
        	VolcanMiniatura volcan = (VolcanMiniatura) file.readObject();
            file.close();
            return volcan;
            
        } catch (ClassNotFoundException ex) {
             System.out.println(ex);
             return null;
        } catch (IOException ex) {
             System.out.println(ex);
             return null;
        }
    }

    public void serializar (IshimuraKiller2001 pIsimura) {
    	try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( this.direccion_RobotIshimura ));
            file.writeObject( pIsimura );
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void serializar (LatigoElemental pLatigo) {
    	try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( this.direccion_LatigoElemental ));
            file.writeObject( pLatigo );
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void serializar (TijeraVoladora pTijeras) {
    	try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( this.direccion_TijeraVoladora ));
            file.writeObject( pTijeras );
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void serializar (VolcanMiniatura pVolcan) {
    	try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( this.direccion_VolcanMiniatura ));
            file.writeObject( pVolcan );
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
