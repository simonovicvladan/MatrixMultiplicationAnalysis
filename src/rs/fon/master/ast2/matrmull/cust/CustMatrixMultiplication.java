/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matrmull.cust;

import rs.fon.master.ast2.matmull.MatrixMultiplication;

/**
 *
 * @author vsimonovic
 * @class CustMatrixMultiplication is own implementation of matrix
 * multiplication. For simplicity reasons it uses two dimensional double array
 * Class provides method for matrix multiplication
 */
public class CustMatrixMultiplication implements MatrixMultiplication {

    /**
     *
     * @param firstMatrix two dimensinal double array representing matrix A
     * @param secondMatrix two dimensinal double array representing matrix B
     * @return result of matrix multiplication as two dimensinal double array
     */
    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) throws Exception {

        /**
         * In order to be able to multiply two matrices, the number of columns
         * of the first matrix must be equal to the number of rows of the second
         * matrix.
         */
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new Exception("Number of columns of the first matrix must be equal"
                    + " to the number of rows of the second matrix.");
        }

        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }

        return result;
    }

    /**
     *
     * @param firstMatrix
     * @param secondMatrix
     * @param row
     * @param col
     * @return element value at (row,col) position, after multipling and summing
     * each element from [row] row and [column] column
     */
    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;

        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }

        return cell;
    }
}
