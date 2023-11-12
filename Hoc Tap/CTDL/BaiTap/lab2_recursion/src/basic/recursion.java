package basic;

public class recursion {
	/**
	 * @param n
	 */
	public recursion() {
	}

	/*
	 * S(n)=1-2+3-4+…+ ((-1) (n+1) ).n ,
	 */
	private double recursion_1(int n) {
		if(n <= 0)
			return 0;
		if (n == 1)
			return 1;
		return (Math.pow(-1, n + 1) * n) + recursion_1(n - 1);
	}

	/*
	 * S(n)=1+1.2+1.2.3+…+1.2.3…n
	 */
	private double recursion_2(int n) {
		if(n <= 0)
			return -1;
		if (n == 1)
			return 1;
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			sum *= i;
		}
		return sum + recursion_2(n - 1);
	}

	/*
	 * S(n)=1^2+2^2+3^2+....+n^2
	 */
	private double recursion_3(int n) {
		if(n <= 0)
			return -1;
		if (n == 1)
			return 1;
		return n * n + recursion_3(n - 1);
	}
	
	/*
	 * S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6...2n)
	 */
	private double recursion_4(int n) {
		if(n < 0)
			return -1;
		if(n == 0)
			return 1;
		int mul = 2;
		for (int i = 2; i <= n; i++) {
			mul *= (2*i);
			System.out.println(mul);
		}
		return ((double)1/mul) + recursion_4(n - 1);
	}
	

	public static void main(String[] args) {
		recursion recursion = new recursion();
		System.out.println((1+(double)1/2+(double)1/(2*4)+(double)1/(2*4*6)) + "");
		
		int n = 4;
		// S(n)=1-2+3-4+…+ ((-1) (n+1) ).n
		System.out.println(" S(n)=1-2+3-4+…+ ((-1) (n+1) ).n: with n = " + n + " = " + recursion.recursion_1(n));

		// S(n)=1+1.2+1.2.3+…+1.2.3…n
		int m = 3;
		System.out.println("S(n)=1+1.2+1.2.3+…+1.2.3…n: with m = " + m + " = " + recursion.recursion_2(m));
		
		//S(n)=1^2+2^2+3^2+....+n^2
		System.out.println("S(n)=1^2+2^2+3^2+....+n^2: with m = " + m + " = " + recursion.recursion_3(m));
		
		//S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6...2n)
		System.out.println("S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6...2n) with m = " + m + " = " + recursion.recursion_4(m));
	}
}
