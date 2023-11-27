package LeetCode;

public class ContainerWithMostWater {
	/*
	 * Cho vao mang chuyen hoa no ve toa do roi tinh the tich lon nhat no co the
	 * chua
	 */

	public static int maxArea(int[] height) {
//		Theo thuat toan	
			int left = 0, right = height.length - 1, max = 0;
			int calc = 0;
			while(left != right) {
				if(height[left] > height[right]) {
					calc = (right - left)*height[right];
					--right;
				}else {
					calc = (right - left)*height[left];
					++left;
				}
				if (max < calc) {
					max = calc;
				}
			}
			return max;
//			Theo de quy
//		return theTinhLonNhat(height, 0, height.length - 1);
//	}
//
//	private static int theTinhLonNhat(int[] height, int left, int right) {
//		// TODO Auto-generated method stub
//		if (left == right)
//			return 0;
//		return height[left] > height[right]
//				? Math.max(height[right] * (Math.abs(right - left)), theTinhLonNhat(height, left, --right))
//				: Math.max(height[left] * (Math.abs(right - left)), theTinhLonNhat(height, ++left, right));
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(arr));
	}
}
