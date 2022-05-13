
package casadecambio;

import java.util.Scanner;

public class Dolares extends Transaccion{
	
	@Override
	public float[] cambiar( float pesos, float euros, float dolares, float tipoCambioD, float tipoCambioE ) {
		Scanner leer = new Scanner( System.in );
		int opcion = 0;
		boolean validacion = false;
		float cant;
		//Validacion de la solicitud de cambio
		do {
			System.out.println("Ha que divisa deseas convertir tus Dolares?");
			System.out.println("1: Euros, 2: Pesos");
			opcion = leer.nextInt();
			
			if ( opcion == 1 || opcion == 2) {
				validacion = true;
			} else {
				System.out.println("Opcion invalida, elija de nuevo \n");
			}
			
		} while ( validacion == false ); 
		//Fin de la validacion
		
		if ( opcion == 1) { //Conversion de Dolares a Euros
			System.out.println("Escriba la cantidad de Euros que desea: ");
			cant = leer.nextFloat();
			
			if ( cant < euros ) {
				euros -= cant;
				dolares += cant*( tipoCambioD / tipoCambioE );
				System.out.println("Transaccion completada con exito");
			} else {
				System.out.println("No hay suficiente dinero en caja");
			}
		} else{ //Conversion de Dolares a pesos
			System.out.println("Escriba la cantidad de Pesos que desea: ");
			cant = leer.nextFloat();
			
			if ( cant < pesos ) {
				dolares += cant/tipoCambioD;
				pesos -= cant;
				System.out.println("Transaccion completada con exito");
			} else {
				System.out.println("No hay suficiente dinero en caja");
			}
		}
		
		
		float[] cambio = new float[3];
		cambio[0] = pesos;
		cambio[1] = euros;
		cambio[2] = dolares;
		return cambio;
	}
}
