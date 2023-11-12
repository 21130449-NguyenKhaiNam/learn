package LeetCode;
import java.util.Arrays;

public class RemoveElement {
	/*
	 * Cho vao mot mang lam mat cac phan tu trung val thay doi mang de cac vi tri do
	 * ve cuoi
	 */
	public int removeElement(int[] nums, int val) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				nums[i] = Integer.MAX_VALUE;
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
