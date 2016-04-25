/*
 * 1. Составить линейную программу, печатающую значение true, если указанное высказывание является истинным, и false — в противном случае:
 * Сумма двух первых цифр заданного четырехзначного числа равна сумме двух его последних цифр. 
*/



package by.epam.tentasks;

public class Task01 {

	public static void main(String[] args) {
		int num = 3714;
	//	int num = 5160;
	//	int num = 9446;
	//	int num = 8017;
	//	int num = 6325;
	//	int num = 523;
	//	int num = 513;
	//	int num = 0;
		int num4 = num % 10;	
		num /= 10;
		int num3 = num % 10;
		num /= 10;
		int num2 = num % 10;
		num /= 10;
		int num1 = num % 10;
		boolean result = ((num1 + num2) == (num3 + num4));
		System.out.println(result);
	}

}
