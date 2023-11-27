package View;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Model.MatrixProcessing;
import Model.PanelInput;
import Model.PanelView;
import Model.PanelWork;

/**
 * Muốn mở rộng: Thay đổi tên lưu các file cuối, cho phép tạo ma trận bằng giao
 * diện, cập nhật giao diện, các chức năng mở rộng
 * 
 * @author PC
 *
 */
public class Frame extends JFrame {
	// Thông số chương trình
	public static final int SCREEN_WIDTH = 813;
	public static final int SCREEN_HEIGHT = 534;

	// Thùng chứa của frame
	Container container;

	// Dùng để chứa layout chuyển tiếp
	private CardLayout card;
	private PanelInput panelInput;
	private PanelWork panelWork;

	private MatrixProcessing mp;
	private PanelView panelView;

	public Frame() {
		init();
		addElements();
	}

	/**
	 * Nơi chỉnh sửa thông số chương trình
	 */
	private void init() {
		// TODO Auto-generated method stub
		this.setResizable(false);
		this.setTitle("Graph Analysis");
		this.setBounds(100, 100, 450, 300);
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\Images\\GraphIcon.png"));
		this.setVisible(true);
	}

	/**
	 * Nơi thêm các phần tử vào chương trình
	 */
	private void addElements() {
		// TODO Auto-generated method stub
		container = this.getContentPane();

		JMenuBar menuBar = new JMenuBar();

		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);
		JMenuItem itemExit = new JMenuItem("Exit");
		itemExit.addActionListener((e) -> System.exit(0));
		itemExit.setMnemonic(KeyEvent.VK_E);
		JMenuItem itemResest = new JMenuItem("Reset");
		itemResest.addActionListener((e) -> {
			card.first(container);
			panelWork = new PanelWork(this);
			panelView = new PanelView(this);
		});
		itemResest.setMnemonic(KeyEvent.VK_R);
		menuFile.add(itemExit);
		menuFile.add(itemResest);

		JMenu menuMore = new JMenu("More");
		menuMore.setMnemonic(KeyEvent.VK_M);
		JMenuItem itemOpenFolder = new JMenuItem("Open folder file matrix");
		itemOpenFolder.setMnemonic(KeyEvent.VK_O);
		itemOpenFolder.addActionListener(e -> {
			String folderPath = "./src/FileTest";
	        File folder = new File(folderPath);
	        
	        try {
	            Desktop.getDesktop().open(folder);
	        } catch (IOException err) {
	            err.printStackTrace();
	        }
		});
		menuMore.add(itemOpenFolder);
		
		menuBar.add(menuFile);
		menuBar.add(menuMore);
		this.setJMenuBar(menuBar);

		card = new CardLayout();
		container.setLayout(card);

		panelInput = new PanelInput(this);
		container.add("1", panelInput);

		panelWork = new PanelWork(this);
		container.add("2", panelWork);

		panelView = new PanelView(this);
		container.add("3", panelView);
	}

	public int getTop() {
		return mp.getTop();
	}

	/**
	 * @param mp the mp to set
	 * @throws IOException
	 */
	public void setMp(MatrixProcessing mp) throws IOException {
		this.mp = mp;
		mp.writeFileAndShow();
		this.panelView.createPanelFunction3();
	}

	/**
	 * @return the mp
	 */
	public MatrixProcessing getMp() {
		return mp;
	}

	/**
	 * Giao diện kế tiếp
	 */
	public void nextPanel() {
		// TODO Auto-generated method stub
		card.next(container);
	}

	/**
	 * Giao diện trước đó
	 */
	public void previousPanel() {
		// TODO Auto-generated method stub
		card.previous(container);
	}

	/**
	 * Cập nhật đường dẫn của file để người dùng có thể tùy chỉnh
	 * 
	 * @param pathFile
	 */
	public void setPathFile(String pathFile) {
		panelInput.setPathFile(pathFile);
	}

	/**
	 * Lấy đường dẫn file hiện tại
	 * 
	 * @return
	 */
	public String getPathFile() {
		return panelInput.getPathFile();
	}

	/**
	 * Thông báo option khi găp lỗi về cấu trúc nhập file
	 */
	public void errorStructure() {
		// TODO Auto-generated method stub
		JOptionPane.showInternalMessageDialog(this.container,
				"[ERROR STURCTURE MATRIX] You need to enter the correct matrix format, visit support for more information");
	}

	/**
	 * Kêu panel work hiển thị ra màn hình
	 * 
	 * @param location
	 * @param strMatrix
	 */
	public void showMatrix(int location, String strMatrix) {
		// TODO Auto-generated method stub
		panelWork.showMatrix(location, strMatrix);
	}

	public void printRoadEuler(List<Integer> road, int checkEuler, int[][] arr) {
		// TODO Auto-generated method stub
		this.panelView.setRoadEuler(road, checkEuler);
	}

	public void drawGraph(int[][] arr) {
		this.panelView.printRoadMatrix(arr, mp.checkDirectAlgorithm(arr));
	}

	/**
	 * Lỗi về file
	 */
	public void errorFile() {
		// TODO Auto-generated method stub
		JOptionPane.showInternalMessageDialog(this.container,
				"[ERROR PATH FILE] You need to enter the correct file format, visit support for more information");
	}

	// thuật toán dijkstra
	public List<Integer> dijkstra(int s, int t) {
		return mp.dijkstra(s, t);
	}

	// in đường đi giữa 2 đỉnh theo thuật toán dijkstra
	public void printDijkstra() {
		if (mp.isNegativeWeight(mp.getMatrix())) {
			JOptionPane.showMessageDialog(this, "Matrix does not match");
			return;
		}
		panelView.printDijkstra();
	}

	public PanelWork getPanelWork() {
		return panelWork;
	}

	public PanelView getPanelView() {
		return panelView;
	}

	public void setPanelView(String string) {
		// TODO Auto-generated method stub
		panelView.setPanel(string);
	}

	public void showPrim(String text) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, text);
	}

	public void showNotCorrect() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Graph don't correct!!!");
	}

	public void showNatureA(String strA, int[][] arrA) {
		// TODO Auto-generated method stub
		this.drawGraph(arrA);
		JOptionPane.showMessageDialog(this, strA);
	}

	public void showNatureC(String strC, int[][] arrC) {
		// TODO Auto-generated method stub
		this.drawGraph(arrC);
		JOptionPane.showMessageDialog(this, strC);
	}

}
