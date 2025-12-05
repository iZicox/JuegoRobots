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
	
	//MÉTODOS
	//Bienvenida
	void bienvenida() {
		System.out.println("---BIENVENIDOS A ROBOT WARS");
	}
	//Configuración de los Robots
	void configuramosRobots() {
		System.out.println("Esta noche tenemos por un lado al mítico " + robot1.getNombre() + " armado con " + robot1.getArma().getNombre());
		System.out.println("Y por otro lado contamos con el aspirante invicto " + robot2.getNombre() + " armado con " + robot2.getArma().getNombre());
		System.out.println("¡Comienza el combate!");
		System.out.println(robot1.getNombre() + " VS " + robot2.getNombre());
		
	}
	//Combate
	void combatePorRondas(Scanner teclado) {
		while (robot1.estaVivo() && robot2.estaVivo()) {

			System.out.print("Pulsa ENTER para la siguiente ronda...");
			teclado.nextLine();

			// robot1 ataca primero
			robot1.atacar(robot2);

			if (!robot2.estaVivo()) {
				break;
			}
			//robot2 continua atacando
			robot2.atacar(robot1);
		}
	}
	
	//Ganador
	void ganador() {
		System.out.println("=== FIN DEL COMBATE ===");
        if (robot1.estaVivo()) {
            System.out.println("¡El ganador es " + robot1.getNombre() + "!");
        } else {
            System.out.println("¡El ganador es " + robot2.getNombre() + "!");
        }
	}
	
	
	

}
