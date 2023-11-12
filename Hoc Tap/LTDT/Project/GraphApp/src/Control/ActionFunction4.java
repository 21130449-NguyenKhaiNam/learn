package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import Model.MatrixProcessing;
import View.Frame;

public class ActionFunction4 implements ActionListener {
	private Frame frame;

	/**
	 * @param frame
	 */
	public ActionFunction4(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MatrixProcessing mp = this.frame.getMp();
		int[][] matrix = mp.getMatrixNonNegativeAndUndirected();
		int[][] arr = new int[matrix.length][matrix.length];
		mp.coppyMatrix(matrix, arr);
		int checkEuler = mp.checkEuler(arr);
		List<Integer> road = mp.findRoadEuler(arr, checkEuler);
		this.frame.printRoadEuler(road, checkEuler, matrix);
		this.frame.drawGraph(matrix);
		this.frame.setPanelView("4");
	}

}
