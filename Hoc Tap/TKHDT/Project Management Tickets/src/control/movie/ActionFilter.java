package control.movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import view.general.staff.movie.Form_Movie;
import view.general.staff.movie.IDataNameCombox;

public class ActionFilter implements ActionListener {
	private Form_Movie root;
	private String[] strs;

	public ActionFilter(Form_Movie root) {
		strs = new String[IDataNameCombox.COUNT];
		this.root = root;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox<String> comBox = (JComboBox<String>) e.getSource();
		String type = comBox.getSelectedItem() + "";
		String name = comBox.getName();
		if (name.equals(IDataNameCombox.TYPE)) {
			strs[0] = type;
		} else if (name.equals(IDataNameCombox.AUTHOR)) {
			strs[1] = type;
		}
		root.filterMovie(strs);
	}

}
