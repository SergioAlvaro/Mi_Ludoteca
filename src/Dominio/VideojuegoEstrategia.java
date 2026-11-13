package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class VideojuegoEstrategia {
    Scanner teclado = new Scanner(System.in);
    Videojuego videojuego = new Videojuego();
    public ArrayList<Double> numeroFacciones = new ArrayList<>();
    public void Estrategia() {
        int Control = 0;
        while (Control != 1) {
            System.out.println("Cuantas misiones");
            numeroFacciones.add(teclado.nextDouble());
            if (numeroFacciones.get(videojuego.nombres.size()) < 0) {
                System.out.println("introducir un numero mayor o igual a 0");
            } else {
                Control = 1;
            }
        }
    }
}
