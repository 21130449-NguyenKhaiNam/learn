package view.general.staff.movie;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import control.movie.ActionFilter;
import model.data.movie.GetMovie;
import model.movie.Author;
import model.movie.InfoMovie;
import view.general.staff.IUpdateMovie;
import view.general.staff.LbImg;

/**
 * Phần đầu của giao diện chọn phim
 */
public class Form_SubMovie_Head extends JPanel implements IUpdateMovie {
	// Cho phép lựa chọn bộ lọc để chỉ hiển thị các bộ phim đó
	private String[] filters = { IDataNameCombox.TYPE, IDataNameCombox.AUTHOR };
	private List<ItemFunctionFilter> listItem;

	private Form_Movie root;

	public Form_SubMovie_Head(Form_Movie root) {
		this.root = root;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		listItem = new ArrayList<>();

		for (String str : filters) {
			listItem.add(new ItemFunctionFilter(str, new String[] {}));
		}

		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		for (ItemFunctionFilter i : listItem) {
			add(i);
		}

		updateMovie(GetMovie.getInfoMovies());
	}

	@Override
	public void updateMovie(List<InfoMovie> movies) {
		// TODO Auto-generated method stub
		List<String> authors = new ArrayList<>();
		List<String> types = new ArrayList<>();

		for (InfoMovie infoMovie : movies) {
			// Lấy ra thông tin các tác giả
			for (Author author : infoMovie.getMovie().getAuthors()) {
				if (!authors.contains(author.getName())) {
					authors.add(author.getName());
				}
			}

			// Lấy ra thông tin thể loại
			String type = infoMovie.getMovie().getType().name();
			if (!types.contains(type)) {
				types.add(type);
			}
		}

		ActionFilter acFilter = new ActionFilter(root);

		List<List<String>> list = Arrays.asList(types, authors);
		for (int i = 0; i < listItem.size(); i++) {
			listItem.get(i).setInfoFilter(list.get(i));
			listItem.get(i).setAction(acFilter);
		}
	}

	@Override
	public void updateClickMovie(LbImg item) {
		// TODO Auto-generated method stub
	}

}
