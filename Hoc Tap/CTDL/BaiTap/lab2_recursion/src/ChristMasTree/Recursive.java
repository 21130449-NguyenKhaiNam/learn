package ChristMasTree;

public class Recursive {
	// Tất cả đều sử dụng đệ quy ( 1 số chỗ xài vòng lặp dễ hơn :)) )

	/*
	 * Sử dụng để lấy hình muốn in
	 */
	public static String hinhIn;

	/*
	 * Lớp chính thực hiện vẽ
	 */
	public static void drawChristmasTree(int n) {
		// Kiểm tra
		if (n <= 0) {
			System.out.println("Nhap so duong nha >.<");
			return;
		}

		// Chỉ các con số đặc biệt mới vẽ được, số đó bằng tổng số tự nhiên nguyên dương
		// ngẫu nhiên
		if (!soDacBiet(n, 2, 3)) {
			System.out.println("Chi so dac biet moi co cay thong noel nay :>");
			return;
		}
		System.out.println("Cay thong nay hoi om :v");

		// Thực hiện vẽ
		veHinh(n, 1, 1);

		// In đế cho cây
		inDe(n);
	}

	/*
	 * Kiểm tra số đặc biệt không
	 */
	private static boolean soDacBiet(int n, int batDau, int tongCacSoTruocDo) {
		// TODO Auto-generated method stub
		if (tongCacSoTruocDo > n || n <= 2) {
			return false;
		}
		return (tongCacSoTruocDo == n) || soDacBiet(n, batDau + 1, tongCacSoTruocDo(batDau));
	}

	private static int tongCacSoTruocDo(int batDau) {
		// TODO Auto-generated method stub
		if (batDau == 1)
			return 1;
		return batDau + tongCacSoTruocDo(batDau - 1);
	}

	private static void inDe(int n) {
		// TODO Auto-generated method stub
		if (n <= 3) {
			System.out.println(khoangTrang(n - 1) + hinhIn);
			return;
		}
		//Nếu dài hơn 15 cần tăng thêm 1 dấu cách ở phần đuôi
		int count = n >= 15 ? 1 : 0;
		inCay(n - 1, n / 2 - 1);
		System.out.println(khoangTrang(n / 2 + count) + chuoiHinh(hinhIn, n / 2));
	}

	/*
	 * In theo dạng dọc
	 */
	private static void inCay(int rong, int doCao) {
		// TODO Auto-generated method stub
		// Điều kiện ngắt
		System.out.println(khoangTrang(rong) + hinhIn);
		if (doCao == 1) 
			return;
		inCay(rong, doCao - 1);
	}

	private static void veHinh(int doCao, int bienChay, int tong) {
		// TODO Auto-generated method stub
		hinh(hinhIn, 1, bienChay, doCao);
		if (tong == doCao) 
			return;
			veHinh(doCao, ++bienChay, tong + bienChay);
	}

	/*
	 * In theo dang ngang
	 */
	private static void hinh(String hinh, int dong, int toiDa, int doCao) {
		// TODO Auto-generated method stub
		System.out.print(khoangTrang(doCao - dong) + chuoiHinh(hinh, dong) + "\n");
		if (dong == toiDa)
			return;
		hinh(hinh, ++dong, toiDa, doCao);
	}

	private static String chuoiHinh(String hinh, int soHinh) {
		// TODO Auto-generated method stub
		if (soHinh == 1)
			return hinh;
		return hinh + " " + chuoiHinh(hinh, soHinh - 1);
	}

	private static String khoangTrang(int soKhoang) {
		// TODO Auto-generated method stub
		if (soKhoang == 0)
			return " ";
		return " " + khoangTrang(soKhoang - 1);
	}

	public static void main(String[] args) {
		Recursive.hinhIn = "X";
		drawChristmasTree(10);
	}
}
