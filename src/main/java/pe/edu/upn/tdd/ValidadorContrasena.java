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
            errores.add("Debe tener al menos 8 caracteres");
        }
        if (!tieneMayuscula(clave)) {
            errores.add("Debe tener al menos una mayúscula");
        }
        if (!tieneDigito(clave)) {
            errores.add("Debe tener al menos un dígito");
        }
        return errores;
    }

    private static boolean tieneMayuscula(String clave) {
        for (char c : clave.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean tieneDigito(String clave) {
        for (char c : clave.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}