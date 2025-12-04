package Logica;

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
		return String.format("%s armado con %s.",this.nombre,this.arma.getNombre());
	}
	
}

