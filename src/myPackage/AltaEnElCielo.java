package myPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class AltaEnElCielo extends EjercicioOIA {

	private int rollo;
	private int cantidadBanderas;
	private ArrayList<Bandera> banderas;
	private ArrayList<TreeSet<Integer>> sets;
	private ArrayList<Secuencia> secuencias;

	private int banderaMasLarga;
	private int maximaLongitud;
	private int maximaCantCosturas;
	private int largoSecuenciaMaxima;
	private int banderaA;
	private int banderaB;

	public AltaEnElCielo(File entrada, File salida) throws FileNotFoundException {
		super(entrada, salida);
		this.leerEntrada();
	}

	private void leerEntrada() throws FileNotFoundException {
		Scanner scan = new Scanner(new FileReader(this.entrada));
		this.rollo = scan.nextInt();
		this.cantidadBanderas = scan.nextInt();
		this.banderas = new ArrayList<Bandera>();
		this.sets = new ArrayList<TreeSet<Integer>>();
		this.secuencias = new ArrayList<Secuencia>();
		int retazo;
		for (int i = 0; i < this.cantidadBanderas; i++) {
			retazo = scan.nextInt();
			this.banderas.add(new Bandera(retazo));
			this.rollo -= retazo;
			this.sets.add(new TreeSet<Integer>());
			this.sets.get(i).add(retazo);
		}
		scan.close();

	}

	@Override
	public void resolver() {
		this.coserBanderas();
		this.calcularBanderaMasLarga();
		this.calcularMaximaCantidadCosturas();
		this.buscarSecuenciaMaxima();
		this.escribirSolucion();
		//this.mostrarBanderas();
	}

	private void escribirSolucion() {
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(this.salida));
			buffer.write(this.banderaMasLarga + " " + this.maximaLongitud);
			buffer.newLine();
			buffer.write(String.valueOf(this.maximaCantCosturas));
			buffer.newLine();
			buffer.write(String.valueOf(String.valueOf(this.rollo)));
			buffer.newLine();
			if(this.largoSecuenciaMaxima > 0)
				buffer.write(this.largoSecuenciaMaxima + " " + this.banderaA + " " + this.banderaB);
			else
				buffer.write(String.valueOf(this.largoSecuenciaMaxima));
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void coserBanderas() {
		int retazo;
		boolean costura = false;
		for(int i = 0 ; i < this.cantidadBanderas ; i++) {
			if ((retazo = nextSecuenciaDeBlautzik(this.banderas.get(i).getUltimoRetazo())) <= this.rollo) {
				this.rollo -= retazo;
				banderas.get(i).coser(retazo);
				costura = true;
				this.sets.get(i).add(retazo);
			}
		}
		if (costura) {
			this.coserBanderas();
		}
	}

	private static int nextSecuenciaDeBlautzik(int retazoAnterior) {
		String num = String.valueOf(retazoAnterior);
		int suma = retazoAnterior;
		int cifra;
		for (int j = 0; j < num.length(); j++) {
			cifra = Character.digit(num.charAt(j), 10);
			suma += cifra;
		}
		return suma;
	}

	public void calcularBanderaMasLarga() {
		this.banderaMasLarga = 1;
		this.maximaLongitud = this.banderas.get(0).getLargo();
		for (int i = 1 ; i < this.cantidadBanderas ; i++) {
			if (this.banderas.get(i).getLargo() > this.maximaLongitud) {
				this.banderaMasLarga = i + 1;
				this.maximaLongitud = this.banderas.get(i).getLargo();
			}
		}
	}

	public void calcularMaximaCantidadCosturas() {
		this.maximaCantCosturas = this.banderas.get(0).costuras();
		for (int i = 1; i < this.cantidadBanderas ; i++) {
			if (this.banderas.get(i).costuras() > this.maximaCantCosturas) {
				this.maximaCantCosturas = this.banderas.get(i).costuras();
			}
		}
	}

	public void mostrarBanderas() {
		for (int i = 0 ; i < this.cantidadBanderas ; i++) {
			for (int j = 0; j < this.banderas.get(i).retazos(); j++) {
				System.out.print(this.banderas.get(i).getRetazo(j) + " ");
			}
			System.out.println();
		}
	}
	
	private void buscarSecuenciaMaxima() {
		prepararSecuencias();
		for(int i = 0 ; i < this.secuencias.size() ; i++) {
			if(this.secuencias.get(i).valorSecuencia() > this.largoSecuenciaMaxima) {
				this.largoSecuenciaMaxima = this.secuencias.get(i).valorSecuencia();
				this.banderaA = this.secuencias.get(i).getBanderaA();
				this.banderaB = this.secuencias.get(i).getBanderaB();
			}
		}
	}
	
	private void prepararSecuencias() {
		HashSet<Integer> set;
		for(int i = 0 ; i < this.cantidadBanderas ; i++) {
			for(int j = i + 1 ; j < this.cantidadBanderas ; j++) {
				set = new HashSet<Integer>(this.sets.get(i));
				set.retainAll(this.sets.get(j));
				if(!set.isEmpty()) {
					this.secuencias.add(new Secuencia(set, i+1, j+1));
				}
			}
		}
	}

	public ArrayList<TreeSet<Integer>> getSets() {
		return sets;
	}

	public void setSets(ArrayList<TreeSet<Integer>> sets) {
		this.sets = sets;
	}
}
