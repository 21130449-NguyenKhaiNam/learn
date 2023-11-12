package view.general.staff.movie;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import control.mouse.MouseClickItem;
import control.observer.Observer;
import control.observer.Subject;
import model.data.movie.GetMovie;
import model.movie.Author;
import model.movie.InfoMovie;
import view.general.staff.IUpdateMovie;
import view.general.staff.LbImg;
import view.general.staff.PanelItem;
import view.scroll.ScrollBar;

/**
 * Phần chính của giao diện chọn phim
 */
public class Form_SubMovie_Center extends JPanel implements IUpdateMovie {
	private Form_Movie main;

	private PanelItem panelItem;

	// Danh sách các phim
	private List<InfoMovie> movies;

	public Form_SubMovie_Center(Form_Movie main) {
		this.main = main;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		panelItem = new PanelItem();

		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setVerticalScrollBar(new ScrollBar());
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportView(panelItem);

		setLayout(new CardLayout());

		add(scroll);

		updateMovie(GetMovie.getInfoMovies());
	}

	@Override
	public void updateMovie(List<InfoMovie> movies) {
		// TODO Auto-generated method stub
		panelItem.removeAll();
		MouseClickItem click = new MouseClickItem(this);
		for (InfoMovie i : movies) {
			LbImg item = new LbImg(i, 200, 200);
			item.addMouseListener(click);
			panelItem.add(item);
		}
		panelItem.revalidate();
		panelItem.repaint();
		if (this.movies == null)
			this.movies = movies;
	}

	@Override
	public void updateClickMovie(LbImg item) {
		// TODO Auto-generated method stub
		main.updateForDetail(item);
	}

	public void filterMovie(String... type) {
		// TODO Auto-generated method stub
		List<InfoMovie> re = new ArrayList<>();

		for (int i = 0; i < type.length; i++) {
			boolean check = type[i] != null && !type[i].isBlank();
			if (i == 0) {
				if (check) {
					for (InfoMovie infoMovie : movies) {
						if (infoMovie.getMovie().getType().name().equals(type[i]))
							re.add(infoMovie);
					}
				} else {
					re.addAll(movies);
				}

			}

			if (i == 1 && check) {
				int j = 0;
				while (j < re.size()) {
					InfoMovie infoMovie = re.get(j);
					List<Author> authors = infoMovie.getMovie().getAuthors();
					boolean flag = false;
					for (Author au : authors) {
						String name = au.getName();
						if (name.equals(type[i])) {
							flag = true;
							break;
						}
					}
					if (flag) {
						++j;
					} else {
						re.remove(j);
					}
				}
			}
		}
		updateMovie(re);
	}

}
