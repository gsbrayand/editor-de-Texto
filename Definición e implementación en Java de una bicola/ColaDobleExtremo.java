import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ColaDobleExtremo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> deque = new LinkedList<>();

        boolean activo = true;

        System.out.println("=== Cola de Doble Extremo (Deque) ===");

        while (activo) {
            System.out.println("\nComandos disponibles:");
            System.out.println("1. agregarFrente [nombre]");
            System.out.println("2. agregarFinal [nombre]");
            System.out.println("3. eliminarFrente");
            System.out.println("4. eliminarFinal");
            System.out.println("5. mostrar");
            System.out.println("6. salir");
            System.out.print("\nIngrese comando: ");

            String input = scanner.nextLine().trim();
            String[] partes = input.split(" ", 2);
            String comando = partes[0].toLowerCase();

            switch (comando) {
                case "agregarfrente":
                    // Precondición: nombre no nulo ni vacío.
                    // Postcondición: el nombre se agrega al inicio del deque.
                    if (partes.length < 2 || partes[1].trim().isEmpty()) {
                        System.out.println("Debe ingresar un nombre válido.");
                    } else {
                        deque.addFirst(partes[1].trim());
                        System.out.println("Agregado al frente.");
                    }
                    break;

                case "agregarfinal":
                    // Precondición: nombre no nulo ni vacío.
                    // Postcondición: el nombre se agrega al final del deque.
                    if (partes.length < 2 || partes[1].trim().isEmpty()) {
                        System.out.println("Debe ingresar un nombre válido.");
                    } else {
                        deque.addLast(partes[1].trim());
                        System.out.println("Agregado al final.");
                    }
                    break;

                case "eliminarfrente":
                    // Precondición: el deque no debe estar vacío.
                    // Postcondición: el primer elemento es eliminado y mostrado.
                    if (deque.isEmpty()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Eliminado del frente: " + deque.removeFirst());
                    }
                    break;

                case "eliminarfinal":
                    // Precondición: el deque no debe estar vacío.
                    // Postcondición: el último elemento es eliminado y mostrado.
                    if (deque.isEmpty()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Eliminado del final: " + deque.removeLast());
                    }
                    break;

                case "mostrar":
                    // Precondición: ninguna.
                    // Postcondición: muestra todos los elementos del deque.
                    if (deque.isEmpty()) {
                        System.out.println("Cola vacía.");
                    } else {
                        System.out.println("Cola actual: " + String.join(", ", deque));
                    }
                    break;

                case "salir":
                    // Precondición: ninguna.
                    // Postcondición: se cierra el programa.
                    activo = false;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Comando no reconocido.");
            }
        }

        scanner.close();
    }
}
