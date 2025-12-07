package Logica;

import java.util.Scanner;
/**
 * Clase principal que gestiona la logica del combate entre dos robots.
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
	
	
	/**
	 * Obtiene un indice aleatorio de un arma disponible en el array.
	 * 
	 * @param armas (Array clase {@link Arma}
	 * @return indice (Integer): índice aleatorio para el arma en cuestión no nula
	 * @see Util#sorteo(int, int)
	 */
	public static int obtenerArmaAleatoria(Arma[] armas) {
		while(true) {
			int indice = Util.sorteo(INICIO_ARMA_ALEATORIA,armas.length-1);
			if(armas[indice] != null) {
				return indice;
			}	
		}
    }
	
	/**
	 * Inicializa el combate entre dos robots. Solicita los nombres a los jugadores,
	 * asigna armas aleatorias, muestra la presentación del combate y determina qué
	 * robot inicia el enfrentamiento.
	 *
	 * @param sc {@link Scanner} utilizado para leer la entrada del usuario.
	 * @see Util#leerCadena(String, int, int, Scanner)
     * @see Util#lanzarMoneda()
	 */
	private static void iniciarCombate(Scanner sc) {
		System.out.println("****************BIENVENIDOS A ROBOT WARS****************");

		Arma[] armas = creacionArmas();
		
		String nombreRobot1 = Util.leerCadena("Introduce el nombre del robot 1: ", 3, 20, sc);
		String nombreRobot2 = Util.leerCadena("Introduce el nombre del robot 2: ", 3, 20, sc);
		
		int indiceArmaRobot1 = obtenerArmaAleatoria(armas);
		Arma armaRobot1 = new Arma(armas[indiceArmaRobot1]);
		Robot robot1 = new Robot(nombreRobot1,armaRobot1);
		armas[indiceArmaRobot1] = null;
		
		int indiceArmaRobot2 = obtenerArmaAleatoria(armas);
		Arma armaRobot2 = new Arma(armas[indiceArmaRobot2]);
		Robot robot2 = new Robot(nombreRobot2,armaRobot2);
		armas[indiceArmaRobot2] = null;
		
		System.out.println("Esta noche tenemos por un lado al mítico " + robot1.getNombre() + " armado con " + robot1.getArma().getNombre());
		System.out.println("Y por otro lado contamos con el aspirante invicto " + robot2.getNombre() + " armado con " + robot2.getArma().getNombre());
		System.out.println("¡Comienza el combate!");
		System.out.println(robot1.getNombre() + " VS " + robot2.getNombre());
		System.out.println("-------------------------------------------------");
		
		//sorteo de quien inicia
		System.out.println("Lancemos una moneda a ver quien inicia esta pelea del siglo!!!");
		System.out.printf("Cara para %s y sello para %s . . .\n",robot1.getNombre(),robot2.getNombre());
		System.out.println("Lanzando moneda al aire . . .");
		
		if(Util.lanzarMoneda()) {
			
			System.out.printf("Ha caido CARA. Empieza %s.\n",robot1.getNombre());
			
			combatePorRondas(sc, robot1, robot2);
			
		}else {
			
			System.out.printf("Ha caido CRUZ. Empieza %s.\n",robot2.getNombre());
			
			combatePorRondas(sc, robot2, robot1);
			
		}
		
		ganador(robot1, robot2);
		
		
	}
	

	/**
	 * Controla el combate por rondas entre dos robots. El robot indicado como
	 * robot1 ataca primero, seguido por robot2, alternando turnos hasta que uno
	 * de los dos deja de estar vivo.
	 *
	 * @param teclado objeto {@link Scanner} para pausar la ejecución esperando pulsación de ENTER.
	 * @param robot1 Robot que inicia atacando en la primera ronda.
	 * @param robot2 Robot que recibe el primer ataque.
	 * @see Util#ambosVivos(Robot, Robot)
	 */
	private static void combatePorRondas(Scanner teclado, Robot robot1, Robot robot2) {
		
		while (Util.ambosVivos(robot1, robot2)) {

			System.out.print("Pulsa ENTER para continuar.");
			teclado.nextLine();

			// robot1 ataca primero
			robot1.atacar(robot2);

			//verifica si alguien murio
			if (!Util.ambosVivos(robot1, robot2)) {
				break;
			}
			System.out.print("Pulsa ENTER para continuar.");
			teclado.nextLine();
			
			//robot2 continua atacando
			robot2.atacar(robot1);
			
			//verifica si alguien murio
			if (!Util.ambosVivos(robot1, robot2)) {
				break;
			}
		}
	}
	
	/**
     * Determina y muestra el ganador del combate.
     *
     * @param robot1 primer robot participante.
     * @param robot2 segundo robot participante.
     * @see Robot#estaVivo()
     */

	private static void ganador(Robot robot1, Robot robot2) {
		System.out.println("=== FIN DEL COMBATE ===");
        if (robot1.estaVivo()) {
            System.out.println("¡El ganador es " + robot1.getNombre() + "!");
        } else {
            System.out.println("¡El ganador es " + robot2.getNombre() + "!");
        }
	}
	
	/**
	 * Metodo principal del programa. Crea el scanner necesario 
	 * para el combate e inicia la ejecución de la arena de batalla.
	 *
	 * @param args Argumentos recibidos desde la línea de comandos (no utilizados).
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		iniciarCombate(sc);
		
		
		
	}
	

}
