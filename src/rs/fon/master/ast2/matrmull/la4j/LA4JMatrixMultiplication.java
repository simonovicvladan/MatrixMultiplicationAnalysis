/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matrmull.la4j;

import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import rs.fon.master.ast2.matmull.MatrixMultiplication;

/**
 *
 * @author vsimonovic
 * @class LA4J, which stands for Linear Algebra for Java.The la4j library is
 * open source and 100% Java library that provides Linear Algebra primitives
 * (matrices and vectors) and algorithms. The library was initially designed to
 * be lightweight and simple tool for passionate Java developers. It has been
 * started as student project and turned into one of the most popular Java
 * packages for matrices and vectors. (http://la4j.org/ ,accessed 26.06.2020.)
 */
public class LA4JMatrixMultiplication implements MatrixMultiplication {

    /**
     * It offers a Matrix interface with a Basic2DMatrix implementation that
     * takes a two-dimensional double array as input.The multiplication method
     * is multiply() and takes another Matrix as its parameter
     *
     * @param firstMatrix two dimensinal double array representing matrix A
     * @param secondMatrix two dimensinal double array representing matrix B
     * @return result of matrix multiplication as Matrix object provided from
     * LA4J library.
     */
    public Matrix multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) throws Exception {

        /**
         * In order to be able to multiply two matrices, the number of columns
         * of the first matrix must be equal to the number of rows of the second
         * matrix.
         */
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new Exception("number of columns of the first matrix must be equal"
                    + " to the number of rows of the second matrix.");
        }

        Matrix matrixA = new Basic2DMatrix(firstMatrix);
        Matrix matrixB = new Basic2DMatrix(secondMatrix);

        return matrixA.multiply(matrixB);
    }
}
