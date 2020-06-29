# University of Belgrade
## Faculty of organisational sciences
## Master studies Software engineering and computer sciences
## Module Software engineering
### Course Advanced Sofware Technologies 2

## Benchmarking and Profiling in Java through Matrix Multiplication Analysis
A project for Advanced Sofware Technologies 2 course of Master studies on Faculty of Organisational Sciences at University of Belgrade.
It's main goal is to analyse and examine different linear algebra Java libraries and focus on matrix multiplication operation. This project deals with Benchmarking and profiling in Java on Matrix multiplication.

## Matrix multiplication analysis
It uses different libraries for linear algebra and scientific calculation in order to perfom operations.
In this project, our focus is  to analyze matrix multiplication operation, through different libraries.
In addition, a Benchmarking is done, using JMH library. With different parameter values (warmpup, measurement iterations, mode of counting, avg,.. etc)

## Application starting points
1. AnalyzeMatrixMultiplication class in package rs.fon.master.ast2.matmull deals with execution of algorithms and custom perfomance tests.
2. MatrixMultiplicationBenchmarking class in package rs.fon.master.ast2.matmull.benchmark executes sample MicroBenchmarking performance tests.
3. BigMatrixMultiplicationBenchmarking class package rs.fon.master.ast2.matmull.benchmark works with big matrices (matrix size as command line parameter).
 -Each class and several most important methods are well documented.
 -Code is written applying template method pattern and coding to specification (interface) principle.
 -Results are presented in console output.
 
