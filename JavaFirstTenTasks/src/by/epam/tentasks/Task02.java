/*
 * 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения): ...
 */

package by.epam.tentasks;

public class Task02 {
	
	public static double function(double a, double b, double c) {
		double result = (b + Math.sqrt(b*b + 4*a*c))/(2*a) - Math.pow(a, 3)*c + Math.pow(b, -2);
		return result;
	}

	public static void main(String[] args) {
		double[] nums = {2.0, 3.5, -0.7};
	//	double[] nums = {5, -1, 3};
	//	double[] nums = {1, 2, 3};
	//	double[] nums = {0, 0, 0};
	//	double[] nums = {-4, 2, 5};
	//	double[] nums = {0, 1, 1};
		double a = nums[0];
		double b = nums[1];
		double c = nums[2];
		System.out.println(function(a, b, c));
	}

}
