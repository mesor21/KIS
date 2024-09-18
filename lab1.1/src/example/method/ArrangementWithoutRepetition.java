package example.method;

import javax.enterprise.inject.Default;

import java.util.List;

/**
 * Реализация размещений без повторений
 */
@Default
@ARRANGEMENT_WITHOUT_REPETITION
public class ArrangementWithoutRepetition implements ICombinatoricsCalculator {
    @Override
    public <T extends Number> long calculate(List<T> parameters) {
        int n = parameters.get(0).intValue();
        int k = parameters.get(1).intValue();
        return factorial(n) / factorial(n - k);
    }

    private long factorial(int n) {
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
