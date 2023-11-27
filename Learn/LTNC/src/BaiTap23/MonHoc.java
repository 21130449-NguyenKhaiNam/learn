package BaiTap23;

public class MonHoc {
	private String nameMonHoc;
	private String idMonHoc;
	private double diem;
	
	public MonHoc(String nameMonHoc, String idMonHoc, double diem) {
		this.nameMonHoc = nameMonHoc;
		this.idMonHoc = idMonHoc;
		this.diem = diem;
	}
	/**
	 * @return the diem
	 */
	public double getDiem() {
		return diem;
	}
	/**
	 * @param diem the diem to set
	 */
	public void setDiem(double diem) {
		this.diem = diem;
	}
	/**
	 * @return the nameMonHoc
	 */
	public String getNameMonHoc() {
		return nameMonHoc;
	}
	/**
	 * @param nameMonHoc the nameMonHoc to set
	 */
	public void setNameMonHoc(String nameMonHoc) {
		this.nameMonHoc = nameMonHoc;
	}
	/**
	 * @return the idMonHoc
	 */
	public String getIdMonHoc() {
		return idMonHoc;
	}
	/**
	 * @param idMonHoc the idMonHoc to set
	 */
	public void setIdMonHoc(String idMonHoc) {
		this.idMonHoc = idMonHoc;
	}
	
	
}
