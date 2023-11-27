package LeetCode;
import java.util.Arrays;

public class MergeSortedArray {
	/*
	 * Cho hai mang so nguyen voi thu tu tang dan, m va n lan luot la dai dai cho so
	 * phan tu trong num1 va num2, luu y 0 khong phai la phan tu, hop nhat num1 va
	 * num2 trong num1 va sap xep theo thu tu khong giam
	 */
	//So lan sai: 1
	public static  void merge(int[] nums1, int m, int[] nums2, int n) {
		int a = 0;
		for (int i = 0; i < nums1.length && a < n; i++) {
			if(nums1[i] == 0) {
				nums1[i] = nums2[a];
				++a;
			}
		}
		Arrays.sort(nums1);
	}
	
	public static void in(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1}; 
		int m = 2;
		int[] nums2 = {};
		int n = 0;
		merge(nums1, m, nums2, n);
	}
}
