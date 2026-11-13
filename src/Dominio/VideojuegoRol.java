package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class VideojuegoRol{
    Videojuego videojuego = new Videojuego();
    Scanner teclado = new Scanner(System.in);
    public ArrayList<Double> numeroMisiones = new ArrayList<>();
    public void Rol(){
        int Control = 0;
        while (Control != 1) {
            System.out.println("Cuantas misiones");
            numeroMisiones.add(teclado.nextDouble());
            if (numeroMisiones.get(videojuego.nombres.size()) <0){
                System.out.println("introducir un numero mayor o igual a 0");
            }
            else {
                Control = 1;
            }
        }
    }
}