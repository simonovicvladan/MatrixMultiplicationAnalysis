/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matmull.benchmark;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import rs.fon.master.ast2.matmull.MatrixMultiplication;
import rs.fon.master.ast2.matmull.provider.MatrixProvider;
import rs.fon.master.ast2.matrmull.apachecommmath3.ApacheCommonsMath3MatrixMultiplication;
import rs.fon.master.ast2.matrmull.colt.ColtMatrixMultiplication;
import rs.fon.master.ast2.matrmull.cust.CustMatrixMultiplication;
import rs.fon.master.ast2.matrmull.ejml.EJMLMatrixMultiplication;
import rs.fon.master.ast2.matrmull.la4j.LA4JMatrixMultiplication;

/**
 *
 * @author vsimonovic
 * @class Here, we are checking the most performant algorithm, by benchmarking
 * methodology. In order to implement the performance test, we'll use the JMH
 * benchmarking library.
 */
public class MatrixMultiplicationBenchmarking {

    public static void main(String[] args) throws Exception {
        
        // Here, a configuruation for jmh is set (warmups, mode, measurement iterations etc)
        Options opt = new OptionsBuilder()
                .include(MatrixMultiplicationBenchmarking.class.getSimpleName())
                //          .exclude(BigMatrixMultiplicationBenchmarking.class.getSimpleName())
                .mode(Mode.AverageTime)
                .forks(2)
                .warmupIterations(5)
                .measurementIterations(5)
                .timeUnit(TimeUnit.MICROSECONDS)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public Object customMatrixMultiplication(MatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new CustMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object ejmlMatrixMultiplication(MatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new EJMLMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object apacheCommonsMatrixMultiplication(MatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ApacheCommonsMath3MatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object coltMatrixMultiplication(MatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ColtMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object la4jMatrixMultiplication(MatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new LA4JMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    /* ND4J doesn't work properly. 
    java.lang.NoClassDefFoundError: org/bytedeco/javacpp/Pointer
	at rs.fon.master.ast2.matrmull.nd4j.ND4JMatrixMultiplication.multiplyMatrices(ND4JMatrixMultiplication.java:45)
	at rs.fon.master.ast2.matrmull.nd4j.ND4JMatrixMultiplication.multiplyMatrices(ND4JMatrixMultiplication.java:21)
	at rs.fon.master.ast2.matmull.benchmark.MatrixMultiplicationBenchmarking.nd4jMatrixMultiplication(MatrixMultiplicationBenchmarking.java:59)
	at rs.fon.master.ast2.matmull.benchmark.generated.MatrixMultiplicationBenchmarking_nd4jMatrixMultiplication_jmhTest.nd4jMatrixMultiplication_avgt_jmhStub(MatrixMultiplicationBenchmarking_nd4jMatrixMultiplication_jmhTest.java:195)
    @Benchmark
    public Object nd4jMatrixMultiplication(MatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ND4JMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }
     */
}
