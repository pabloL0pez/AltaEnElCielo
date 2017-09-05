package myPackage;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		generarSalidas();
	}
	
	public static void generarSalidas() {
		File entrada;
		File salida;
		AltaEnElCielo alta;
		try {
			entrada = new File("./Lote de prueba/Entrada/00_CasoTrivial.in");
			salida = new File("./Lote de prueba/Salida producida/00_CasoTrivial.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/01_RecibenSoloElRetazoInicial.in");
			salida = new File("./Lote de prueba/Salida producida/01_RecibenSoloElRetazoInicial.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/02_ElRolloQuedaVacío.in");
			salida = new File("./Lote de prueba/Salida producida/02_ElRolloQuedaVacío.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/03_SoloUnaBanderaTieneCosturas.in");
			salida = new File("./Lote de prueba/Salida producida/03_SoloUnaBanderaTieneCosturas.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/04_TodasTienenCosturaMenosUna.in");
			salida = new File("./Lote de prueba/Salida producida/04_TodasTienenCosturaMenosUna.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/05_TodasLasBanderasQuedanIgualDeLargas.in");
			salida = new File("./Lote de prueba/Salida producida/05_TodasLasBanderasQuedanIgualDeLargas.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/06_NoHaySecuenciaComún.in");
			salida = new File("./Lote de prueba/Salida producida/06_NoHaySecuenciaComún.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/07_SecuenciaComúnDeLongitudUno.in");
			salida = new File("./Lote de prueba/Salida producida/07_SecuenciaComúnDeLongitudUno.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
			
			entrada = new File("./Lote de prueba/Entrada/08_HayVariasSecuenciasEnComúnConLaMismaLongitud.in");
			salida = new File("./Lote de prueba/Salida producida/08_HayVariasSecuenciasEnComúnConLaMismaLongitud.out");
			alta = new AltaEnElCielo(entrada, salida);
			alta.resolver();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	public static void secuenciaDeBlautzik(int inicio, int iter) {
		String num = String.valueOf(inicio);
		int nuevo = inicio;
		int cifra;
		System.out.print(inicio);
		for (int i = 0; i < iter; i++) {			
			for (int j = 0; j < num.length(); j++) {
				cifra = Character.digit(num.charAt(j), 10);
				nuevo += cifra;
			}
			num = String.valueOf(nuevo);
			System.out.print(" " + nuevo);
		}
		System.out.println();
	}
	*/
}
