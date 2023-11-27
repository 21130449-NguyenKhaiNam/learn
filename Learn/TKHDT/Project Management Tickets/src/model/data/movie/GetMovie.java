package model.data.movie;

import java.util.List;

import model.movie.InfoMovie;

/**
 * Giúp lấy các thông tin phim một các linh động
 */
public class GetMovie {
	private static SourceMovie movie = new DataMovie();

	public static List<InfoMovie> getInfoMovies() {
		return movie.getInfoMovies();
	}
}
