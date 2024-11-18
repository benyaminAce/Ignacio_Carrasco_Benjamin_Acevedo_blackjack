//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * Clase principal que inicializa el juego de BlackJack
 */

public class Main {

    /**
     *Metodo que ejecuta el juego
     *
     * @throws InterruptedException si ocurre una interrupcion durante el juego
     */

    public static void main(String[] args) throws InterruptedException {
        MesaDeJuego mesaDeJuego = new MesaDeJuego();
        mesaDeJuego.empezarPartida();
    }

}