package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import Model.MatrixProcessing;
import View.Frame;

public class ActionFunction3 implements ActionListener {
	private Frame frame;
	private int count = 0;

	/**
	 * @param frame
	 */
	public ActionFunction3(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MatrixProcessing mp = this.frame.getMp();
		int[][] matrix = mp.getMatrix();
		int[][] arr = new int[matrix.length][matrix.length];
		mp.coppyMatrix(matrix, arr);
		frame.drawGraph(arr);
		frame.setPanelView("3");
	}

}
