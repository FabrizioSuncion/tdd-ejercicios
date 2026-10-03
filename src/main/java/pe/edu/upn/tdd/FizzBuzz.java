package pe.edu.upn.tdd;

public class FizzBuzz {

    public static String convertir(int n) {
        if (n == 3) {
            return "Fizz";
        }
        if (n == 5) {
            return "Buzz";
        }
        return String.valueOf(n);
    }
}