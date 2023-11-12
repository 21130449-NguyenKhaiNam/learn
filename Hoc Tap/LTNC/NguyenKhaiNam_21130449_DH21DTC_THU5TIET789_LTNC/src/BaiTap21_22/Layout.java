package BaiTap21_22;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;

import java.awt.*;
import java.awt.event.*;

public class Layout extends JFrame implements ActionListener{
	private Color choseColor;
	private String choseShape;
	private int count;
	int width_first;
	int width_second;
	int height_first;
	int height_second;
	private Graphics g;
	
	public Layout() {
		choseShape = "";
		width_first = 0;
		width_second = 0;
		height_first = 0;
		height_second = 0;
		count = 0;
		choseColor = Color.BLUE;
		init();
	}
	
	public void init() {
		setTitle("Chuong trinh ve hinh co ban");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_DOWN_MASK));
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		file.add(exit);
		
		//Group shape
		ButtonGroup shapes = new ButtonGroup();
		JMenu shape = new JMenu("Shape");
		JRadioButtonMenuItem line = new JRadioButtonMenuItem("Line");
		line.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.SHIFT_DOWN_MASK));
		line.addActionListener(this);
		JRadioButtonMenuItem circle = new JRadioButtonMenuItem("Circle");
		circle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
		circle.addActionListener(this);
		JRadioButtonMenuItem rectangle = new JRadioButtonMenuItem("Rectangle");
		rectangle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.ALT_DOWN_MASK));
		rectangle.addActionListener(this);
		//Trong group
		shapes.add(line);
		shapes.add(circle);
		shapes.add(rectangle);
		//Trong menu
		shape.add(line);
		shape.add(circle);
		shape.add(rectangle);
		
		//Group color
		ButtonGroup colors = new ButtonGroup();  
		
		JRadioButton color_white = new JRadioButton("White");
		color_white.addActionListener(this);
		JRadioButton color_black = new JRadioButton("Black");
		color_black.addActionListener(this);
		JRadioButton  color_red = new JRadioButton("Red");
		color_red.addActionListener(this);
		//Them mau vao group
		colors.add(color_white);
		colors.add(color_black);
		colors.add(color_red);
		
		menuBar.add(file);
		menuBar.add(shape);
		menuBar.add(color_white);
		menuBar.add(color_black);
		menuBar.add(color_red);
		
		JPanel draw = new JPanel();
		draw.setBackground(Color.BLUE);
		draw.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Chon ve");
				++count;
				if(count == 1) {
					System.out.println(count+"");
					System.out.println(e.getX()+"");
					System.out.println(e.getY()+"");
					width_first = e.getX();
					height_first = e.getY();
				}else if(count == 2) {
					count = 0;
					System.out.println(count+"");
					System.out.println(e.getX()+"");
					System.out.println(e.getY()+"");
					width_second = e.getX();
					height_second = e.getY();
					g = getGraphics();
					g.setColor(choseColor);
					if(choseShape.equalsIgnoreCase("Line")) {
						g.drawLine(width_first,height_first,width_second,height_second);
					}else if(choseShape.equalsIgnoreCase("Circle")) {
						g.drawOval(width_first,height_first,2*(width_second-width_first),2*(height_second-height_first));
					}else if(choseShape.equalsIgnoreCase("Rectangle")) {
						g.drawRect(width_first,height_first,width_second-width_first,height_second-height_first);
					}
				}
				
			}

		});
		
		this.add(draw);
		this.setJMenuBar(menuBar);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String chose = e.getActionCommand();
		if(chose.equalsIgnoreCase("Line") || chose.equalsIgnoreCase("Circle") || chose.equalsIgnoreCase("Rectangle")) {
			choseShape = chose;
			System.out.println("chon hinh");
		}else if(chose.equalsIgnoreCase("White")) {
			System.out.println("mau trang");
			choseColor = Color.WHITE;
		}else if(chose.equalsIgnoreCase("Black")) {
			System.out.println("mau den");
			choseColor = Color.BLACK;
		}else if( chose.equalsIgnoreCase("Red")) {
			System.out.println("mau do");
			choseColor = Color.RED;
		}
	}
}
