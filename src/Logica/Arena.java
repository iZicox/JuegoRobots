package Logica;

import java.util.Random;

public class Arena {
	Arma[] armas = {
		new Arma("Motosierra de plasma", 15),
		new Arma("Cañón de pulsos", 18),
		new Arma("Espada infinita", 10),
		new Arma("Martillo neumático", 12),
		new Arma("Garras de titanio", 10),
		new Arma("Látigo eléctrico", 11),
		new Arma("Pistola nuclear", 12),
		new Arma("Lanza de diamante", 11),
		new Arma("Escopeta sónica", 14),
		new Arma("Lanzallamas fundente", 15),
		new Arma("Puños de acero", 10),
	};
	
	public static Arma obtenerArmaAleatoria(Arma[] armas) {
        Random aleatorio = new Random();
        int indice = aleatorio.nextInt(armas.length);
        return armas[indice];
    }

}
