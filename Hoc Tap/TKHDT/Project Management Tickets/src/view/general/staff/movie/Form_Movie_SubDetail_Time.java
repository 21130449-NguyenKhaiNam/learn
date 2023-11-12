package view.general.staff.movie;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.JPanel;

import model.info.Date;
import model.movie.InfoMovie;
import model.movie.ShowTime;
import view.general.staff.LbImg;

/**
 * Giao diện về thời gian của một bộ phim
 */
public class Form_Movie_SubDetail_Time extends JPanel {
	private List<CardTime> list;

	public Form_Movie_SubDetail_Time() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(0, 4, 20, 20));

		CardTime timeMon = new CardTime("Monday");
		CardTime timeTues = new CardTime("Tuesday");
		CardTime timeWed = new CardTime("Wednesday");
		CardTime timeThur = new CardTime("Thursday");
		CardTime timeFri = new CardTime("Friday");
		CardTime timeSatur = new CardTime("Saturday");
		CardTime timeSun = new CardTime("Sunday");

		list = Arrays.asList(timeMon, timeTues, timeWed, timeThur, timeFri, timeSatur, timeSun);

		for (CardTime cardTime : list) {
			this.add(cardTime);
		}
	}

	// Cập nhật thời gian của bộ phim theo từng ngày tương ứng
	public void updateMovie(LbImg item) {
		// TODO Auto-generated method stub
		// Cần tối ưu hơn
		InfoMovie info = (InfoMovie) item.getInfo().getInfo();
		Calendar cal = Calendar.getInstance();
		List<ShowTime> showTimes = info.getShowTimes();
		List<String> dates = new ArrayList<>();

		for (int i = 0; i < list.size(); ++i) {
			dates.add("");
		}

		for (ShowTime showTime : showTimes) {
			Date date = showTime.getDate();
			cal.set(date.getYear(), date.getMonth(), date.getDay());
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
			dates.set(dayOfWeek, dates.get(dayOfWeek).concat(showTime.toString() + "\n"));
		}

		for (int i = 0; i < dates.size(); i++) {
			String str = dates.get(i);
			if (str.isBlank()) {
				this.remove(list.get(i));
			} else {
				list.get(i).setDate(str);
				this.add(list.get(i));
			}
		}

	}
}
