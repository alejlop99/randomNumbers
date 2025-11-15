package randomNumbers;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeats = 0;
        int[] freq = new int[8];

        boolean input = true;
        while (input) {
            try {
                System.out.print("Ingresa el numero de veces:");
                repeats = scanner.nextInt();
                if (repeats <= 0) System.out.println("El numero debe ser mayor que 1.");
                else input = false;
            } catch (InputMismatchException e) {
                System.out.println("El numero entero no es valido.");
                scanner.next();
            }
        }

        for (int i = 0; i < repeats; i++) {

            int numberRandom = randomNumber();
            freq[numberRandom]++;
        }

        // Grafica de barras
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Frecuencias
        System.out.println("Frecuencias del generador 1–7:\n");
        for (int i = 1; i <= 7; i++) {
            System.out.printf("%d = %d\n", i, freq[i]);
            dataset.addValue(freq[i], "Frecuencia", String.valueOf(i));
        }

        // Configuracion
        JFreeChart chart = ChartFactory.createBarChart(
                "Generador 1 a 7",
                "Valor",
                "Frecuencia",
                dataset
        );

        // Mostrar grafico
        JFrame frame = new JFrame("Grafico de Barras 1 a 7");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static int randomNumber() {
        while (true) {
            //Esto crea la secuencia de numeros del 1 al 25 manteniendo la uniformidad
            int randomNumber = (generator() - 1) * 5 + generator();
            if (randomNumber <= 14) {
                //Formula que se crea para poder hacer la relacion del numero dado a 7
                // 1 + ((7 - 1) / (14 - 1) * (Numero Aleatorio - 1))
                return Math.round(1 + ((float) 6 / 13) * (randomNumber - 1));
            }
        }
    }

    // Genera el valor de 1 a 5
    public static int generator() {
        return new Random().nextInt(5) + 1;
    }
}