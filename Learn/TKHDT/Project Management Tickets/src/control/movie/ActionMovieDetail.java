package control.movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.general.staff.movie.Form_Movie_SubDetail;

public class ActionMovieDetail implements ActionListener {
	private Form_Movie_SubDetail main;

	public ActionMovieDetail(Form_Movie_SubDetail main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		main.changeViewDetail(btn.getText().toLowerCase());
	}

}
