package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Model.MatrixProcessing;
import View.Frame;

public class ActionPrintFile implements ActionListener {
	private Frame frame;

	/**
	 * @param frame
	 */
	public ActionPrintFile(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Nhận đường dẫn file hiện tại
		String pathFile = frame.getPathFile();
		try {
			BufferedReader read = Files.newBufferedReader(Paths.get(pathFile));
			this.frame.setMp(new MatrixProcessing(read, frame));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			this.frame.errorFile();
			this.frame.previousPanel();
		}
	}

}
