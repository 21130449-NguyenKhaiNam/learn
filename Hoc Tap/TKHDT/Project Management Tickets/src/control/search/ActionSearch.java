package control.search;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.movie.InfoMovie;
import view.general.main.PanelHeader;

public class ActionSearch implements KeyListener, ListSelectionListener {
	private PanelHeader search;

	public ActionSearch(PanelHeader search) {
		super();
		this.search = search;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		search.getSearchText().grabFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		search.getSearchText().grabFocus();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		String text = search.getSearchText().getText().trim();
		if (!text.equals("")) {
			search.getSearchDropDown().getMod().removeAllElements();

			for (InfoMovie item : search.listFilm()) {
				text = text.toLowerCase();
				String filmName = item.getMovie().getName().toLowerCase();

				if (filmName.startsWith(text)) {
					search.getSearchDropDown().getMod().addElement(item.getMovie().getName());
				}
			}
			search.getSearchText().grabFocus();
			search.getSearchDropDown().show(search.getSearchText(), 0, search.getSearchText().getHeight());
		} else {
			search.getSearchDropDown().setVisible(false);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (search.getStringFilm() != null) {
			search.notifyAllList(search.getFilm());
		}
		search.getSearchText().grabFocus();
	}

}
