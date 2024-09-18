package example.method;

import java.util.List;

/**
 * Интерфейс для выполнения комбинаторных операций
 */
public interface ICombinatoricsCalculator {
    <T extends Number> long calculate(List<T> parameters);
}