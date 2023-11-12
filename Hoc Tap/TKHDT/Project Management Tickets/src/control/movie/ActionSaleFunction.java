package control.movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.dialog.EmptyDialog;
import view.general.staff.sale.Form_Sale;

public class ActionSaleFunction implements ActionListener {
	private Form_Sale main;

	public ActionSaleFunction(Form_Sale main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Lấy nội dung bút bấm
		String text = ((JButton) e.getSource()).getText().toLowerCase();

		// Hiện tại đang ở giao diện nào
		int locationLayout = main.getLocationLayout();

		// Nếu nhấn quay lại thì quay lại
		if (text.equals("previous")) {
			main.previous();
		} else if (text.equals("next")) {
			// Nếu là vị trí cuối cùng thì phần giao diện cuối sẽ khóa không cho chỉnh sửa
			// ghế đã chọn và chốt lại hóa đơn
			if (locationLayout == main.getCountLayout()) {
				main.getCinema().clockChairs();
				main.getTicket().setTicket();
			}

			// Tại giao diện chọn ghế đã chọn ghế nào chưa
			if (locationLayout == main.getCountLayout() - 1) {
				if (main.getCinema().isChooseChair()) {
					main.getCinema().updateTicket();
					main.next();
				} else {
					EmptyDialog.show("Please choose chairs");
				}
			} else {
				main.next();
			}
		}
	}
}
