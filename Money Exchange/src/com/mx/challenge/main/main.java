package com.mx.challenge.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;
import com.mx.challenge.busqueda.Conversion;

public class main {

	public static void main(String[] args){
	
		Scanner scan =new Scanner(System.in);
		Gson gson = new Gson();
		Conversion conver = new Conversion();
		
		System.out.println("INGRESE EL TIPO DE DIVISA A CONVERTIR");
		String divisa1 = scan.nextLine().toUpperCase();
		
		System.out.println("INGRESE LA DIVISA A LA QUE SE CONVERTIRA");
		String divisa2 = scan.nextLine().toUpperCase();
		
		System.out.println("INGRESE LA CANTDIDAD A CONVERTIR");
		double value = scan.nextDouble();
		
		
		System.out.println("----------------------------------");
		try {
			System.out.println(conver.obtenerValores(divisa1, divisa2, value));
		} catch (IOException | InterruptedException e) {
			System.out.println("ERROR");
		}
		
		
	}

}
