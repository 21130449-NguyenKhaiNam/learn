package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums.length < 4)
			return new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int len = nums.length;
		long t = target;
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < len - 3; i++) {
			for (int j = i + 1; j < len - 2; j++) {
				int low = j + 1;
				int high = len - 1;
				while (low < high) {
					long sum = (long)nums[i] + (long)nums[j] + (long)nums[low] + (long)nums[high];
					if (sum == t) {
						set.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));
					} else if (sum < t) {
						++low;
					} else {
						--high;
					}
				}
			}
		}
		return new ArrayList<List<Integer>>(set);
	}

	public static void main(String[] args) {
		int[] nums = { 2,2,2,2,2 };
		int target = 8;
		System.out.println(fourSum(nums, target).toString());
	}
}
