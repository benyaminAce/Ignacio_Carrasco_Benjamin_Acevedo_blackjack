import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un jugador en el BlackJack
 * Mantiene la lista de cartas que el jugador tiene en la mano
 */

public class Jugador {

    private List<Carta>cartas;

    /**
     * Constructor de la clase Jugador. Inicializa la lista de cartas
     */
    public Jugador() {

        cartas = new ArrayList<Carta>();
    }


    /**
     * Metodo que devuelve la lista de al jugador
     *
     * @return lista de  cartas que tiene el jugador
     */

    public List<Carta> getCartas() {
        return cartas;
    }

}
