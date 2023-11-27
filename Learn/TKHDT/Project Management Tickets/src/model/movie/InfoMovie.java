package model.movie;

import java.awt.Image;
import java.util.List;

import model.info.Info;

/**
 * Thông tin cần thiết của một bộ phim hiển thị trên màn hình
 */
public class InfoMovie implements Info {
	// Mã thông tin
	private String id;

	// Thông tin phim
	private Movie movie;

	// Thông tin giờ chiếu
	private List<ShowTime> showTimes;

	// Giờ hiện tại muốn chiếu
	private int currentTime;

	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	/**
	 * @return the currentTime
	 */
	public int getCurrentTime() {
		return currentTime;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @return the showTimes
	 */
	public List<ShowTime> getShowTimes() {
		return showTimes;
	}

	public InfoMovie(String id, Movie movie, List<ShowTime> showTimes) {
		this.id = id;
		this.movie = movie;
		this.showTimes = showTimes;
		currentTime = 0;
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return movie.getImg();
	}

	@Override
	public Info getInfo() {
		// TODO Auto-generated method stub
		return this;
	}

}
