package view.general.staff;

import java.util.List;

import model.movie.InfoMovie;

/**
 * Để tường minh lớp nào cần phương thức cập nhật phim thì implemnets interface
 * này
 */
public interface IUpdateMovie {
	// Cập nhật nếu có thông tin phim từ database
	void updateMovie(List<InfoMovie> movies);

	// Cập nhật phim khi được thông báo
	void updateClickMovie(LbImg item);
}
