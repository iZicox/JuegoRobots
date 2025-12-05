package Logica;

import java.util.Random;
import java.util.Scanner;

public class Util {
	public static String leerCadena(String mensaje, int longMin, int longMax, Scanner sc) {
		String cadena;
		while (true) {
			System.out.print(mensaje);
			try {
				cadena = sc.nextLine();
				int cadenaLen = cadena.length();
				if (cadenaLen < longMin || cadenaLen > longMax) {
					throw new IllegalArgumentException(
							String.format("La cadena de texto debe estar entre %d - %d.", longMin, longMax));
				}
				return cadena;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static boolean alguienMurio(Robot robotA, Robot robotB) {
		if(robotA.estaVivo() && robotB.estaVivo()) {
			return false;
		}
		return true;
	}
	
	public static boolean lanzarMoneda(double probabilidad) throws IllegalArgumentException{
		Random rand = new Random();
		if(probabilidad <= 0) {
			throw new IllegalArgumentException(String.format("Debes ingresar una probabilidad mayor a cero."));
		}
	
			if( probabilidad < (rand.nextDouble()*100+1)) {
				return false;
			}
			return true;
	
		
		
	}
	
	public static int sorteo(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(min,max+1);
	}
}
