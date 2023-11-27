package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	/*
	 * Cho mot mang va mot so nguyen, tim xem co vi tri trung trong mang va hai vi
	 * tri do tru nhau co be hon hoac bang so nguyen khong, co tra ve true, luu y:
	 * phai thu cho tat ca vi tri
	 */

	/*
	 * Cach 1: Khong duoc: Vi thoi gian duyet mang qua lau khong khac phuc duoc
	 * Huong lam: Vong for(i) 1 cho chay phan tu, chay vong for(j) 2 cho kiem tra
	 * phan tu tai vi tri i voi phan tu tai vi tri j, neu trung kiem tra tiep tru
	 * nhau co be hon so nguyen khong
	 */

	public boolean containsNearbyDuplicate(int[] nums, int k) {
//		Cach 1:
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[i] == nums[j]) {
//					if (Math.abs(i - j) <= k)
//						return true;
//					// Bang nhung tru khong be hon thi vi tri sau lon hon chac chan khong be hon nen
//					// thoat luon
//					break;
//				}
//			}
//		}
//		return false;

		/*
		 * Cach 2: Su dung map, lay gia tri lam key con vi tri lam value
		 */
//		Cach 2
		//So lan sai: 11
		Map<Integer, Integer> t = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length - 1;) {
			t.put(nums[i], i);
			if(t.containsKey(nums[++i])) {
				if(Math.abs(i - t.get(nums[i])) <= k) return true;
			}
		}
		return false;
	}
}
