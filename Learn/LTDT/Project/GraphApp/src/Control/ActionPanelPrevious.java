package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Frame;

public class ActionPanelPrevious implements ActionListener {
	private Frame frame;

	/**
	 * @param frame
	 */
	public ActionPanelPrevious(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.previousPanel();
	}

}
