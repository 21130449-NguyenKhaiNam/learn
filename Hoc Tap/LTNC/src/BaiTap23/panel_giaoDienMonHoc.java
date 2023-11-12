package BaiTap23;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class panel_giaoDienMonHoc extends JPanel {
	private JTextField text_hoVaTen;
	private JTextField text_mssv;
	private JTextArea hienThiThongTinMonHoc;
	private JFrame_giaoDienChinh giaoDienChinh;
	private String hienThi = "STT \t\t Ten Mon Hoc \t\t\t Diem \n";
	private JComboBox<String> comboBox_MonHoc;
	private JPanel panel_ThemMonHoc;
	private JTextField text_diem;

	public panel_giaoDienMonHoc(JFrame_giaoDienChinh giaoDienChinh) {
		this.giaoDienChinh = giaoDienChinh;
		themThanhPhan();
	}

	public void themThanhPhan() {
		// Cac panel chua
		panel_ThemMonHoc = new JPanel();
		JPanel panel_thaoTac = new JPanel();

		// Thiet lap cac border
		panel_ThemMonHoc.setBorder(BorderFactory.createTitledBorder("Them mon hoc"));
		panel_thaoTac.setBorder(BorderFactory.createTitledBorder("Thao tac"));

		// Hien thi cac thong tin mon hoc
		hienThiThongTinMonHoc = new JTextArea(hienThi);
		Font font = new Font("Times New Roman", Font.PLAIN, 20);
		hienThiThongTinMonHoc.setFont(font);
		hienThiThongTinMonHoc.setEditable(false);
		JScrollPane hienThiThongTinMonHocCoThanhCuon = new JScrollPane(hienThiThongTinMonHoc,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// Them thanh phan vao panel them mon hoc
		JLabel label_mssv = new JLabel("MSSV", JLabel.RIGHT);
		text_mssv = new JTextField();
		JLabel label_hoVaTen = new JLabel("Ho va ten", JLabel.RIGHT);
		text_hoVaTen = new JTextField();
		text_hoVaTen.setEditable(false);
		JLabel label_MonHoc = new JLabel("Mon hoc", JLabel.RIGHT);
		comboBox_MonHoc = new JComboBox();
		JLabel label_diem = new JLabel("Diem", JLabel.RIGHT);
		text_diem = new JTextField();
		panel_ThemMonHoc.setLayout(new GridLayout(4, 2));
		panel_ThemMonHoc.add(label_mssv);
		panel_ThemMonHoc.add(text_mssv);
		panel_ThemMonHoc.add(label_hoVaTen);
		panel_ThemMonHoc.add(text_hoVaTen);
		panel_ThemMonHoc.add(label_MonHoc);
		panel_ThemMonHoc.add(comboBox_MonHoc);
		panel_ThemMonHoc.add(label_diem);
		panel_ThemMonHoc.add(text_diem);

		// Them thanh phan vao thao tac
		JButton button_themDiem = new JButton("Them diem");
		HanhDongThemDiemChoMonHoc hanhDongThemDiemChoMonHoc = new HanhDongThemDiemChoMonHoc(this);
		button_themDiem.addActionListener(hanhDongThemDiemChoMonHoc);
		JButton button_timSinhVien = new JButton("Tim sinh vien");
		HanhDongTimSinhVien hanhDongTimSinhVien = new HanhDongTimSinhVien(this);
		button_timSinhVien.addActionListener(hanhDongTimSinhVien);
		panel_thaoTac.add(button_themDiem);
		panel_thaoTac.add(button_timSinhVien);

		// Thiet lap dang cho panel chinh
		this.setLayout(new GridLayout(3, 1));

		// Them cac thanh phan vao panel chinh
		this.add(panel_ThemMonHoc);
		this.add(panel_thaoTac);
		this.add(hienThiThongTinMonHocCoThanhCuon);
	}

	/*
	 * Tim sinh vien theo ma so sinh vien neu khong co thi thong bao trong hien thi
	 * thong bao
	 */
	public void sinhVienCanTim() {
		if (TruyCapDanhSachSinhVien.danhSachSinhVien.timTrongDanhSach(text_mssv.getText())) {
			SinhVien.thietLapSTT();
			String[] tenMonHocDangCoCuaSinhVien = TruyCapDanhSachSinhVien.danhSachSinhVien
					.tenCanMonHocDangCo(text_mssv.getText());
			comboBox_MonHoc.removeAllItems();
			for (String tenMonHoc : tenMonHocDangCoCuaSinhVien) {
				comboBox_MonHoc.addItem(tenMonHoc);
			}
			hienThiThongTinMonHoc.setText(hienThi);
			text_hoVaTen.setText(TruyCapDanhSachSinhVien.danhSachSinhVien.layTenSinhVien(text_mssv.getText()));
			hienThiThongTinMonHoc
					.append(TruyCapDanhSachSinhVien.danhSachSinhVien.danhSachMonHocCuaSinhVien(text_mssv.getText()));
		} else {
			hienThiThongTinMonHoc.append(" \t\t[Khong co sinh vien nay]" + "\n");
		}
		giaoDienChinh.capNhatGiaoDien();
	}

	/*
	 * Thay doi diem cho mon hoc
	 */
	public void themDiemChoMonHoc() {
		if (TruyCapDanhSachSinhVien.danhSachSinhVien.timTrongDanhSach(text_mssv.getText())) {
			String chuoiTenMonHoc = (String) comboBox_MonHoc.getSelectedItem();
			String idMonHoc = chuoiTenMonHoc.substring(chuoiTenMonHoc.lastIndexOf("(") + 1,
					chuoiTenMonHoc.lastIndexOf(")"));
			TruyCapDanhSachSinhVien.danhSachSinhVien.themDiemChoMonHoc(idMonHoc, text_diem.getText());
			sinhVienCanTim();
		} else {
			hienThiThongTinMonHoc.append(" \t\t[Them sinh vien va chon mon hoc]" + "\n");
		}
		giaoDienChinh.capNhatGiaoDien();
	}
}
