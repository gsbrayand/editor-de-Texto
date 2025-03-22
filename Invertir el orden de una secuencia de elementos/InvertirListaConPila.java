import java.util.Stack;

public class InvertirListaConPila {

    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5};

        System.out.println("Lista original:");
        mostrarLista(lista);

        invertirListaConPila(lista);

        System.out.println("\nLista invertida:");
        mostrarLista(lista);
    }

    // Precondición: lista debe estar declarada y contener elementos.
    // Postcondición: se imprime el contenido de la lista sin modificarla.
    public static void mostrarLista(int[] lista) {
        for (int valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    // Precondición: lista debe tener elementos válidos.
    // Postcondición: la lista queda con los elementos en orden invertido.
    public static void invertirListaConPila(int[] lista) {
        Stack<Integer> pila = new Stack<>();

        // Empujar todos los elementos de la lista a la pila
        for (int valor : lista) {
            pila.push(valor);
        }

        // Extraer de la pila y sobrescribir la lista
        for (int i = 0; i < lista.length; i++) {
            lista[i] = pila.pop();
        }
    }
}
