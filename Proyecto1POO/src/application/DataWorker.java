package com.jpmcers.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataWorker {
	private ArrayList<String> listPalabras = new ArrayList<String>();
	private String[] palabras = new String [30];
	private int[] tweets = new int[30];
	
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
		int contPalabras[] = new int[30];
		
		for(int i = 0; i < tweets.size();i++) {
			for(int j = 0; j < palabras.length;j++) {
				if(list[i].contains(palabras[j]) == true) {
					contPalabras[j]++;
				}
			}
		}
		return contPalabras;
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
	 * Métodos Set y Get.
	 * @return
	 */
	public ArrayList<String> getListPalabras() {
		return listPalabras;
	}

	public void setListPalabras(ArrayList<String> listPalabras) {
		this.listPalabras = listPalabras;
	}

	public String[] getPalabras() {
		return palabras;
	}

	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}

	public int[] getTweets() {
		return tweets;
	}

	public void setTweets(int[] tweets) {
		this.tweets = tweets;
	}

	
	
}


