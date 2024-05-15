package com.mx.challenge.dominio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Divisa {

	String base_code;
	ValoresNacionales conversion_rates;
	List<String> historial = new ArrayList<String>();

	public Divisa() {

	}

	public double conversion(String monedaOrigen, String monedaDestino, double cantidad) {

		Gson gson = new Gson();
		double conversion = 0;
		try {

			String url = "https://v6.exchangerate-api.com/v6/d06df3ef84aa69e3b4df7d3f/latest/"
					+ monedaOrigen.toUpperCase();
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			Divisa moneda1 = gson.fromJson(response.body(), Divisa.class);

			switch (monedaDestino) {
			case "ARS":
				conversion = moneda1.getConversion_rates().getARS() * cantidad;
				break;
			case "BOB":
				conversion = moneda1.getConversion_rates().getBOB() * cantidad;
				break;
			case "BRL":
				conversion = moneda1.getConversion_rates().getBRL() * cantidad;
				break;
			case "CLP":
				conversion = moneda1.getConversion_rates().getCLP() * cantidad;
				break;
			case "COP":
				conversion = moneda1.getConversion_rates().getCOP() * cantidad;
				break;
			case "USD":
				conversion = moneda1.getConversion_rates().getUSD() * cantidad;
				break;
			case "MXN":
				conversion = moneda1.getConversion_rates().getMXN() * cantidad;
				break;
			default:
				System.out.println("NO HAY MONEDA DISPONIBLE");
			}

		} catch (IOException | InterruptedException e) {
			System.out.println("MONEDA INCORRECTA");
		}
		
		return conversion;

	}
	


	public String getBase_code() {
		return base_code;
	}

	public ValoresNacionales getConversion_rates() {
		return conversion_rates;
	}

}
