/* 
 * 4. Для данных областей составить линейную программу, которая печатает true, 
 * если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае: ...
 */

package by.epam.tentasks;

public class Task04 {

	public static boolean isInside(double x, double y) {
		if (((Math.abs(x) <= 4) && (y >= -3) && (y <= 0)) || ((Math.abs(x) <= 2) && (y >= 0) && (y <= 4))) {
			return true;
		}
		else return false;
	}
	
	public static void main(String[] args) {
		double[] nums = {1, 1};
	//	double[] nums = {-4, -3};
	//	double[] nums = {4, 0};
	//	double[] nums = {2, 4};
	//	double[] nums = {-4.1, -3.1};
	//	double[] nums = {2, 5};
	//	double[] nums = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
		double x = nums[0];
		double y = nums[1];
		System.out.println(isInside(x, y));
	}

}
