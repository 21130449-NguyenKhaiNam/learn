package BaiTap23;

import java.awt.event.*;

public class HanhDongHienThiGiaoDienDiem implements ActionListener{
	private JFrame_giaoDienChinh giaoDienChinh;
	
	
	
	public HanhDongHienThiGiaoDienDiem(JFrame_giaoDienChinh giaoDienChinh) {
		this.giaoDienChinh = giaoDienChinh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		giaoDienChinh.chuyenSangGiaoDienDiem();
	}

}
