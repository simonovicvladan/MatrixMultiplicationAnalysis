/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.master.ast2.matmull.benchmark;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import rs.fon.master.ast2.matmull.MatrixMultiplication;
import rs.fon.master.ast2.matmull.provider.BigMatrixProvider;
import rs.fon.master.ast2.matrmull.apachecommmath3.ApacheCommonsMath3MatrixMultiplication;
import rs.fon.master.ast2.matrmull.colt.ColtMatrixMultiplication;
import rs.fon.master.ast2.matrmull.cust.CustMatrixMultiplication;
import rs.fon.master.ast2.matrmull.ejml.EJMLMatrixMultiplication;
import rs.fon.master.ast2.matrmull.la4j.LA4JMatrixMultiplication;

/**
 *
 * @author vsimonovic
 */
public class BigMatrixMultiplicationBenchmarking {

    private static final int DEFAULT_FORKS = 2;
    private static final int DEFAULT_WARMUP_ITERATIONS = 5;
    private static final int DEFAULT_MEASUREMENT_ITERATIONS = 10;

    public static void main(String[] args) throws Exception {

        Map<String, String> parameters = parseParameters(args);

        ChainedOptionsBuilder builder = new OptionsBuilder()
                .include(BigMatrixMultiplicationBenchmarking.class.getSimpleName())
                .mode(Mode.AverageTime)
                .forks(forks(parameters))
                .warmupIterations(warmupIterations(parameters))
                .measurementIterations(measurementIterations(parameters))
                .timeUnit(TimeUnit.SECONDS);

        parameters.forEach(builder::param);

        new Runner(builder.build()).run();
    }

    private static Map<String, String> parseParameters(String[] args) {
        return Arrays.stream(args)
                .map(arg -> arg.split("="))
                .collect(Collectors.toMap(
                        arg -> arg[0],
                        arg -> arg[1]
                ));
    }

    private static int forks(Map<String, String> parameters) {
        String forks = parameters.remove("forks");
        return parseOrDefault(forks, DEFAULT_FORKS);
    }

    private static int warmupIterations(Map<String, String> parameters) {
        String warmups = parameters.remove("warmupIterations");
        return parseOrDefault(warmups, DEFAULT_WARMUP_ITERATIONS);
    }

    private static int measurementIterations(Map<String, String> parameters) {
        String measurements = parameters.remove("measurementIterations");
        return parseOrDefault(measurements, DEFAULT_MEASUREMENT_ITERATIONS);
    }

    private static int parseOrDefault(String parameter, int defaultValue) {
        return parameter != null ? Integer.parseInt(parameter) : defaultValue;
    }

    @Benchmark
    public Object customMatrixMultiplication(BigMatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new CustMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object ejmlMatrixMultiplication(BigMatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new EJMLMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object apacheCommonsMatrixMultiplication(BigMatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ApacheCommonsMath3MatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object coltMatrixMultiplication(BigMatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new ColtMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }

    @Benchmark
    public Object la4jMatrixMultiplication(BigMatrixProvider matrixProvider) throws Exception {
        MatrixMultiplication matrixMultiplication = new LA4JMatrixMultiplication();
        return matrixMultiplication.multiplyMatrices(matrixProvider.getFirstMatrix(), matrixProvider.getSecondMatrix());
    }
}
