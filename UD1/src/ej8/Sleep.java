package ej8;

import java.util.concurrent.TimeUnit;

public class Sleep {
	/**
	 * Ejecuta sleep 10 y finalízalo si tarda más de 2 segundos.
	 * @param args
	 */
	public static void main(String [] args) {
		try {
			
			ProcessBuilder pb = new ProcessBuilder("sleep", "10").inheritIO();
			Process p = pb.start();
			boolean terminado = p.waitFor(2, TimeUnit.SECONDS);
			if(!terminado) {
				System.out.println("El proceso tarda demasiado. Se cancela");
				p.destroy();
			}else {
				System.out.println("Finalizado correctamente");
			}
			
			
		}catch(Exception ex) {
			System.err.print(ex);
		}
	}

}
