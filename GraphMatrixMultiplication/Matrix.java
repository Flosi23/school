package school.GraphMatrixMultiplication;

import java.util.Arrays;

public final class Matrix {

    private Matrix(){}

    public int[] getRow(int[][] matrix, int rowNum){
        if(matrix.length == 0){
            throw new Error("Invalid matrx");
        }
        int[] row = new int[matrix.length];

        for(int column = 0; column < matrix.length; column++){
            row[column] = matrix[column][rowNum];
        }

        return row;
    }

    public int[] getColumn(int[][] matrix, int colNum){
        if(matrix.length == 0){
            throw new Error("Invalid matrix");
        }
        int[] column = new int[matrix[0].length];

        System.arraycopy(matrix[colNum], 0, column, 0, matrix.length);

        return column;
    }

    public int[][] multiplicate(int[][] matrixOne, int[][] matrixTwo) {
        if(
            matrixOne.length == 0 ||
            matrixTwo.length == 0 ||
            matrixOne.length != matrixTwo.length ||
            matrixOne[0].length != matrixTwo[0].length)
        {
            throw new Error("Matrizes are invalid");
        }

        int[][] newMatrix = new int[matrixOne.length][matrixOne[0].length];

        for(int column = 0; column < newMatrix.length; column++){
            for(int row = 0; row < newMatrix.length; row++){
                int[] matrixOneRow = getRow(matrixOne, row);
                int[] matrixTwoColumn = getColumn(matrixTwo, column);

                int result = 0;

                for(int i = 0; i < matrixOneRow.length; i++){
                    result += matrixOneRow[i] * matrixTwoColumn[i];
                }

                newMatrix[column][row] = result;
            }
        }

        return newMatrix;
    }
}
