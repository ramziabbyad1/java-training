package datastructures;

import java.util.Arrays;

public class MatrixMultDemo {
	
	private static int[][] mult(int[][] A, int[][] B) throws Exception{
		int rowA = A.length;
		int colA = A[0].length;
		int rowB = B.length;
		int colB = B[0].length;
		if (colA != rowB) {
			throw new Exception("Number of columns of A must match number of rows of B");
		}
		int[][] C = new int[rowA][colB];
		for(int row = 0; row < rowA; row++) {
			for(int col = 0; col < colB; col++) {
				for(int k = 0; k < colA; k++) {
					C[row][col] += A[row][k]*B[k][col];
				}
			}
		}
		return C;
	}
	
	static double[][] mult(double[][] A, double[][] B) throws Exception{
		int rowA = A.length;
		int colA = A[0].length;
		int rowB = B.length;
		int colB = B[0].length;
		if (colA != rowB) {
			throw new Exception("Number of columns of A must match number of rows of B");
		}
		double[][] C = new double[rowA][colB];
		for(int row = 0; row < rowA; row++) {
			for(int col = 0; col < colB; col++) {
				for(int k = 0; k < colA; k++) {
					C[row][col] += A[row][k]*B[k][col];
				}
			}
		}
		return C;
	}
	
	static int[][] randMatrix(int row, int col) {
		int[][] out = new int[row][];
		for(int rowi = 0; rowi < row; rowi++) {
			out[rowi] = BSortDemo.distinctRandArray(col-1);
		}
		return out;
	}
	
	static String matrixString(int[][] A) {
		String[] out = new String[A.length]; 
		for(int row = 0; row < out.length; row++) {
			out[row] = "\n"+Arrays.toString(A[row]);
		}
		return Arrays.toString(out);
	}
	static String matrixString(double[][] A) {
		String[] out = new String[A.length]; 
		for(int row = 0; row < out.length; row++) {
			out[row] = "\n"+Arrays.toString(A[row]);
		}
		return Arrays.toString(out);
	}

	public static void main(String[] args) throws Exception {
		int rowA = 5;
		int colA = 3;
		int rowB = 3;
		int colB = 2;
		int[][] A = randMatrix(rowA, colA);
		int[][] B = randMatrix(rowB, colB);
		System.out.println("A = ");
		System.out.println(matrixString(A));
		System.out.println("B = ");
		System.out.println(matrixString(B));
		
		int[][] C = mult(A, B);
		

		System.out.println("C = ");
		System.out.println(matrixString(C));
	}

}
