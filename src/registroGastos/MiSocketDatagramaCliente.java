package registroGastos;
import java.net.*;
import java.io.*;

public class MiSocketDatagramaCliente extends DatagramSocket {
	static final int MAX_LON = 500;
	
	MiSocketDatagramaCliente() throws SocketException{
		super();
	}
	
	MiSocketDatagramaCliente(int numPuerto) throws SocketException{
		super(numPuerto);
	}
	public void enviaMensaje(InetAddress maquinaReceptora,int puertoReceptor,String nombredad) throws IOException {
		byte[] almacenEnvio = nombredad.getBytes();
		DatagramPacket datagrama = new DatagramPacket(almacenEnvio,almacenEnvio.length,maquinaReceptora,puertoReceptor);
		this.send(datagrama);
	}
	public String recibeMensaje() throws IOException{
		byte[] almacenRecepcion = new byte[MAX_LON];
		DatagramPacket datagram = new DatagramPacket(almacenRecepcion,MAX_LON);
		this.receive(datagram);
		String mensaje = new String (almacenRecepcion);
		return mensaje;
	}
}
