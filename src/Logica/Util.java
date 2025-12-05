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
	
	public static boolean ambosVivos(Robot robotA, Robot robotB) {
		return robotA.estaVivo() && robotB.estaVivo();
	}
	
	//probabilidad del 50% si es true es cara y false cruz
	public static boolean lanzarMoneda() {
		Random rand = new Random();
		return rand.nextBoolean();	
	}
	
	public static int sorteo(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(min,max+1);
	}
	
	
}
