package ej10;

import java.io.File;

public class EjecutarScript {
	
	public static void main(String [] args) {
		ProcessBuilder pb = new ProcessBuilder("bash", "./hola.sh", "Pablo").inheritIO();
		pb.directory(new File("/home/usuario/Documentos/scripts"));
		pb.environment().put("PRUEBA", "🌹");
		try {
			Process proceso = pb.start();
			
			proceso.waitFor();
			
		}catch(Exception ex) {
			
		}
		
		
	}

}
