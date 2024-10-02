package ru.decorator;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/*
Создать интерфейс Операция над матрицей.
Создать класс, выполняющий сложение матриц.
Создать декоратор, выполняющий умножение матрицы
на число и декоратор,выполняющий вычитание матриц.
Продемонстрировать операции с различным набором декораторов.
 */

public class Main {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) throws Exception {
        weld = new Weld();
        container = weld.initialize();

        try {
            // Получение экземпляра IMatrixOperation с учетом всех декораторов
            IMatrixOperation matrixOperation = container.instance().select(IMatrixOperation.class).get();

            int[][] matrix1 = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            int[][] matrix2 = {
                    {9, 8, 7},
                    {6, 5, 4},
                    {3, 2, 1}
            };

            // Выполнение операции с использованием декораторов
            int[][] result = matrixOperation.apply(matrix1, matrix2);

            // Вывод результата
            System.out.println("Результат операции:");
            for (int[] row : result) {
                for (int elem : row) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }

        } finally {
            weld.shutdown();
        }
    }
}