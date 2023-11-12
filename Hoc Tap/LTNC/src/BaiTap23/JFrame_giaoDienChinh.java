package BaiTap23;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class JFrame_giaoDienChinh extends JFrame {
	private panel_giaoDienDiem giaoDienDiem;
	private panel_giaoDienMonHoc giaoDienMonHoc;
	private JPanel chuaThanhPhanLamViec;
	private JLabel label_thongBao;

	public JFrame_giaoDienChinh() {
		themPhanTu();
		tuyChinhHienThi();
	}

	/*
	 * Them cac phan tu vao cua so
	 */
	public void themPhanTu() {
		// Them menu bar
		JMenuBar menuBar = new JMenuBar();
		//Menu file
		JMenu menu_file = new JMenu("File");
		JMenuItem item_exit = new JMenuItem("Exit", KeyEvent.VK_E);
		HanhDongThoatChuongTrinh thoatChuongTrinh = new HanhDongThoatChuongTrinh(this);
		item_exit.addActionListener(thoatChuongTrinh);
		menu_file.add(item_exit);
		//Menu quan ly sinh vien
		JMenu menu_quanLySinhVien = new JMenu("Quan ly sinh vien");
		JMenuItem item_quanLyMonHoc = new JMenuItem("Quan Ly Mon Hoc", KeyEvent.VK_M);
		HanhDongHienThiGiaoDienMonHoc hienThiGiaoDienMonHoc = new HanhDongHienThiGiaoDienMonHoc(this);
		item_quanLyMonHoc.addActionListener(hienThiGiaoDienMonHoc);
		JMenuItem item_quanLyDiem = new JMenuItem("Quan Ly Diem", KeyEvent.VK_D);
		HanhDongHienThiGiaoDienDiem hienThiGiaoDienDiem = new HanhDongHienThiGiaoDienDiem(this);
		item_quanLyDiem.addActionListener(hienThiGiaoDienDiem);
		menu_quanLySinhVien.add(item_quanLyDiem);
		menu_quanLySinhVien.add(item_quanLyMonHoc);
		menuBar.add(menu_file);
		menuBar.add(menu_quanLySinhVien);

		//Noi Lam viec
		chuaThanhPhanLamViec = new JPanel();
		chuaThanhPhanLamViec.setLayout(new BorderLayout());
		label_thongBao = new JLabel("Quan ly khoa CNTT", JLabel.CENTER);
		label_thongBao.setVisible(true);
		Font font = new Font("Times New Roman", Font.PLAIN, 50);
		label_thongBao.setFont(font);
		giaoDienDiem = new panel_giaoDienDiem(this);
		giaoDienMonHoc = new panel_giaoDienMonHoc(this);
		chuaThanhPhanLamViec.add(label_thongBao);
		
		// Them phan tu vao cua so
		this.setJMenuBar(menuBar);
		this.add(chuaThanhPhanLamViec);
	}

	/*
	 * Tuy chinh giao dien chinh
	 */
	public void tuyChinhHienThi() {
		setTitle("Chuong trinh quan ly sinh vien khoa cong nghe thong tin");
		setSize(800, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/*
	 * Chuyen sang giao dien diem
	 */
	public void chuyenSangGiaoDienDiem() {
		chuaThanhPhanLamViec.add(giaoDienDiem);
		label_thongBao.setVisible(false);
		giaoDienDiem.setVisible(true);
		giaoDienMonHoc.setVisible(false);
		capNhatGiaoDien();
	}
	
	/*
	 * Cap nhat lai giao dien
	 */
	public void capNhatGiaoDien() {
		this.revalidate();
	}
	
	/*
	 * Chuyen sang giao dien mon hoc
	 */
	public void chuyenSangGiaoDienMonHoc() {
		chuaThanhPhanLamViec.add(giaoDienMonHoc);
		label_thongBao.setVisible(false);
		giaoDienDiem.setVisible(false);
		giaoDienMonHoc.setVisible(true);
		capNhatGiaoDien();
	}
}
