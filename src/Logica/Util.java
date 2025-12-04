package Logica;

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
}
