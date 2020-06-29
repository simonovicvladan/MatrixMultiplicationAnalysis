/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matmull;

/**
 *
 * @author vsimonovic
 * @class An inteface representing matrix multiplication contract
 *
 */
public interface MatrixMultiplication {

    public Object multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) throws Exception;

}
