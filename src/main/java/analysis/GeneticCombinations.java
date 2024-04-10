package analysis;

public class GeneticCombinations {

    public int calculateCombinations(int geneLength) {
        if (geneLength <= 1) {
            return 1;
        } else {
            return geneLength * calculateCombinations(geneLength - 1);
        }
    }
}