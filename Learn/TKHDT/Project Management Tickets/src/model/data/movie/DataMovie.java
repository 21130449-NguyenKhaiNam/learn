package model.data.movie;

import java.util.List;

import model.movie.InfoMovie;

/**
 * Lấy dữ liệu phim từ cơ sở dữ liệu
 */
public class DataMovie implements SourceMovie {

	public DataMovie() {

	}

	@Override
	public List<InfoMovie> getInfoMovies() {
		// TODO Auto-generated method stub
		return infoMovies;
	}

}
