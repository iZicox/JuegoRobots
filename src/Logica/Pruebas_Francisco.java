package Logica;

import java.util.Scanner;

public class Pruebas_Francisco {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TipoArma[] arsenal = TipoArma.values();
		Arma[] armas = new Arma[arsenal.length];
		
		for(int i = 0; i < armas.length; i++) {
			armas[i] = new Arma(arsenal[i]);
			System.out.println(armas[i].toString());
		}
		
		int indice = Arena.obtenerArmaAleatoria(armas);
		
		Arma miArma = new Arma(armas[indice]);
		
		System.out.println("---");
		
		System.out.println(miArma);
		
		

		
	}

}
