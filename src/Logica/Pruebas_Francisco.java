package Logica;

import java.util.Scanner;

public class Pruebas_Francisco {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in;
		// TODO Auto-generated method stub
		Robot pepe = new Robot("pepe", new Arma(TipoArma.CANON_DE_PULSOS));
		Robot juan = new Robot("juan", new Arma(TipoArma.ESCOPETA_SONICA));
		
		System.out.println("**********Robot 1*********\n"+pepe.toString());
		System.out.println("**********Robot 2*********\n"+juan.toString());

			System.out.println(Util.lanzarMoneda(50));
		
		
		
		
		/*
		while(true) {
			System.out.println("\n\n\n*********Empieza turno***********");
			pepe.atacar(juan);
			
			System.out.println("Enter para seguir.");
			in = sc.nextLine();
			if(Util.alguienMurio(pepe, juan)) {
				break;
			}
			juan.atacar(pepe);
			
			System.out.println("Enter para seguir.");
			in=sc.nextLine();
			if(Util.alguienMurio(pepe, juan)) {
				break;
			}
			System.out.println("*************Fin del turno**************");
			System.out.println("Enter para seguir.");
			in=sc.nextLine();
		}
		*/
		
		
		
	}

}
