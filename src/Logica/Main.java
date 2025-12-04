package Logica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipoArma [] catalogo = TipoArma.values();
		Arma[] arsenal = new Arma[catalogo.length];
		
		for(int i = 0; i < arsenal.length; i++) {
			arsenal[i] = new Arma(catalogo[i].getNombre(),catalogo[i].getPotencia());
		}
		
		for(Arma n: arsenal) {
			System.out.println(n.getNombre());
			System.out.println(n.getPotencia());
			System.out.println("****************");
		}
		
	}

}
