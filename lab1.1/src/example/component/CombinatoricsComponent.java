package example.component;

import example.Interceptors.ProfileInterceptor;
import example.method.*;

import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.List;

@Interceptors(ProfileInterceptor.class)
public class CombinatoricsComponent {

    @Inject
    private ICombinatoricsCalculator arrangementWithoutRepetitionCalculator;

    @Inject @ARRANGEMENT_WITH_REPETITION
    private ICombinatoricsCalculator arrangementWithRepetitionCalculator;

    @Inject @PERMUTATION_WITHOUT_REPETITION
    private ICombinatoricsCalculator permutationWithoutRepetitionCalculator;

    @Inject @PERMUTATION_WITH_REPETITION
    private ICombinatoricsCalculator permutationWithRepetitionCalculator;

    @Inject @COMBINATION_WITHOUT_REPETITION
    private ICombinatoricsCalculator combinationWithoutRepetitionCalculator;

    @Inject @COMBINATION_WITH_REPETITION
    private ICombinatoricsCalculator combinationWithRepetitionCalculator;

    public <T extends Number> long calculateArrangementWithoutRepetition(List<T> parameters) {
        return arrangementWithoutRepetitionCalculator.calculate(parameters);
    }

    public <T extends Number> long calculateArrangementWithRepetition(List<T> parameters) {
        return arrangementWithRepetitionCalculator.calculate(parameters);
    }

    public <T extends Number> long calculatePermutationWithoutRepetition(List<T> parameters) {
        return permutationWithoutRepetitionCalculator.calculate(parameters);
    }

    public <T extends Number> long calculatePermutationWithRepetition(List<T> parameters) {
        return permutationWithRepetitionCalculator.calculate(parameters);
    }

    public <T extends Number> long calculateCombinationWithoutRepetition(List<T> parameters) {
        return combinationWithoutRepetitionCalculator.calculate(parameters);
    }

    public <T extends Number> long calculateCombinationWithRepetition(List<T> parameters) {
        return combinationWithRepetitionCalculator.calculate(parameters);
    }
}