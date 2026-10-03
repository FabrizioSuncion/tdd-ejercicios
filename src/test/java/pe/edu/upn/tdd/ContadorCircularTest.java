package pe.edu.upn.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContadorCircularTest {

    // inicial 0, incremento 1, límite 1
    private ContadorCircular porDefectoLimite1;
    // inicial 5, incremento 5, límite 12
    private ContadorCircular deCincoEnCincoLimite12;

    @BeforeEach
    void setUp() {
        porDefectoLimite1 = new ContadorCircular(1);
        deCincoEnCincoLimite12 = new ContadorCircular(5, 5, 12);
    }

    // ---------- Valor inicial ----------
    @Test
    void contadorPorDefectoEmpiezaEnCero() {
        assertEquals(0, porDefectoLimite1.getValor());
    }

    @Test
    void contadorConValorInicialCincoEmpiezaEnCinco() {
        assertEquals(5, deCincoEnCincoLimite12.getValor());
    }

    // ---------- Incremento ----------
    @Test
    void incrementarContadorPorDefectoSumaUno() {
        porDefectoLimite1.incrementa();
        assertEquals(1, porDefectoLimite1.getValor());
    }

    @Test
    void incrementarContadorDeCincoEnCincoPasaDe5A10() {
        deCincoEnCincoLimite12.incrementa();
        assertEquals(10, deCincoEnCincoLimite12.getValor());
    }

    // ---------- Límite ----------
    @Test
    void alAlcanzarElLimiteNoLoSupera() {
        assertFalse(porDefectoLimite1.incrementa());
    }

    @Test
    void alPasarElLimiteIndicaQueLoSupero() {
        porDefectoLimite1.incrementa();
        assertTrue(porDefectoLimite1.incrementa());
    }

    @Test
    void contadorDeCincoEnCincoSuperaElLimiteEnElSegundoIncremento() {
        assertFalse(deCincoEnCincoLimite12.incrementa());
        assertTrue(deCincoEnCincoLimite12.incrementa());
    }

    // ---------- Vuelta al valor inicial ----------
    @Test
    void alSuperarElLimiteVuelveAlValorInicialCero() {
        porDefectoLimite1.incrementa();
        porDefectoLimite1.incrementa();
        assertEquals(0, porDefectoLimite1.getValor());
    }

    @Test
    void alSuperarElLimiteVuelveAlValorInicialCinco() {
        deCincoEnCincoLimite12.incrementa();
        deCincoEnCincoLimite12.incrementa();
        assertEquals(5, deCincoEnCincoLimite12.getValor());
    }

    // ---------- Reseteo ----------
    @Test
    void resetearDevuelveElContadorAlValorInicial() {
        deCincoEnCincoLimite12.incrementa();
        deCincoEnCincoLimite12.resetea();
        assertEquals(5, deCincoEnCincoLimite12.getValor());
    }

    // ---------- Validaciones (Propuesto 01) ----------
    @Test
    void crearConIncrementoCeroLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> new ContadorCircular(0, 0, 10));
    }

    @Test
    void crearConIncrementoNegativoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> new ContadorCircular(0, -3, 10));
    }

    @Test
    void crearConLimiteMenorQueElInicialLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> new ContadorCircular(10, 1, 5));
    }

    @Test
    void crearConLimiteIgualAlInicialSeCreaCorrectamente() {
        ContadorCircular contador = new ContadorCircular(5, 1, 5);
        assertEquals(5, contador.getValor());
    }
}