package com.example.demo.beans;

public class Empleat {
	
	//private static int nextId = 1;
	private int id;
	private String nom;
	private Feina feina;
	private int sou;
	
	/*public Empleat(String nom, Feina feina) {
		this.id = nextId;
		nextId++;
		this.nom = nom;
		this.feina = feina;
		this.setSou(feina);
	}*/
	
	public Empleat (int id, String nom, Feina feina) {
		this.id = id;
		this.nom = nom;
		this.feina = feina;
		this.setSou(feina);
	}
	
	public Empleat() {
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Feina getFeina() {
		return feina;
	}

	public void setFeina(Feina feina) {
		this.feina = feina;
	}
	
	public void setSou(Feina feina) {
		switch(feina) {
		case ADMINISTRACIO: 
			this.sou = 1200;
			break;
		case CEO: 
			this.sou = 3000;
			break;
		case CTO: 
			this.sou = 2500;
			break;
		case CMO: 
			this.sou = 2300;
			break;
		case TECNIC: 
			this.sou = 1500;
			break;
		case BECARI: 
			this.sou = 900;
			break;
		}
	}
	
	public int getSou() {
		return sou;
	}

}
