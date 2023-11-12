package LeetCode;

public class PowerofTwo {
	/*
	 * Kiem tra so co la mot so 2 mu len khong
	 */
	
	/*
	 * Su dung vong lap:
	 * double number = n;
		if(number == 1 || number == 2) return true;
		while((int)number != 0) {
			number /= 2;
			if(number == 2) return true;
		}
		return false;
	 */
	
	/*
	 * De quy
	 *         if(n==1)
            return true;
        if(n%2!=0 || n<=0)
            return false;
        return isPowerOfTwo(n/2);
	 */
	public static boolean isPowerOfTwo(int n) {
		if(n == 0) return false;
		double number = Math.log(n)/Math.log(2);
		System.out.println(number);
		return (number - (int)number) <= 0.000000000000009 ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(536870912));
	}
}
