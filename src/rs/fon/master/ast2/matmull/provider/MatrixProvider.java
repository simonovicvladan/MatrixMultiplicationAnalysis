/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matmull.provider;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 *
 * @author vsimonovic
 * @class MatrixProvider is created for testing purposes, to have some data in matrices and to see if benchmarking
 * is working properly.
 */
@State(Scope.Benchmark)
public class MatrixProvider {

    private final double[][] firstMatrix;
    private final double[][] secondMatrix;

    public MatrixProvider() {
        firstMatrix
                = new double[][]{
                    new double[]{1d, 5d},
                    new double[]{2d, 3d},
                    new double[]{1d, 7d}
                };

        secondMatrix
                = new double[][]{
                    new double[]{1d, 2d, 3d, 7d},
                    new double[]{5d, 2d, 8d, 1d}
                };
    }

    public double[][] getFirstMatrix() {
        return firstMatrix;
    }

    public double[][] getSecondMatrix() {
        return secondMatrix;
    }
}
