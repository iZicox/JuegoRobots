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
		armas[indice] = null;
		
		
		System.out.println("---");
		
		System.out.println(miArma);
		
		System.out.println("---");
		for(int i = 0; i < armas.length; i++) {
			System.err.println(String.valueOf(armas[i]));
		}
		
		

		
	}

}

/*
 * - Extra: hacer torneo seleccionando el numero de robots, 4, 8.
 * 
 * 
 * - crear los array de las armas
 * - pedir los nombres de los robot y guardarlos en 2 variables usando el metodo de leerCadena()
 * - al asignar el arma a los robot llamar al nombre para finalizar la creacion
 * - robots ya creados
 * - meterlos en un bucle hasta que uno muera
 * 
 * */
