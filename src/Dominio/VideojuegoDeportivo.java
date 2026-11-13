package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

public class VideojuegoDeportivo {
        Scanner teclado = new Scanner(System.in);
        public ArrayList<String> deporte = new ArrayList<>();
        public void Deportivo(){
            System.out.println("Que deporte es");
            deporte.add(teclado.nextLine());
        }
}

