package client;

import shared.MatrixCalculator;
import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            MatrixCalculator calculator = (MatrixCalculator) Naming.lookup("rmi://localhost/MatrixCalculator");
            System.out.println("Connecting to RMI server...");

            // Define two matrices
            int[][] matrix1 = {
                    {1, 2},
                    {3, 4}
            };

            int[][] matrix2 = {
                    {5, 6},
                    {7, 8}
            };

            // Display the input matrices
            System.out.println("Matrix 1:");
            printMatrix(matrix1);

            System.out.println("Matrix 2:");
            printMatrix(matrix2);

            // Call the remote method
            int[][] result = calculator.calculateSum(matrix1, matrix2);

            // Display the result
            System.out.println("Result:");
            printMatrix(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to print matrices
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}