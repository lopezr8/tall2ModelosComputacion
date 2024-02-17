package registroGastos;
import java.net.*;

public class MensajeDatagrama {
	private String mensaje; 
	private InetAddress direccionEmisor; 
	private int puertoEmisor; 
	public void fijaValor(String mensaje,InetAddress dir, int puerto) {
		this.mensaje = mensaje; 
		this.direccionEmisor=dir; 
		this.puertoEmisor=puerto; 
	}
	public String obtieneMensaje() {
		return this.mensaje; 
	}
	public InetAddress obtieneDireccion() {
		return this.direccionEmisor;
	}
	public int obtienePuerto() {
		return this.puertoEmisor;
	}
}
