package com.mx.challenge.main;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mx.challenge.dominio.Divisa;
import com.mx.challenge.dominio.Historial;

public class main {

	public static void main(String[] args) {
		
		int menu = 0;
		List<String> historial = new ArrayList<String>();
		
		while(true) {
			

			
			if (menu == 0) {
				String divOrigen, divDestino;
				double cantidad, resultado;
			
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				Divisa divisa = new Divisa();

				System.out.println("INGRESE EL CODIGO DE LA MONEDA A CONVERTIR\n" + "(ARS, " + "BOB, " + "BRL, " + "CLP, "
						+ "COP. " + "USD, " + "MXN)");
				divOrigen = scan.nextLine().toUpperCase();
				System.out.println("INGRESE EL CODIGO DE LA MONEDA DESTINO\n" + "(ARS, " + "BOB, " + "BRL, " + "CLP, "
						+ "COP. " + "USD, " + "MXN)");
				divDestino = scan.nextLine().toUpperCase();
				System.out.println("INGRESE CANTIDAD DE " + divOrigen + " A CONVERTIR A " + divDestino);
				cantidad = scan.nextDouble();

				resultado = divisa.conversion(divOrigen, divDestino, cantidad);
				
			
				System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "] ");
				System.out.print(cantidad + " " + divOrigen + " ES IGUAL A " + resultado + " " + divDestino + "\n");
				
				historial.add("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "] "+"  "+cantidad + " " + divOrigen + " ES IGUAL A " + resultado + " " + divDestino);
				
				System.out.println(
						"\nESCRIBA\n -SALIR- PARA TERMINAR\n-H- PARA GENERAR EL HISTORIAL \nCUALQUIER CARACTER PARA CONTINUAR");
				scan.nextLine().toUpperCase();
				String loop = scan.nextLine().toUpperCase();
				if (loop.equals("SALIR"))
					menu=2;
				else if (loop.equals("H")) {
					menu = 1;
				} else {
					System.out.println("NUEVA CONVERSION");
				}
			}

			else if (menu == 1) {
				Scanner scan=new Scanner(System.in);
				
				System.out.println(String.join("\n", historial));
				
				System.out.println(
						"\nESCRIBA\n -SALIR- PARA TERMINAR\n-H- PARA GENERAR EL HISTORIAL \nCUALQUIER CARACTER PARA CONTINUAR");
				scan.nextLine().toUpperCase();
				String loop = scan.nextLine().toUpperCase();
				scan.nextLine();
				if (loop.equals("SALIR"))
					menu=2;
				else if (loop.equals("H")) {
					menu = 1;
				} else {
					System.out.println("NUEVA CONVERSION");
					menu=0;
				}
				
			}
			else if(menu==2)
			{
				break;
			}

			
		
		}
		System.out.println("HASTA PRONTO");
	}

}
