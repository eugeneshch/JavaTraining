/*
 * 8. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */


package by.epam.tentasks;

public class Task08 {

	public static long sumMultiples(int[] a, int k) {
		long sum = 0;
		for (int i : a) {
			if ((k > 0) && (i > 0) && (i % k == 0)) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int k = 10;
		int[] a = {121,156,23,2,1,69,48,698,12,45,17,11,5,20,93,77};
		System.out.println(sumMultiples(a, k));
	}
}
