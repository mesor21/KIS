package example;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import example.component.CombinatoricsComponent;
import java.util.Arrays;
import java.util.List;


public class Main {
    protected static Weld weld;
    protected static WeldContainer container;
    public static void main(String[] args) {
        // Инициализация контейнера
        weld = new Weld();
        container = weld.initialize();
        try {
            // Получение экземпляра компонента
            CombinatoricsComponent combinatoricsComponent = container.instance().select(CombinatoricsComponent.class).get();

            // Пример параметров для расчетов
            List<Integer> params = Arrays.asList(5, 3);

            // Выполнение расчетов и вывод результатов
            long result = combinatoricsComponent.calculateArrangementWithoutRepetition(params);
            System.out.println("Arrangement Without Repetition: " + result);

            result = combinatoricsComponent.calculateArrangementWithRepetition(params);
            System.out.println("Arrangement With Repetition: " + result);

            result = combinatoricsComponent.calculatePermutationWithoutRepetition(params);
            System.out.println("Permutation Without Repetition: " + result);

            result = combinatoricsComponent.calculatePermutationWithRepetition(params);
            System.out.println("Permutation With Repetition: " + result);

            result = combinatoricsComponent.calculateCombinationWithoutRepetition(params);
            System.out.println("Combination Without Repetition: " + result);

            result = combinatoricsComponent.calculateCombinationWithRepetition(params);
            System.out.println("Combination With Repetition: " + result);
        } finally {
            // Завершение работы контейнера Weld
            weld.shutdown();
        }
    }
}