package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Frame;

public class ActionPanelNext implements ActionListener {
	private Frame frame;

	/**
	 * @param frame
	 */
	public ActionPanelNext(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.nextPanel();
	}

}
