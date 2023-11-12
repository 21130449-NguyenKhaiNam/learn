package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int minDiff = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < n - 2; i++) {
			int low = i + 1, high = n - 1;
			while (low < high) {
				int temp = nums[i] + nums[low] + nums[high];
				if (Math.abs(target - temp) < minDiff) {
					ans = temp;
					minDiff = Math.abs(target - temp);
				}
				if (temp == target) {
					return target;
				} else if (temp > target) {
					high--;
				} else {
					low++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 0, 5, -5, 3, 3, 0, -4, -5 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(threeSumClosest(nums, -2));
	}
}
