package myPackage;

import java.util.HashSet;

public class Secuencia {
	
	private HashSet<Integer> interseccion;
	private int banderaA;
	private int banderaB;
	
	public Secuencia() {
		this.interseccion = new HashSet<Integer>();
	}
	
	public Secuencia(HashSet<Integer> set, int a, int b) {
		this.interseccion = new HashSet<Integer>(set);
		this.banderaA = a;
		this.banderaB = b;
	}

	public int valorSecuencia() {
		return this.interseccion.size();
	}
	
	public int getBanderaA() {
		return banderaA;
	}

	public int getBanderaB() {
		return banderaB;
	}
}
