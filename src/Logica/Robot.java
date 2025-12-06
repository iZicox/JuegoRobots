package Logica;

/**
 * 
 * @author Francisco Antonio Rosales Mangano
 * @author Antonio Manuel Otero de Antonio
 * @version 1.0
 * 
 * Representa a un robot participante en un combate. Cada robot posee un nombre,
 * una cantidad de vida inicial y un arma con la que puede atacar a otros robots.
 *
 */

public class Robot {
	
	
	
	//atributos
	/** Nombre del robot. */
	private String nombre;
	/** Valor inicial del número de vidas */
	private int vida;	
	/** Arma equipada por el robot. */
	private Arma arma;
	
	
	/**
	 * @param nombre (String), 
	 * @param arma (Objeto clase Arma)
	 */
	public Robot(String nombre, Arma arma) {
		setNombre(nombre);
		setArma(arma);
		setVida();
	}
	
	/**
	 * 
	 * @param nombre (String)
	 */
	public Robot(String nombre) {
		setNombre(nombre);
		setArma(TipoArma.PUNOS_DE_ACERO);
		setVida();
	}
	
	//Getters y Setters
	public int getVida() {
		return vida;
	}

	/**
	 * Establece la vida inicial del robot a 100.
	 */
	private void setVida() {
		this.vida = 100;
		
	}
	
	
	//-----------------------------------
	public String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return this.arma;
	}

	private void setArma(Arma arma) {
		this.arma = arma;
	}
	
	private void setArma(TipoArma arma) {
		this.arma = new Arma(arma);
	}
	
	
	//Métodos
	
	/**
	 * Realiza un ataque contra otro robot, calculando el daño en función
	 * de la potencia del arma y un factor de suerte aleatorio.
	 *
	 * @param robot (Robot que recibe el ataque).
	 */
	public void atacar(Robot robot) throws IllegalArgumentException{
		try {
			if (this == robot) {
			    throw new IllegalArgumentException("Un robot no puede atacarse a sí mismo.");
			}
			int factorSuerte = (int) (Math.random() * 8);
			int danio = arma.getPotencia() + factorSuerte;
			String mensaje = this.nombre + " ataca a " + robot.getNombre() + " con " + this.arma.getNombre() + "...";
			System.out.println(mensaje);
			robot.recibirDanio(danio);
		}catch(IllegalArgumentException e) {
			System.out.println("Error en el ataque: " + e.getMessage());
		}	
	}
	
	/**
	 * @param cantidad de daño recibido
	 */
	public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) {
        	vida = 0;
        }
        System.out.println("   >>  " + nombre + " recibe " + cantidad + " puntos de daño. Vida restante: " + vida);
    }
	
	/**
	 * @return el número de vidas
	 */
	public boolean estaVivo() {
        return this.vida > 0;
    }
	
	/**
	 * Devuelve una representación textual del robot, incluyendo su nombre
	 * y el arma que posee.
	 *
	 * @return Cadena con la información del robot.
	 */
	@Override
	public String toString() {
		return String.format("%s armado con %s.",this.nombre,this.arma.getNombre());
	}
	
}

