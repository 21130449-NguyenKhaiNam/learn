package view.general.staff.sale;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import control.movie.ActionSaleFunction;
import control.observer.Observer;
import control.observer.Subject;
import view.button.Button;

/**
 * Giao diện chứa chức năng về cho các lớp ở trong sale
 */
public class Form_Sale_Function extends JPanel {
	private Form_Sale parent;

	public Form_Sale_Function(Form_Sale parent) {
		this.parent = parent;
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		ActionSaleFunction acSale = new ActionSaleFunction(parent);

		Button btnPrev = new Button("Previous");
		btnPrev.addActionListener(acSale);

		Button btnNext = new Button("Next");
		btnNext.addActionListener(acSale);

		this.setLayout(new GridLayout(1, 0, 10, 10));

		this.add(btnPrev);
		this.add(btnNext);
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

}
