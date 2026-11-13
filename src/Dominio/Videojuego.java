package Dominio;
import java.util.ArrayList;
import java.util.Scanner;

public class Videojuego {
    Scanner teclado = new Scanner(System.in);
    public ArrayList<Double> tipoJuego = new ArrayList<>();
    //1 - ROL
    //2 - DEPORTIVO
    // 3 - ESTRATEGIA
    // 4 - ONLINE
    VideojuegoRol videojuegoRol = new VideojuegoRol();
    VideojuegoDeportivo videojuegoDeportivo = new VideojuegoDeportivo();
    VideojuegoEstrategia videojuegoEstrategia = new VideojuegoEstrategia();
    VideojuegoOnline videojuegoOnline = new VideojuegoOnline();

    public ArrayList<String> nombres= new ArrayList<>();
    public ArrayList<String> plataforma= new ArrayList<>();
    public ArrayList<Double> puntuacion= new ArrayList<>();
    public ArrayList<Double> horasJugadas= new ArrayList<>();
    Double puntuacionValida(Scanner teclado){
        double apoyo = -1.00;
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
        double apoyo = -1.00;
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
        int control = -1, control2 = -1;
        Double apoyo;
        nombres.clear();
        plataforma.clear();
        puntuacion.clear();
        horasJugadas.clear();
        tipoJuego.clear();
        videojuegoRol.numeroMisiones.clear();
        videojuegoOnline.numeroJugadoresOnline.clear();
        videojuegoEstrategia.numeroFacciones.clear();
        videojuegoDeportivo.deporte.clear();
        while (control != 2){
            System.out.println("Que juego quieres introducir");
            nombres.add(teclado.nextLine());
            System.out.println("En que plataforma está el juego");
            plataforma.add(teclado.nextLine());
            System.out.println("que puntuacion le quieres meter");
            apoyo = puntuacionValida(teclado);
            puntuacion.add(apoyo);
            apoyo = horasValida(teclado);
            horasJugadas.add(apoyo);
            System.out.println("que tipo de juego es");
            while (true){
                System.out.println("""
                        1) VIDEOJUEGO DE ROL
                        2) VIDEOJUEGO DEPORTIVO
                        3) VIDEOJUEGO DE ESTRATEGIA
                        4) VIDEOJUEGO ONLINE""");
                control2 = teclado.nextInt();
                if (control2 < 1 || control2 > 4){
                    System.out.println("introduce un valor valido");
                }
                else {
                    tipoJuego.add((double) control2);
                    if(tipoJuego.get(tipoJuego.size()) == 1){
                        videojuegoRol.Rol();

                        videojuegoOnline.numeroJugadoresOnline.add(0.00);
                        videojuegoDeportivo.deporte.add("");
                        videojuegoEstrategia.numeroFacciones.add(0.00);
                    }
                    else if (tipoJuego.get(tipoJuego.size()) == 2) {
                        videojuegoDeportivo.Deportivo();

                        videojuegoOnline.numeroJugadoresOnline.add(0.00);
                        videojuegoRol.numeroMisiones.add(0.00);
                        videojuegoEstrategia.numeroFacciones.add(0.00);
                    }
                    else if (tipoJuego.get(tipoJuego.size()) == 3) {
                        videojuegoEstrategia.Estrategia();

                        videojuegoOnline.numeroJugadoresOnline.add(0.00);
                        videojuegoRol.numeroMisiones.add(0.00);
                        videojuegoDeportivo.deporte.add("");
                    }
                    else if (tipoJuego.get(tipoJuego.size()) == 4) {
                        videojuegoOnline.Online();

                        videojuegoDeportivo.deporte.add("");
                        videojuegoEstrategia.numeroFacciones.add(0.00);
                        videojuegoRol.numeroMisiones.add(0.00);
                    }
                    break;
                }
            }
            while (control < 1||control>2) {
                System.out.println("""
                        1) añadir otro juego.
                        2) terminar de añadir.""");
                control = teclado.nextInt();
                teclado.nextLine();
                if (control < 1||control>2){
                    System.out.println("presione 1 o 2");
                }
            }
            if (control==1){
                control = -1;
            }
        }
    }
}