/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matmull;

import java.time.Duration;
import java.time.Instant;
import rs.fon.master.ast2.matmull.provider.MatrixDataProvider;
import rs.fon.master.ast2.matrmull.apachecommmath3.ApacheCommonsMath3MatrixMultiplication;
import rs.fon.master.ast2.matrmull.colt.ColtMatrixMultiplication;
import rs.fon.master.ast2.matrmull.cust.CustMatrixMultiplication;
import rs.fon.master.ast2.matrmull.ejml.EJMLMatrixMultiplication;
import rs.fon.master.ast2.matrmull.la4j.LA4JMatrixMultiplication;

/**
 *
 * @author vsimonovic
 */
public class AnalyzeMatrixMultiplication {

    public static void main(String[] args) throws Exception {

        for (int i = 10; i < 1001; i *= 10) {
            // Generate data for matrix multiplication and set matrix size as parameter.
            MatrixDataProvider matrixDataProvider = new MatrixDataProvider(i);
            System.out.println("\t<< MATRIX MULTIPLICATION ANALYSIS >>");
            System.out.println("\tparameters>\n\tmatrix size: " + i);
            System.out.println();

            // Start execution and print results.
            executeAndAnalyzeAlgorithm(new ApacheCommonsMath3MatrixMultiplication(), matrixDataProvider);
            executeAndAnalyzeAlgorithm(new ColtMatrixMultiplication(), matrixDataProvider);
            executeAndAnalyzeAlgorithm(new CustMatrixMultiplication(), matrixDataProvider);
            executeAndAnalyzeAlgorithm(new EJMLMatrixMultiplication(), matrixDataProvider);
            executeAndAnalyzeAlgorithm(new LA4JMatrixMultiplication(), matrixDataProvider);
        }

//        // Generate data for matrix multiplication and set matrix size as parameter.
//        MatrixDataProvider matrixDataProvider = new MatrixDataProvider(1300);
//
//        // Start execution and print results.
//        executeAndAnalyzeAlgorithm(new ApacheCommonsMath3MatrixMultiplication(), matrixDataProvider);
//        executeAndAnalyzeAlgorithm(new ColtMatrixMultiplication(), matrixDataProvider);
//        executeAndAnalyzeAlgorithm(new CustMatrixMultiplication(), matrixDataProvider);
//        executeAndAnalyzeAlgorithm(new EJMLMatrixMultiplication(), matrixDataProvider);
//        executeAndAnalyzeAlgorithm(new LA4JMatrixMultiplication(), matrixDataProvider);

//       executeAndAnalyzeAlgorithm(new ND4JMatrixMultiplication(), matrixDataProvider); Throws error :-(
    }

    private static void executeAndAnalyzeAlgorithm(MatrixMultiplication matrixMultiplication, MatrixDataProvider matrixDataProvider) throws Exception {
        Instant start = Instant.now();

        System.out.println("\tALGORITHM FROM> " + matrixMultiplication.getClass().getSimpleName());
        System.out.println("=====================================================================\n");
        System.out.println("-- Started at: " + start.toString());
        System.out.println("-- Proccesing algorithm. . . \n");
        matrixMultiplication.multiplyMatrices(matrixDataProvider.getFirstMatrix(), matrixDataProvider.getSecondMatrix());

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("-- Finished at: " + finish.toString());

        System.out.println("\n#########################################");
        System.out.println("|\tTime elapsed ~ " + timeElapsed + " ms. \t|");
        System.out.println("##########################################\n\n");

    }

    // Measure Elapsed Time in Java
    //        Old, inaccurate way.
//        long start = System.currentTimeMillis();
//// ...
//        long finish = System.currentTimeMillis();
//        long timeElapsed = finish - start;
//      
    // Java 8 features
    // Instant class
}
