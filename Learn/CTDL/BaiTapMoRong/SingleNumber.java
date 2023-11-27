package LeetCode;

public class SingleNumber {
	/*
	 * Cho mot mang cac so, moi so deu lap lai 1 lan, co 1 so khong lap, tim ra so
	 * do
	 */
	public static int singleNumber(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i] == nums[j]) {
					k = 0;
					break;
				}
				++k;
			}
			if (k == nums.length) {
				return nums[i];
			}
		}
		return 0;
	}

	/*
	 * Mot cach khac: Neu hai so giong nhau cung xor thi se bang 0 vi vay so con lai
	 * se la so duy nhat co trong mang khong bi trung 
	 * int s=0; 
	 * for(int n:nums){
	 * s^=n; } return s;
	 */
	// So lan sai: 1
	public static void main(String[] args) {
		int[] arr = { 2, 2, 3, 3, 1 };
		int[] arr2 = { 1, 0, 1 };
		System.out.println(singleNumber(arr));
		System.out.println(singleNumber(arr2));
	}
}
