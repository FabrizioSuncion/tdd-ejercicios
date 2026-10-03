package pe.edu.upn.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class ValidadorContrasenaTest {

    private static final String ERROR_LONGITUD = "Debe tener al menos 8 caracteres";
    private static final String ERROR_MAYUSCULA = "Debe tener al menos una mayúscula";
    private static final String ERROR_DIGITO = "Debe tener al menos un dígito";

    @Test
    void claveValidaDevuelveListaVacia() {
        assertEquals(Collections.emptyList(),
            ValidadorContrasena.validar("Segura123"));
    }

    @Test
    void claveCortaDevuelveErrorDeLongitud() {
        assertEquals(Arrays.asList(ERROR_LONGITUD),
            ValidadorContrasena.validar("Abc1"));
    }

    @Test
    void claveSinMayusculaDevuelveErrorDeMayuscula() {
        assertEquals(Arrays.asList(ERROR_MAYUSCULA),
            ValidadorContrasena.validar("segura123"));
    }

    @Test
    void claveSinDigitoDevuelveErrorDeDigito() {
        assertEquals(Arrays.asList(ERROR_DIGITO),
            ValidadorContrasena.validar("SeguraSinNum"));
    }

    @Test
    void claveConTodosLosErroresDevuelveLosTresMensajes() {
        assertEquals(Arrays.asList(ERROR_LONGITUD, ERROR_MAYUSCULA, ERROR_DIGITO),
            ValidadorContrasena.validar("abc"));
    }

    @Test
    void claveConExactamenteOchoCaracteresEsValida() {
        assertEquals(Collections.emptyList(),
            ValidadorContrasena.validar("Abcdefg1"));
    }

    @Test
    void claveConSieteCaracteresDevuelveErrorDeLongitud() {
        assertEquals(Arrays.asList(ERROR_LONGITUD),
            ValidadorContrasena.validar("Abcdef1"));
    }

    @Test
    void claveNullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> ValidadorContrasena.validar(null));
    }
}