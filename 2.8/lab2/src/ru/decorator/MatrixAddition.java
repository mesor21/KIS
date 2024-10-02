package ru.decorator;

import javax.enterprise.inject.Default;

@Default
public class MatrixAddition implements IMatrixOperation {
    @Override
    public int[][] apply(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Результат операции класса MatrixAddition:");
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