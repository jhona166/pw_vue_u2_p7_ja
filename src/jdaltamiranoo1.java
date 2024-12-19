/*Realice el cifrado de un mensaje por permutacion de filas, teniendo como clave 5 filas y la cantidad de 
columnas que sean necesarias(garantice al menos 3).  Los espacios del mensaje originarl se sustituyen con el carácter 
"-". Si en la matriz de cifrado sobran espacios, estos deben llenarse con el caracter
"*".
El algoritmo recibe el mensaje al iniciar y debe mostrar los siguientes resultados 
*El mensaje original
*La matriz de cifrado 
*El mensaje de cifrado

En el caso que se produzca algun error en la ejecución, el mismo debe mostrarse una alerta al usuario*/
import java.util.Scanner;

public class CifradoPorPermutacion {

    public static void cifradoPorPermutacion(String mensaje) {
        try {
            // Paso 1: Preparar el mensaje original (sustituir espacios por "-")
            String mensajeOriginal = mensaje.replace(" ", "-");

            // Paso 2: Calcular el número de columnas
            int filas = 5;
            int columnas = (int) Math.ceil((double) mensajeOriginal.length() / filas);

            // Paso 3: Llenar la matriz con el mensaje y agregar "*" si es necesario
            char[][] matriz = new char[filas][columnas];

            int index = 0;
            // Llenamos la matriz con los caracteres del mensaje
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (index < mensajeOriginal.length()) {
                        matriz[i][j] = mensajeOriginal.charAt(index++);
                    } else {
                        matriz[i][j] = '*'; // Llenamos con "*" si el mensaje es más corto
                    }
                }
            }

            // Paso 4: Mostrar el mensaje original y la matriz de cifrado
            System.out.println("Mensaje original:");
            System.out.println(mensajeOriginal);

            System.out.println("\nMatriz de cifrado:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }

            // Paso 5: Crear el mensaje cifrado (leer por columnas)
            StringBuilder mensajeCifrado = new StringBuilder();
            for (int j = 0; j < columnas; j++) {
                for (int i = 0; i < filas; i++) {
                    mensajeCifrado.append(matriz[i][j]);
                }
            }

            // Paso 6: Mostrar el mensaje cifrado
            System.out.println("\nMensaje cifrado:");
            System.out.println(mensajeCifrado.toString());

        } catch (Exception e) {
            System.out.println("Error al realizar el cifrado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el mensaje a cifrar
        System.out.println("Ingrese el mensaje a cifrar:");
        String mensaje = scanner.nextLine();

        // Llamar al método de cifrado
        cifradoPorPermutacion(mensaje);
        
        scanner.close();
    }
}
