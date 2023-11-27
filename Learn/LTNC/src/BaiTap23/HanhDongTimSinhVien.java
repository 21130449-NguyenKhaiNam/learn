package BaiTap23;

import java.awt.event.*;


public class HanhDongTimSinhVien implements ActionListener{
	private String lopGoiToi = "";
	private panel_giaoDienDiem giaoDienDiem;
	private panel_giaoDienMonHoc giaoDiemMonHoc;
	
	public HanhDongTimSinhVien(panel_giaoDienMonHoc giaoDiemMonHoc) {
		lopGoiToi = "Mon Hoc";
		this.giaoDiemMonHoc = giaoDiemMonHoc;
	}

	public HanhDongTimSinhVien(panel_giaoDienDiem giaoDienDiem) {
		lopGoiToi = "Diem";
		this.giaoDienDiem = giaoDienDiem;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(lopGoiToi.equals("Mon Hoc")) {
			giaoDiemMonHoc.sinhVienCanTim();
		}else if(lopGoiToi.equals("Diem")) {
			giaoDienDiem.sinhVienCanTim();
		}
	}

}
