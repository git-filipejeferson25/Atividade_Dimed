package Service;


import java.util.Scanner;

public class Raio { 
	    
	public void raioCalcular() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe as distâncias");
		double x1 = entrada.nextDouble();
		System.out.println("Informe as distâncias");
		double y1 = entrada.nextDouble();
		System.out.println("Informe as distâncias");
		double x2 = entrada.nextDouble();
		System.out.println("Informe as distâncias");
		double y2 = entrada.nextDouble();
		
		
		double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		
		System.out.println("A distancia é " + distancia);
	}

	
	  

}
