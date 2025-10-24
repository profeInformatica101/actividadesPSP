package ej5;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Ejecuta pwd desde un directorio distinto al actual (por ejemplo, /tmp).

 */
public class Direccion {

	public static void main(String [] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("bash","-lc","pwd").directory(new File("/tmp")).inheritIO();
			Process proceso = pb.start();
			/*
			InputStream inputStream = proceso.getInputStream();
			InputStreamReader lector_de_flujo = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(lector_de_flujo);
			
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			*/
			
			int code = proceso.waitFor();
		}catch(Exception ex) {
			
		}
	}
}
