/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matmull;

import rs.fon.master.ast2.matmull.provider.MatrixDataProvider;
import rs.fon.master.ast2.matrmull.apachecommmath3.ApacheCommonsMath3MatrixMultiplication;
import rs.fon.master.ast2.matrmull.colt.ColtMatrixMultiplication;
import rs.fon.master.ast2.matrmull.cust.CustMatrixMultiplication;
import rs.fon.master.ast2.matrmull.ejml.EJMLMatrixMultiplication;
import rs.fon.master.ast2.matrmull.la4j.LA4JMatrixMultiplication;
import rs.fon.master.ast2.matrmull.nd4j.ND4JMatrixMultiplication;

/**
 *
 * @author vsimonovic
 */
public interface MatrixMultiplicationAlgorithm {

    public static Object customMatrixMultiplication(Object algorithm, MatrixDataProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new CustMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    public static Object ejmlMatrixMultiplication(Object algorithm, MatrixDataProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new EJMLMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    public static Object apacheCommonsMatrixMultiplication(Object algorithm, MatrixDataProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ApacheCommonsMath3MatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    public static Object coltMatrixMultiplication(Object algorithm, MatrixDataProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ColtMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    public static Object la4jMatrixMultiplication(Object algorithm, MatrixDataProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new LA4JMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    public static Object nd4jMatrixMultiplication(Object algorithm, MatrixDataProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ND4JMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }
}
