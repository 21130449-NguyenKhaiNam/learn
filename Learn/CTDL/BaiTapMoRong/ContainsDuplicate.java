package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	/*
	 * Kiem tra trong mang co phan tu nao lap lai 2 lan khong, neu khong tra ve
	 * false
	 */
	//So lan sai: 6
	public static boolean containsDuplicate(int[] nums) {
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if(nums[i] == nums[j]) return true;
//			}
//		}
//		return false;
		//Su dung se xu ly duoc thoi gian; Bai cua nguoi khac
		 Set<Integer> set = new HashSet<>();

		    for (Integer i: nums){
		        if (!set.add(i))
		            return true;
		    }

		    return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(containsDuplicate(arr));
	}
}
