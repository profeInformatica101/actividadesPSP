package ej6;
/**
 * Define una variable de entorno (p. ej. MI_VAR=UD1) y verifica su valor con printenv.
 */
//Son valores globales que afectan cómo funcionan los programas dentro del sistema.
public class VariablesEntorno {

	public static void main(String [] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("bash","-lc","printenv MI_VAR").inheritIO();
			pb.environment().put("MI_VAR","UD1");
			
			Process proceso = pb.start();
			
			 
			proceso.waitFor();
			
		}catch(Exception ex) {
			System.err.println(ex);
		}
		
	}
}
