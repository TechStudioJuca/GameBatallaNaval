import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
// Clase principal del juego
public class BatallaNaval {
    public static void main(String[] args) {
        BatallaNaval juego = new BatallaNaval();
        juego.iniciarJuego();
    }

    public void iniciarJuego() {
        Juego juego = new Juego();
        juego.jugar();
    }
}
