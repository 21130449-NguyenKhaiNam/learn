package LeetCode;

public class MajorityElement {
	/*
	 * So lan xuat hien nhieu nhat trong mang, tra ve con so xuat hien nhieu nhat
	 */

	// So lan sai: 6
	/*
	 * Cach khac public int majorityElement(int[] nums) { Arrays.sort(nums); return
	 * nums[nums.length/2]; }
	 */
	public static int majorityElement(int[] nums) {
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j])
					++len;
			}
			if (len > nums.length / 2)
				return nums[i];
			len = 0;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6 };
		System.out.println(MajorityElement.majorityElement(nums) + "");
	}
}
