/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matrmull.apachecommmath3;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import rs.fon.master.ast2.matmull.MatrixMultiplication;

/**
 *
 * @author vsimonovic
 * @class Commons Math module: The Apache Commons Mathematics Library Math3 is a
 * library of lightweight, self-contained mathematics and statistics components
 * addressing the most common problems not available in the Java programming
 * language or Commons Lang. (https://commons.apache.org/proper/commons-math/
 * ,accessed 26.05.2020.)
 */
public class ApacheCommonsMath3MatrixMultiplication implements MatrixMultiplication {

    /**
     * For matrix multiplication task, this library offers RealMatrix interface
     * and its Array2DRowRealMatrix implementation to create our usual matrices.
     * The constructor of the implementation class takes a two-dimensional
     * double array as its parameter. As for matrices multiplication, the
     * RealMatrix interface offers a multiply() method taking another RealMatrix
     * parameter
     *
     * @param firstMatrix two dimensinal double array representing matrix A
     * @param secondMatrix two dimensinal double array representing matrix B
     * @return result of matrix multiplication as RealMatrix object provided
     * from apache commons math3 library.
     */
    public RealMatrix multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) throws Exception {

        /**
         * In order to be able to multiply two matrices, the number of columns
         * of the first matrix must be equal to the number of rows of the second
         * matrix.
         */
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new Exception("number of columns of the first matrix must be equal"
                    + " to the number of rows of the second matrix.");
        }

        RealMatrix matrixA = new Array2DRowRealMatrix(firstMatrix);
        RealMatrix matrixB = new Array2DRowRealMatrix(secondMatrix);

        return matrixA.multiply(matrixB);
    }
}
