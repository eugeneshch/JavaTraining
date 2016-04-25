/*
* 5. Даны три действительных числа. Возвести в квадрат те из них, значения которых неотрицательны, и в четвертую степень — отрицательные.
 */

package by.epam.tentasks;

public class Task05 {

	public static double[] powNums(double[] nums) {
		int pow;
		double[] result = new double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				pow = 2; 
			}
			else pow = 4;
			result[i] = Math.pow(nums[i], pow);
		}
		return result;
	}
	
	public static void main(String[] args) {
		double[] nums = {3, 0, -2};
	//	double[] nums = {0.5, 1.7, -5.4};
	//	double[] nums = {0, 0, 0};
	//	double[] nums = {10, Double.MAX_VALUE, Double.MIN_VALUE};
	//	double[] nums = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN};
		double[] result = powNums(nums);
		for (double num : result) {
			System.out.print(num + " ");
		}

	}

}
