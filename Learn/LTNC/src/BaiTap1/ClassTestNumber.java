package BaiTap1;

public class ClassTestNumber {
	/*
	 * Lam tron so 
	 * Kiem tra phan thap phan co lon hon 0.5
	 * Neu co thi moi tang len khong thi ha xuong
	 */
	public static int roundNumber(float number) {
		if(number - (int)number >= 0.5) {
			return (int)number + 1;
		}
		return (int)number;
	}
}
