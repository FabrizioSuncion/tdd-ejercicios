package pe.edu.upn.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FizzBuzzTest {

    @Test
    void convertirUnoDevuelveUnoComoTexto() {
        assertEquals("1", FizzBuzz.convertir(1));
    }

    @Test
    void convertirDosDevuelveDosComoTexto() {
        assertEquals("2", FizzBuzz.convertir(2));
    }

    @Test
    void convertirTresDevuelveFizz() {
        assertEquals("Fizz", FizzBuzz.convertir(3));
    }

    @Test
    void convertirCincoDevuelveBuzz() {
        assertEquals("Buzz", FizzBuzz.convertir(5));
    }

    @Test
    void convertirSeisDevuelveFizz() {
        assertEquals("Fizz", FizzBuzz.convertir(6));
    }

    @Test
    void convertirDiezDevuelveBuzz() {
        assertEquals("Buzz", FizzBuzz.convertir(10));
    }

    @Test
    void convertirQuinceDevuelveFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.convertir(15));
    }

    @ParameterizedTest(name = "n = {0} lanza excepcion")
    @ValueSource(ints = {0, -3})
    void convertirCeroONegativoLanzaExcepcion(int n) {
        assertThrows(IllegalArgumentException.class,
            () -> FizzBuzz.convertir(n));
    }
}