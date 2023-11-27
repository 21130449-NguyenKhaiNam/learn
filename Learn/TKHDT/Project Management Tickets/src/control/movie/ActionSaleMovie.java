package control.movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.movie.InfoMovie;
import view.dialog.EmptyDialog;
import view.general.staff.sale.Form_Sale;

public class ActionSaleMovie implements ActionListener {
	private Form_Sale main;
	private InfoMovie info;

	/**
	 * @param info the info to set
	 */
	public void setInfo(InfoMovie info) {
		this.info = info;
	}

	public ActionSaleMovie(Form_Sale main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (info != null) {
			main.getCinema().updateChairs(info);
			main.next();
		} else {
			EmptyDialog.show("Please choose a movie");
		}
	}

	public void setIndexTime(int ind) {
		if (info != null) {
			info.setCurrentTime(ind);
		}
	}

}
