package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixCalculator extends Remote {
    int[][] calculateSum(int[][] matrixA, int[][] matrixB) throws RemoteException;
}