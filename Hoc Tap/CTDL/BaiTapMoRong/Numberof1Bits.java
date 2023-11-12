package LeetCode;

public class Numberof1Bits {
	/*
	 * Co bao nhieu bit so 1 trong so
	 */
	 public static int hammingWeight(int n) {
//	     String s = Integer.toBinaryString(n);
//	     int count = 0;
//	     for (char ch : s.toCharArray()) {
//			if(ch == '1') ++count;
//		}
//	     return count;
		 int count = 0;
	        while(n!=0){
	        	System.out.println(n & 1);
	            if((n & 1) == 1){
	              count++;   
	            }
	            n = n>>>1; // using ">>>" because n is an unsigned value so we use unsigned right shift operator
	            System.out.println(n);
	            System.out.println("------------------------------");
	        } 
	        return count;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}
}
