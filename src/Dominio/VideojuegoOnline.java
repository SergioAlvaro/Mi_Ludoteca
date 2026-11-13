package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class VideojuegoOnline {

    Scanner teclado = new Scanner(System.in);
    Videojuego videojuego = new Videojuego();
    public ArrayList<Double> numeroJugadoresOnline = new ArrayList<>();
    public void Online() {
        int Control = 0;
        while (Control != 1) {
            System.out.println("Cuantas misiones");
            numeroJugadoresOnline.add(teclado.nextDouble());
            if (numeroJugadoresOnline.get(videojuego.nombres.size()) < 0) {
                System.out.println("introducir un numero mayor o igual a 0");
            } else {
                Control = 1;
            }
        }
    }
}
