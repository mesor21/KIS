package example.method;

import java.util.List;

@ARRANGEMENT_WITH_REPETITION
public class ArrangementWithRepetition implements ICombinatoricsCalculator {

    @Override
    public <T extends Number> long calculate(List<T> parameters) {
        int n = parameters.get(0).intValue();
        int k = parameters.get(1).intValue();
        return (long) Math.pow(n, k);
    }
}