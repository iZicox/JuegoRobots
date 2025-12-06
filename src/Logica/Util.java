package Logica;

import java.util.Random;
import java.util.Scanner;
/**
 * Clase de utilidades de metodos estaticos con operaciones repetitivas en el programa Arena tales como
 * leer una cadena de texto, saber si algun robot murio, sorteo y lanzar moneda para
 * darle un factor aleatorio al iniciar el combate y escoger el arma del robot.
 * 
 * @author Francisco Antonio Rosales Mangano
 * @version 1.0
 */
public class Util {
	
	/**
	 * Leer una cadena desde el {@link Scanner} ingresada por el usuario donde debe tener una longitud minima y maxima sino devuelve excepcion para pedir nuevamnete la cadena
	 * 
	 * @param mensaje mensaje que queremos mostar al usuario que le indique como debe llenar el mensaje atraves del scanner.
	 * @param longMin valor entero para verificar la longitud minima del string la cual si se encuentra por debajo de esta cantidad le pida al usuario ingresarla nuevamente dentro del rango solicitado
	 * @param longMax valor entero para verificar la longitud maxima del string la cual si se encuentra por encima de esta cantidad le pida al usuario ingresarla nuevamente dentro del rango solicitado
	 * @param sc aqui introducimos como parametro un objeto tipo scanner para poder hacer lecturas de teclado
	 * @return el valor de retorno sera un string con la cadena de texto ingresada por el usuario
	 * @throws IllegalArgumentException si la cadena ingresada tiene una longitud menor que {@code longMin} o mayor que {@code longMax} 
	 */
	public static String leerCadena(String mensaje, int longMin, int longMax, Scanner sc) throws IllegalArgumentException{
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
	
	/**
	 * Metodo para verificar si alguno de los robot murio para determinar un ganador y finalizar el combate
	 * 
	 * @param robotA ingresar el primer robot del combate
	 * @param robotB ingresar el segundo robot del combate
	 * @return devuelve un valor {@code boolean} si es {@code true} el combate sigue porque ambos estan vivos de  lo contrario devuelve un {@code false} porque alguno murio
	 * @see Robot#estaVivo()
	 */
	public static boolean ambosVivos(Robot robotA, Robot robotB) {
		return robotA.estaVivo() && robotB.estaVivo();
	}
	
	/**
	 * Simula el lanzamiento de una moneda con probabilidad del 50%.
	 *
	 * @return {@code true} si el resultado es cara, {@code false} si es cruz.
	 */
	public static boolean lanzarMoneda() {
		Random rand = new Random();
		return rand.nextBoolean();	
	}
	
	/**
	 * Metodo para devolver un valor aleatorio entero entre el minimo y maximo 
	 * 
	 * @param min numero entero desde donde inicia (inclusivo) los valores aleatorios
	 * @param max numero entero donde termina los valores aleatorios (inclusivo)
	 * @return devuelve un numero entero dentro del minimo y maximo
	 */
	public static int sorteo(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(min,max+1);
	}
	
	
}
