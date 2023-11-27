package view.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import control.dialog.ActionDialog;
import model.data.img.GetImage;
import model.data.size.EnumSize;
import model.data.size.IScreenWindow;
import model.function.FunctionImg;
import view.button.Button;
import view.main.App;

/**
 * Dialog thông báo trên màn hình
 */
public class MessageDialog extends JDialog {
	// Logo
	private JLabel lbIcon;

	// Tiêu đề
	private JLabel lbTitle;

	// Nội dung
	private JTextPane txt;

	public MessageDialog(App app) {
		// Phải để như vậy để nó tự lấy lớp frame mặc định
		super(app, true);
		initComponents();
		init();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		BackgroundDialog background = new BackgroundDialog();

		ActionDialog acDialog = new ActionDialog(this);

		Button btnCancel = new Button("Cancel");
		btnCancel.addActionListener(acDialog);

		lbIcon = new JLabel();
		lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
		setLogo(GetImage.getImgError(0));

		lbTitle = new JLabel();
		lbTitle.setFont(new Font("sansserif", 1, 18));
		lbTitle.setForeground(new Color(245, 71, 71));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setText("Message Title");

		txt = new JTextPane();
		txt.setEditable(false);
		txt.setFont(new Font("sansserif", 0, 14));
		txt.setForeground(new Color(76, 76, 76));
		txt.setText("Message Text\nSimple");
		txt.setOpaque(false);
		StyledDocument doc = txt.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		txt.setBackground(new Color(0, 0, 0, 0));
		txt.setFocusable(false);

		// Cấu trúc cửa sổ thông báo
		GroupLayout groupLayout = new GroupLayout(background);
		background.setLayout(groupLayout);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 195,
						Short.MAX_VALUE))
				.addComponent(lbIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lbTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(txt));

		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGap(20, 20, 20).addComponent(lbTitle)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txt, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))));

		// Thêm vào panel chính
		GroupLayout layout = new GroupLayout(getContentPane());
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(background,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

	}

	private void init() {
		// TODO Auto-generated method stub
		setSize(EnumSize.WidthDialog.size, EnumSize.HeightDialog.size);
		setUndecorated(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	// Hiển thị thông báo với nội dung tùy chỉnh
	public void showMessage(String title, String message) {
		lbTitle.setText(title);
		txt.setText(message);
		setLocation((IScreenWindow.SCREEN_WIDTH - getWidth()) / 2, (IScreenWindow.SCREEN_HEIGHT - getHeight()) / 2);
		setVisible(true);
	}

	// Kết thúc thông báo
	public void closeMessage() {
		dispose();
	}

	// Thiết lập lại logo thông báo
	public void setLogo(Image img) {
		lbIcon.setIcon(FunctionImg.scaleImg(img, 50, 50));
	}

}
