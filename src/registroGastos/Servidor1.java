package registroGastos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Servidor1 {
	private static int presupuesto = 50000000;
	private static double porcentaje = 0.10;
    private static ArrayList<String> reporte = new ArrayList<>();
    
    public static String getReporte() {
    	String repor="";
    	
    	for(int i = 0; i<reporte.size()  ;i++) {
    		
    		String[] n = reporte.get(i).split("-");
    		List<String> lista = new ArrayList<>(Arrays.asList(n));
    		repor = repor + lista.get(1).trim()+"---"+lista.get(2).trim()+"----"+lista.get(3).trim()+"\n";
    	}
    	
    	return repor;
    }
	
    public static void main(String[] args) {
        int puertoServidor = 13;
        if (args.length == 1)
            puertoServidor = Integer.parseInt(args[0]);
        try {
            MiSocketDatagramaServidor miSocket = new MiSocketDatagramaServidor(puertoServidor);
            System.out.println("El servidor está listo");
            String mensaje = "";
            while (true) {
                MensajeDatagrama peticion = miSocket.recibeMensajeYEmisor();
                System.out.println("Petición recibida");

                String[] n = peticion.obtieneMensaje().split("-");
                List<String> lista = new ArrayList<>(Arrays.asList(n));
                if(Integer.parseInt(lista.get(0).trim())==1  ) {
                	if (Integer.parseInt(lista.get(3).trim()) >= (presupuesto*porcentaje)) {
                        mensaje = lista.get(1) + " no se aprueba el gasto"+ "lo maximo para solicitar es de: "+presupuesto*porcentaje;
                    } else {
                        mensaje = lista.get(1) + " se aprueba el gasto";
                        presupuesto -= Integer.parseInt(lista.get(3).trim());
                        reporte.add(peticion.obtieneMensaje());
                    }
                }else {
                	
                	mensaje = getReporte();
                }
                
      
                //System.out.println("Info enviada " + mensaje);
                System.out.println("Presupuesto disponible: "+presupuesto);

                miSocket.enviaMensaje(peticion.obtieneDireccion(), peticion.obtienePuerto(), mensaje);
                // No cierres el socket dentro del bucle
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
