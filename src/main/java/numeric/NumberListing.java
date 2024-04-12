package numeric;

public class NumberListing {

    public String listNumbers(int start, int end) {
        StringBuilder numbers = new StringBuilder();
        for (int i = start; i <= end; i++) {
            numbers.append(i).append(" ");
        }
        return numbers.toString().trim();
    }
}