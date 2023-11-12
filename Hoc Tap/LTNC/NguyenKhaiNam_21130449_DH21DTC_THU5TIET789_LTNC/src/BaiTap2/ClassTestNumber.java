package BaiTap2;

public class ClassTestNumber {
	/*
	 * Kiem tra so la chan hay le, 
	 * bang cach xem chia du 2 co cho ra 0 khong
	 */
	public void evenOrOdd(int number) {
		if((number%2) == 0) {
			System.out.println(number +" is a even number");
		}else {
			System.out.println(number + " is a odd number");
		}
	}
	
	/*
	 * Kiem tra co phai so nguyen to khong
	 * Kiem coi no chia het so nao trong day tu 2 toi no tru 1, chi can chia gap so khong phai nguyen to thi thoat ra con chia mai toi no tru 1 van khong phai thi khang dinh no la so nguyen to
	 */
	public void primeNumber(int number) {
		for (int i = 2;; i++) {
				if((number%i == 0 && number != 2) || number<=1) {
					System.out.println(number + " isn't a prime number");
					break;
				}else if((i == number/2 + 1) && (number >= 2)){
					System.out.println(number + " is a prime number");
					break;
			}					
		} 
	}
}
