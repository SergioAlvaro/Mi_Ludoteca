package Dominio;
import java.util.Scanner;
import java.util.ArrayList;

public class Ludoteca {
    VideojuegoDeportivo videojuegoDeportivo = new VideojuegoDeportivo();
    VideojuegoEstrategia videojuegoEstrategia = new VideojuegoEstrategia();
    VideojuegoOnline videojuegoOnline = new VideojuegoOnline();
    VideojuegoRol videojuegoRol = new VideojuegoRol();
    Videojuego Videojuego = new Videojuego();
    public Scanner teclado = new Scanner(System.in);
    public int MediaPuntuacion (){
        int t = 0, mediaPuntuacion = 0;
        while (t < Videojuego.nombres.size()){
            mediaPuntuacion += Videojuego.puntuacion.get(t);
            t += 1;
        }
        mediaPuntuacion /= Videojuego.nombres.size();
        return mediaPuntuacion;
    }
    String separadorTipos(int reloj){
        String pregunta = "", respuesta = "";
        if (Videojuego.tipoJuego.get(reloj) == 1){
            pregunta = "el numero de misiones es:";
            respuesta = String.valueOf(videojuegoRol.numeroMisiones.get(reloj).intValue());
        }else if (Videojuego.tipoJuego.get(reloj) == 2){
            pregunta = "el deporte es:";
            respuesta = videojuegoDeportivo.deporte.get(reloj);
        }else if (Videojuego.tipoJuego.get(reloj) == 3){
            pregunta = "numero de facciones:";
            respuesta = String.valueOf(videojuegoEstrategia.numeroFacciones.get(reloj).intValue());
        }else if (Videojuego.tipoJuego.get(reloj) == 4){
            pregunta = "numero de jugadores activos:";
            respuesta = String.valueOf(videojuegoOnline.numeroJugadoresOnline.get(reloj).intValue());
        }
        return (pregunta + " " + respuesta);
    }
    private final ArrayList<String> videojuegos = new ArrayList<>();
    public String mejorJuego (){
        int t = 0, mejorNumero = 0;
        while (t < Videojuego.nombres.size()){
            if (Videojuego.puntuacion.get(t) > Videojuego.puntuacion.get(mejorNumero)){
                mejorNumero = t;
            }
            t += 1;
        }
        return "El mejor juego de la lista es el " + Videojuego.nombres.get(mejorNumero) + " con una puntuacion de " + Videojuego.puntuacion.get(mejorNumero);
    }
    public int buscarPorNombre (Scanner Teclado){
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
    public int buscarPorID (Scanner Teclado){
        int t = 0, r=-1;
        String busqueda;
        System.out.println("¿que codigo quieres buscar?");
        busqueda = Teclado.nextLine();
        while (t < Videojuego.nombres.size()){
            if (Videojuego.nombres.get(t).equals(busqueda)){
                r = t;
            }
            t +=1;
        }
        return r;
    }
    public void buscarJuegoPorIdentificador(){
        int SG = buscarPorID(teclado);
        if (SG == -1) {
            System.out.println("no se ha encontrado el juego");
        } else {
            System.out.println(
                            "------------------\n"
                            + Videojuego.nombres.get(SG) + "\n" +
                            "puntuacion: " + Videojuego.puntuacion.get(SG) + "\n" +
                            "------------------\n"
            );
        }
    }
    public void buscarJuegoPorNombre(){
        int SG = buscarPorNombre(teclado);
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
    }
    public void BuscarJuego(){
        int Daniel = -1;
        System.out.println("""
                    ------------------------------
                    Buscar por nombre          (1)
                    Buscar por referencia      (2)
                    ------------------------------"""
        );
        while (Daniel < 1 || Daniel > 2){
            Daniel = teclado.nextInt();
            teclado.nextLine();
            if (Daniel < 1 || Daniel > 2){
                System.out.println("introducir un numero valido");
            }
        }
        if (Daniel == 1) {
            buscarJuegoPorNombre();
            teclado.nextLine();
        }else {
            buscarJuegoPorIdentificador();
            teclado.nextLine();
        }
    }
    public void fichaJuegos(){
        int reloj = 0;
        while (reloj < Videojuego.horasJugadas.size()) {
            System.out.println("------------");
            System.out.println(Videojuego.nombres.get(reloj));
            System.out.println("Horas jugadas: " + Videojuego.horasJugadas.get(reloj));
            System.out.println("Puntuacion dada: " + Videojuego.puntuacion.get(reloj) + "/100");
            System.out.println("Plataforma: " + Videojuego.plataforma.get(reloj));
            System.out.println("identificador: " + videojuegos.get(reloj));
            System.out.println(separadorTipos(reloj));
            System.out.println("------------");
            reloj += 1;
        }
        teclado.nextLine();
    }
    public void identificador() {
        videojuegos.clear();
        int t = 0;
        while (t < Videojuego.nombres.size()) {
            videojuegos.add(String.valueOf((t + 1)));
            t += 1;
        }
    }
    public void listadoPorPlataformas(){
        System.out.println("Que plataforma quieres buscar");
        String plataforma = teclado.nextLine();
        int reloj = 0;
        int Geo = 0;
        System.out.println("Buscando los juegos de la plataforma " + plataforma);
        while (reloj < Videojuego.nombres.size()){
            if (plataforma.equals(Videojuego.plataforma.get(reloj))){
                System.out.println("------------");
                System.out.println(Videojuego.nombres.get(reloj));
                System.out.println("Horas jugadas: " + Videojuego.horasJugadas.get(reloj));
                System.out.println("Puntuacion dada: " + Videojuego.puntuacion.get(reloj) + "/100");
                System.out.println("identificador: " + videojuegos.get(reloj));
                System.out.println("------------");
                Geo = 1;
            }
            reloj +=1;
        }
        if (Geo == 0){
            System.out.println("no se han encontrado juegos para esa plataforma");
        }
    }
}