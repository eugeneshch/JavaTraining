/*
 * 10. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

package by.epam.tentasks;

public class Task10 {

	public static int[][] createMatrix(int n) {
		if (n < 0) {
			n = 0;
		}
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				matrix[2 * i][j] = j + 1;
				matrix[2 * i + 1][j] = n - j;
			}	
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		int n = 10;
		int[][]	matrix = createMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%5d ", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
