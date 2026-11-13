import java.util.Scanner;
import Dominio.Ludoteca;
import Dominio.Videojuego;

Videojuego Videojuego = new Videojuego();
Ludoteca Ludoteca = new Ludoteca();
void main(){
    Videojuego.ejecutar();
    Ludoteca.identificador();
    Scanner teclado = new Scanner(System.in);
    int Opciones;
    while (true) {
        System.out.println("""
                        ------------------------------------------------------------------------
                        ------------------------------------------------------------------------
                        ------------------------------------------------------------------------
                        --------------▒▒▒    ▒▒▒   ▒▒▒▒▒▒▒▒   ▒▒▒    ▒▒  ▒▒    ▒▒---------------
                        --------------▒▒ ▒  ▒ ▒▒   ▒▒         ▒▒ ▒   ▒▒  ▒▒    ▒▒---------------
                        --------------▒▒  ▒▒  ▒▒   ▒▒▒▒▒▒▒▒   ▒▒  ▒  ▒▒  ▒▒    ▒▒---------------
                        --------------▒▒      ▒▒   ▒▒         ▒▒   ▒ ▒▒  ▒▒    ▒▒---------------
                        --------------▒▒      ▒▒   ▒▒▒▒▒▒▒▒   ▒▒    ▒▒▒  ▒▒▒▒▒▒▒▒---------------
                        ------------------------------------------------------------------------
                        -------------------------------OPCIONES---------------------------------
                        ------------------------------------------------------------------------
                        -----------------------LISTADO DE JUEGOS       (1)----------------------
                        -----------------------BUSCAR MEJOR JUEGO      (2)----------------------
                        -----------------------BUSCAR JUEGO            (3)----------------------
                        -----------------------CAMBIAR LISTADO         (4)----------------------
                        -----------------------MEDIA PUNTUACION JUEGOS (5)----------------------
                        -----------------------LISTADO POR PLATAFORMA  (6)----------------------
                        -----------------------SALIR DEL LA LUDOTECA   (7)----------------------
                        ------------------------------------------------------------------------
                        ------------------------------------------------------------------------""");
        Opciones = teclado.nextInt();
        teclado.nextLine();
        if (Opciones == 1) {
            Ludoteca.fichaJuegos();
        }
        else if (Opciones == 2) {
            System.out.println(Ludoteca.mejorJuego());
            teclado.nextLine();
        }
        else if (Opciones ==3 ) {
            Ludoteca.BuscarJuego();
        }
        else if (Opciones == 4) {
            Videojuego.ejecutar();
            Ludoteca.identificador();
        }
        else if (Opciones == 5) {
            System.out.println("La media de puntuacion de los juegos es: " + Ludoteca.MediaPuntuacion());
            teclado.nextLine();
        }
        else if (Opciones == 6) {
            Ludoteca.listadoPorPlataformas();
            teclado.nextLine();
        }
        else if (Opciones == 7){
            break;
        }
        else {
            System.out.println("introduzca un numero valido");
            teclado.nextLine();
        }
    }
}