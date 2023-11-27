package LeetCode;
import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
	/*
	 * Nhan mang so tra ra so phan tu giong nhau trong mang, dong thoi thay doi mang
	 * ban dau sao so sap xep theo thu tu tu be toi lon va khong co so trung nhau
	 */
	public static int removeDuplicates(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					nums[j] = Integer.MAX_VALUE;
				}
			}
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != Integer.MAX_VALUE) {
				++k;
			}
		}
		return k;
	}
}
