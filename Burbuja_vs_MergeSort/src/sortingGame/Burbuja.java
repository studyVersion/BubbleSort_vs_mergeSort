package sortingGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Burbuja {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String ruta = "Numeros.txt";
		long tiempo = 0;

		String fichero = leerFichero(ruta);
		int[] numeros = toArrayOfInteger(fichero);
		System.out.println("----------------------------");
		System.out.println(" Elija tu metodo de ordenar: ");
		System.out.println("----------------------------");
		System.out.println("  _____________________");
		System.out.println(" |  1. Parra Butbuja   |  ");
		System.out.println(" |  2. Para MergeSort  |");
		System.out.println(" |_____________________|");
		int option = Integer.valueOf(sc.nextLine());
		switch (option) {
		case 1:
			System.out.println("Clasificando...");
			tiempo = burbuja(numeros);
			escribirFichero("burbuja.txt", numeros);
			System.out.println("\nLa clasificacion se hizo en " + tiempo + " segundos\n");
			break;
		case 2:
			System.out.println("Clasificando...");
			tiempo = mergeSort(numeros);
			escribirFichero("MergeSort.txt", numeros);
			System.out.println("\nLa clasificacion se hizo en " + tiempo + " segundos\n");
			break;
		}
		System.out.println("Fichero escrito de forma correcta. ");

	}

	public static String leerFichero(String ruta) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(ruta));
		String line = "";
		String texto = "";

		line = reader.readLine();
		while (line != null) {
			texto += line;
			line = reader.readLine();

		}
		reader.close();
		return texto;

	}// leerFichero

	public static void escribirFichero(String ruta, int[] numeros) throws IOException {
		FileWriter fichero = new FileWriter(ruta);

		for (int i = 1; i <= numeros.length; i++) {
			fichero.write(numeros[i - 1] + "\t\t");
			if (i % 10 == 0) {
				fichero.write("\n");
			}
		}
		fichero.close();

	}// escribirFichero

	public static int[] toArrayOfInteger(String texto) {

		String[] arrString = texto.split("\\t\\t");

		int[] numeros = new int[arrString.length];

		for (int i = 0; i < arrString.length; i++) {
			numeros[i] = Integer.parseInt(arrString[i]);
		}
		return numeros;

	}// toArrayOfInteger

	public static long burbuja(int[] split) {
		Date d1 = new Date();
		for (int i = 0; i < split.length - 1; i++) {
			for (int j = 0; j < split.length - i - 1; j++) {
				if (split[j + 1] < split[j]) {
					int aux = split[j + 1];
					split[j + 1] = split[j];
					split[j] = aux;
				}
			}
		}
		Date d2 = new Date();
		long diferenciaTiempos = d2.getTime() - d1.getTime();
		diferenciaTiempos = TimeUnit.MILLISECONDS.toSeconds(diferenciaTiempos);

		return diferenciaTiempos;
	}// burbuja

	private static long mergeSort(int[] inputArray) {
		long diferenciaTiempos = 0;
		Date d1 = new Date();
		int inputLength = inputArray.length;

		if (inputLength < 2) {
			return diferenciaTiempos;
		}

		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];

		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = inputArray[i];
		}

		mergeSort(leftHalf);
		mergeSort(rightHalf);

		merge(inputArray, leftHalf, rightHalf);
		Date d2 = new Date();
		diferenciaTiempos = d2.getTime() - d1.getTime();
		diferenciaTiempos = TimeUnit.MILLISECONDS.toSeconds(diferenciaTiempos);

		return diferenciaTiempos;
		
	}//mergeSort

	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;

		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] <= rightHalf[j]) {
				inputArray[k] = leftHalf[i];
				i++;
			} else {
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		while (i < leftSize) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}

	}//merge
}
