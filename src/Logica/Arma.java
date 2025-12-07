package Logica;

/**
 * Representa un arma utilizada por los robots en combate.
 * Cada arma posee un nombre identificador y un nivel de potencia
 * que determina el daño base que puede infligir en los ataques.
 * 
 * <p>La potencia de las armas está limitada al rango [10-19]. 
 * Si se intenta establecer un valor fuera de este rango, 
 * se ajustará automáticamente a 10 (potencia mínima por defecto).</p>
 *
 * @author Francisco Antonio Rosales Mangano
 * @author Antonio Manuel Otero de Antonio
 * @version 1.0
 */

public class Arma {
	
	/** Nombre identificador del arma. */
	private String nombre;
	/** 
     * Potencia del arma, que determina el daño base en combate.
     * El valor válido está en el rango [10-19].
     */
	private int potencia;
	
	/**
     * Constructor para crear un arma con nombre y potencia específicos.
     * Si la potencia no está en el rango válido [10-19], se establece a 10 por defecto.
     *
     * @param nombre el nombre identificador del arma
     * @param potencia el nivel de potencia del arma (debe estar entre 10 y 19)
     * @throws NullPointerException si el nombre es {@code null}
     */
	public Arma(String nombre, int potencia) {
		setNombre(nombre);
		setPotencia(potencia);
	}
	/**
     * Constructor de copia que crea un arma a partir de otra arma existente.
     * Copia tanto el nombre como la potencia del arma original.
     *
     * @param arma el arma a copiar
     * @throws NullPointerException si el arma es {@code null} o su nombre es {@code null}
     */
	public Arma(Arma arma) {
		setNombre(arma.getNombre());
		setPotencia(arma.getPotencia());
	}
	/**
     * Constructor que crea un arma a partir de un tipo de arma predefinido.
     * Utiliza los valores de nombre y potencia asociados al tipo de arma especificado.
     *
     * @param arma el tipo de arma predefinido del cual obtener las características
     */
	public Arma(TipoArma arma) {
		this.nombre=arma.getNombre();
		this.potencia=arma.getPotencia();
	}

	/**
     * Obtiene el nombre del arma.
     *
     * @return el nombre identificador del arma
     */
	public String getNombre() {
		return this.nombre;
	}
	
	 /**
     * Obtiene la potencia del arma.
     *
     * @return el nivel de potencia del arma (valor entre 10 y 19)
     */
	public int getPotencia() {
		return this.potencia;
	}
	
	/**
     * Establece la potencia del arma validando que esté en el rango permitido.
     * Este método es privado para proteger la consistencia interna del objeto.
     * 
     * <p>Si el valor proporcionado no está entre 10 y 19 (inclusive),
     * se establece automáticamente la potencia en 10 y se muestra un mensaje
     * de error en la consola de errores.</p>
     *
     * @param potencia el nivel de potencia a establecer (rango válido: 10-19)
     */
	private void setPotencia(int potencia) {
		if(potencia >= 10 && potencia <= 19) {
			this.potencia = potencia;
		} else {
			System.err.println("Valor erroneo, estableciendo potencia por defecto. (Potencia: 10).");
			this.potencia = 10;
		}
		
	}
	
	/**
     * Establece el nombre del arma.
     * Este método es privado para proteger la inmutabilidad del nombre
     * una vez creada el arma.
     *
     * @param nombre el nombre a asignar al arma
     * @throws NullPointerException si el nombre es {@code null}
     */
	private void setNombre(String nombre) throws NullPointerException{
		if (nombre == null) {
			throw new NullPointerException ("El nombre del arma no puede ser null.");
		}
		this.nombre=nombre;
	}
	
	/**
     * Devuelve una representación textual del arma, incluyendo su nombre y potencia.
     *
     * @return una cadena con el formato actual del arma, o {@code null} 
     *         si ocurre una excepción durante el formateo
     */
	@Override
	public String toString() throws NullPointerException {
		try {
			return String.format("Robot: %s.\nArmado con: %s.\n",this.nombre,this.potencia);
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	
	
}
