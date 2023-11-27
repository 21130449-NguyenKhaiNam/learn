package model.movie;

import java.awt.Image;
import java.util.List;

import model.info.Date;
import model.info.EnumTypeMovie;

/**
 * Một đối tượng phim để có thể hiện thị trên màn hình phải có các thông tin cơ
 * bản sau
 */
public class Movie {
	// Phần hiển thị cơ bản
	private Image img;
	private String name;
	private double price;
	private EnumTypeMovie type;
	private String description;

	// Phần hiển thị chi tiết
	private Date releaseDate;
	private List<Author> authors;
	private List<String> scriptWriters;
	private List<String> producer;
	private List<Actor> actors;
	private List<String> language;
	private String detail;

	/**
	 * @return the img
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the type
	 */
	public EnumTypeMovie getType() {
		return type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}

	/**
	 * @return the scriptWriters
	 */
	public List<String> getSciptWriters() {
		return scriptWriters;
	}

	/**
	 * @return the producer
	 */
	public List<String> getProducer() {
		return producer;
	}

	/**
	 * @return the actors
	 */
	public List<Actor> getActors() {
		return actors;
	}

	/**
	 * @return the language
	 */
	public List<String> getLanguage() {
		return language;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	public Movie(Image img, String name, double price, EnumTypeMovie type, String description, Date releaseDate,
			List<Author> authors, List<String> scriptWriters, List<String> producer, List<Actor> actors,
			List<String> language, String detail) {
		this.img = img;
		this.name = name;
		this.price = price;
		this.type = type;
		this.description = description;
		this.releaseDate = releaseDate;
		this.authors = authors;
		this.scriptWriters = scriptWriters;
		this.producer = producer;
		this.actors = actors;
		this.language = language;
		this.detail = detail;
	}

}
