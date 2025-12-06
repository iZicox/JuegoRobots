package Logica;

import java.util.Scanner;
/**
 * Clase principal que gestiona la lógica del combate entre dos robots.
 * Se encarga de crear las armas, asignarlas aleatoriamente a los robots,
 * iniciar el combate, controlar los turnos y anunciar al ganador.
 * 
 * @author Francisco Antonio Rosales Mangano
 * @author Antonio Manuel Otero de Antonio
 * @version 1.0
 */

public class Arena {
	
	/** Valor inicial para el sorteo del índice de un arma aleatoria. */
	private static final int INICIO_ARMA_ALEATORIA = 0;
	
	/**
	 * Genera un array de armas a partir de las constantes definidas en {@link TipoArma}
	 * 
	 * @return un array de todas las armas disponibles tipo (Objeto de la clase Arma)
	 */
	private static Arma[] creacionArmas() {
		TipoArma[] arsenal = TipoArma.values();
		Arma[] armas = new Arma[arsenal.length];
		
		for(int i = 0; i < armas.length; i++) {
			armas[i] = new Arma(arsenal[i]);
		}
		return armas;
	}
	
	//Método obtener arma aleatoria
	
	/**
	 * 
	 * @param armas (Array clase Arma)
	 * @return indice (Integer): índice aleatorio para el arma en cuestión
	 */
	public static int obtenerArmaAleatoria(Arma[] armas) {
		while(true) {
			int indice = Util.sorteo(INICIO_ARMA_ALEATORIA,armas.length-1);
			if(armas[indice] != null) {
				return indice;
			}	
		}
    }
	
	
	
	
	//MÉTODOS
	
	/**
	 * Inicializa el combate entre dos robots. Solicita los nombres a los jugadores,
	 * asigna armas aleatorias, muestra la presentación del combate y determina qué
	 * robot inicia el enfrentamiento.
	 *
	 * @param sc Scanner utilizado para leer la entrada del usuario.
	 */
	
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
	/**
	 * Controla el combate por rondas entre dos robots. El robot indicado como
	 * robot_1 ataca primero, seguido por robot_2, alternando turnos hasta que uno
	 * de los dos deja de estar vivo.
	 *
	 * @param teclado Scanner para pausar la ejecución esperando pulsación de ENTER.
	 * @param robot_1 Robot que inicia atacando en la primera ronda.
	 * @param robot_2 Robot que recibe el primer ataque.
	 */
	
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
	
	/**
	 * Método principal del programa. Crea el scanner necesario 
	 * para el combate e inicia la ejecución de la arena de batalla.
	 *
	 * @param args Argumentos recibidos desde la línea de comandos (no utilizados).
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		iniciarCombate(sc);
		
		
		
	}
	

}
