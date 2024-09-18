package example.method;

import java.util.List;

@COMBINATION_WITH_REPETITION
public class CombinationWithRepetition implements ICombinatoricsCalculator {

    @Override
    public <T extends Number> long calculate(List<T> parameters) {
        int n = parameters.get(0).intValue();
        int k = parameters.get(1).intValue();
        return factorial(n + k - 1) / (factorial(k) * factorial(n - 1));
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}