package BaiTap23;

import java.awt.event.*;


public class HanhDongThemDiemChoMonHoc implements ActionListener {
	private panel_giaoDienMonHoc giaoDienMonHoc;

	public HanhDongThemDiemChoMonHoc(panel_giaoDienMonHoc giaoDienMonHoc) {
		this.giaoDienMonHoc = giaoDienMonHoc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		giaoDienMonHoc.themDiemChoMonHoc();
	}

}
