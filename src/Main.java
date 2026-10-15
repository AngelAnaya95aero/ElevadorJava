import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int PISO_MAX = 10;
        int pisoActual = 1;
        boolean activo = true;

        System.out.println("=== ELEVADOR ===");
        System.out.println("Pisos disponibles: 1 al " + PISO_MAX);
        System.out.println("Estás en el piso " + pisoActual);

        while (activo) {
            System.out.print("\n¿A qué piso quieres ir? (0 para salir): ");
            int destino = sc.nextInt();

            if (destino == 0) {
                activo = false;
                System.out.println("Elevador apagado. ¡Hasta luego!");
            } else if (destino < 0) {
                System.out.println("Error: no se pueden poner números negativos.");
            } else if (destino > PISO_MAX) {
                System.out.println("Error: el edificio solo tiene " + PISO_MAX + " pisos.");
            } else if (destino == pisoActual) {
                System.out.println("Error: ya estás en el piso " + pisoActual + " (no se puede repetir).");
            } else {
                if (destino > pisoActual) {
                    System.out.println("Subiendo...");
                    while (pisoActual < destino) {
                        pisoActual++;
                        System.out.print(pisoActual);
                        if (pisoActual < destino) System.out.print(", ");
                        esperar();
                    }
                } else {
                    System.out.println("Bajando...");
                    while (pisoActual > destino) {
                        pisoActual--;
                        System.out.print(pisoActual);
                        if (pisoActual > destino) System.out.print(", ");
                        esperar();
                    }
                }
                System.out.println("\nLlegaste al piso " + pisoActual);
            }
        }
        sc.close();
    }

    static void esperar() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}