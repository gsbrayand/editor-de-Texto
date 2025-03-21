import java.util.Stack;
import java.util.Scanner;

class PilaTexto {
    private Stack<String> texto;
    private Stack<String> pilaDeshacer;

    public PilaTexto() {
        this.texto = new Stack<>();
        this.pilaDeshacer = new Stack<>();
    }

    public void agregar(String linea) {
        texto.push(linea);
        pilaDeshacer.clear();
    }

    public void deshacer() {
        if (!texto.isEmpty()) {
            pilaDeshacer.push(texto.pop());
        } else {
            System.out.println("Nada que deshacer.");
        }
    }

    public void rehacer() {
        if (!pilaDeshacer.isEmpty()) {
            texto.push(pilaDeshacer.pop());
        } else {
            System.out.println("Nada que rehacer.");
        }
    }

    public void mostrar() {
        if (!texto.isEmpty()) {
            for (String linea : texto) {
                System.out.println(linea);
            }
        } else {
            System.out.println("(Texto vacío)");
        }
    }
}

public class EditorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilaTexto editor = new PilaTexto();

        while (true) {
            String comando = scanner.nextLine().trim();
            if (comando.equals("SALIR")) {
                break;
            } else if (comando.equals("DESHACER")) {
                editor.deshacer();
            } else if (comando.equals("REHACER")) {
                editor.rehacer();
            } else if (comando.equals("MOSTRAR")) {
                editor.mostrar();
            } else {
                editor.agregar(comando);
            }
        }
        scanner.close();
    }
}
