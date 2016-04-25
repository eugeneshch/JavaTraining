/*
 * 9. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 * Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого.
 */

package by.epam.tentasks;

public class Task09 {
	
	public static Object[] arrayMerge(Object[] a, Object[] b, int k) {
		Object[] c = new Object[a.length + b.length];
		for (int i = 0; i < k; i++) {
			c[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			c[i + k] = b[i];
		}
		for (int i = k; i < a.length; i++) {
			c[i + b.length] = a[i];
		}
		return c;
	}
	
	public static Object[] arrayMergeSimple(Object[] a, Object[] b, int k) {	// Второй вариант.
		Object[] c = new Object[a.length + b.length];
		System.arraycopy(a, 0, c, 0, k);
		System.arraycopy(b, 0, c, k, b.length);
		System.arraycopy(a, k, c, b.length + k, a.length - k);
		return c;
	}
	
	public static void main(String[] args) {
		int k = 1;						// в реальном приложении необходимо добавить проверку, действительно ли k - натуральное число.
		Object[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Object[] b = {"One", "Two", "Three", "Four", "Five"};
		Object[] result1 = arrayMerge(a, b, k);
		for (Object obj : result1) {
			System.out.print(obj + " ");
		}
		Object[] result2 = arrayMergeSimple(a, b, k);
		System.out.println();
		for (Object obj : result2) {
			System.out.print(obj + " ");
		}
	}

}
