package numeric;

public class NumberSummation {

    public int sumNumbers(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n + sumNumbers(n - 1);
        }
    }
}