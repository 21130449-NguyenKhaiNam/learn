package nk;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private DrawMatrix draw;
	private int[][] matrix;

	public Frame(int[][] matrix) {
		this.matrix = matrix;
		init();
	}

	public Frame(int[][] matrix, List<Integer> road) {
		this.matrix = matrix;
		init();
		printRoad(road);
	}

	public Frame(int[][] matrix, List<List<Integer>> colors, List<Color> listColor) {
		this.matrix = matrix;
		init();
		color(colors, listColor);
	}

	private void init() {
		this.setTitle("Graph Analysis");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new CardLayout());

		draw = new DrawMatrix(this.matrix);
		this.getContentPane().add(draw);
		this.pack();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void printRoad(List<Integer> road) {
		List<Integer> reduce = new ArrayList<>();
		for (Integer i : road) {
			reduce.add(i - 1);
		}
		draw.printRoad(reduce);
	}

	public void color(List<List<Integer>> colors, List<Color> listColor) {
		List<List<Integer>> reduce = new ArrayList<>();
		for (int i = 0; i < colors.size(); i++) {
			reduce.add(new ArrayList<>());
			for (int j = 0; j < colors.get(i).size(); j++) {
				reduce.get(i).add(colors.get(i).get(j));
			}
		}
		draw.color(reduce, listColor);
	}

}
