package BaiTap20;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout extends JFrame{
	public JPanel include;
	/*
	 * Xay dung chuong trinh ve cac hinh co ban
	 * Hinh vuong va hinh tron co mau la do hoac xanh, day hay la rong, no co the resest lai chuong trinh
	 */
	private DrawShape drawShape;
	
	public Layout() {
		addElement();
		setWindow();
	}
	
	
	/*
	 * Chua cac thuoc tinh trong cua so 
	 * Nut resest lam bang cach tao ra cua so moi de len cua so cu 
	 */
	public void addElement() {
		include = new JPanel();
		
		include.setLayout(new BorderLayout());
		
		SixButton sixButton = new SixButton();

		drawShape = new DrawShape();
		
		ResestButton resestButton = new ResestButton(this);
		
		include.add(drawShape, BorderLayout.CENTER);
		
		include.add(sixButton, BorderLayout.NORTH);
		include.add(resestButton, BorderLayout.WEST);
		
		this.add(include);
		
	}	
	
	public void lamMoiVe() {
		this.remove(drawShape);
		drawShape = new DrawShape();
		this.add(drawShape, BorderLayout.CENTER);
		capNhatGiaoDien();
	}
	
	public void capNhatGiaoDien() {
		this.pack();
		setSize(600,600);
	}
	
	public void setWindow() {
		setTitle("Chuong trinh ve hinh");
		setSize(600,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
