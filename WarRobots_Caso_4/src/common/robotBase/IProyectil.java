package common.robotBase;

public class IProyectil {
	private int nivel;
	private MOVEMENT direccion_Movimiento;
	private int pos_X;
	private int pos_Y;
	private int distancia;
	private String URL_Proyecil;
	
	public IProyectil(int pNivel, MOVEMENT pDireccion_Movimiento, int pPos_X, int pPos_Y, int pDistancia, String pURL_Proyecil) {
		
		this.nivel = pNivel;
		this.direccion_Movimiento = pDireccion_Movimiento;
		this.pos_X = pPos_X;
		this.pos_Y = pPos_Y;
		this.distancia = pDistancia;
		this.URL_Proyecil = pURL_Proyecil;
	}
	
	public void move () {
		if(this.distancia > 0){
			int [] array_X = {-1, 1, 0, 0};
			int [] array_Y = {0, 0, 1, -1};
			
			this.pos_X = array_X [this.direccion_Movimiento.getValue()];
			this.pos_Y = array_Y [this.direccion_Movimiento.getValue()];
			
			this.distancia-=1;
		}
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPos_X() {
		return pos_X;
	}

	public void setPos_X(int pos_X) {
		this.pos_X = pos_X;
	}

	public int getPos_Y() {
		return pos_Y;
	}

	public void setPos_Y(int pos_Y) {
		this.pos_Y = pos_Y;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getURL_Proyecil() {
		return URL_Proyecil;
	}

	public void setURL_Proyecil(String uRL_Proyecil) {
		URL_Proyecil = uRL_Proyecil;
	}
	
	
	

}
