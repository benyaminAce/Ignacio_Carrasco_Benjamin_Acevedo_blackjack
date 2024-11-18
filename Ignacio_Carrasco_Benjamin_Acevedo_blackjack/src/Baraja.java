import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Clase que representa una baraja de cartas
 *Crea almacena, baraja y reparte las cartas
 */

public class Baraja {

    private List<Carta> cartas;

    /**
     * Constructor de la clase Baraja. Inicializa la baraja creando las cartas con sus palos y valores del 1 al 13
     * y luego las baraja para que sean aleatorias
     */

    public Baraja() {
        cartas = new ArrayList<>();

        for (int i = 0; i < 13; i++) {
            cartas.add(new Carta(Pinta.PICA, i + 1));
        }

        for (int i = 0; i < 13; i++) {
            cartas.add(new Carta(Pinta.CORAZON, i + 1));
        }

        for (int i = 0; i < 13; i++) {
            cartas.add(new Carta(Pinta.CORAZON, i + 1));
        }

        for (int i = 0; i < 13; i++) {
            cartas.add(new Carta(Pinta.TREBOL, i + 1));
        }

        Collections.shuffle(cartas);
    }

    /**
     * Metodo que obtiene una carta de la baraja y la retira
     *
     * @return la primera carta de la baraja
     */

    public Carta obtener(){
        Carta carta = cartas.get(0);
        cartas.remove(carta);
        return carta;
    }


}

