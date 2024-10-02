package ru.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class MatrixSubtraction implements IMatrixOperation {
    @Inject
    @Delegate
    private IMatrixOperation matrixOperation;

    @Override
    public int[][] apply(int[][] matrix1, int[][] matrix2) {

        // Вызов оригинальной операции (например, сложение)
        int[][] additionResult = matrixOperation.apply(matrix1, matrix2);

        int rows = additionResult.length;
        int cols = additionResult[0].length;
        int[][] result = new int[rows][cols];

        // Вычитание матриц из результата сложения
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = additionResult[i][j] - matrix2[i][j]; // Можно заменить на matrix1 для вычитания из другого
            }
        }

        System.out.println("Результат операции класса MatrixSubtraction:");
        for (int[] row : result) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();

        return result;
    }
}