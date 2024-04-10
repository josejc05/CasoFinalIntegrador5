import analysis.GeneCounter;
import analysis.GeneticCombinations;
import information.DateManager;
import information.DocumentOrganizer;
import information.TextSearcher;
import numeric.MaxFinder;
import numeric.NumberListing;
import numeric.NumberSummation;
import numeric.PowerCalculator;
import optimization.QuicksortOptimizer;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Hola y bienvenido!");

        GeneCounter geneCounter = new GeneCounter();
        System.out.println("Introduce una secuencia de genes (por ejemplo, ATGATGATG):");
        String genes = scanner.nextLine();
        System.out.println("Número de genes: " + geneCounter.countGenes(genes));

        GeneticCombinations geneticCombinations = new GeneticCombinations();
        System.out.println("Introduce la longitud del gen:");
        int geneLength = scanner.nextInt();
        System.out.println("Número de combinaciones: " + geneticCombinations.calculateCombinations(geneLength));

        DateManager dateManager = new DateManager();
        dateManager.addDate(LocalDate.now());
        System.out.println("Fechas: " + dateManager.getDates());

        // DocumentOrganizer y TextSearcher requieren rutas de archivos y no se demuestran aquí

        MaxFinder maxFinder = new MaxFinder();
        System.out.println("Introduce una serie de números separados por espacios:");
        scanner.nextLine(); // consume the newline
        String[] numbersStr = scanner.nextLine().split(" ");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }
        System.out.println("Número máximo: " + maxFinder.findMax(numbers));

        NumberListing numberListing = new NumberListing();
        System.out.println("Introduce el número inicial y final para listar los números, separados por un espacio:");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        numberListing.listNumbers(start, end);

        NumberSummation numberSummation = new NumberSummation();
        System.out.println("Introduce un número para calcular su suma:");
        int n = scanner.nextInt();
        System.out.println("Suma de números: " + numberSummation.sumNumbers(n));

        PowerCalculator powerCalculator = new PowerCalculator();
        System.out.println("Introduce la base y el exponente para calcular la potencia, separados por un espacio:");
        double base = scanner.nextDouble();
        int exponent = scanner.nextInt();
        System.out.println("Cálculo de potencia: " + powerCalculator.calculatePower(base, exponent));

        QuicksortOptimizer quicksortOptimizer = new QuicksortOptimizer();
        System.out.println("Introduce una serie de números separados por espacios para ordenarlos:");
        scanner.nextLine(); // consume the newline
        String[] arrayStr = scanner.nextLine().split(" ");
        int[] array = new int[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        quicksortOptimizer.quickSort(array, 0, array.length - 1);
        System.out.print("Array ordenado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}