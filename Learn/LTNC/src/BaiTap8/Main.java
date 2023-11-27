package BaiTap8;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Chuoi ma hoa la: " + ClassTestNumber.encode("Nam", (byte) 8));
		System.out.println("Chuoi giai ma la: " + ClassTestNumber.decoding("Fie", (byte) 8));
		System.out.println("Chuoi ma hoa la: " + ClassTestNumber.encodes("Nam", "54"));
		System.out.println("Chuoi gia ma la: " + ClassTestNumber.decodings("{UX", "54"));
	}

}
