package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Control.ActionFunction1;
import Control.ActionFunction2;
import Control.ActionFunction3;
import Control.ActionFunction4;
import Control.ActionPanelNext;
import View.Frame;

/**
 * Nơi in ra các ma trận đã chuyển và cho phép thực hiện các chức năng hiện có.
 *
 */
public class PanelWork extends JPanel {
	private Frame frame;

	// Mảng các text area để không cần phải làm từng phần tử
	private JTextArea[] textAreas = new JTextArea[3];

	// Mảng các jpanel để không cần phải làm từng phần tử
	private JPanel[] panels = new JPanel[3];

	// Mảng các scroll để không cần phải làm từng phần tử
	private JScrollPane[] scrollPanes = new JScrollPane[3];

	// Mảng các button để không cần phải làm từng phần tử
	private JButton[] btnFunctions = new JButton[4];

	private ActionFunction1 actionFunction1;
	private ActionFunction2 actionFunction2;
	private ActionFunction3 actionFunction3;
	private ActionFunction4 actionFunction4;
	// Mảng các action để không cần phải làm từng phần tử
	private ActionListener[] actionFunctions = { actionFunction1, actionFunction2, actionFunction3, actionFunction4 };

	private String[] namePanels = { "normal - A", "nonnegative - B", "nonnegative nondirected - C" };

	/**
	 * @param frame
	 */
	public PanelWork(Frame frame) {
		this.frame = frame;
		addElements();
	}

	private void addElements() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		this.setBackground(new Color(83, 83, 81));

		// Căn đều các thành phần hiển thị
		int widthCardPanel = 258;

		// Không thể sử dụng foreach vì có vẻ như những cái cũ chưa hỗ trợ
		for (int i = 0; i < textAreas.length; i++) {
			textAreas[i] = new JTextArea();
			textAreas[i].setEditable(false);
			textAreas[i].setFont(new Font("Times New Roman", Font.PLAIN, 25));
		}

		for (int i = 0; i < scrollPanes.length; i++) {
			scrollPanes[i] = new JScrollPane();
			scrollPanes[i].setViewportView(textAreas[i]);
		}

		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			panels[i].setBorder(
					new TitledBorder(null, namePanels[i], TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panels[i].setLayout(null);
			panels[i].add(scrollPanes[i]);
			this.add(panels[i]);
		}

		panels[0].setBounds(10, 11, widthCardPanel, 274);
		scrollPanes[0].setBounds(10, 22, 241, 241);

		panels[1].setBounds(269, 11, widthCardPanel, 274);
		scrollPanes[1].setBounds(10, 22, 241, 241);

		panels[2].setBounds(528, 11, widthCardPanel, 274);
		scrollPanes[2].setBounds(10, 22, 241, 241);

		JPanel panelFunctions = panelFunctions();
		this.add(panelFunctions);
	}

	/**
	 * Để riêng để dễ kiểm soát
	 * 
	 * @return JPanel
	 */
	private JPanel panelFunctions() {
		JPanel panelFunctions = new JPanel();
		panelFunctions.setBounds(10, 296, 775, 168);
		panelFunctions.setBackground(new Color(83, 83, 81));
		panelFunctions.setLayout(new GridLayout(2, 2, 10, 10));

		createActionFunctions();

		ActionPanelNext panelNext = new ActionPanelNext(frame);

		String[] name = { "Properties of A and C are enough graph", "Check Prim for C", "Dijkstra for A",
				"Euler for C" };
		for (int i = 0; i < btnFunctions.length; i++) {
			btnFunctions[i] = new JButton(name[i]);
			btnFunctions[i].setForeground(new Color(255, 255, 255));
			btnFunctions[i].setBackground(new Color(255, 128, 128));
			btnFunctions[i].setFocusable(false);
			btnFunctions[i].addActionListener(actionFunctions[i]);
			btnFunctions[i].addActionListener(panelNext);
			panelFunctions.add(btnFunctions[i]);
		}
		return panelFunctions;
	}

	/**
	 * Khoi tao cac chuc nang chinh
	 */
	private void createActionFunctions() {
		// TODO Auto-generated method stub
		actionFunctions[0] = new ActionFunction1(frame);
		actionFunctions[1] = new ActionFunction2(frame);
		actionFunctions[2] = new ActionFunction3(frame);
		actionFunctions[3] = new ActionFunction4(frame);
	}

	/**
	 * Hiển thị các ma trận tương ứng ra màn hình
	 * 
	 * @param location
	 * @param strMatrix
	 */
	public void showMatrix(int location, String strMatrix) {
		// TODO Auto-generated method stub
		textAreas[location].setText(strMatrix);
	}

	public JButton getBtnFunction3() {
		return btnFunctions[2];
	}

}
