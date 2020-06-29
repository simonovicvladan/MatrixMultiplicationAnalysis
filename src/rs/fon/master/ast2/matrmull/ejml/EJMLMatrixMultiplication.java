/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matrmull.ejml;

import org.ejml.simple.SimpleMatrix;
import rs.fon.master.ast2.matmull.MatrixMultiplication;

/**
 *
 * @author vsimonovic
 * @class EJML, which stands for Efficient Java Matrix Library is one of the
 * most recently updated Java matrix libraries. Its purpose is to be as
 * efficient as possible regarding calculation and memory usage. Details can be
 * found at http://ejml.org/wiki/index.php?title=Main_Page (accessed
 * 25.06.2020.)
 */
public class EJMLMatrixMultiplication implements MatrixMultiplication {

    /**
     * For matrix multiplication task, this library offers SimpleMatrix class
     * and mult() method
     *
     * @param firstMatrix two dimensinal double array representing matrix A
     * @param secondMatrix two dimensinal double array representing matrix B
     * @return result of matrix multiplication as SimpleMatrix object provided
     * from EJML library.
     */
    public SimpleMatrix multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) throws Exception {

        /**
         * In order to be able to multiply two matrices, the number of columns
         * of the first matrix must be equal to the number of rows of the second
         * matrix.
         */
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new Exception("number of columns of the first matrix must be equal"
                    + " to the number of rows of the second matrix.");
        }

        SimpleMatrix matrixA = new SimpleMatrix(firstMatrix);
        SimpleMatrix matrixB = new SimpleMatrix(secondMatrix);

        return matrixA.mult(matrixB);
    }
}
