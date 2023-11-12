package BaiTap23;

import java.awt.event.*;


public class HanhDongHienThiGiaoDienMonHoc implements ActionListener{
	private JFrame_giaoDienChinh giaoDienChinh;
	
	public HanhDongHienThiGiaoDienMonHoc(JFrame_giaoDienChinh giaoDienChinh) {
		this.giaoDienChinh = giaoDienChinh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		giaoDienChinh.chuyenSangGiaoDienMonHoc();
	}

}
