package server;

import shared.MatrixCalculator;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixCalculatorImpl extends UnicastRemoteObject implements MatrixCalculator {
    protected MatrixCalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public int[][] calculateSum(int[][] matrixA, int[][] matrixB) throws RemoteException {
        System.out.println("Received matrix addition request.");

        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];

        // Create a thread to perform the calculation
        Thread calculationThread = new Thread(() -> {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            System.out.println("Calculation completed by thread: " + Thread.currentThread().getName());
        });

        // Start the thread
        calculationThread.start();

        // Wait for the thread to finish
        try {
            calculationThread.join(); // Wait for the thread to complete
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
            throw new RemoteException("Thread interrupted", e);
        }

        System.out.println("Returning result.");
        return result;
    }
}