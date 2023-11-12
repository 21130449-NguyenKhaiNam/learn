package Control;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import View.Frame;

public class ActionOpenFile implements ActionListener, DropTargetListener {
	private Frame frame;

	/**
	 * @param frame
	 */
	public ActionOpenFile(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Truyền vào thư mục đang sử dụng để truy cập nhanh hơn
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

		fileChooser.setDialogTitle("Open File");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));

		// Tạo hộp thư mục lựa chọn
		int x = fileChooser.showOpenDialog(frame);

		// Kiểm tra xem có cho phép khởi tạo
		if (x == JFileChooser.APPROVE_OPTION) {
			// File đã lựa chọn
			File f = fileChooser.getSelectedFile();

			// Cập nhật đường dẫn để người dùng có thể thấy và tùy chỉnh
			frame.setPathFile(f.getAbsolutePath());
		}
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drop(DropTargetDropEvent event) {
		// TODO Auto-generated method stub
		// Có cho phép kéo thả
		event.acceptDrop(DnDConstants.ACTION_COPY);
		
		// Get the transfer which can provide the dropped item data
		Transferable transferable = event.getTransferable();

		// Get the data formats of the dropped item
		DataFlavor[] flavors = transferable.getTransferDataFlavors();

		// Loop through the flavors
		for (DataFlavor flavor : flavors) {

			try {
				// If the drop items are files
				if (flavor.isFlavorJavaFileListType()) {

					// Get all of the dropped files
					List<File> files = (List) transferable.getTransferData(flavor);
					// Loop them through
					for (File file : files) {
						String path = file.getPath();
						String extension = path.substring(path.lastIndexOf('.') + 1);
						if (extension.equals("txt")) {
							this.frame.setPathFile(file.getAbsolutePath());
							return;
						}
					}
				}

			} catch (Exception e) {

				// Print out the error stack
				e.printStackTrace();

			}
		}

		// Inform that the drop is complete
		event.dropComplete(true);
	}

}
