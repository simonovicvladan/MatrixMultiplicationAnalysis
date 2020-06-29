/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matrmull.colt;

import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;
import rs.fon.master.ast2.matmull.MatrixMultiplication;

/**
 *
 * @author vsimonovic
 * @class Colt is a library developed by CERN. It provides features enabling
 * high performance scientific and technical computing.
 * (https://dst.lbl.gov/ACSSoftware/colt/ ,accessed 26.06.2020.)
 */
public class ColtMatrixMultiplication implements MatrixMultiplication {

    /**
     * In order to create matrices with Colt, we must make use of the
     * DoubleFactory2D class.It comes with three factory instances: dense,
     * sparse and rowCompressed.Each is optimized to create the matching kind of
     * matrix.
     *
     * For our purpose, we'll use the dense instance. This time, the method to
     * call is make() and it takes a two-dimensional double array again,
     * producing a DoubleMatrix2D object:
     *
     * @param firstMatrix two dimensinal double array representing matrix A
     * @param secondMatrix two dimensinal double array representing matrix B
     * @return result of matrix multiplication as Algebra object provided from
     * Colt library.
     */
    public DoubleMatrix2D multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) throws Exception {

        /**
         * In order to be able to multiply two matrices, the number of columns
         * of the first matrix must be equal to the number of rows of the second
         * matrix.
         */
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new Exception("number of columns of the first matrix must be equal"
                    + " to the number of rows of the second matrix.");
        }

        DoubleFactory2D doubleFactory2D = DoubleFactory2D.dense;

        DoubleMatrix2D matrixA = doubleFactory2D.make(firstMatrix);
        DoubleMatrix2D matrixB = doubleFactory2D.make(secondMatrix);

        Algebra algebra = new Algebra();
        return algebra.mult(matrixA, matrixB);
    }
}
