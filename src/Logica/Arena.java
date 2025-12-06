package Logica;

import java.util.Scanner;
/**
 * @author Francisco Antonio Rosales Mangano
 * @author Antonio Manuel Otero de Antonio
 */
public class Arena {
	
	private static final int INICIO_ARMA_ALEATORIA = 0;
	
	//Array de armas autogenerado del enum
	private static Arma[] creacionArmas() {
		TipoArma[] arsenal = TipoArma.values();
		Arma[] armas = new Arma[arsenal.length];
		
		for(int i = 0; i < armas.length; i++) {
			armas[i] = new Arma(arsenal[i]);
		}
		return armas;
	}
	
	//Método obtener arma aleatoria
	public static int obtenerArmaAleatoria(Arma[] armas) {
		while(true) {
			int indice = Util.sorteo(INICIO_ARMA_ALEATORIA,armas.length-1);
			if(armas[indice] != null) {
				return indice;
			}	
		}
    }
	
	
	
	
	//MÉTODOS
	//Bienvenida
	private static void iniciarCombate(Scanner sc) {
		System.out.println("****************BIENVENIDOS A ROBOT WARS****************");

		Arma[] armas = creacionArmas();
		
		String nombreRobot1 = Util.leerCadena("Introduce el nombre del robot 1: ", 3, 20, sc);
		String nombreRobot2 = Util.leerCadena("Introduce el nombre del robot 2: ", 3, 20, sc);
		
		int indiceArmaRobot1 = obtenerArmaAleatoria(armas);
		Arma armaRobot1 = new Arma(armas[indiceArmaRobot1]);
		Robot robot_1 = new Robot(nombreRobot1,armaRobot1);
		armas[indiceArmaRobot1] = null;
		
		int indiceArmaRobot2 = obtenerArmaAleatoria(armas);
		Arma armaRobot2 = new Arma(armas[indiceArmaRobot2]);
		Robot robot_2 = new Robot(nombreRobot2,armaRobot2);
		armas[indiceArmaRobot2] = null;
		
		System.out.println("Esta noche tenemos por un lado al mítico " + robot_1.getNombre() + " armado con " + robot_1.getArma().getNombre());
		System.out.println("Y por otro lado contamos con el aspirante invicto " + robot_2.getNombre() + " armado con " + robot_2.getArma().getNombre());
		System.out.println("¡Comienza el combate!");
		System.out.println(robot_1.getNombre() + " VS " + robot_2.getNombre());
		System.out.println("-------------------------------------------------");
		//sorteo de quien inicia
		System.out.println("Lancemos una moneda a ver quien inicia esta pelea del siglo!!!");
		System.out.printf("Cara para %s y sello para %s . . .\n",robot_1.getNombre(),robot_2.getNombre());
		System.out.println("Lanzando moneda al aire . . .");
		if(Util.lanzarMoneda()) {
			System.out.printf("Ha caido CARA. Empieza %s.\n",robot_1.getNombre());
			combatePorRondas(sc, robot_1, robot_2);
		}else {
			System.out.printf("Ha caido CRUZ. Empieza %s.\n",robot_2.getNombre());
			combatePorRondas(sc, robot_2, robot_1);
		}
		
		ganador(robot_1, robot_2);
		
		
	}
	

	//Combate. El robot_1 inicia el combate
	private static void combatePorRondas(Scanner teclado, Robot robot_1, Robot robot_2) {
		
		while (Util.ambosVivos(robot_1, robot_2)) {

			System.out.print("Pulsa ENTER para continuar.");
			teclado.nextLine();

			// robot1 ataca primero
			robot_1.atacar(robot_2);

			//verifica si alguien murio
			if (!Util.ambosVivos(robot_1, robot_2)) {
				break;
			}
			System.out.print("Pulsa ENTER para continuar.");
			teclado.nextLine();
			
			//robot2 continua atacando
			robot_2.atacar(robot_1);
			
			//verifica si alguien murio
			if (!Util.ambosVivos(robot_1, robot_2)) {
				break;
			}
		}
	}
	
	//Ganador/*
	private static void ganador(Robot robot_1, Robot robot_2) {
		System.out.println("=== FIN DEL COMBATE ===");
        if (robot_1.estaVivo()) {
            System.out.println("¡El ganador es " + robot_1.getNombre() + "!");
        } else {
            System.out.println("¡El ganador es " + robot_2.getNombre() + "!");
        }
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		iniciarCombate(sc);
		
		
		
	}
	

}
