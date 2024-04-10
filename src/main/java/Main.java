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

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola y bienvenido!");

        GeneCounter geneCounter = new GeneCounter();
        System.out.println("Número de genes: " + geneCounter.countGenes("ATGATGATG"));

        GeneticCombinations geneticCombinations = new GeneticCombinations();
        System.out.println("Número de combinaciones: " + geneticCombinations.calculateCombinations(3));

        DateManager dateManager = new DateManager();
        dateManager.addDate(LocalDate.now());
        System.out.println("Fechas: " + dateManager.getDates());

        // DocumentOrganizer y TextSearcher requieren rutas de archivos y no se demuestran aquí

        MaxFinder maxFinder = new MaxFinder();
        System.out.println("Número máximo: " + maxFinder.findMax(new int[]{1, 2, 3}));

        NumberListing numberListing = new NumberListing();
        numberListing.listNumbers(1, 5);

        NumberSummation numberSummation = new NumberSummation();
        System.out.println("Suma de números: " + numberSummation.sumNumbers(5));

        PowerCalculator powerCalculator = new PowerCalculator();
        System.out.println("Cálculo de potencia: " + powerCalculator.calculatePower(2, 3));

        QuicksortOptimizer quicksortOptimizer = new QuicksortOptimizer();
        int[] array = {5, 3, 2, 1, 4};
        quicksortOptimizer.quickSort(array, 0, array.length - 1);
        System.out.print("Array ordenado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}