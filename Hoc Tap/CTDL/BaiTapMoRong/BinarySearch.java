package LeetCode;

import java.util.Calendar;

public class BinarySearch {
	/*
	 * VI tri xuat hien trong mang, khong co tra ve target,
	 * Lam voi thoi gian la O(log n)
	 */
	public static int search(int[] nums, int target) {
//		int len = nums.length/2 - 1;
//		int len_2 = nums.length/2;
//		if(target == nums[len])
//			return len;
//		if(target == nums[len_2])
//			return len_2;
//		if(target < nums[len]) {
//			for (int i = 0; i < len; i++) {
//				if(target == nums[i])
//					return i;
//			}
//			return -1;
//		}
//		if(target > nums[len_2]) {
//			for (int i = len_2; i < nums.length; i++) {
//				if(target == nums[i])
//					return i;
//			}
//			return -1;
//		}
//		return -1;
		for (int i = 0; i < nums.length; i++) {
			if(target == nums[i])
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		long begin = Calendar.getInstance().getTimeInMillis();
		// some code.....
		int[] arr = {-1,0,3,5,9,12,1,1,1,1,1,1,1,11,1,1,11,1,1,1,11};
		System.out.println(search(arr, 2));
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Executed Time: " + (end - begin) + "ms");
		
	}
}
