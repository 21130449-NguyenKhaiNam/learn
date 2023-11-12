package BaiTap18;

public class Subject {
	private String nameSubject;
	private String idSubject;
	private double score;

	public Subject(String nameSubject, String idSubject, double score) {
		this.nameSubject = nameSubject;
		this.idSubject = idSubject;
		this.score = score;
	}
	/*
	 * Lay ten mon hoc ra
	 */
	public String getNameSubject() {
		return nameSubject;
	}
	
	/*
	 * Lay ma mon hoc ra
	 */
	public String getIdSubject() {
		return idSubject;
	}
	
	/*
	 * Lay diem mon hoc
	 */
	public double getScore(){
		return score;
	}
	
	/*
	 * Thay doi diem cho sinh vien
	 * Diem phai be hon bang 10 neu sai thi giu nguyen
	 */
	public void addScore(double addScore) {
		if(addScore <= 10) {
			this.score = addScore;
		}
	}
}
