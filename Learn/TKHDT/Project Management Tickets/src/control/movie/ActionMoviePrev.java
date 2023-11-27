package control.movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.general.staff.movie.Form_Movie_SubDetail;

public class ActionMoviePrev implements ActionListener {
	private Form_Movie_SubDetail main;
	
	public ActionMoviePrev(Form_Movie_SubDetail main) {
		// TODO Auto-generated constructor stub
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		main.previousMovie("movie");
	}

}
