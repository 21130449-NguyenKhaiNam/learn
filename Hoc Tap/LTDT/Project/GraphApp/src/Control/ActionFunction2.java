package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MatrixProcessing;
import View.Frame;

public class ActionFunction2 implements ActionListener {
	private Frame frame;

	/**
	 * @param frame
	 */
	public ActionFunction2(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MatrixProcessing mp = this.frame.getMp();
		frame.setPanelView("2");
		int[][] matrix = mp.getMatrix();
		int[][] arr = new int[matrix.length][matrix.length];
		mp.coppyMatrix(matrix, arr);
		frame.drawGraph(arr);
		if (mp.isCorrect()) {
			mp.printMST();
		} else {
			frame.showNotCorrect();
		}
		this.frame.setPanelView("2");
	}

}
