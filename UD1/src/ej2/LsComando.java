package ej2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Ejecuta ls -l, lee stdout del proceso 
 * y muéstralo por consola Java.
 */
public class LsComando {

	public static void main(String [] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "-l");
			Process proceso = pb.start();
			// FLUJO DE ENTRADA DE BYTE --> 0, 1
			InputStream inputStream = proceso.getInputStream();
			InputStreamReader lector_de_flujo = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(lector_de_flujo);
			
			String linea;
			linea = br.readLine();
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			int codigo = proceso.waitFor();
			
			if(codigo == 0) {
				System.out.println("Todo fue bien");
			}else {
				System.err.println("Error");
			}
			br.close();
		}catch(Exception ex) {
			
		}
		
		
		
		
		
	}
	
	
}
