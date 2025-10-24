package ej4;
/**
 * Ejecuta top -b -n1 heredando la salida directamente a tu terminal.

 */
public class InheritIO {
	
	public static void main(String [] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("top", "-b", "-n1").inheritIO();
			Process proceso = pb.start();
			int codigo = proceso.waitFor();
		}catch(Exception ex) {
			System.err.println(ex);
		}
	}
	
}
