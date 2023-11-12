package BaiTap23;

import java.awt.event.*;


public class HanhDongThemMonHoc implements ActionListener{
	private panel_giaoDienDiem giaoDienDiem;
	
	public HanhDongThemMonHoc(panel_giaoDienDiem giaoDienDiem) {
		this.giaoDienDiem = giaoDienDiem;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		giaoDienDiem.themMonHocChoSinhVien();
	}

}
