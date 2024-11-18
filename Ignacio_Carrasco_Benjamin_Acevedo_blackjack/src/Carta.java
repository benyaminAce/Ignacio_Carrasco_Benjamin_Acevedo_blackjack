public class Carta {

    private Pinta pinta;
    private int numero;

    /**
     * Clase que representa una carta en el juego de Blackjack.
     * Una carta tiene una pinta (corazones, diamantes, tréboles, picas) y un número.
     */
    public Carta(Pinta pinta, int numero) {

        if(numero <= 0 || numero > 13) {
            throw new IllegalArgumentException("El número de la carta solo puede estar entre 1 y 13");
        }

        this.pinta = pinta;
        this.numero = numero;
    }

    /**
     * obtiene la pinta de la carta
     * @return
     */
    public Pinta getPinta() {
        return pinta;
    }

    /**
     * obtiene el valor de la carta
     * @return
     */
    public int getValor() {
        return numero;
    }

    /**
     * representa como string la carta
     * @return
     */
    @Override
    public String toString() {
        return String.format("Pinta = %s, Numero = %s", pinta, numero);
    }

}
