package Model;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Control.ActionDijkstra;
import Control.ActionPanelPrevious;
import View.Frame;

/**
 * Nơi hiển thị ra kết quả của các chức năng chính. Khi người dùng muốn thực
 * hiện chức năng khác thì bấm nút trở vể sẽ về PanelWork.
 *
 */
public class PanelView extends JPanel {
	private Frame frame;
	private PanelDraw panelDraw;
	private JPanel panelView;
	private JButton btnDijkstra;

	private JSpinner from;
	private JSpinner to;
	private JPanel panel;

	private JPanel panelFunction3;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private String text;

	/**
	 * @param frame
	 */
	public PanelView(Frame frame) {
		this.frame = frame;
		addElement();
	}

	private void addElement() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		this.setBackground(new Color(83, 83, 81));

		panelView = new JPanel();
		panelView.setBounds(10, 11, 777, 360);
		panelView.setLayout(null);
		panel = new JPanel();
		panel.setLayout(new CardLayout());
		panel.setBounds(10, 0, 757, 32);
		panelView.add(panel);

		this.add(panelView);

		panelDraw = new PanelDraw(frame);
		panelDraw.setBounds(0, 32, 777, 328);
		panelView.add(panelDraw);

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(219, 394, 367, 70);
		btnPrevious.setFocusable(false);
		ActionPanelPrevious panelPrevious = new ActionPanelPrevious(frame);
		btnPrevious.addActionListener(panelPrevious);
		this.add(btnPrevious);

		scrollPane = new JScrollPane();
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	public JPanel panelFunction3() {
		JPanel wholePanel = new JPanel();
		JPanel partPanel = new JPanel();

		SpinnerModel modelFrom = new SpinnerNumberModel(1, 1, frame.getTop(), 1);
		SpinnerModel modelTo = new SpinnerNumberModel(1, 1, frame.getTop(), 1);
		from = new JSpinner(modelFrom);
		to = new JSpinner(modelTo);

		JLabel label1 = new JLabel("Từ đỉnh: ");
		JLabel label2 = new JLabel("Đến đỉnh: ");
		ActionDijkstra ac = new ActionDijkstra(frame);

		btnDijkstra = new JButton("Dijkstra");
		JPanel btnPanel = new JPanel();
		btnPanel.setFocusable(false);
		btnDijkstra.addActionListener(ac);
		partPanel.setLayout(new GridLayout(1, 4));
		partPanel.add(label1);
		partPanel.add(from);
		partPanel.add(label2);
		partPanel.add(to);
		btnPanel.add(btnDijkstra);
		partPanel.add(btnDijkstra);

		wholePanel.add(partPanel);

		return wholePanel;
	}

	public void printRoadMatrix(int[][] arr, boolean checkDirect) {
		// TODO Auto-generated method stub
		panelDraw.setMatrix(arr, checkDirect);
	}

	public void setRoadEuler(List<Integer> road, int checkEuler) {
		// TODO Auto-generated method stub
		text = "Not an Euler graph";
		if (checkEuler == 0) {
			text = "Semi-Euler graph with path: ";
		} else if (checkEuler == 1) {
			text = "Euler graph with path: ";
		}
		for (int i = 0; i < road.size(); i++) {
			text += (road.get(i) + 1) + (i == road.size() - 1 ? "" : " -> ");
		}
	}

	// lấy ra đường đi giữa 2 đỉnh theo thuật toán dijkstra
	public String dijkstra() {
		int s = (int) from.getValue();
		int t = (int) to.getValue();
		List<Integer> list = frame.dijkstra(s - 1, t - 1);

		String result = "Shorrtest path from " + s + " to " + t + " is: ";

		if (s != t && list.size() == 1) {
			result += "Trackless";
			return result;
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			if (i == 0) {
				result += list.get(i);
			} else {
				result += list.get(i) + "->";
			}
		}

		return result;
	}

	// in ra đường đi và hiện lên JOptionPane
	public void printDijkstra() {
		String result = dijkstra();
		JOptionPane.showMessageDialog(frame, result);
	}

	public JPanel getPanelView() {
		return panelView;
	}

	public JButton getBtnDijkstra() {
		return btnDijkstra;
	}

	public JSpinner getFrom() {
		return from;
	}

	public JSpinner getTo() {
		return to;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(String string) {
		// TODO Auto-generated method stub
		panel.removeAll();
		if (string.equals("1")) {

		} else if (string.equals("2")) {

		} else if (string.equals("3")) {
			panel.add(panelFunction3);
		} else {
			textArea.setText(text);
			textArea.setEditable(false);
			panel.add(scrollPane);
		}
	}

	public void createPanelFunction3() {
		// TODO Auto-generated method stub
		panelFunction3 = panelFunction3();
	}
}
