package BaiTap15;

public class ClassTestNumber {
	/*
	 * Cho 2 mang so viet ham xac dinh xem mang so 1 co chua mang so 2 khong
	 * Su dung for kiem vi tri dau tien trung voi gia tri dau cua arr2 duoc dem bang count
	 * Su dung while de vua kiem vua xem gia tri ke tiep cua arr1 co trung gia tri cua arr2 vi neu chua thi gia tri phai lien tiep
	 * cuoi cung kiem tra xem co chua khong, neu chua phai thoa tat ca den khi count bang do dai mang arr2
	 * Dieu kien tien quyet la mang 1 phai lon hon mang 2
	 */
	public static void checkArrays(int[] arr1, int[] arr2) {
		if(arr1.length >= arr2.length) {
			int count = 0;
			for (int i = 0; i < arr1.length;++i) {
				while (count < arr2.length && arr1[i] == arr2[count]) {
					System.out.println("Vi tri " + (i + 1) + " cua arr1 trung voi vi tri " + (count + 1) + " cua arr2 bang: " + arr2[count]);
					++i;
					++count;
				}
				if(i==arr1.length -1) {
					System.out.println("Arr1 khong chua Arr2");
				}else if(count==arr2.length){
					System.out.println("Arr1 co chua Arr2");
					break;
				}
			}
		}else {
			System.out.println("Arr1 must be greater than Arr2");
		}
		
	}
}
