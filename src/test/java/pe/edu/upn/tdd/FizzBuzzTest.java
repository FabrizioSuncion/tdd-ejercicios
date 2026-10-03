package pe.edu.upn.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void convertirUnoDevuelveUnoComoTexto() {
        assertEquals("1", FizzBuzz.convertir(1));
    }
}