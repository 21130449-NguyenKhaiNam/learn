package BaiTap8;

public class ClassTestNumber {
	/*
	 * Dung xor ma hoa va giai ma chuoi voi 1 byte password, sau do mo rong voi password la chuoi bat ky
	 * String duoc cau tao tu cac ky tu, ma hoa cac ky tu thanh byte roi luu vao mang
	 * Bien text dung de noi chuoi lai o cuoi cung
	 * Cho chay for roi ma hoa bang xor, vong for thu hai de noi lai thanh mot chuoi roi in ra
	 */
	public static String encode(String s, byte key) {
		byte[] arr = s.getBytes();
		String text = "";
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (arr[i] ^ key);
		}
		for (int i = 0; i < arr.length; i++) {
			text = text + (char)arr[i];
		}
		return text;
	}
	/*
	 * Giai ma cho chuoi 1 byte password
	 * Dua vao viec ma hoa de giai ma
	 */
	public static String decoding(String text, byte key) {
		return ClassTestNumber.encode(text, key);
	}
	/*
	 * Ma hoa cho chuoi bat ky
	 * Dua key ve thanh cac byte roi luu vao mang, roi lam nhu mang voi 1 byte, bien count dung de chay mang key neu chay het thi lap lai chay tu dau
	 */
	public static String encodes(String s, String key) {
		byte[] arr0 = s.getBytes();
		byte[] arr1 = key.getBytes();
		int count = 0;
		String text = "";
		for (int i = 0; i < arr0.length; i++) {
			arr0[i] = (byte) (arr0[i] ^ arr1[count]);
			if(count == arr1.length-1) {
				count = 0;
			}else {
				++count;
			}
		}
		for (int i = 0; i < arr0.length; i++) {
			text = text + (char)arr0[i];
		}
		return text;
	}
	/*
	 * Gia ma cho chuoi bat ky
	 */
	public static String decodings(String s, String key) {
		return ClassTestNumber.encodes(s, key);
	}
}
