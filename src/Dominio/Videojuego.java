package Dominio;

import java.util.ArrayList;
import java.util.Scanner;
public class Videojuego {
    Scanner teclado = new Scanner(System.in);
    public ArrayList<String> nombres= new ArrayList<>();
    public ArrayList<String> plataforma= new ArrayList<>();
    public ArrayList<Double> puntuacion= new ArrayList<>();
    public ArrayList<Double> horasJugadas= new ArrayList<>();
    Double puntuacionValida(Scanner teclado){
        Double apoyo = -1.00;
        while (apoyo < 0|| apoyo > 100){
            apoyo = teclado.nextDouble();
            teclado.nextLine();
            if (apoyo < 0|| apoyo > 100){
                System.out.println("la puntuacion introducida no se encuentra entre los valores permitidos, introduzca valores validos (entre el 0 y el 100)");
            }
        }
        return apoyo;
    }
    Double horasValida(Scanner teclado){
        Double apoyo = -1.00;
        System.out.println("Cuantas horas tienes en el juego");
        while (apoyo<0.00){
            apoyo = teclado.nextDouble();
            if (apoyo<0){
                System.out.println("no puedes tener horas negativas");
            }
        }
        return apoyo;
    }
     public void ejecutar (){
        int control = -1;
        int reloj = 0;
        Double apoyo = -1.00;
        nombres.clear();
        plataforma.clear();
        puntuacion.clear();
        horasJugadas.clear();
        while (control != 1){
            System.out.println("Que juego quieres introducir");
            nombres.add(teclado.nextLine());
            System.out.println("En que plataforma está el juego");
            plataforma.add(teclado.nextLine());
            System.out.println("que puntuacion le quieres meter");
            apoyo = puntuacionValida(teclado);
            puntuacion.add(apoyo);
            apoyo = -1.00;
            apoyo = horasValida(teclado);
            horasJugadas.add(apoyo);
            apoyo = -1.00;
            while (control < 0||control>1) {
                System.out.println("""
                        0) añadir otro juego.
                        1) terminar de añadir.""");
                control = teclado.nextInt();
                teclado.nextLine();
                if (control < 0||control>1){
                    System.out.println("presione 1 o 0");
                }
            }
            if (control==0){
                control = -1;
            }
        }
     }
}