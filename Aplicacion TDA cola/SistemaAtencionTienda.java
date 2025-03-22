import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaAtencionTienda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> filaClientes = new LinkedList<>();

        boolean continuar = true;

        System.out.println("=== Sistema de Atención en la Tienda ===");

        while (continuar) {
            System.out.print("Ingrese comando: ");
            String input = scanner.nextLine().trim();
            String[] partes = input.split(" ", 2);
            String comando = partes[0].toUpperCase();

            switch (comando) {
                case "LLEGAR":
                    // Precondición: El nombre ingresado debe ser una cadena no vacía.
                    // Postcondición: El nombre del cliente se agrega al final de la fila.
                    if (partes.length < 2 || partes[1].trim().isEmpty()) {
                        System.out.println("Debe ingresar un nombre.");
                    } else {
                        String nombre = partes[1].trim();
                        filaClientes.add(nombre);
                    }
                    break;

                case "ATENDER":
                    // Precondición: La fila debe tener al menos un cliente.
                    // Postcondición: El primer cliente en la fila es eliminado y mostrado.
                    if (filaClientes.isEmpty()) {
                        System.out.println("No hay clientes en la fila.");
                    } else {
                        String atendido = filaClientes.poll();
                        System.out.println("Atendiendo a: " + atendido);
                    }
                    break;

                case "MOSTRAR":
                    // Precondición: Puede estar vacía o tener clientes.
                    // Postcondición: Se imprime el estado actual de la fila.
                    if (filaClientes.isEmpty()) {
                        System.out.println("Fila actual: (vacía)");
                    } else {
                        System.out.print("Fila actual: ");
                        int i = 0;
                        for (String cliente : filaClientes) {
                            System.out.print(cliente);
                            if (++i < filaClientes.size()) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case "SALIR":
                    // Precondición: Ninguna.
                    // Postcondición: Se finaliza el programa correctamente.
                    continuar = false;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Comando no reconocido. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
