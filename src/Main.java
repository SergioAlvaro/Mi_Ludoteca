import java.util.Scanner;

import Dominio.Ludoteca;
import Dominio.Videojuego;
String mejorJuego (int Contador){
    int t = 0, mejorNumero = 0;
    while (t < Contador){
        if (Videojuego.puntuacion.get(t) > Videojuego.puntuacion.get(mejorNumero)){
            mejorNumero = t;
        }
        t += 1;
    }
    return "El mejor juego de la lista es el " + Videojuego.nombres.get(mejorNumero) + " con una puntuacion de " + Videojuego.puntuacion.get(mejorNumero);
}
int MediaPuntuacion (int Contador){
    int t = 0, mediaPuntuacion = 0;
    while (t < Contador){
        mediaPuntuacion += Videojuego.puntuacion.get(t);
        t += 1;
    }
    mediaPuntuacion /= Contador;
    return mediaPuntuacion;
}
int buscarPorNombre (Scanner Teclado, int Contador){
    int t = 0, r=-1;
    String busqueda;
    System.out.println("¿que juego quieres buscar?");
    busqueda = Teclado.nextLine();
    while (t < Contador){
        if (Videojuego.nombres.get(t).equals(busqueda)){
            r = t;
        }
        t +=1;
    }
    return r;
}
int buscarPorCodigotoString (Scanner Teclado, int Contador){
    int t = 0, r=-1;
    String busqueda;
    System.out.println("¿que codigo quieres buscar?");
    busqueda = Teclado.nextLine();
    while (t < Contador){
        if (Videojuego.nombres.get(t).equals(busqueda)){
            r = t;
        }
        t +=1;
    }
    return r;
}
Videojuego Videojuego = new Videojuego();
Ludoteca Ludoteca = new Ludoteca();
void main(){
    Videojuego.ejecutar();
    Ludoteca.identificador();
    Scanner teclado = new Scanner(System.in);
    int Contador = Videojuego.nombres.size(), reloj = 0;
    int Opciones = 0;
    while (true) {
        System.out.println("""
                        
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
                        -----------------------SALIR DEL LA LUDOTECA   (6)----------------------
                        ------------------------------------------------------------------------
                        ------------------------------------------------------------------------""");
        Opciones = teclado.nextInt();
        teclado.nextLine();

        if (Opciones == 1) {
            reloj = 0;
            while (reloj < Videojuego.horasJugadas.size()) {
                System.out.println("------------");
                System.out.println(Videojuego.nombres.get(reloj));
                System.out.println("Horas jugadas: " + Videojuego.horasJugadas.get(reloj));
                System.out.println("Puntuacion dada: " + Videojuego.puntuacion.get(reloj) + "/100");
                System.out.println("Plataforma: " + Videojuego.plataforma.get(reloj));
                System.out.println("------------");
                System.out.println("identificador: " + Ludoteca.videojuegos.get(reloj));
                reloj += 1;
            }
            teclado.nextLine();
        }
        else if (Opciones == 2) {
            System.out.println(mejorJuego(Contador));
            teclado.nextLine();
        }
        else if (Opciones ==3 ){
            int Daniel = -1;
            System.out.println("""
                    Buscar por nombre          (1)
                    Buscar por codigo tostring (2)
                    """);
            while (Daniel < 1 || Daniel > 2){
                Daniel = teclado.nextInt();
                teclado.nextLine();
                if (Daniel < 1 || Daniel > 2){
                    System.out.println("introducir un numero valido");
                }
            }
            if (Daniel == 1) {
                int SG = buscarPorNombre(teclado, Contador);
                if (SG == -1) {
                    System.out.println("no se ha encontrado el juego");
                } else {
                    System.out.println(
                            "-------------\n"
                                    + Videojuego.nombres.get(SG) + "\n" +
                                    "puntuacion: " + Videojuego.puntuacion.get(SG) + "\n" +
                                    "-------------\n"
                    );
                }
                teclado.nextLine();
            }else if(Daniel == 2){
                int SG = buscarPorCodigotoString(teclado, Contador);
                if (SG == -1) {
                    System.out.println("no se ha encontrado el juego");
                } else {
                    System.out.println(
                            "-------------\n"
                                    + Videojuego.nombres.get(SG) + "\n" +
                                    "puntuacion: " + Videojuego.puntuacion.get(SG) + "\n" +
                                    "-------------\n"
                    );
                }
                teclado.nextLine();
            }
        }
        else if (Opciones == 4) {
            Videojuego.ejecutar();
            Ludoteca.identificador();
        }
        else if (Opciones == 5) {
            System.out.println("La media de puntuacion de los juegos es: " + MediaPuntuacion(Contador));
            teclado.nextLine();
        }
        else if (Opciones == 6){
            break;
        }
        else {
            System.out.println("introduzca un numero valido");
            teclado.nextLine();
        }
    }
}

//todo REQ-01 Crear Ludoteca.java en el paquete dominio, junto a Videojuego.java. No crear subclases.
//todo REQ-02 Declarar un atributo privado ArrayList<Videojuego> videojuegos e inicializarlo en el constructor de Ludoteca.
//todo REQ-03 Implementar agregar(Videojuego videojuego) para incorporar a la colección una referencia a un videojuego ya creado. No crear el objeto dentro del método.
//todo REQ-04 Implementar toString() recorriendo la colección y concatenando cada objeto mediante su toString(). Si no hay videojuegos,devolver una cadena vacía.
//todo REQ-05 Implementar buscarPorTitulo(String titulo), que devuelve el primer videojuego con ese título o null si no existe. Utilizar equals() de String para comparar títulos.
//todo REQ-06 Modificar Main.java para crear una Ludoteca, crear al menos tres objetos Videojuego, agregarlos, listar mediante un print y comprobar una búsqueda existente y otra inexistente.
//todo REQ-07 Mantener en Videojuego el criterio de igualdad implementado la semana anterior mediante equals() y hashCode(). No es necesario redefinirlos en Ludoteca.
