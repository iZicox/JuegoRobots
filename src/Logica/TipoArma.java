package Logica;

/**
 * Clase Enum que define distintos tipos de armas disponibles en el juego,
 * cada una con un nombre descriptivo y un valor de potencia asociado.
 *
 * <p>Este enum permite representar las armas como constantes con atributos
 * adicionales, facilitando su uso en la lógica del programa.</p>
 * 
 * @author Francisco Antonio Rosales Mangano
 * @version 1.0
 */

public enum TipoArma {
	/** Arma de gran potencia cuerpo a cuerpo. */
    MOTOSIERRA_DE_PLASMA("Motosierra de plasma", 15),

    /** Arma de largo alcance con gran dano. */
    CANON_DE_PULSOS("Cañón de pulsos", 18),

    /** Arma legendaria con poder moderado. */
    ESPADA_INFINITA("Espada infinita", 10),

    /** Arma contundente de gran fuerza. */
    MARTILLO_NEUMATICO("Martillo neumático", 12),

    /** Arma de ataque rapido con dano medio. */
    GARRAS_DE_TITANIO("Garras de titanio", 10),

    /** Arma flexible con dano electrico. */
    LATIGO_ELECTRICO("Látigo eléctrico", 11),

    /** Arma de fuego con gran impacto. */
    PISTOLA_NUCLEAR("Pistola nuclear", 12),

    /** Arma de precisión con filo resistente. */
    LANZA_DE_DIAMANTE("Lanza de diamante", 11),

    /** Arma de corto alcance con gran potencia sonora. */
    ESCOPETA_SONICA("Escopeta sónica", 14),

    /** Arma de fuego que emite llamas intensas. */
    LANZALLAMAS_FUNDENTE("Lanzallamas fundente", 15),

    /** Arma cuerpo a cuerpo de fuerza básica. */
    PUNOS_DE_ACERO("Puños de acero", 10);

	
	/** Nombre descriptivo del arma */
	private final String nombre;
	
	/** Potencia del arma */
	private final int potencia;
	
	/**
	 * Constructor privado del enum para inicializar cada arma con su nombre y potencia que estan asociados en los parametros del enum
	 * Se invoca automaticamente de forma interna por cada constante definida
	 * 
	 * @param nombre nombre del arma
	 * @param potencia potencia del arma
	 */
	private TipoArma(String nombre, int potencia) {
		this.nombre=nombre;
		this.potencia=potencia;
	}

	/**
	 * Obtiene el nombre del arma
	 * 
	 * @return Nombre del arma como {@code String}
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la potencia del arma
	 * 
	 * @return Potencia del arma {@code int}
	 */
	public int getPotencia() {
		return potencia;
	}
	
	
}
