package registroGastos;
import java.net.*;

public class ClienteAuxiliar1 {

	public static String obtenerinfo(String nombreMaquina, String numPuerto,String nombredad) {
		String info ="";
		try {
			InetAddress serverHost =InetAddress.getByName(nombreMaquina);
			int serverPort = Integer.parseInt(numPuerto);
			
			MiSocketDatagramaCliente miSocket = new MiSocketDatagramaCliente();
			miSocket.enviaMensaje(serverHost,serverPort,nombredad);
			info = miSocket.recibeMensaje();
			miSocket.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return info;
	}
	
}
