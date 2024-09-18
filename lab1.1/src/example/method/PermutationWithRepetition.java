package example.method;

import java.util.List;

@PERMUTATION_WITH_REPETITION
public class PermutationWithRepetition implements ICombinatoricsCalculator {

    @Override
    public <T extends Number> long calculate(List<T> parameters) {
        int n = parameters.get(0).intValue();
        long numerator = factorial(n);
        long denominator = 1;

        for (int i = 1; i < parameters.size(); i++) {
            int repetition = parameters.get(i).intValue();
            denominator *= factorial(repetition);
        }

        return numerator / denominator;
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}