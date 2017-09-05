package myPackage;

import java.util.ArrayList;

public class Bandera {

	private int largo;
	private int ultimoRetazo;
	private ArrayList<Integer> retazos;
	
	public Bandera(int retazo) {
		this.retazos = new ArrayList<Integer>();
		this.coser(retazo);
	}

	public void coser(int retazo) {
		this.largo += retazo;
		this.ultimoRetazo = retazo;
		this.retazos.add(retazo);
	}
	
	public int costuras() {
		return this.retazos() - 1;
	}
	
	public int retazos() {
		return this.retazos.size();
	}

	public int getLargo() {
		return largo;
	}
	
	public int getRetazo(int i) {
		return this.retazos.get(i);
	}
	
	public int getUltimoRetazo() {
		return this.ultimoRetazo;
	}
}
