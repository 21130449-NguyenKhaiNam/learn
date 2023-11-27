package BaiTap23;

import javax.swing.*;

import java.awt.*;

public class panel_giaoDienDiem extends JPanel {
	private JFrame_giaoDienChinh giaoDienChinh;
	private JTextArea hienThiThongTinMonHoc;
	private JTextField text_mssv;
	private JTextField text_hoVaTen;
	private String hienThi = "STT \t\t Ten Mon Hoc \t\t\t Diem \n";
	private JTextField text_maMonHoc;
	private JTextField text_tenMonHoc;

	public panel_giaoDienDiem(JFrame_giaoDienChinh giaoDienChinh) {
		this.giaoDienChinh = giaoDienChinh;
		themThanhPhan();
	}

	public void themThanhPhan() {
		// Cac panel chua
		JPanel panel_ThemMonHoc = new JPanel();
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

		// panel them mon hoc
		JLabel label_mssv = new JLabel("MSSV", JLabel.RIGHT);
		text_mssv = new JTextField();
		JLabel label_hoVaTen = new JLabel("Ho va ten", JLabel.RIGHT);
		text_hoVaTen = new JTextField();
		text_hoVaTen.setEditable(false);
		JLabel label_maMonHoc = new JLabel("Ma mon hoc", JLabel.RIGHT);
		text_maMonHoc = new JTextField();
		JLabel label_tenMonHoc = new JLabel("Ten mon hoc", JLabel.RIGHT);
		text_tenMonHoc = new JTextField();
		panel_ThemMonHoc.setLayout(new GridLayout(4, 2));
		panel_ThemMonHoc.add(label_mssv);
		panel_ThemMonHoc.add(text_mssv);
		panel_ThemMonHoc.add(label_hoVaTen);
		panel_ThemMonHoc.add(text_hoVaTen);
		panel_ThemMonHoc.add(label_maMonHoc);
		panel_ThemMonHoc.add(text_maMonHoc);
		panel_ThemMonHoc.add(label_tenMonHoc);
		panel_ThemMonHoc.add(text_tenMonHoc);

		// panel thao tac
		JButton button_themMonHoc = new JButton("Them mon hoc");
		HanhDongThemMonHoc hanhDongThemMonHoc = new HanhDongThemMonHoc(this);
		button_themMonHoc.addActionListener(hanhDongThemMonHoc);
		JButton button_timSinhVien = new JButton("Tim sinh vien");
		HanhDongTimSinhVien hanhDongTimSinhVien = new HanhDongTimSinhVien(this);
		button_timSinhVien.addActionListener(hanhDongTimSinhVien);
		panel_thaoTac.add(button_themMonHoc);
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
	 * Them mon hoc cho sinh vien
	 */
	public void themMonHocChoSinhVien() {
		if (TruyCapDanhSachSinhVien.danhSachSinhVien.timTrongDanhSach(text_mssv.getText())) {
			SinhVien.thietLapSTT();
			hienThiThongTinMonHoc.setText(hienThi);
			hienThiThongTinMonHoc
					.append(TruyCapDanhSachSinhVien.danhSachSinhVien.danhSachMonHocCuaSinhVien(text_mssv.getText())
							+ TruyCapDanhSachSinhVien.danhSachSinhVien.themMonHocChoSinhVien(text_mssv.getText(),
									text_maMonHoc.getText(), text_tenMonHoc.getText()));
		} else {
			hienThiThongTinMonHoc.append(" \t\t[Nhap dung ma so sinh vien de them mon hoc]" + "\n");
		}
		giaoDienChinh.capNhatGiaoDien();
	}
}
