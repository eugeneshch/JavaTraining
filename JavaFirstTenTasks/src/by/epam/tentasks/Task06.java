/*
 * 6. Написать программу нахождения суммы большего и меньшего из трех чисел.
 */

package by.epam.tentasks;

public class Task06 {

	public static double sumMinMax(double[] nums) {
		double min = nums[0];
		double max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			} else if (nums[i] > max) {
				max = nums[i];
			}
		}
		return (min + max);
	}
	
	public static void main(String[] args) {
		double[] nums = {3, 0, -2};
	//	double[] nums = {1.0, -5.3, -1.2};
	//	double[] nums = {0, 0, 0};
	//	double[] nums = {Double.MAX_VALUE, 1, 10};
	//	double[] nums = {Double.NaN, 1, 10};
	//	double[] nums = {1, Double.NaN, 10};
	//	double[] nums = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 10};
		System.out.println(sumMinMax(nums));
	}
}
