package BaiTap23;

import java.util.ArrayList;

public class SinhVien {
	private String nameStudent;
	private String idStudent;
	private ArrayList<MonHoc> danhSachMonHoc;
	public static int stt;

	public SinhVien(String nameStudent, String idStudent, ArrayList<MonHoc> danhSachMonHoc) {
		this.nameStudent = nameStudent;
		this.idStudent = idStudent;
		this.danhSachMonHoc = danhSachMonHoc;
	}

	/**
	 * @return the stt
	 */
	public static int getStt() {
		return ++stt;
	}

	/*
	 * Thiet lap stt
	 */
	public static void thietLapSTT() {
		stt = 0;
	}

	/**
	 * @return the nameStudent
	 */
	public String getNameStudent() {
		return nameStudent;
	}

	/**
	 * @param nameStudent the nameStudent to set
	 */
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	/**
	 * @return the idStudent
	 */
	public String getIdStudent() {
		return idStudent;
	}

	/**
	 * @param idStudent the idStudent to set
	 */
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	/**
	 * @return the danhSachMonHoc
	 */
	public ArrayList<MonHoc> getDanhSachMonHoc() {
		return danhSachMonHoc;
	}

	/**
	 * @param danhSachMonHoc the danhSachMonHoc to set
	 */
	public void setDanhSachMonHoc(ArrayList<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}

	/*
	 * Lay ten cac mon hoc
	 */
	public String[] tenCacMonHocDangCo() {
		String[] tenMonHoc = new String[danhSachMonHoc.size()];
		for (int i = 0; i < tenMonHoc.length; i++) {
			tenMonHoc[i] = (i + 1) + "     " + danhSachMonHoc.get(i).getNameMonHoc() + "("
					+ danhSachMonHoc.get(i).getIdMonHoc() + ")";
		}
		return tenMonHoc;
	}

	/*
	 * Lay danh sach mon hoc dang co
	 */
	public String layDanhSachMonHoc() {
		String cacMonHoc = "";
		for (MonHoc monHoc : danhSachMonHoc) {
			cacMonHoc += ++stt + "\t\t " + monHoc.getNameMonHoc() + "\t\t\t\t " + monHoc.getDiem() + "\n";
		}
		return cacMonHoc;
	}

}
