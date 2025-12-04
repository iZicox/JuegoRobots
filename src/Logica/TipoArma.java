package Logica;

public enum TipoArma {
	MOTOSIERRA_DE_PLASMA("Motosierra de plasma", 15),
	CANON_DE_PULSOS("Cañón de pulsos", 18),
	ESPADA_INFINITA("Espada infinita", 10),
	MARTILLO_NEUMATICO("Martillo neumático", 12),
	GARRAS_DE_TITANIO("Garras de titanio", 10),
	LATIGO_ELECTRICO("Látigo eléctrico", 11),
	PISTOLA_NUCLEAR("Pistola nuclear", 12),
	LANZA_DE_DIAMANTE("Lanza de diamante", 11),
	ESCOPETA_SONICA("Escopeta sónica", 14),
	LANZALLAMAS_FUNDENTE("Lanzallamas fundente", 15);
	
	//atributos
	private final String nombre;
	private final int potencia;
	
	//constructor
	TipoArma(String nombre, int potencia) {
		this.nombre=nombre;
		this.potencia=potencia;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPotencia() {
		return potencia;
	}
	
	
}
