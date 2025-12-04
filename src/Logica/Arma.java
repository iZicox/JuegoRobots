package Logica;
/*
 * Atributos:
○ nombre: Cadena con el nombre del arma
○ potencia: Entero con el daño causado

● Constructores:
○ Un constructor que recibe ambos atributos. Comprobar que la potencia es un valor
entre 10 y 19 (ambos incluidos). En caso contrario mostramos mensaje de error y
fijamos la potencia a un valor por defecto de 10.

● Métodos:
○ Solamente getters. Una vez creado el objeto no se puede modificar.
 * */
public class Arma {
	
	//atributos
	private String nombre;
	private int potencia;
	
	//constructores
	public Arma(String nombre, int potencia) {
		setNombre(nombre);
		setPotencia(potencia);
	}

	public Arma(TipoArma arma) {
		this.nombre=arma.getNombre();
		this.potencia=arma.getPotencia();
	}

	//getters
	public String getNombre() {
		return this.nombre;
	}
	public int getPotencia() {
		return this.potencia;
	}
	
	//setters privados para solo usarlos dentro de la clase y no por fuera
	private void setPotencia(int potencia) {
		if(potencia >= 10 && potencia <= 19) {
			this.potencia = potencia;
		} else {
			System.err.println("Valor erroneo, estableciendo potencia por defecto. (Potencia: 10).");
			this.potencia = 10;
		}
		
	}
	
	private void setNombre(String nombre) throws NullPointerException{
		if (nombre == null) {
			throw new NullPointerException ("El nombre del arma no puede ser null.");
		}
		this.nombre=nombre;
	}
	
	
	
}
