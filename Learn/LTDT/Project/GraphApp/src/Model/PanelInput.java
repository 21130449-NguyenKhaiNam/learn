package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.dnd.DropTarget;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Control.ActionOpenFile;
import Control.ActionPanelNext;
import Control.ActionPrintFile;
import View.Frame;

/**
 * Nơi nhận file input chứa ma trận của đồ thị đơn có hướng, có thể có trọng số
 * âm. Khi nhấn print sẽ chuyển thành 2 file input_nonegative - chứa ma trận
 * không có trọng số âm từ input; và input_nonnegative_nondirected - chứa ma
 * trận chuyển từ có hướng thành vô hướng do input_nonnegative cung cấp.
 */
public class PanelInput extends JPanel {
	private Frame frame;

	private JTextField pathFile;

	/**
	 * @param frame
	 * @throws IOException
	 */
	public PanelInput(Frame frame) {
		this.frame = frame;
		addElements();
	}

	private void addElements() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		this.setBackground(new Color(83, 83, 81));

		JPanel panelInputFile = panelInputFile();
		this.add(panelInputFile);

		JButton btnPrint = new JButton("Print File");
		btnPrint.setForeground(new Color(255, 255, 255));
		btnPrint.setBackground(new Color(255, 128, 128));
		btnPrint.setFont(new Font("Arial", Font.PLAIN, 13));
		btnPrint.setBounds(302, 357, 172, 45);
		btnPrint.setFocusable(false);
		btnPrint.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		ActionPrintFile actionPrintFile = new ActionPrintFile(frame);
		btnPrint.addActionListener(actionPrintFile);
		ActionPanelNext actionPanelNext = new ActionPanelNext(frame);
		btnPrint.addActionListener(actionPanelNext);
		this.add(btnPrint);

		JLabel note = new JLabel("@LTDT Group 12");
		note.setForeground(new Color(255, 255, 255));
		note.setFont(new Font("Arial", Font.PLAIN, 13));
		note.setBounds(10, 431, 777, 33);
		this.add(note);
	}

	/**
	 * Tạo hàm để tránh nhằm
	 * 
	 * @return JPanel
	 */
	private JPanel panelInputFile() {
		JPanel panelInputFile = new JPanel();
		panelInputFile.setBounds(10, 11, 777, 335);
		panelInputFile.setBorder(BorderFactory.createDashedBorder(null, 5, 5));
		panelInputFile.setLayout(null);

		JLabel dropFile = new JLabel();
		dropFile.setHorizontalAlignment(SwingConstants.CENTER);
		dropFile.setBounds(0, 0, 777, 257);
		ImageIcon iconDropFile = new ImageIcon(".\\src\\Images\\DropFile.png");
		dropFile.setIcon(iconDropFile);
		panelInputFile.add(dropFile);

		JLabel labelPathFile = new JLabel("Path File:");
		labelPathFile.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPathFile.setFont(new Font("Arial", Font.PLAIN, 13));
		labelPathFile.setBounds(10, 268, 72, 20);
		panelInputFile.add(labelPathFile);

		pathFile = new JTextField();
		pathFile.setBounds(92, 268, 675, 20);
		panelInputFile.add(pathFile);
		pathFile.setColumns(10);

		JButton btnOpenFile = new JButton("Open File...");
		btnOpenFile.setBounds(670, 299, 97, 23);
		btnOpenFile.setBackground(new Color(225, 225, 225));
		btnOpenFile.setFocusable(false);
		ActionOpenFile actionOpenFile = new ActionOpenFile(frame);
		btnOpenFile.addActionListener(actionOpenFile);
		panelInputFile.add(btnOpenFile);

		new DropTarget(dropFile, actionOpenFile);

		return panelInputFile;
	}

	/**
	 * Cập nhật đường dẫn của file
	 * 
	 * @param pathFile
	 */
	public void setPathFile(String pathFile) {
		// TODO Auto-generated method stub
		this.pathFile.setText(pathFile);
	}

	/**
	 * Lấy đường dẫn của file hiện tại
	 * 
	 * @return
	 */
	public String getPathFile() {
		return this.pathFile.getText();
	}

}
