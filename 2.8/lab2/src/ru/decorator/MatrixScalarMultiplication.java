package ru.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class MatrixScalarMultiplication implements IMatrixOperation {
    @Inject
    @Delegate
    private IMatrixOperation matrixOperation;

    private int scalar = 2; // Число, на которое будем умножать матрицу

    public void setScalar(int scalar) {
        this.scalar = scalar;
    }

    @Override
    public int[][] apply(int[][] matrix1, int[][] matrix2) {

        int[][] result = matrixOperation.apply(matrix1, matrix2);

        // Умножение результата на скаляр
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] *= scalar;
            }
        }

        System.out.println("Результат операции класса MatrixScalarMultiplication:");
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