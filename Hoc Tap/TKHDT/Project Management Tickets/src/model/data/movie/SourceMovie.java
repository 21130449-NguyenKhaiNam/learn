package model.data.movie;

import java.util.List;

import database.Database;
import model.movie.InfoMovie;

/**
 * Định nghĩa ra các phương thức để lấy dữ liệu từ database
 */
public interface SourceMovie {
	List<InfoMovie> infoMovies = Database.getInfoMovies();
	
	List<InfoMovie> getInfoMovies();
}
