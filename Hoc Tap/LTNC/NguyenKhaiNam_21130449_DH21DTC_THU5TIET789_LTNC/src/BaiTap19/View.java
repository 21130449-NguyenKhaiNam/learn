package BaiTap19;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{

	public View() {
		addElement();
		display();
	}
	
	
	//Ve hinh
	public void addElement() {
		this.setLayout(new GridLayout(2,1));
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,2));
		
		Line line = new Line();
		CircleFill circleFill = new CircleFill();
		Circle circle = new Circle();
		Arc arc = new Arc();
		SquareFill squareFill = new SquareFill();
		
		center.add(line);
		center.add(circle);
		center.add(circleFill);
		center.add(arc);
		
		
		
		this.add(center);
		this.add(squareFill);
	}
	
	public void display() {
		setTitle("Ve hinh");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}
	
}
