package view.general.staff.movie;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.data.font.IDataFont;
import model.movie.Actor;
import model.movie.Author;
import model.movie.InfoMovie;
import model.movie.Movie;
import view.field.TextArea;
import view.general.staff.LbImg;
import view.scroll.ScrollBar;

/**
 * Giao diện tổng quan về bộ phim
 */
public class Form_Movie_SubDetail_Overview extends JPanel {
	// Các phần tử sẽ được cập nhật khi có bộ phim được chọn
	private JLabel releaseDate;
	private JLabel directedBy;
	private JLabel scriptWriters;
	private JLabel producers;
	private JLabel actors;
	private JLabel language;
	private TextArea txtDetail;

	public Form_Movie_SubDetail_Overview() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		txtDetail = new TextArea();

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(txtDetail);
		scroll.setVerticalScrollBar(new ScrollBar());
		scroll.setHorizontalScrollBar(new ScrollBar());

		JPanel detail = new JPanel();
		detail.setLayout(new GridLayout(0, 1, 2, 2));

		releaseDate = new JLabel();
		releaseDate.setText("Release Date : ");

		directedBy = new JLabel();
		directedBy.setText("Directed By : ");

		scriptWriters = new JLabel();
		scriptWriters.setText("Script Writers : ");

		producers = new JLabel();
		producers.setText("Producers : ");

		actors = new JLabel();
		actors.setText("Actors : ");

		language = new JLabel();
		language.setText("Language : ");

		List<JLabel> list = Arrays.asList(releaseDate, directedBy, scriptWriters, producers, actors, language);

		for (JLabel jLabel : list) {
			jLabel.setFont(IDataFont.NORMAL);
			detail.add(jLabel);
		}

		this.setLayout(new GridLayout(0, 1, 5, 5));
		add(scroll);
		add(detail);
	}

	// Cập nhât thông tin về bộ phim
	public void updateMovie(LbImg item) {
		// TODO Auto-generated method stub
		// Cần tối ưu hơn
		InfoMovie info = (InfoMovie) item.getInfo();
		Movie movie = info.getMovie();
		txtDetail.setText(movie.getDetail());

		releaseDate.setText("Release Date: " + movie.getReleaseDate().toString());

		String authors = "Author: ";
		for (Author author : movie.getAuthors()) {
			authors += author.getName() + ", ";
		}
		authors = authors.substring(0, authors.length() - 2);
		directedBy.setText(authors);

		String scripts = "Script Writers: ";
		for (String str : movie.getSciptWriters()) {
			scripts += str + ", ";
		}
		scripts = scripts.substring(0, scripts.length() - 2);
		scriptWriters.setText(scripts);

		String products = "Prodecers: ";
		for (String str : movie.getProducer()) {
			products += str + ", ";
		}
		products = products.substring(0, products.length() - 2);
		producers.setText(products);

		String strActors = "Actors: ";
		for (Actor actor : movie.getActors()) {
			strActors += actor.getName() + ", ";
		}
		strActors += "...";
		actors.setText(strActors);

		String strLanguage = "Languages: ";
		for (String str : movie.getLanguage()) {
			strLanguage += str + ", ";
		}
		strLanguage = strLanguage.substring(0, strLanguage.length() - 2);
		language.setText(strLanguage);
	}
}
