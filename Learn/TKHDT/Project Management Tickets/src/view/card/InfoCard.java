package view.card;

import javax.swing.Icon;

/**
 * Định nghĩa về thông tin card khi hiển thị trên màn hình
 */
public class InfoCard {
	private Icon icon;
	private String title;
	private String values;
	private String description;

	public InfoCard(Icon icon, String title, String values, String description) {
		this.icon = icon;
		this.title = title;
		this.values = values;
		this.description = description;
	}

	public InfoCard() {
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
