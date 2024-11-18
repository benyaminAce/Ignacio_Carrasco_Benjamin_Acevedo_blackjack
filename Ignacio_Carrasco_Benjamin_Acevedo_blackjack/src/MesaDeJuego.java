import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * clase principal que gestiona una partida de Blackjack.
 */
public class MesaDeJuego {

     //genera numeros aleatorios para las cartas

    private static final Random RANDOM = new Random();

    private static final Scanner SCANNER = new Scanner(System.in);

    //listas para las cartas del jugador y el crupier

    private List<Carta> cartasJugador;
    private List<Carta> cartasCrupier;

    private Baraja baraja;

    /**
     * metodo principal que inicia la partida de Blackjack
     * reparte cartas, permite al jugador decidir, y determina el ganador
     */
    public void empezarPartida() throws InterruptedException {
        baraja = new Baraja();

         //inicializa las manos del jugador y del crupier

        cartasCrupier = new ArrayList<>();
        cartasJugador = new ArrayList<>();

        System.out.println("\n--Black Jack 21--");
        System.out.println("(A considerar. J: numero 11 - Q: numero 12 - K: numero 13)");

        System.out.println("\nRepartiendo 2 cartas a jugador y crupier");
        System.out.println("Empezando por jugador\n");


        //reparte 2 cartas al jugador

        cartasJugador.add(baraja.obtener());
        cartasJugador.add(baraja.obtener());

        //reparte 2 cartas al grupier

        cartasCrupier.add(baraja.obtener());
        cartasCrupier.add(baraja.obtener());

         //pregunta al jugador si quiere mas cartas

        preguntarJugador();

         //calcula el puntaje del jugador y verificar si pierde

        int cantidadCartasJugador = contar(cartasJugador);
        if(cantidadCartasJugador > 21){
            System.out.println("Perdiste : ");
            empezarPartida();
        }
        //turno del crupier
        crupier();
        //determina el ganador
        decidirGanador();

    }

    /**
     * calcula la suma total
     * @param cartas lista de cartas
     * @return la suma total
     */
    public int contar(List<Carta> cartas){
        int cantidad = 0;

        for(Carta carta : cartas){
            /**
             * asigna el valor a las cartas J, Q, K o 10
             */
            if(carta.getValor() == 11 ||
            carta.getValor() == 12 ||
            carta.getValor() == 13 ||
             carta.getValor() == 10){
                cantidad += 10;
            } else {
                cantidad += carta.getValor();
            }
        }

        return cantidad;
    }

    //permite al jugador decidir si quiere más cartas o se planta.

    public void preguntarJugador(){

        System.out.println("Cartas = ");
        /**
         * muestra las cartas actuales del jugador.
         */
        for (Carta carta : cartasJugador) {
            System.out.println(carta);
        }

        int cantidad = contar(cartasJugador);
        System.out.println("Cantidad > " + cantidad);
        // ciclo para preguntar si desea otra carta
        while (true){
            System.out.println("¿Quieres otra carta?: (si/no) ");
            String respuesta = SCANNER.nextLine();

            if(respuesta.equalsIgnoreCase("si")) {
                // agregar una nueva carta al jugador
                cartasJugador.add(baraja.obtener());
                // muestra las cartas actualizadas
                for (Carta carta : cartasJugador) {
                    System.out.println(carta);
                }
                // actuliza y muestra la nueva cantidad
                cantidad = contar(cartasJugador);
                System.out.println("Cantidad > " + cantidad);
            } else {
                break; //rompe el cliclo
            }


        }

    }
    /**
     * simula el turno del crupier, quien debe pedir cartas hasta alcanzar al menos 17.
     */
    public void crupier() throws InterruptedException {

        System.out.println("\nCartas Crupier = ");
        // muestra las cartes del crupier
        for(Carta carta : cartasCrupier) {
            System.out.println(carta);
        }

        int cantidad = contar(cartasCrupier);
        System.out.println("Cantidad Crupier > " + cantidad);
        Thread.sleep(1000L);
        // el crupier pide cartes hasta llegar a 17
        while (cantidad < 17){
            cartasCrupier.add(baraja.obtener());
            cantidad = contar(cartasCrupier);

            for(Carta carta : cartasCrupier) {
                System.out.println(carta);
            }
            System.out.println("Cantidad Crupier > " + cantidad);

            Thread.sleep(1000L); //pausa para cada turno
        }

        System.out.println("\nFINALIZADOOO\n");

    }
    /**
     * Determina el ganador comparando las manos del jugador y el crupier.
     * Reinicia la partida en caso de empate o blackjack.
     */
    public void decidirGanador() throws InterruptedException {
        int cantidadJugador = contar(cartasJugador);
        int cantidadCrupier = contar(cartasCrupier);

        if(cantidadJugador == cantidadCrupier){
            System.out.println("EMPATE");
            empezarPartida(); //reinicia si empatas
        } else if(cantidadJugador == 21){
            System.out.println(("BLACKJACK. HAZ GANADO"));
            empezarPartida();// reinicia si ganas
        } else if(cantidadCrupier == 21){
            System.out.println("BLACKJACK PARA EL CRUPIER");
            empezarPartida();// reinicia si pierdes
        }

        if(cantidadJugador > cantidadCrupier) {
            System.out.println("Haz ganado!!!");
        } else {
            System.out.println("Ha ganado el crupier");
        }

        empezarPartida(); // reinicia la partida
    }
}
