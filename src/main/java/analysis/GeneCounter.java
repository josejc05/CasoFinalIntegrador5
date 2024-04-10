package analysis;

public class GeneCounter {

    public int countGenes(String dnaSequence) {
        return countGenesHelper(dnaSequence, 0);
    }

    private int countGenesHelper(String dnaSequence, int index) {
        if (index >= dnaSequence.length() - 2) {
            return 0;
        }

        String codon = dnaSequence.substring(index, index + 3);
        if (codon.equals("ATG")) {
            return 1 + countGenesHelper(dnaSequence, index + 3);
        } else {
            return countGenesHelper(dnaSequence, index + 1);
        }
    }
}