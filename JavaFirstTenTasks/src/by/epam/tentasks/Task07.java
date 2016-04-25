/*
 * 7. Составить программу для вычисления значений функции  F(x) на отрезке [а, b] с шагом h. 
 * Результат представить в виде таблицы, первый столбец которой – значения  аргумента, второй - соответствующие значения функции: ...
 */

package by.epam.tentasks;

public class Task07 {

	public static double function(double x) {
		return (Math.pow(Math.sin(x), 2) - Math.cos(2*x));
	}
	
	public static double[][] generateTable(double a, double b, double h) {
		double precision_corr = 1.0E-10; // поправка для компенсации ошибки в расчётах с плавающей точкой.
		int points_count =  (int) ((b - a)/h  + precision_corr) + 1;
		if (points_count < 0) {
			points_count = 0;
		}
		double[][] result = new double[points_count][2];
		for (int i = 0; i < points_count; i++) {
			result[i][0] = a + i*h;
			result[i][1] = function(result[i][0]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		double[] nums = {-0.5, 0.7, 0.1};
	//	double[] nums = {-2.7, 1.9, 0.05};
	//	double[] nums = {0, 0.8, 0.2};
	//	double[] nums = {12, 28, 1};
	//	double[] nums = {0.5, -0.7, 0.1};
		double a = nums[0];
		double b = nums[1];
		double h = nums[2];
		double[][] result = generateTable(a, b, h);
		for (int i = 0; i < result.length; i++) {
			System.out.printf("x = %10.5f	F(x) = %10.5f \n", result[i][0], result[i][1]);
		}
	}

}
