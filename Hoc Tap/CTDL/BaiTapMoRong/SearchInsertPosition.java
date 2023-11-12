package LeetCode;

public class SearchInsertPosition {
	/*
	 * Cho vao mang da duoc sap xep va mot so tim vi tri cua so trong mang neu khong
	 * co hay gia su co va tra ve vi tri
	 */
	// So lan lam sai: 8
	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == target) 
				return i;
			if (target < nums[0]) 
				return 0;
			if (target > nums[nums.length-1])
				return nums.length;
			if(target > nums[i] && target <= nums[++i])
				return i;
			--i;
		}
		return -1;
		//Mot cach giai ngan
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= target) return i;
//        }
//        return nums.length;
	}

	/*
	 * Test
	 */
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		//0,2,5,7
		System.out.println(searchInsert(nums, 0));
		/*
		 * Loi bi nhieu
		 * Mang chi co mot phan tu
		 */
	}
}
