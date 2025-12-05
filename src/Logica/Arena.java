package Logica;

import java.util.Random;
import java.util.Scanner;

public class Arena {
	//Atributos
	private String nombreRobot1;
	private String nombreRobot2;
	
	//Array de armas
	Arma[] armas = {
		new Arma("Motosierra de plasma", 15),
		new Arma("Cañón de pulsos", 18),
		new Arma("Espada infinita", 10),
		new Arma("Martillo neumático", 12),
		new Arma("Garras de titanio", 10),
		new Arma("Látigo eléctrico", 11),
		new Arma("Pistola nuclear", 12),
		new Arma("Lanza de diamante", 11),
		new Arma("Escopeta sónica", 14),
		new Arma("Lanzallamas fundente", 15),
		new Arma("Puños de acero", 10),
	};
	
	
	//Método obtener arma aleatoria
	public static Arma obtenerArmaAleatoria(Arma[] armas) {
        Random aleatorio = new Random();
        int indice = aleatorio.nextInt(armas.length);
        return armas[indice];
    }
	
	//Método dar nombre a los robots
	public void nombrarRobots(String nombreRobot1, String nombreRobot2, Scanner teclado) {
		System.out.print("Introduce el nombre del Robot 1: ");
		nombreRobot1 = teclado.nextLine();
		System.out.print("Introduce el nombre del Robot 2: ");
		nombreRobot2 = teclado.nextLine();
	}
	
	//Creamos los objetos robot
	Robot robot1 = new Robot(nombreRobot1, obtenerArmaAleatoria(armas));
	Robot robot2 = new Robot(nombreRobot2, obtenerArmaAleatoria(armas));
	
	void bienvenida() {
		System.out.println("---BIENVENIDOS A ROBOT WARS");
	}
	void configuramosRobots() {
		
	}
	
	
	

}
