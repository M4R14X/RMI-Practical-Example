package client;

import shared.MatrixCalculator;
import java.rmi.Naming;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Look up the remote object
            MatrixCalculator calculator = (MatrixCalculator) Naming.lookup("rmi://localhost/MatrixCalculator");
            System.out.println("Connected to RMI server.");

            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for matrix dimensions
            System.out.print("Enter the number of rows for the matrices: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns for the matrices: ");
            int cols = scanner.nextInt();

            // Create two matrices based on user input
            int[][] matrix1 = new int[rows][cols];
            int[][] matrix2 = new int[rows][cols];

            // Prompt the user to enter values for the first matrix
            System.out.println("Enter values for Matrix 1:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Enter value for row " + (i + 1) + ", column " + (j + 1) + ": ");
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            // Prompt the user to enter values for the second matrix
            System.out.println("Enter values for Matrix 2:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Enter value for row " + (i + 1) + ", column " + (j + 1) + ": ");
                    matrix2[i][j] = scanner.nextInt();
                }
            }

            // Display the input matrices
            System.out.println("Matrix 1:");
            printMatrix(matrix1);

            System.out.println("Matrix 2:");
            printMatrix(matrix2);

            // Call the remote method to calculate the sum
            System.out.println("Sending matrices to the server for addition...");
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