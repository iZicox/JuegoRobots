package Logica;

/**
 *  * Representa a un robot participante en un combate. Cada robot posee un nombre,
 * una cantidad de vida inicial y un arma con la que puede atacar a otros robots y recibir daño.
 * 
 * <p>Los robots comienzan con 100 puntos de vida y pueden equipar diferentes
 * tipos de armas. El combate se resuelve mediante ataques que calculan el daño
 * basándose en la potencia del arma y un factor de suerte aleatorio.</p>
 * 
 * @author Francisco Antonio Rosales Mangano
 * @author Antonio Manuel Otero de Antonio
 * @version 1.0
 * 
 *
 */

public class Robot {
	
	/** Nombre del robot. */
	private String nombre;
	/** Valor inicial del número de vidas */
	private int vida;	
	/** Arma equipada por el robot. */
	private Arma arma;
	
	
	/**
	 * Constructor para crear un robot con dos parametros, la vida se ajusta por defecto a 100 puntos
	 * 
	 * @param nombre nombre del robot (String), 
	 * @param arma arma que equipara el robot (Objeto clase Arma)
	 */
	public Robot(String nombre, Arma arma) {
		setNombre(nombre);
		setArma(arma);
		setVida();
	}
	
	/**
	 * Constructor para crear robot solo con el parametro del nombre y se le asigna un arma por defecto Puños de acero. La vida se ajusta por defecto a 100 puntos
	 * 
	 * @param nombre nombre del robot (String)
	 */
	public Robot(String nombre) {
		setNombre(nombre);
		setArma(TipoArma.PUNOS_DE_ACERO);
		setVida();
	}
	
	/**
	 * Getter para saber los puntos de vida actuales que tiene el robot
	 * 
	 * @return vida puntos de vida del robot
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Setter privado void para que solo pueda ser usado dentro de la clase para establecer la vida inicial del robot a 100 en la construccion del objeto
	 */
	private void setVida() {
		this.vida = 100;
		
	}
	
	
	/**
	 * Getter que devuelve el nombre del robot en tipo String
	 * 
	 * @return nombre nombre del robot
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Establece el nombre del robot.
     * Este metodo es privado para usarlo solo en la creacion del objeto
     * una vez creado el robot. 
     * 
	 * @param nombre nombre que se recibe como parametro en el constructor
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter para consultar cual arma tiene el robot actualmente
	 * 
	 * @return arma valor del objero tipo {@code Arma}
	 */
	public Arma getArma() {
		return this.arma;
	}

	/**
	 * Setter privado para crear el el objeto tipo {@code Arma} que tendra el robot en su creacion
	 * Este setter se llama si ingresamos el tipo {@code Arma} como parametro en el constructor
	 * 
	 * @param arma arma del robot
	 */
	private void setArma(Arma arma) {
		this.arma = arma;
	}
	
	/**
	 * Setter privado en caso de que llamemos el constructor que tiene como parametro solo el nombre y el arma lo genera a partir del enum {@code TipoArma}
	 * 
	 * @param arma arma del enum para crear el {@code Arma}
	 */
	private void setArma(TipoArma arma) {
		this.arma = new Arma(arma);
	}
	
	
	/**
	 * Realiza un ataque contra otro robot, calculando el daño en función
	 * de la potencia del arma y un factor de suerte aleatorio.
	 * Manejo de excepcion si se ingresa como parametro el mismo robot debido a que un robot no puede atacarse a si mismo
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
	 * Metodo para la propiedad de recibir daño del robot y reducir su vida. Si el ataque hace que su vida sea negativa se ajusta a 0
	 * 
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
	 * Metodo para saber si un robot permanece con vida por medio de un boolean
	 * 
	 * @return Boolean si esta vivo o no
	 */
	public boolean estaVivo() {
        return this.vida > 0;
    }
	
	/**
	 * Devuelve una representación textual del robot, incluyendo su nombre
	 * y el arma que posee.
	 *
	 * @return Cadena con la informacion del robot.
	 */
	@Override
	public String toString() {
		return String.format("%s armado con %s.",this.nombre,this.arma.getNombre());
	}
	
}

