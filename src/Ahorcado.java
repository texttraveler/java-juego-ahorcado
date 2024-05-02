import java.io.*;

public class Ahorcado {

    public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String palabraSec = "bananas";
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSec.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            System.out.print(letrasAdivinadas[i]);
        }
        System.out.println("\n");

        while (!palabraAdivinada && intentos < intentosMax) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));
            System.out.println("Introduce una letra");
            char letra = Character.toLowerCase(console.readLine().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSec.length(); i++) {
                if (palabraSec.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! te quedan " + (intentosMax - intentos) + " intentos");

            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSec)) {
                palabraAdivinada = true;
                System.out.println("!Felicidades! has adivinado la palabra secreta: " + palabraSec);
            }

        }

        if (!palabraAdivinada) {
            System.out.println("---------------------------");
            System.out.println("Te has quedado sin intentos");
            System.out.println("GAME OVER");
            System.out.println("( TTnTT)");
            System.out.println("---------------------------");

        }
    }
}