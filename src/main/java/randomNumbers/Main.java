package randomNumbers;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean input = true;
        while (input) {
            try {
                System.out.print("Ingresa un número entero de un digito:");
                number = scanner.nextInt();
                if (number > 9) System.out.println("El numero solo debe tener un digito.");
                else if (number <= 0) System.out.println("El numero debe ser mayor que 1.");
                else input = false;
            } catch (InputMismatchException e) {
                System.out.println("El numero entero no es valido.");
            }
        }

        System.out.print("Ingresa el numero de veces que se va a generar el numero aletorio:");
        int repeats = scanner.nextInt();
        for (int i = 0; i < repeats; i++) {
            randomNumber(number);
            Thread.sleep(15);
        }
    }

    public static void randomNumber(int number) {
        while (true) {
            long time = System.currentTimeMillis() % 10;
            if (time >= 1) {
                System.out.println("El numero  es: " + Math.round(1 + ((float) (number - 1) / 8)*(time - 1)));
                break;
            }
        }
    }
}