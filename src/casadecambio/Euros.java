
package casadecambio;

import java.util.Scanner;

public class Euros extends Transaccion{
	
	@Override
	public float[] cambiar(float pesos, float euros, float dolares, float tipoCambioD, float tipoCambioE ) {
		Scanner leer = new Scanner( System.in );
		int opcion = 0;
		boolean validacion = false;
		float cant;
		//Validacion de la solicitud de cambio
		do {
			System.out.println("Ha que divisa deseas convertir tus Euros?");
			System.out.println("1: Pesos, 2: Dolares");
			opcion = leer.nextInt();
			
			if ( opcion == 1 || opcion == 2) {
				validacion = true;
			} else {
				System.out.println("Opcion invalida, elija de nuevo \n");
			}
			
		} while ( validacion == false ); 
		//Fin de la validacion
		
		if ( opcion == 1) { //Conversion de Euros a Pesos
			System.out.println("Escriba la cantidad de Pesos que desea: ");
			cant = leer.nextFloat();
			
			if ( cant < pesos ) {
				euros += cant/tipoCambioE;
				pesos -= cant;
				System.out.println("Transaccion completada con exito");
			} else {
				System.out.println("No hay suficiente dinero en caja");
			}
		} else{ //Conversion de Euros a Dolares
			System.out.println("Escriba la cantidad de Dolares que desea: ");
			cant = leer.nextFloat();
			
			if ( cant < dolares ) {
				euros += cant*( tipoCambioE / tipoCambioD );
				dolares -= cant;
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
