/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matrmull.nd4j;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import rs.fon.master.ast2.matmull.MatrixMultiplication;

/**
 *
 * @author vsimonovic
 * @class ND4J is a computation library and is part of the deeplearning4j
 *
 * project. Among other things, ND4J offers matrix computation features. More
 * details> https://deeplearning4j.konduit.ai/nd4j/overview (accessed
 * 25.06.2020.)
 */
public class ND4JMatrixMultiplication implements MatrixMultiplication {

    /**
     * With ND4J, we must create an INDArray.In order to do that, we'll call the
     * Nd4j.create() factory method and pass it a double array representing our
     * matrix:
     *
     * @param firstMatrix two dimensinal double array representing matrix A
     * @param secondMatrix two dimensinal double array representing matrix B
     * @return result of matrix multiplication as INDArray object provided from
     * ND4J library.
     */
    public INDArray multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) throws Exception {

        /**
         * In order to be able to multiply two matrices, the number of columns
         * of the first matrix must be equal to the number of rows of the second
         * matrix.
         */
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new Exception("number of columns of the first matrix must be equal"
                    + " to the number of rows of the second matrix.");
        }

        INDArray matrixA = Nd4j.create(firstMatrix);
        INDArray matrixB = Nd4j.create(secondMatrix);

        return matrixA.mmul(matrixB);

    }
}
