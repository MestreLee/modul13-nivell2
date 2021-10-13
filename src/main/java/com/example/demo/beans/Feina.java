package com.example.demo.beans;

public enum Feina {
	CEO("CEO"), CMO("CMO"), CTO("CTO"), ADMINISTRACIO("ADMINISTRACIO"), TECNIC("TECNIC"), BECARI("BECARI");
	
	private String nom;
	
	private Feina(String feina) {
		this.nom = feina;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
