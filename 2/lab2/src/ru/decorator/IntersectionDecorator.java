package ru.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@Decorator
public class IntersectionDecorator implements ISetOperation {
    @Inject
    @Delegate
    private ISetOperation operation;

    @Override
    public Set<Integer> apply(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1); // начинаем с первого множества
        result.retainAll(set2); // пересечение
        return result; // возвращаем результат пересечения
    }
}