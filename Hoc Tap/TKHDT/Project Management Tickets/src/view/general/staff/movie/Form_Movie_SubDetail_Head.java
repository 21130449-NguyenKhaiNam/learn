package view.general.staff.movie;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import control.movie.ActionMovieDetail;
import control.movie.ActionMoviePrev;
import model.data.font.IDataFont;
import model.data.img.GetImage;
import model.function.FunctionImg;
import model.movie.InfoMovie;
import model.movie.Movie;
import view.button.Button;
import view.general.staff.LbImg;

/**
 * Giao diện nằm ở đầu cho phần chi tiết về một bộ phim
 */
public class Form_Movie_SubDetail_Head extends JPanel {
	// Các thông tin cần cập nhật khi chọn bộ phim
	private JLabel img;
	private JLabel name;
	private JLabel shortDes;

	private Form_Movie_SubDetail main;

	public Form_Movie_SubDetail_Head(Form_Movie_SubDetail main) {
		this.main = main;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		Button btnBack = new Button("Back");
		ActionMoviePrev acPrev = new ActionMoviePrev(main);
		btnBack.addActionListener(acPrev);

		JPanel shortDetail = new JPanel();

		ActionMovieDetail acChangeView = new ActionMovieDetail(main);

		img = new JLabel();
		setInfoImg(GetImage.getImgError(0));

		JPanel title = new JPanel();

		name = new JLabel();
		name.setText("Name movie");
		name.setFont(IDataFont.HEADING);

		shortDes = new JLabel();
		shortDes.setText("Short Description");
		shortDes.setFont(IDataFont.MIN_TITLE);

		title.setLayout(new GridLayout(0, 1));
		title.add(name);
		title.add(shortDes);

		shortDetail.setLayout(new BorderLayout(5, 5));
		shortDetail.add(img, BorderLayout.WEST);
		shortDetail.add(title, BorderLayout.CENTER);

		JPanel function = new JPanel();

		Button btnOverview = new Button("Overview");
		btnOverview.addActionListener(acChangeView);

		Button btnShowTimes = new Button("Showtimes");
		btnShowTimes.addActionListener(acChangeView);

		function.setLayout(new GridLayout(1, 0));

		function.add(btnOverview);
		function.add(btnShowTimes);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(shortDetail, GroupLayout.PREFERRED_SIZE, 578, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(function, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
				.addComponent(shortDetail, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
				.addComponent(function, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE));
	}

	// Cập nhật thông tin khi được yêu cầu
	public void updateMovie(LbImg item) {
		// TODO Auto-generated method stub
		InfoMovie info = (InfoMovie) item.getInfo();
		Movie movie = info.getMovie();
		setInfoImg(movie.getImg());
		name.setText(movie.getName());
		shortDes.setText(movie.getReleaseDate().toString());
	}

	// Định nghĩa phương thức cập nhật ảnh chung để không phải khai báo nhiều
	public void setInfoImg(Image image) {
		img.setIcon(FunctionImg.scaleImg(image, 125, 119));
	}
}
