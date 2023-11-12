package Fibonacci;import basic.recursion;

public class Recursion {
	
	public static int getFibonacci(int n) {
		int a = 0;
		int b = 1;
		int sum = 0;
		while(n > 0) {
			sum = a + b;
			a = b;
			b = sum;
			--n;
		}
		return sum;
	}

	/*
	 * In day so do ra, Cho vao n thu tu, in ra so n phan tu trong day fibonacci
	 */
	public static void printFibonacci(int n) {
		if(n <= 0) {
			System.out.println("-1");
			return;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
	}

	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		recursion.printFibonacci(100);
	}
}
