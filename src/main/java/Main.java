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

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GeneCounter geneCounter = new GeneCounter();
            GeneticCombinations geneticCombinations = new GeneticCombinations();
            DateManager dateManager = new DateManager();
            MaxFinder maxFinder = new MaxFinder();
            NumberListing numberListing = new NumberListing();
            NumberSummation numberSummation = new NumberSummation();
            PowerCalculator powerCalculator = new PowerCalculator();
            QuicksortOptimizer quicksortOptimizer = new QuicksortOptimizer();

            String genes = JOptionPane.showInputDialog(null, "Introduce una secuencia de genes (por ejemplo, ATGATGATG):");
            if (genes != null) {
                int geneCount = geneCounter.countGenes(genes);
                JOptionPane.showMessageDialog(null, "Número de genes: " + geneCount);
            }

            String geneLengthStr = JOptionPane.showInputDialog(null, "Introduce la longitud del gen:");
            if (geneLengthStr != null) {
                int geneLength = Integer.parseInt(geneLengthStr);
                int combinations = geneticCombinations.calculateCombinations(geneLength);
                JOptionPane.showMessageDialog(null, "Número de combinaciones: " + combinations);
            }

            dateManager.addDate(LocalDate.now());
            JOptionPane.showMessageDialog(null, "Fechas: " + dateManager.getDates());

            // DocumentOrganizer y TextSearcher requieren rutas de archivos y no se demuestran aquí

            String numbersStr = JOptionPane.showInputDialog(null, "Introduce una serie de números separados por espacios:");
            if (numbersStr != null) {
                String[] numbersArr = numbersStr.split(" ");
                int[] numbers = new int[numbersArr.length];
                for (int i = 0; i < numbersArr.length; i++) {
                    numbers[i] = Integer.parseInt(numbersArr[i]);
                }
                int max = maxFinder.findMax(numbers);
                JOptionPane.showMessageDialog(null, "Número máximo: " + max);
            }

            String startEndStr = JOptionPane.showInputDialog(null, "Introduce el número inicial y final para listar los números, separados por un espacio:");
            if (startEndStr != null) {
                String[] startEndArr = startEndStr.split(" ");
                int start = Integer.parseInt(startEndArr[0]);
                int end = Integer.parseInt(startEndArr[1]);
                numberListing.listNumbers(start, end);
            }

            String nStr = JOptionPane.showInputDialog(null, "Introduce un número para calcular su suma:");
            if (nStr != null) {
                int n = Integer.parseInt(nStr);
                int sum = numberSummation.sumNumbers(n);
                JOptionPane.showMessageDialog(null, "Suma de números: " + sum);
            }

            String baseExponentStr = JOptionPane.showInputDialog(null, "Introduce la base y el exponente para calcular la potencia, separados por un espacio:");
            if (baseExponentStr != null) {
                String[] baseExponentArr = baseExponentStr.split(" ");
                double base = Double.parseDouble(baseExponentArr[0]);
                int exponent = Integer.parseInt(baseExponentArr[1]);
                double power = powerCalculator.calculatePower(base, exponent);
                JOptionPane.showMessageDialog(null, "Cálculo de potencia: " + power);
            }

            String arrayStr = JOptionPane.showInputDialog(null, "Introduce una serie de números separados por espacios para ordenarlos:");
            if (arrayStr != null) {
                String[] arrayArr = arrayStr.split(" ");
                int[] array = new int[arrayArr.length];
                for (int i = 0; i < arrayArr.length; i++) {
                    array[i] = Integer.parseInt(arrayArr[i]);
                }
                quicksortOptimizer.quickSort(array, 0, array.length - 1);
                StringBuilder sortedArrayStr = new StringBuilder("Array ordenado: ");
                for (int i : array) {
                    sortedArrayStr.append(i).append(" ");
                }
                JOptionPane.showMessageDialog(null, sortedArrayStr.toString());
            }
        });
    }
}