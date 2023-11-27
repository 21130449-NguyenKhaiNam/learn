package view.general.staff.sale;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * Phần đầu của giao diện chọn ghế
 */
public class Form_Sale_SubCinema_Head extends JPanel {
	private SpinnerNumberModel modelFrom;

	public Form_Sale_SubCinema_Head() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		// Hiện tại có giảm giá nếu là sinh viên
		JPanel panelStudent = new JPanel();

		JLabel lbCountStudent = new JLabel();
		lbCountStudent.setText("Student: ");
		lbCountStudent.setHorizontalAlignment(JLabel.LEFT);

		modelFrom = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		JSpinner spinner = new JSpinner(modelFrom);

		panelStudent.setLayout(new BorderLayout(5, 5));
		panelStudent.add(lbCountStudent, BorderLayout.WEST);
		panelStudent.add(spinner, BorderLayout.CENTER);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		this.add(panelStudent);
	}

	public int getNumSudent() {
		// TODO Auto-generated method stub
		return (int) modelFrom.getValue();
	}

}
