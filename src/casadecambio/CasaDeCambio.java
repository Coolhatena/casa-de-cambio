
package casadecambio;

import java.util.Scanner;

public class CasaDeCambio {
	static Scanner leer = new Scanner(System.in);
	
	static Pesos p = new Pesos();
	static Euros e = new Euros();
	static Dolares d = new Dolares();
	
	static int contador = 0, opcion = 0;
	static float pesos, dolares, euros, tipoCambioD, tipoCambioE;
	static float[] actualizacion = new float[3];
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido al sistema de Casa de cambio");
		System.out.println("Para comenzar, se necesitan algunos datos:");
		
		definirCambio();
		definirCaja();
		
		do {
			System.out.println("Seleccione la opcion deseada");
			System.out.println("1.- Cambiar Pesos a X cantidad de Euros o Dolares");
			System.out.println("2.- Cambiar Euros a X cantidad de Pesos o Dolares");
			System.out.println("3.- Cambiar Dolares a X cantidad de Euros o Pesos");
			System.out.println("4.- Listar la cantidad de dinero en caja");
			System.out.println("5.- Listar el numero de transacciones del dia");
			System.out.println("6.- Salir");
			System.out.print("Opcion seleccionada: ");
			opcion = leer.nextInt();
			
			switch( opcion ){
				case 1 -> {
					actualizacion = p.cambiar(pesos, euros, dolares, tipoCambioD, tipoCambioE);
					pesos = actualizacion[0];
					euros = actualizacion[1];
					dolares = actualizacion[2];
					contador++;
				}
				
				case 2 -> {
					actualizacion = e.cambiar(pesos, euros, dolares, tipoCambioD, tipoCambioE);
					pesos = actualizacion[0];
					euros = actualizacion[1];
					dolares = actualizacion[2];
					contador++;
				}
				
				case 3 -> {
					actualizacion = d.cambiar(pesos, euros, dolares, tipoCambioD, tipoCambioE);
					pesos = actualizacion[0];
					euros = actualizacion[1];
					dolares = actualizacion[2];
					contador++;
				}
				
				case 4 -> mostrarCaja();
				case 5 -> System.out.println("\nSe han realizado "+contador+" transacciones el dia de hoy\n");
				case 6 -> System.out.println("\nHasta Luego!\n");
				default -> System.out.println("\nOpcion invalida\n");
			}
			
		} while ( opcion != 6 );
		
		
	}
	
	public static void definirCambio() {
		System.out.println("Cuanto vale el Dolar en Pesos el dia de hoy?");
		tipoCambioD = leer.nextFloat();
		System.out.println("Cuanto vale el Euro en Pesos el dia de hoy?");
		tipoCambioE = leer.nextFloat();
	}
	
	public static void definirCaja(){
		System.out.println("Cuanto Pesos hay disponibles en caja?");
		pesos = leer.nextFloat();
		System.out.println("Cuanto Dolares hay disponibles en caja?");
		dolares = leer.nextFloat();
		System.out.println("Cuanto Euros hay disponibles en caja?");
		euros = leer.nextFloat();
	}
	
	public static void mostrarCaja(){
		System.out.println("\n--Dinero disponible en caja--");
		System.out.print("\nPesos: ");
		System.out.printf("%.2f", pesos);
		System.out.print("\nDolares: ");
		System.out.printf("%.2f", dolares);
		System.out.print("\nEuros: ");
		System.out.printf("%.2f", euros);
		System.out.println("\n");
	}
	
}
