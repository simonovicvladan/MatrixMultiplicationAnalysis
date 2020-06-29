/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matmull.provider;

import java.util.Random;

/**
 *
 * @author vsimonovic
 */
public class MatrixDataProvider {

    private int matrixSize = 2; // default value
    private double[][] firstMatrix;
    private double[][] secondMatrix;

    public MatrixDataProvider(int matrixSize) {
        if (matrixSize < 2) {
            matrixSize = 2;
        }
        this.matrixSize = matrixSize;
        setup();
    }

    private void setup() {
        firstMatrix = createMatrix(matrixSize);
        secondMatrix = createMatrix(matrixSize);
    }

    private double[][] createMatrix(int matrixSize) {
        Random random = new Random();

        double[][] result = new double[matrixSize][matrixSize];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = random.nextDouble();
            }
        }
        return result;
    }

    public double[][] getFirstMatrix() {
        return firstMatrix;
    }

    public double[][] getSecondMatrix() {
        return secondMatrix;
    }
}
