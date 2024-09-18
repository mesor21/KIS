package example.method;

import java.util.List;

@PERMUTATION_WITHOUT_REPETITION
public class PermutationWithoutRepetition implements ICombinatoricsCalculator {

    @Override
    public <T extends Number> long calculate(List<T> parameters) {
        int n = parameters.get(0).intValue();
        return factorial(n);
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}