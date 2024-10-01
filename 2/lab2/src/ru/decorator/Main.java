package ru.decorator;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/*
Создать интерфейс Операция над множеством.
Создать класс, выполняющий операцию объединение множеств.
Создать декоратор, выполняющий операцию пересечение множеств и декоратор,
выполняющий операцию разность множеств.
Продемонстрировать операции с различным набором декоyfраторов.
 */

import java.util.HashSet;
import java.util.Set;

public class Main {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            Set<Integer> set1 = new HashSet<>();
            set1.add(1);
            set1.add(2);
            set1.add(3);

            Set<Integer> set2 = new HashSet<>();
            set2.add(3);
            set2.add(4);
            set2.add(5);

            System.out.println("Исходное множество 1: " + set1);
            System.out.println("Исходное множество 2: " + set2);

            // Объединение множеств
            System.out.println("\nОбъединение множеств:");
            UnionOperation unionOperation = new UnionOperation();
            Set<Integer> unionResult = unionOperation.apply(set1, set2);
            System.out.println("Результат объединения: " + unionResult);

            // Пересечение множеств
            System.out.println("\nПересечение множеств:");
            IntersectionDecorator intersectionDecorator = new IntersectionDecorator();
            Set<Integer> intersectionResult = intersectionDecorator.apply(set1, set2);
            System.out.println("Результат пересечения: " + intersectionResult);

            // Разность множеств
            System.out.println("\nРазность множеств:");
            DifferenceDecorator differenceDecorator = new DifferenceDecorator();
            Set<Integer> differenceResult = differenceDecorator.apply(set1, set2);
            System.out.println("Результат разности: " + differenceResult);

            // Выполнение операций с несколькими декораторами
            SetOperationBean operationBean = container.instance().select(SetOperationBean.class).get();

            // Применяем пересечение и разность в качестве декораторов
            operationBean.performOperation(set1, set2);
            Set<Integer> result = operationBean.performOperation(set1, set2); // результат будет зависеть от цепочки декораторов

            System.out.println("\nРезультат после применения декораторов: " + result);
        } finally {
            weld.shutdown();
        }
    }
}