package pe.edu.upn.tdd;

/**
 * Contador que avanza según un incremento y vuelve a su valor inicial
 * cuando supera el límite.
 */
public class ContadorCircular {

    private final int inicial;
    private final int incremento;
    private final int limite;
    private int valor;

    /** Crea un contador con valor inicial 0 e incremento 1. */
    public ContadorCircular(int limite) {
        this(0, 1, limite);
    }

    public ContadorCircular(int inicial, int incremento, int limite) {
        this.inicial = inicial;
        this.incremento = incremento;
        this.limite = limite;
        this.valor = inicial;
    }

    public int getValor() {
        return valor;
    }

    /**
     * Suma el incremento al valor actual.
     *
     * @return true si se superó el límite (y el contador volvió al valor inicial)
     */
    public boolean incrementa() {
        valor += incremento;
        boolean limiteSuperado = valor > limite;
        if (limiteSuperado) {
            resetea();
        }
        return limiteSuperado;
    }

    public void resetea() {
        valor = inicial;
    }
}