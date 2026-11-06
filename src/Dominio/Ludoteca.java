package Dominio;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
public class Ludoteca {
    Videojuego Videojuego = new Videojuego();
    public ArrayList<String> videojuegos = new ArrayList<>();
    public int buscarPorNombre (Scanner Teclado, int Contador){
        int t = 0, r=-1;
        String busqueda;
        System.out.println("¿que juego quieres buscar?");
        busqueda = Teclado.nextLine();
        while (t < Videojuego.nombres.size()){
            if (Videojuego.nombres.get(t).equals(busqueda)){
                r = t;
            }
            t +=1;
        }
        return r;
    }
    public void identificador() {
        videojuegos.clear();
        int t = 0;
        while (t < Videojuego.nombres.size()) {
            videojuegos.add(String.valueOf((t + 1)));
            t += 1;
        }
    }
}