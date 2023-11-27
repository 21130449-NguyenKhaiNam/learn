package LeetCode;

public class ClimbingStairs {
	/*
	 * Co n bac thang moi lan co the buoc tu 1 toi 2 buoc tinh so truong hop co the
	 * buoc len cau thang
	 * Su dung cong thuc Binet
	 */
	//So lan sai: 1
	public static int climbStairs(int n) {
		//Cach khac
//		 if(n==1)return 1;
//		    int[] dp =new int[n];
//		    dp[0] = 1;
//		    dp[1]=2;
//		    
//		    for(int i = 2 ;i<n ;i++){
//		        dp[i]=dp[i-1]+dp[i-2];
//		    }
//		    return dp[n-1];
		double can_5 = Math.sqrt(5);
		return (int) ((1/can_5)*(Math.pow((1+can_5)/2, n + 1)-Math.pow((1-can_5)/2,n+1)));
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(2) + "");
	}
}
