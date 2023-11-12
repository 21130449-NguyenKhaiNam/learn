package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MatrixProcessing;
import View.Frame;

public class ActionFunction1 implements ActionListener {
	private Frame frame;

	/**
	 * @param frame
	 */
	public ActionFunction1(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MatrixProcessing mp = this.frame.getMp();
		this.frame.setPanelView("1");
		int[][] matrixA = mp.getMatrix();
		int[][] matrixC = mp.getMatrixNonNegativeAndUndirected();
		int[][] arrA = new int[matrixA.length][matrixA.length];
		int[][] arrC = new int[matrixA.length][matrixA.length];
		mp.coppyMatrix(matrixA, arrA);
		mp.coppyMatrix(matrixC, arrC);
		String strA = "";
		boolean checkDirect = mp.checkDirectAlgorithm(arrA);
		strA += "A is the graph: " + (checkDirect ? "Directed" : "Undirected") + "\n";
		strA += "The number of vertices of graph A is: " + arrA.length + "\n";
		strA += "The number of edges of graph A is: " + mp.numberOfEdge(arrA) + "\n";
		if (checkDirect) {
			strA += mp.countDegInDegOut(arrA);
		} else {
			strA += mp.countDeg(arrA);
		}

		String strC = "";
		strC += mp.checkCompleteGraph(arrC);

		this.frame.showNatureA(strA, arrA);
		this.frame.showNatureC(strC, arrC);
	}

}
