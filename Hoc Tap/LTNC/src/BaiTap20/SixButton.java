package BaiTap20;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SixButton extends JPanel implements ActionListener{
	private ButtonGroup color;
	private ButtonGroup style;
	private ButtonGroup fillOrEmpty;
	
	private JButton color_Red;
	private JButton color_Blue;
	
	private JRadioButton circle;
	private JRadioButton square;
	private JRadioButton fill;
	private JRadioButton empty;
	
	public SixButton() {
		this.setBackground(Color.YELLOW);
		addElements();
	}
	
	/*
	 * Tao ra cac nut bam 
	 */
	public void addElements() {
		this.color_Red = new JButton("Red");
		color_Red.addActionListener(this);
		this.color_Blue = new JButton("Blue");
		color_Blue.addActionListener(this);
		this.circle = new JRadioButton("Circle");
		circle.addActionListener(this);
		this.square = new JRadioButton("Square");
		square.addActionListener(this);
		this.fill = new JRadioButton("Fill");
		fill.addActionListener(this);
		this.empty = new JRadioButton("Empty");
		empty.addActionListener(this);
		
		color = new ButtonGroup();
		style = new ButtonGroup();
		fillOrEmpty = new ButtonGroup();
		
		
		color.add(color_Blue);
		color.add(color_Red);
		
		style.add(circle);
		style.add(square);
		
		fillOrEmpty.add(fill);
		fillOrEmpty.add(empty);
		
		this.add(color_Red);
		this.add(color_Blue);
		this.add(circle);
		this.add(square);
		this.add(fill);
		this.add(empty);
	}
	
	
	/*
	 * Bam vao nut nao thi cac thuoc tinh boolean ben drawShape vve
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		
		// true is Red false is Blue
		//true is fill false is empty
		//true is Circle false is Square
		
		if(src.equalsIgnoreCase("Blue")){
			System.out.println("Blue");
			DrawShape.nameColor = false;
		}else if(src.equalsIgnoreCase("Red")){
			System.out.println("Red");
			DrawShape.nameColor = true;
		}else if(src.equalsIgnoreCase("Square")) {
			System.out.println("Square");
			DrawShape.nameShape = false;
		}else if(src.equalsIgnoreCase("Circle")){
			System.out.println("Circle");
			DrawShape.nameShape = true;
		}else if(src.equalsIgnoreCase("Empty")) {
			System.out.println("Empty");
			DrawShape.FillOrEmpty = false;
		}else if(src.equalsIgnoreCase("Fill")){
			System.out.println("Fill");
			DrawShape.FillOrEmpty = true;
		}
	}
}
