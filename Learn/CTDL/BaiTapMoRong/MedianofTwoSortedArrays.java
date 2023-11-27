package LeetCode;

public class MedianofTwoSortedArrays {
	/*
	 * Neu hai mang hop lai la chan thi tong hai vi tri giua, neu le thi tra ve o
	 * giua
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums3 = new int[nums1.length + nums2.length];
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		while (index1 < nums1.length && index2 < nums2.length) {
			if (nums1[index1] < nums2[index2]) {
				nums3[index3] = nums1[index1];
				++index1;
			} else {
				nums3[index3] = nums2[index2];
				++index2;
			}
			++index3;
		}
		for (int i = index1; i < nums1.length; i++) {
			nums3[index3] = nums1[i];
			++index3;
		}
		for (int i = index2; i < nums2.length; i++) {
			nums3[index3] = nums2[i];
			++index3;
		}
		return (nums3.length % 2) == 0 ? (double) (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2
				: (double) nums3[nums3.length/2];
	}

	public static void main(String[] args) {
		int[] arr1 = {1,3};
		int[] arr2 = {2};
		System.out.println(findMedianSortedArrays(arr1, arr2));
	}
}
