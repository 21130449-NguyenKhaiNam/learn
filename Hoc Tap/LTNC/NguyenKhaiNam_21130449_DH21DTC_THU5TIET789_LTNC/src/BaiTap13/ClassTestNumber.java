package BaiTap13;

public class ClassTestNumber {
	/*
	 * Ma hoa mot chuoi theo quy tac sau
	 * I am student -> Isn-ttau-md--e-
	 * Quy tac
	 * I	-	a	m	-
	 * s	t	u	d	e
	 * n	t	-	-	-
	 * Tao ra mang chua cac gia tri cua chuoi, thay the cac khoang trang bang dau "-"
	 * Tuy theo loai cho mang so co dong khac nhau
	 * Bien count dung de dem roi thoat ra khi dat toi gioi han cua chuoi
	 * Thuc hien viec luu cho toi khi vuot qua do dai chuoi neu van con trong o phia sau mang thi them "-" vao cac vi tri do
	 * Viec in thuc hien theo quy tac in theo cot
	 */
	public static void stringEncoding(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ') {
				arr[i] = '-';
			}
		}
		char[][] c;
		c = (((double)arr.length/5 - arr.length/5) >0)?(new char[arr.length/5 + 1][5]):(new char[arr.length/5][5]);
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < 5; j++) {
				if(count != arr.length) {
					c[i][j] = arr[count];
					count++;
				}else {
					c[i][j] = '-';
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < c.length; j++) {
				System.out.print(c[j][i]);
			}
		}
	}
	/*
	 * Giai ma chuoi dung quy tac tren
	 * Bien chuoi thanh mot mang thay the cac "-" thanh khoang trong ' '
	 * Vi so luong phan tu trong mang arr luon la so chan chia duoc cho 5 nen khong can dat truong hop
	 * Luu theo thu tu dong, bien count dung de chay mang arr
	 * In ra theo thu tu cot
	 */
	public static void stringDecoding(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == '-') {
				arr[i] = ' ';
			}
		}
		char[][] c = new char[arr.length/5][5];
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < c.length; j++) {
				c[j][i] = arr[count];
				count++;
			}
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(c[i][j]);
			}
		}
	}
}
