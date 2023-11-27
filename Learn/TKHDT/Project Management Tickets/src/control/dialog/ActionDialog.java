package control.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.dialog.MessageDialog;

/**
 * Các hành động liên quan đến dialog
 */
public class ActionDialog implements ActionListener {
	private MessageDialog dialog;

	/**
	 * @param dialog
	 */
	public ActionDialog(MessageDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dialog.closeMessage();
	}

}
