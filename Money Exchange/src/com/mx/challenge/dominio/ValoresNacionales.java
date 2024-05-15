package com.mx.challenge.dominio;

public class ValoresNacionales {
	
	private double ARS;
	private double BOB;
	private double BRL;
	private double CLP;
	private double COP;
	private double USD;
	private double MXN;
	
	public ValoresNacionales() {
		
		
	}

	@Override
	public String toString() {
		return " ["
				+ "\n ARS= " + ARS
				+ "\n BOB= " + BOB 
				+ "\n BRL= " + BRL 
				+ "\n CLP= " + CLP
				+ "\n COP= " + COP
				+ "\n USD= " + USD
				+ "\n MXN= " + MXN
				+ "\n ]";
	}

	public double getARS() {
		return ARS;
	}

	public double getBOB() {
		return BOB;
	}

	public double getBRL() {
		return BRL;
	}

	public double getCLP() {
		return CLP;
	}

	public double getCOP() {
		return COP;
	}

	public double getUSD() {
		return USD;
	}
	public double getMXN() {
		return MXN;
	}
	
	
	
	
}
