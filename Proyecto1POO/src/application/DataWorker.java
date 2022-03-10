package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataWorker {
	private ArrayList<String> listPalabras = new ArrayList<String>();
	private String[] palabrasConsultadas = new String [30];
	private int[] numTweets;
	
	/**
	 * Método que crea una array list a partir de un csv
	 * @param String path del archivo csv
	 * @return ArrayList del csv.
	 */
	public ArrayList<String> regresaArrayList(String ruta){
		ArrayList <String> list = new ArrayList <String>();
		
		
		try {
			Scanner csvData = new Scanner(new File(ruta));
			while(csvData.hasNext()) {
				list.add(csvData.nextLine());
			}}catch(FileNotFoundException ex){
				System.out.println(ex.toString());
			}
			
		return list;
		
	}
	
	/**
	 * Método que elimina numeros, caracteres especiales y palabras que contengan Mo//mo
	 * @param Array List previamente convertido
	 * @return Array List corregido.
	 */
	public ArrayList<String> eliminarCaracteres(ArrayList<String> list2) {
		int i=0, j=0;
		
		ArrayList<String> list = new ArrayList<String>();
		String[] tempArray = list2.toArray(new String[0]);
		
		for(i=0; i<tempArray.length; i++) {
			
			tempArray[i]=tempArray[i].replaceAll("F1", " ").replaceAll("\\d", " ").replaceAll("\\W", " ").replaceAll("AbuDhabiGP[\\w]*", " ").replaceAll("https[\\w]*", " ");
			list.add(tempArray[i]);
			System.out.println(list.get(i));
		}
		return list;
	}
	
	/**
	 * Método que cuenta las palabras de un arreglo específico indicado por el usuario (Primeramente esta hardcodeado pero posteriormente se le pedirán al usuario las palabras)
	 * @param palabras
	 * @param tweets
	 * @return int Array con los numeros de las palabras.
	 */
	public int[] contarPalabras(String[] palabras, ArrayList <String> tweets) {
		String[] list = tweets.toArray(new String[0]);
		int[] contadorPalabras = new int[palabras.length];
		
		
		for(int i = 0; i < tweets.size();i++) {
			for(int j = 0; j < palabras.length;j++) {
				if(list[i].contains(palabras[j]) == true) {
					contadorPalabras[j]++;
				}
				
				
			}
			
		}
		return contadorPalabras;
	}
	
	/**
	 * Método que imprime el arreglo junto con las palabras que se indicaron previamente
	 * @param numPalabras
	 * @param palabras
	 */
	public void imprimirPalabras(int[] numPalabras, String[] palabras) {
		
		System.out.println("\n");
		for(int i = 0; i < palabras.length;i++) {
			System.out.println("El numero de veces que se encontro la palabra:'"+palabras[i]+"' Fueron: "+numPalabras[i]);
		}
		return;
	}
	
	/**
	 * Método que guarda el numero de veces que se menciona algo sobre Red Bull o Verstappen
	 * @param numPalabras
	 * @param palabras
	 * @return
	 */
	public int contadorRedBull(int[] numPalabras, String[] palabras) {
		int contRB = 0;
		for(int i = 0; i < 11;i++) {
			contRB = numPalabras[i]+contRB;
		}
		System.out.println("El numero de veces que se mencionó a RB/Verstappen fue:" + contRB);
	
		return contRB;
	}

	/**
	 * Método que guarda el numero de veces que se menciona algo sobre Mercedes o Hamilton
	 * @param numPalabras
	 * @param palabras
	 * @return
	 */
	public int contadorMerc(int[] numPalabras, String[] palabras) {
		int contMerc = 0;
		for(int i = 11; i <21;i++) {
			contMerc = numPalabras[i]+contMerc;
		}
		System.out.println("El numero de veces que se mencionó a Mercedes/Hamilton fue:" + contMerc);
	
		return contMerc;
	}
	
	/**
	 * Método que guarda el numero de veces que se menciona algo sobre la FIA o Michael Masi
	 * @param numPalabras
	 * @param palabras
	 * @return
	 */
	public int contadorFia(int[] numPalabras, String[] palabras) {
		int contFIA = 0;
		for(int i = 21; i <27;i++) {
			contFIA = numPalabras[i] + contFIA;
		}
		System.out.println("El numero de veces que se mencionó a FIA/Masi fue:" + contFIA);
	
		return contFIA;
	}	
	
	/**
	 * Método que guarda el numero de veces que se menciona algo sobre Nicholas Latifi
	 * @param numPalabras
	 * @param palabras
	 * @return
	 */
	public int contadorLatifi(int[] numPalabras, String[] palabras) {
		int contLatifi = 0;
		for(int i = 27; i <30;i++) {
			contLatifi = numPalabras[i]+contLatifi;
		}
		System.out.println("El numero de veces que se mencionó a Latifi fue:" + contLatifi);
	
		return contLatifi;
	}	
	
	/**
	 * Métodos Set y Get.
	 * @return
	 */
	public ArrayList<String> getListPalabras() {
		return listPalabras;
	}

	public void setListPalabras(ArrayList<String> listPalabras) {
		this.listPalabras = listPalabras;
	}

	public String[] getPalabrasConsultadas() {
		return palabrasConsultadas;
	}

	public void setPalabrasConsultadas(String[] palabras) {
		this.palabrasConsultadas = palabras;
	}

	public int[] getNumTweets() {
		return numTweets;
	}

	public void setNumTweets(int[] tweets) {
		this.numTweets = tweets;
	}

	
	
}



