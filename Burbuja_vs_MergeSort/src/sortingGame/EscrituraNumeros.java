package sortingGame;

import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class EscrituraNumeros {

	public static void main(String[] args) {
		 Random rand = new Random();
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("-----------------------------------");
		 System.out.println("  Cuantos numeros quiere generar?");
		 System.out.println("-----------------------------------");
		 int number = sc.nextInt();
		 int rendInt =0; 
		
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("Numeros.txt");

			// Escribimos linea a linea en el fichero
			for (int i = 1; i <= number; i++) {
				rendInt=rand.nextInt(number);
				fichero.write(rendInt + "\t\t");
				if(i%10 == 0) {
					fichero.write(System.lineSeparator());
				}
				
			}

			fichero.close();
			
			System.out.println("\nFichero escrito de forma correcta. ");

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}
	}


}


