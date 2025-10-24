package ej3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Lanza ls /ruta/que/no/existe y muestra el mensaje de error de stderr.
 */
public class RedireccionError {


	public static void main(String [] args) {
		
		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "/ruta/que/no/existe");
			Process p = pb.start();
			
			InputStream error = p.getErrorStream();
			
			InputStreamReader lector_de_flujo = new InputStreamReader(error);
			BufferedReader br = new BufferedReader(lector_de_flujo);
			
			String linea;
			while( (linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			int codigo = p.waitFor();
			if(codigo == 0) {
				System.out.println("OK");
			}else {
				System.out.println("Hubo error");
			}
			
		}catch(Exception ex) {
			System.err.println(ex);
		}
	}
	
}
