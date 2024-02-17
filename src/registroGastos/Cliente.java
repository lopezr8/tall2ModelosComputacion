package registroGastos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cliente {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("Bienvenido al cliente");
                System.out.println("Seleccione una opción:");
                System.out.println("1. Hacer petición de gastos");
                System.out.println("2. Ver registro de gastos");
                System.out.println("9. Salir");

                String opcion = br.readLine().trim();

                switch (opcion) {
                    case "1":
                        hacerPeticion(br);
                        break;
                    case "2":
                        verRegistro(br);
                        break;
                    case "9":
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void hacerPeticion(BufferedReader br) throws Exception {
        System.out.println("Haciendo petición de gastos...");

        String nombreMaquina = "localhost";
        String numPuerto = "13";
        String nombre = obtenerInputNoVacio(br, "Cual es su nombre?");
        String cedula = obtenerInputNoVacio(br, "Digite su cedula");
        String cantidad = obtenerInputNoVacio(br, "De cuanto dinero es su solicitud de gasto?");
        
        String infGasto = "1-" + nombre + "-" + cedula + "-" + cantidad;
        System.out.println("Información recibida del servidor\n" + ClienteAuxiliar1.obtenerinfo(nombreMaquina, numPuerto, infGasto).trim());
    }

    private static void verRegistro(BufferedReader br) throws Exception {
        System.out.println("Viendo registro de gastos...");
        
        String nombreMaquina = "localhost";
        String numPuerto = "13";
        String nombre = "";
        String cedula = ""; 
        String cantidad = "";
        String infGasto = "2-" + nombre + "-" + cedula + "-" + cantidad;; 
        
        System.out.println("Información recibida del servidor\n" + ClienteAuxiliar1.obtenerinfo(nombreMaquina, numPuerto, infGasto).trim());
    }

    private static String obtenerInputNoVacio(BufferedReader br, String mensaje) throws Exception {
        boolean b = true;
        String input = "";
        
        while (b) {
            System.out.println(mensaje);
            input = br.readLine();
            
            if (input.length() > 0) {
                b = false;
            }
        }
        return input;
    }
}
