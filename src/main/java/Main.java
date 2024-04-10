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

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String genes = JOptionPane.showInputDialog(null, "Introduce una secuencia de genes (por ejemplo, ATGATGATG):");
            if (genes != null) {
                GeneCounter geneCounter = new GeneCounter();
                int geneCount = geneCounter.countGenes(genes);
                JOptionPane.showMessageDialog(null, "Número de genes: " + geneCount);
            }
        });
    }
}