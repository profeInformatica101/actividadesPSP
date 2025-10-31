package ej12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;

public class Ip {
	
	public static void main(String [] args) {
		ProcessBuilder pb = new ProcessBuilder("curl", "-s", "https://api.ipify.org?format=json");
		ProcessBuilder pb2 = new ProcessBuilder("hostname", "-I");

		try {
			Instant inicio = Instant.now();
			Process p = pb.start();
			int code = p.waitFor();
			
			
			Duration duracion = Duration.between(inicio, Instant.now());
			
			String linea;
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println("PID del proceso: " + p.pid());
			System.out.println("🌐 Respuesta de la API:");
			while((linea = br.readLine())!= null) {
				System.out.println(linea);
			}
			System.out.println("codigo de salida " + code);
			System.out.println("Duración: " + duracion.toMillis());
			
			if(code == 0) {
				System.out.println("✅ Proceso finalizado correctamente.");
			}
			
			inicio = Instant.now();
			p = pb.start();
			code = p.waitFor();
			duracion = Duration.between(inicio, Instant.now());
			 br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println("PID del proceso: " + p.pid());
			System.out.println("🌐 Respuesta de la API:");
			while((linea = br.readLine())!= null) {
				System.out.println(linea);
			}
			System.out.println("codigo de salida " + code);
			System.out.println("Duración: " + duracion.toMillis());
			
			if(code == 0) {
				System.out.println("✅ Proceso finalizado correctamente.");
			}
			
			
		}catch(Exception ex) {}
	}

}
