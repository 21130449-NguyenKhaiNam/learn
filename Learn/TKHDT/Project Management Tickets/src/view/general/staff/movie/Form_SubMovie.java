package view.general.staff.movie;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * Giao diện chính của phần chọn phim
 */
public class Form_SubMovie extends JPanel {
	private Form_Movie root;
	private Form_SubMovie_Center center;
	private Form_SubMovie_Head head;

	public Form_SubMovie(Form_Movie root) {
		this.root = root;
		init();
		initComponents();
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		head = new Form_SubMovie_Head(root);

		center = new Form_SubMovie_Center(root);

		setLayout(new BorderLayout());
		add(head, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
	}

	public void filterMovie(String... type) {
		// TODO Auto-generated method stub
		center.filterMovie(type);
	}

}
