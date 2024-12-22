import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
// Clase Juego que contiene la lógica principal
class Juego {
    private static final int TAMANO_TABLERO = 10;
    private static final int NUMERO_BARCOS = 5;
    private char[][] tableroJugador1;
    private char[][] tableroJugador2;
    private ArrayList<int[]> listaCoordenadasJugador1;
    private ArrayList<int[]> listaCoordenadasJugador2;
    private ArrayList<String> listaJugador1;  // Lista adicional 1
    private ArrayList<String> listaJugador2;  // Lista adicional 2
    private ArrayList<String> listaGeneral;   // Lista adicional 3
    private Stack<int[]> pilaJugador1;
    private Stack<int[]> pilaJugador2;
    private Queue<int[]> colaJugador1;
    private Queue<int[]> colaJugador2;
    private Random random;
    private Scanner scanner;

    public Juego() {
        tableroJugador1 = new char[TAMANO_TABLERO][TAMANO_TABLERO];
        tableroJugador2 = new char[TAMANO_TABLERO][TAMANO_TABLERO];
        listaCoordenadasJugador1 = new ArrayList<>();
        listaCoordenadasJugador2 = new ArrayList<>();
        listaJugador1 = new ArrayList<>();     // Inicialización de la lista adicional 1
        listaJugador2 = new ArrayList<>();     // Inicialización de la lista adicional 2
        listaGeneral = new ArrayList<>();      // Inicialización de la lista adicional 3
        pilaJugador1 = new Stack<>();
        pilaJugador2 = new Stack<>();
        colaJugador1 = new LinkedList<>();
        colaJugador2 = new LinkedList<>();
        random = new Random();
        scanner = new Scanner(System.in);
        inicializarTableros();
        colocarBarcos(tableroJugador1, listaCoordenadasJugador1);
        colocarBarcos(tableroJugador2, listaCoordenadasJugador2);
    }

    // Métodos privados
    private void inicializarTableros() {
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            for (int j = 0; j < TAMANO_TABLERO; j++) {
                tableroJugador1[i][j] = '~';
                tableroJugador2[i][j] = '~';
            }
        }
    }

    private void colocarBarcos(char[][] tablero, ArrayList<int[]> listaCoordenadas) {
        for (int i = 0; i < NUMERO_BARCOS; i++) {
            int x = random.nextInt(TAMANO_TABLERO);
            int y = random.nextInt(TAMANO_TABLERO);
            tablero[x][y] = 'B';
            int[] coordenadas = {x, y};
            listaCoordenadas.add(coordenadas);
        }
    }

    public void jugar() {
        while (true) {
            // Limpiar pantalla
            limpiarPantalla();

            // Turno del jugador 1
            System.out.println("Tablero del jugador 1:");
            imprimirTablero(tableroJugador1);
            jugarTurno(tableroJugador2, listaCoordenadasJugador2);

            // Limpiar pantalla
            limpiarPantalla();

            // Turno del jugador 2
            System.out.println("Tablero del jugador 2:");
            imprimirTablero(tableroJugador2);
            jugarTurno(tableroJugador1, listaCoordenadasJugador1);

            // Verificar si hay un ganador
            if (ganador(tableroJugador2)) {
                System.out.println("¡Jugador 1 gana!");
                imprimirGanador("JUGADOR 1");
                break;
            } else if (ganador(tableroJugador1)) {
                System.out.println("¡Jugador 2 gana!");
                imprimirGanador("JUGADOR 2");
                break;
            }
        }
    }

    // Método protegido que puede ser heredado y sobrescrito
    protected void jugarTurno(char[][] tableroOponente, ArrayList<int[]> listaCoordenadasOponente) {
        System.out.print("Ingrese la coordenada x (1-" + TAMANO_TABLERO + "): ");
        int x = scanner.nextInt() - 1;
        System.out.print("Ingrese la coordenada y (1-" + TAMANO_TABLERO + "): ");
        int y = scanner.nextInt() - 1;
        if (tableroOponente[x][y] == 'B') {
            System.out.println("¡Impacto!");
            tableroOponente[x][y] = 'X';
        } else {
            System.out.println("¡Agua!");
            tableroOponente[x][y] = 'O';
        }
        int[] coordenadas = {x, y};
        listaCoordenadasOponente.add(coordenadas);
        pilaJugador1.push(coordenadas);
        colaJugador1.offer(coordenadas);
    }

    private void imprimirTablero(char[][] tablero) {
        System.out.print(" ");
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANO_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean ganador(char[][] tablero) {
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            for (int j = 0; j < TAMANO_TABLERO; j++) {
                if (tablero[i][j] == 'B') {
                    return false;
                }
            }
        }
        return true;
    }

    private void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private void imprimirGanador(String nombreGanador) {
        System.out.println("*************************************");
        System.out.println("*                                   *");
        System.out.println("*          WINNER!!!                *");
        System.out.println("*                                   *");
        System.out.println("*          " + nombreGanador + "          *");
        System.out.println("*                                   *");
        System.out.println("*************************************");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
