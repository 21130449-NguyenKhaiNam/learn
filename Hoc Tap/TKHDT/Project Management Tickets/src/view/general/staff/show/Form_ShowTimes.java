package view.general.staff.show;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.data.movie.GetMovie;
import model.movie.InfoMovie;
import model.movie.ShowTime;
import view.dialog.ErrorDialog;
import view.general.staff.IUpdateMovie;
import view.general.staff.LbImg;
import view.general.staff.PanelItem;
import view.scroll.ScrollBar;

public class Form_ShowTimes extends JPanel implements IUpdateMovie {
	private List<InfoMovie> movies;

	public Form_ShowTimes() {
		init();
		initComponents();
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		// Phải để trước để khởi tạo rồi mới sử dụng được
		updateMovie(GetMovie.getInfoMovies());

		Map<ShowTime, List<Integer>> map = new TreeMap<>();

		for (int i = 0; i < movies.size(); ++i) {
			InfoMovie info = movies.get(i);
			for (ShowTime st : info.getShowTimes()) {
				if (!map.containsKey(st))
					map.put(st, new ArrayList<>());
				map.get(st).add(i);
			}
		}
		JPanel panel = new PanelItem();
		panel.setLayout(new GridLayout(0, 1, 10, 10));

		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBar(new ScrollBar());
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(null);
		scroll.setViewportView(panel);

		for (Map.Entry<ShowTime, List<Integer>> entry : map.entrySet()) {
			ShowTime key = entry.getKey();
			List<Integer> val = entry.getValue();
			PanelItemShowTime item = new PanelItemShowTime(key);
			for (Integer i : val) {
				item.add(new LbImg(movies.get(i), 200, 200));
			}
			panel.add(item);
		}

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scroll,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scroll,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

	}

	@Override
	public void updateMovie(List<InfoMovie> movies) {
		// TODO Auto-generated method stub
		this.movies = movies;
	}

	@Override
	public void updateClickMovie(LbImg item) {
		// TODO Auto-generated method stub
		ErrorDialog.show();
	}
}
