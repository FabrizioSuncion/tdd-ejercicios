package pe.edu.upn.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorContrasena {

    private static final int LONGITUD_MINIMA = 8;

    public static List<String> validar(String clave) {
        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser null");
        }

        List<String> errores = new ArrayList<>();

        if (clave.length() < LONGITUD_MINIMA) {
            errores.add("Debe tener al menos " + LONGITUD_MINIMA + " caracteres");
        }
        if (clave.chars().noneMatch(Character::isUpperCase)) {
            errores.add("Debe tener al menos una mayúscula");
        }
        if (clave.chars().noneMatch(Character::isDigit)) {
            errores.add("Debe tener al menos un dígito");
        }
        return errores;
    }
}