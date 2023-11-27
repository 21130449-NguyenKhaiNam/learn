package BaiTap23;

import java.util.ArrayList;
import java.util.Arrays;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> danhSachSinhVien;
	private ArrayList<MonHoc> danhSachMonHoc;

	public DanhSachSinhVien() {
		themSinhVien();
	}

	/*
	 * Them danh sach sinh vien vao danh sach
	 */
	public void themSinhVien() {
		// Tao mon hoc
		MonHoc monToan = new MonHoc("Toan", "000", 10.0);
		MonHoc monHoa = new MonHoc("Hoa hoc", "001", 9.25);
		MonHoc monLy = new MonHoc("Vat ly", "002", 9.5);
		MonHoc monDia = new MonHoc("Dia Ly", "003", 8.0);
		MonHoc monVan = new MonHoc("Van hoc", "004", 5.5);
		MonHoc monSu = new MonHoc("Lich su", "005", 4.75);

		// Them mon hoc vao danh sach
		danhSachMonHoc = new ArrayList<MonHoc>();
		danhSachMonHoc.add(monToan);
		danhSachMonHoc.add(monHoa);
		danhSachMonHoc.add(monDia);
		danhSachMonHoc.add(monSu);
		danhSachMonHoc.add(monLy);
		danhSachMonHoc.add(monVan);

		// Tao danh sach mon hoc
		ArrayList<MonHoc> danhSachMonHoc_nam = new ArrayList<MonHoc>();
		danhSachMonHoc_nam.add(monToan);
		danhSachMonHoc_nam.add(monLy);
		danhSachMonHoc_nam.add(monHoa);
		ArrayList<MonHoc> danhSachMonHoc_kimNgan = new ArrayList<MonHoc>();
		danhSachMonHoc_kimNgan.add(monDia);
		danhSachMonHoc_kimNgan.add(monSu);
		danhSachMonHoc_kimNgan.add(monVan);

		// Tao Sinh vien
		SinhVien nam = new SinhVien("Nguyen Khai Nam", "21130449", danhSachMonHoc_nam);
		SinhVien kimNgan = new SinhVien("Nguyen Thi Kim Ngan", "1000000", danhSachMonHoc_kimNgan);

		// Them sinh vien vao danh sach
		this.danhSachSinhVien = new ArrayList<SinhVien>();
		danhSachSinhVien.add(nam);
		danhSachSinhVien.add(kimNgan);
	}

	/*
	 * Ten cac mon hoc hien co
	 */
	public String[] tenCanMonHocDangCo(String mssv) {
		for (SinhVien sinhVien : danhSachSinhVien) {
			if (sinhVien.getIdStudent().equals(mssv)) {
				return sinhVien.tenCacMonHocDangCo();
			}
		}
		return null;
	}

	/*
	 * kiem tra sinh vien co trong danh sach khong
	 */
	public boolean timTrongDanhSach(String mssv) {
		for (SinhVien sinhVien : danhSachSinhVien) {
			if (sinhVien.getIdStudent().equals(mssv)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Lay ten sinh vien duoc yeu cau
	 */
	public String layTenSinhVien(String mssv) {
		for (SinhVien sinhVien : danhSachSinhVien) {
			if (sinhVien.getIdStudent().equals(mssv)) {
				return sinhVien.getNameStudent();
			}
		}
		return "";
	}

	/*
	 * Lay danh sach mon hoc cua sinh vien co so thu tu
	 */
	public String danhSachMonHocCuaSinhVien(String mssv) {
		String cacMonHoc = "";
		for (SinhVien sinhVien : danhSachSinhVien) {
			if (sinhVien.getIdStudent().equals(mssv)) {
				cacMonHoc = sinhVien.layDanhSachMonHoc();
				break;
			}
		}
		return cacMonHoc;
	}

	/*
	 * Them mon hoc cho sinh vien roi tra ve danh sach chuoi hien thi gom co mon hoc
	 * do
	 */
	public String themMonHocChoSinhVien(String mssv, String idMonHoc, String tenMonHoc) {
		for (MonHoc monHoc : danhSachMonHoc) {
			if (monHoc.getIdMonHoc().equals(idMonHoc)) {
				return "\t\t[Ma so id mon hoc bi trung]";
			}
		}
		MonHoc monHocMoi = new MonHoc(tenMonHoc, idMonHoc, 0);
		danhSachMonHoc.add(monHocMoi);
		themMonHocVaoDanhSachChoSinhVien(mssv, monHocMoi);
		String themMonHocMoi = SinhVien.getStt() + "\t\t " + tenMonHoc + "\t\t\t\t 0.0 \n";
		return themMonHocMoi;
	}

	/*
	 * Them mon hoc vao danh sach cua sinh vien co mssv
	 */
	public void themMonHocVaoDanhSachChoSinhVien(String mssv, MonHoc monHocMoi) {
		for (SinhVien sinhVien : danhSachSinhVien) {
			if (sinhVien.getIdStudent().equals(mssv)) {
				sinhVien.getDanhSachMonHoc().add(monHocMoi);
				break;
			}
		}
	}

	/*
	 * Them hoac thay doi diem cho sinh vien roi tra ve hien thi mon hoc voi diem
	 * thay doi
	 */
	public void themDiemChoMonHoc(String idMonHoc, String diem) {
		for (MonHoc monHoc : danhSachMonHoc) {
			if (monHoc.getIdMonHoc().equals(idMonHoc)) {
				int diemSo = Integer.valueOf(diem);
				if(diemSo > 10 || diemSo < 0) {
					monHoc.setDiem(0);
				}else {
					monHoc.setDiem(Integer.valueOf(diem));
				}
				break;
			}
		}
	}
}
