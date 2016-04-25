/*
 * 3. Вычислить периметр и площадь прямоугольного треугольника по длинам а и b  двух катетов.
 */

package by.epam.tentasks;

public class Task03 {

	public static double perimeter(double a, double b) {
		double c = Math.sqrt(a*a + b*b);
		return (a + b + c);
	}
	
	public static double area(double a, double b) {
		return (a * b / 2);
	}
	
	public static void main(String[] args) {
	 	double[] nums = {1, 1};
	 // double[] nums = {0.5, 1.7};
	 //	double[] nums = {3, 4};
	 //	double[] nums = {0, 0};
	 //	double[] nums = {3.1, -3.5};	// в полноценном приложении должна быть проверка корректности данных
	 	double a = nums[0];
		double b = nums[1];
		System.out.println("P = " + perimeter(a, b) + "\nS = " + area(a, b));
	}

}
