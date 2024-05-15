package com.mx.challenge.dominio;

import java.util.List;

public class Historial {

	private List<Object> historial;
	
	public Historial() {
		
	}

	public void agregarHistorial(String e) {
		this.historial.add(e);
	}
	
	public String mostrarHistorial(){
		return historial.toString();
	}
	
}
