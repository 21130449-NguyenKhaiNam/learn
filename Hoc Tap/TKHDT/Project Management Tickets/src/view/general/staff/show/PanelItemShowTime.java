package view.general.staff.show;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.data.color.EnumColor;
import model.movie.ShowTime;

public class PanelItemShowTime extends JPanel implements Comparable<PanelItemShowTime> {
	private ShowTime name;

	public PanelItemShowTime(ShowTime name) {
		this.name = name;
		init();
		initComponents();
	}

	private void init() {
		// TODO Auto-generated method stub
		setOpaque(false);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setLayout(new FlowLayout());
		Border border = BorderFactory.createLineBorder(EnumColor.Focus3.color);
		
		setBorder(BorderFactory.createTitledBorder(border, name.toString()));
	}

	@Override
	public int compareTo(PanelItemShowTime o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
}
