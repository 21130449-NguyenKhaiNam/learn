package view.general.staff.sale;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import control.mouse.MouseClickItem;
import control.movie.ActionSaleMovie;
import model.data.movie.GetMovie;
import model.function.FunctionImg;
import model.movie.InfoMovie;
import model.movie.Movie;
import model.movie.ShowTime;
import view.button.Button;
import view.general.staff.IUpdateMovie;
import view.general.staff.LbImg;
import view.general.staff.PanelItem;
import view.scroll.ScrollBar;

/**
 * Là phần giao diện chính cho giao diện chọn phim
 */
public class Form_Sale_SubMovie extends JPanel implements IUpdateMovie {
	// Sử dụng để gọi chuyển tiếp hoặc các chức năng không thể làm ở class con
	private Form_Sale root;

	// Chứa các thành phần cơ hiển thị nội dung bộ phim
	private JPanel panel;

	// Các phần thông tin cơ bản hiển thị khi chọn
	private JLabel lbImg;
	private JSeparator separator;
	private JLabel lbItemName;
	private JLabel lbBrand;
	private JLabel lbPrice;
	private JTextPane txtDescription;
	private JScrollPane scroll;
	private JComboBox<String> times;

	// Chứa các item phim
	private PanelItem panelItem;

	// Nhận vào thông tin bộ phim được chọn và truyền cho các view khác
	private ActionSaleMovie acMovie;

	/**
	 * @return the times
	 */
	public JComboBox<String> getTimes() {
		return times;
	}

	public Form_Sale_SubMovie(Form_Sale root) {
		this.root = root;
		init();
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		times = new JComboBox<>();
		scroll = new JScrollPane();
		panelItem = new PanelItem();
		panel = new JPanel();
		lbItemName = new JLabel();
		lbPrice = new JLabel();
		lbBrand = new JLabel();
		separator = new JSeparator();
		txtDescription = new JTextPane();

		scroll.setBorder(null);
		scroll.setVerticalScrollBar(new ScrollBar());
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportView(panelItem);

		panel.setOpaque(false);

		lbItemName.setFont(new Font("sansserif", 1, 18)); // NOI18N
		lbItemName.setForeground(new Color(76, 76, 76));
		lbItemName.setText("Item Name");

		lbPrice.setFont(new Font("sansserif", 1, 18)); // NOI18N
		lbPrice.setForeground(new Color(76, 76, 76));
		lbPrice.setText("$0.00");

		lbBrand.setFont(new Font("sansserif", 1, 12)); // NOI18N
		lbBrand.setForeground(new Color(76, 76, 76));
		lbBrand.setText("Brand");

		txtDescription.setBorder(null);
		txtDescription.setFont(new Font("sansserif", 1, 14)); // NOI18N
		txtDescription.setForeground(new Color(178, 178, 178));
		txtDescription.setFocusable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBar(new ScrollBar());
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(txtDescription);

		Button btn = new Button("Choose");
		acMovie = new ActionSaleMovie(root);
		btn.addActionListener(acMovie);

		lbImg = new JLabel();
		lbImg.setHorizontalAlignment(JLabel.CENTER);

		times.addActionListener(e -> {
			int indTime = times.getSelectedIndex();
			acMovie.setIndexTime(indTime);
		});

		// Định nghĩa cấu trúc cho thông tin khi chọn phim
		GroupLayout panelLayout = new GroupLayout(panel);
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(Alignment.LEADING).addGroup(panelLayout
				.createSequentialGroup().addGap(10)
				.addGroup(panelLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(panelLayout.createSequentialGroup()
								.addGroup(panelLayout.createParallelGroup(Alignment.LEADING).addComponent(lbBrand)
										.addComponent(lbPrice).addComponent(lbImg, GroupLayout.DEFAULT_SIZE, 280, 280))
								.addContainerGap())
						.addGroup(panelLayout.createSequentialGroup().addGroup(panelLayout
								.createParallelGroup(Alignment.TRAILING).addComponent(lbItemName, 280, 280, 280)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 280, 280)
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 280, 280)
								.addComponent(times, 0, 280, 280).addComponent(btn, GroupLayout.DEFAULT_SIZE, 280, 280))
								.addGap(10)))));
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(Alignment.LEADING).addGroup(panelLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(lbImg, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lbItemName)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lbPrice)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lbBrand)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(times, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, 280)));
		panel.setLayout(panelLayout);

		// Định nghĩa cấu trúc toàn phần
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scroll)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		updateMovie(GetMovie.getInfoMovies());
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	// Cập nhật các bộ phim có được từ cơ sở dữ liệu - ban đầu
	public void updateMovie(List<InfoMovie> movies) {
		panelItem.removeAll();
		MouseClickItem click = new MouseClickItem(this);
		for (InfoMovie i : movies) {
			LbImg item = new LbImg(i, 200, 200);
			item.addMouseListener(click);
			panelItem.add(item);
		}
		panelItem.revalidate();
	}

	// Cập nhật thông tin khi phim khi được chọn
	public void updateClickMovie(LbImg item) {
		// TODO Auto-generated method stub
		InfoMovie im = (InfoMovie) item.getInfo();
		Movie movieSelect = im.getMovie();
		lbItemName.setText(movieSelect.getName());
		lbBrand.setText(movieSelect.getType().name());
		DecimalFormat df = new DecimalFormat("$#,##0.00");
		lbPrice.setText(df.format(movieSelect.getPrice()));
		lbImg.setIcon(FunctionImg.scaleImg(movieSelect.getImg(), 280, 264));
		txtDescription.setText(movieSelect.getDescription());
		times.removeAllItems();
		for (ShowTime st : im.getShowTimes()) {
			String time = st.getTime();
			times.addItem(time);
		}
		acMovie.setInfo(im);
	}

}
