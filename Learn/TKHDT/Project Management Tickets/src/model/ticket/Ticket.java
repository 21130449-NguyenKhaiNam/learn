package model.ticket;

import java.util.List;
import java.util.Objects;

import model.movie.ShowTime;

/**
 * Định nghĩa về nội dung quan trọng trên vé cần có
 */
public class Ticket {
	private String id;
	private String date;
	private String nameMovie;
	private ShowTime time;
	private String room;
	private List<String> chairs;
	private double price;
	private int numSt;
	private double sale;
	private boolean check;

	/**
	 * @return the id
	 */
	public String getId() {
		return id + Objects.hash(chairs, date, id, nameMovie, numSt, price, room, sale, time) + "";
	}

	/**
	 * @return the check
	 */
	public boolean isCheck() {
		return check;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date.substring(0, date.lastIndexOf("."));
	}

	/**
	 * @return the nameMovie
	 */
	public String getNameMovie() {
		return nameMovie;
	}

	/**
	 * @return the time
	 */
	public ShowTime getTime() {
		return time;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @return the chairs
	 */
	public List<String> getChairs() {
		return chairs;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price * chairs.size() - numSt * (price * 0.1);
	}

	/**
	 * @return the numSt
	 */
	public int getNumSt() {
		return numSt;
	}

	/**
	 * @return the sale
	 */
	public double getSale() {
		return sale;
	}

	/**
	 * @param check the check to set
	 */
	public void setCheck(boolean check) {
		this.check = check;
	}

	public Ticket(String id, String date, String nameMovie, ShowTime time, String room, List<String> chairs,
			double price, int numSt, double sale) {
		this.id = id;
		this.date = date;
		this.nameMovie = nameMovie;
		this.time = time;
		this.room = room;
		this.chairs = chairs;
		this.price = price;
		this.numSt = numSt;
		this.sale = sale;
		this.check = false;
	}

	public String getChairsToString() {
		// TODO Auto-generated method stub
		String re = "";

		for (int i = 0; i < chairs.size(); i++)
			re += chairs.get(i) + (i == chairs.size() - 1 ? "" : ", ");

		return re;
	}

}
