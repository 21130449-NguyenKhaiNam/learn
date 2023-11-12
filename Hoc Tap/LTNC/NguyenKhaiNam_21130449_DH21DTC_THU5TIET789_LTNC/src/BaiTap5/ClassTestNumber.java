package BaiTap5;

public class ClassTestNumber {
	/*
	 * Nhan vao a va b, sau do khi goi chuong trinh se in ra so luong a la so nguyen to lon hon b va gan b nhat
	 * mang arr de luu cac so nguyen to do, count la bien so thuc hien viec tang so, number de dem so luong khi la so nguyen to
	 * Thuc hien vong lap va chi ket thuc khi mang o vi tri cuoi cung theo so luong a khac 0
	 * Khong nhan b nen count tang len 
	 * Vi 1 va 0 khong phai so nguyen to va khong xet so am
	 * Trong qua trinh tang so nao khong phai so nguyen to thi bo con lai luu vao arr
	 */
	public void recentPrimes(int a, int b) {
		if(a>0) {
			int[] arr = new int[a];
			int count = b;
			int number = 0;
			while(arr[a-1] == 0) {
				++count;
				if(b<0){
					System.out.println("Please check numbers");
				}
					for (int i = 2;; i++) {
							if((count%i == 0 && count != 2) || count<=1) {
								break;
							}else if((i == count/2 + 1) && (count >= 2)){
								arr[number] = count;
								++number;
								break;
							}
					}
			}
			//In cho dep
			System.out.print("There are " + a + " primes close to " + b + " that are: [ ");
			for (int j = 0; j < a; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.print("]");
		}else {
			System.out.println("Please check a");
		}
	}
}
