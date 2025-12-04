package Logica;

import java.util.Random;

public class Robot {
	
	/*public Robot() {
		vidas = 100;
	}*/
	
	private String nombre;
	private int vidas;
	private Arma arma;
	
	//Constructor que recibe nombre y arma
	public Robot(String nombre, Arma arma) {
		this.nombre = nombre;
		this.arma = arma;
	}
	
	
	//Métodos
	void atacar(Robot robot) {
		Random rand = new Random();
		int factorSuerte = rand.nextInt(7)+1;
		//int danioCausado = TipoArma.getPotencia() + factorSuerte;
		String mensaje; 
	}
	
	
}

