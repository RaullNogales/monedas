package com.mx.challenge.busqueda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class Conversion {
	String base_code;
	String target_code;
	double conversion_rate;
	double conversion_result;
	
	
	public Conversion() {
		
	}
	
	public Conversion obtenerValores(String baseC,String targetC, double value) throws IOException, InterruptedException{
		
		String url = "https://v6.exchangerate-api.com/v6/d06df3ef84aa69e3b4df7d3f/pair/"+baseC+"/"+targetC+"/"+value;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
		//String json = 
		return new Gson().fromJson(response.body(),Conversion.class);
		
	}

	@Override
	public String toString() {
		return "Conversion [base_code=" + base_code + ", target_code=" + target_code + ", conversion_rate="
				+ conversion_rate + ", conversion_result=" + conversion_result + "]";
	}
	
	
}
