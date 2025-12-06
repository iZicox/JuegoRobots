package Logica;

/**
 * 
 * @author Francisco Antonio Rosales Mangano
 * @author Antonio Manuel Otero de Antonio
 * @version 1.0
 *
 */

public class Robot {
	
	
	
	//atributos
	private String nombre;
	private int vida;	//Valor inicial del número de vidas
	private Arma arma;
	
	
	//Constructor que recibe nombre y arma
	public Robot(String nombre, Arma arma) {
		setNombre(nombre);
		setArma(arma);
		setVida();
	}
	
	public Robot(String nombre) {
		setNombre(nombre);
		setArma(TipoArma.PUNOS_DE_ACERO);
		setVida();
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
	
	public void atacar(Robot robot) {
		int factorSuerte = (int) (Math.random() * 8);
		int danio = arma.getPotencia() + factorSuerte;
		String mensaje = this.nombre + " ataca a " + robot.getNombre() + " con " + this.arma.getNombre() + "...";
		System.out.println(mensaje);
		robot.recibirDanio(danio);
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
	
	@Override
	public String toString() {
		return String.format("%s armado con %s.",this.nombre,this.arma.getNombre());
	}
	
}

