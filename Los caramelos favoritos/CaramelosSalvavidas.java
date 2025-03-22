import java.util.Stack;

public class CaramelosSalvavidas {

    public static void main(String[] args) {
        Stack<String> paquete = new Stack<>();

        // Llenar el paquete de caramelos con colores variados
        llenarPaquete(paquete);

        System.out.println("Paquete original:");
        mostrarPaquete(paquete);

        // Comer solo los caramelos amarillos
        comerCaramelosAmarillos(paquete);

        System.out.println("\nPaquete después de comer caramelos amarillos:");
        mostrarPaquete(paquete);
    }

    // Precondición: La pila 'paquete' debe estar inicializada.
    // Postcondición: Se agregan caramelos de diferentes colores al paquete.
    public static void llenarPaquete(Stack<String> paquete) {
        paquete.push("amarillo");
        paquete.push("rojo");
        paquete.push("verde");
        paquete.push("amarillo");
        paquete.push("azul");
        paquete.push("amarillo");
    }

    // Precondición: La pila 'paquete' debe contener caramelos.
    // Postcondición: Se eliminan los caramelos amarillos y los demás se reinsertan en orden original.
    public static void comerCaramelosAmarillos(Stack<String> paquete) {
        Stack<String> auxiliar = new Stack<>();

        // Sacamos los caramelos y comemos solo los amarillos
        while (!paquete.isEmpty()) {
            String caramelo = paquete.pop();
            if (!caramelo.equalsIgnoreCase("amarillo")) {
                auxiliar.push(caramelo);
            }
        }

        // Devolvemos los caramelos no amarillos al paquete en su orden original
        while (!auxiliar.isEmpty()) {
            paquete.push(auxiliar.pop());
        }
    }

    // Precondición: La pila puede estar vacía o tener elementos.
    // Postcondición: Se muestra el contenido actual del paquete sin modificarlo.
    public static void mostrarPaquete(Stack<String> paquete) {
        if (paquete.isEmpty()) {
            System.out.println("(Paquete vacío)");
        } else {
            // Imprimir sin modificar el paquete
            for (int i = paquete.size() - 1; i >= 0; i--) {
                System.out.println("- " + paquete.get(i));
            }
        }
    }
}
