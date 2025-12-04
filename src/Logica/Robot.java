package Logica;

public class Robot {
	
	public Robot() {
		vida = 100;
	}
	

	private String nombre;
	private int vida;	//Valor inicial del número de vidas
	private Arma arma;
	
	//Constructor que recibe nombre y arma
	public Robot(String nombre, Arma arma) {
		this.nombre = nombre;
		setVida();
	}
	
	public Robot(String nombre) {
		this.nombre = nombre;
		this.arma = new Arma("Puños de Acero", 10);
	}
	
	//Getters y Setters
	public int getVida() {
		return vida;
	}

	private void setVida() {
		this.vida = 100;
		
	}
	//-----------------------------------
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	
	//Métodos
	
	void atacar(Robot robot) {
		int factorSuerte = (int) (Math.random() * 8);
		int danio = arma.getPotencia() + factorSuerte;
		String mensaje = nombre + " ataca a " + robot.nombre + " con " + arma.getNombre() + "...";
		System.out.println(mensaje);
		robot.recibirDanio(danio);
	}
	
	void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) {
        	vida = 0;
        }
        System.out.println(" --- " + nombre + " recibe " + cantidad + " puntos de daño. Vida restante: " + vida);
    }
	
	boolean estaVivo() {
        return vida > 0;
    }
	
	@Override
	public String toString() {
		return nombre + " armado con " + arma;
	}
	
}

