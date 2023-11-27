package BaiTap9;

public class ClassTestNumber {
	/*
	 * Viet chuong trinh phan cach hang tram, nghin, trieu,... cho day so
	 * Dua so ve chuoi roi dua ve mang de co the dem so luong roi them dau 
	 * s la bien dua so ve chuoi, arr mang chua chuoi s bi bien thanh, text luu day so khi them dau phay, count the hien vi tri hien tai dang dung o mang
	 * cho vong lap chay voi con so duoc bo vao, khong xai bien number nua nen lay su dung lam bien luu luon,
	 * neu number chia 1000 ra khong tuc be hon 4 chu so thu khong can them dau phay con nguoc lai them
	 * neu number hon 3 chu so thi them day phai hang cuoi, day la chuoi dao vi nen dem tu duoi len
	 * count thuc hien viec the hien vi tri hien hanh cua chuoi, vd da di qua 3 chu so va them dau phay th count se dung o vi tri thu 4
	 * neu number be hon 3 chu so thi cho chay for voi vi tri bat dau la vi tri count roi chay cho toi cuoi vi khong chia het nen chi co the be hon bang 3 chu so
	 * vong lap for cuoi cung la dao lai chuoi theo dung thu tu 
	 */
	public static void numberSeparator(int number) {
		String s = String.valueOf(number);
		char[] arr = s.toCharArray();
		String text = "";
		int count = arr.length-1;
		while(number>0) {
			if((number/=1000) != 0) {
				text = text + arr[count] + arr[--count] + arr[--count] + ",";
				--count;
			}else {
				for (int i = count; i >= 0; i--) {
					text = text + arr[i];
				}
			}
		}
		char[] arr1 = text.toCharArray();
		for (int i = arr1.length-1; i >= 0; i--) {
			System.out.print(arr1[i]);
		}
	}
}
