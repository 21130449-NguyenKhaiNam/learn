package nk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JPanel;

public class DrawMatrix extends JPanel implements MouseListener, MouseMotionListener {
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 500;

	private int top;
	private int[][] matrix;

	protected static int r = 30;
	private Map<Point, Integer> locations;
	private List<Circle> circles;
	private int sizeCircle;

	private int dragX;
	private int dragY;
	private Circle c;

	private List<Integer> road;

	public DrawMatrix(int[][] matrix) {
		this.matrix = matrix;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		this.top = this.matrix.length;
		this.dragX = 0;
		this.dragY = 0;
		this.locations = new HashMap<>();
		this.circles = new ArrayList<>();
		road = new ArrayList<>();

		c = null;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		sizeCircle = r + 1;
		Random random = new Random();
		int i = 0;
		while (i < top) {
			int x = random.nextInt(SCREEN_WIDTH - r * 5 + 1) + r;
			int y = random.nextInt(SCREEN_HEIGHT - r * 5 + 1) + r;
			Point p = new Point(x, y);
			boolean flag = true;
			if (!locations.containsKey(p)) {
				for (Map.Entry<Point, Integer> entry : locations.entrySet()) {
					Point key = entry.getKey();
					if (key.distance(p) < 40) {
						flag = false;
						break;
					}
				}
				if (flag) {
					locations.put(p, i++);
					Circle cr = new Circle(i + "");
					circles.add(cr);
					cr.setBounds(p.x, p.y, sizeCircle, sizeCircle);
					this.add(cr);
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Ve do thi
		for (int j = 0; j < matrix.length; j++) {
			for (int k = 0; k < matrix.length; k++) {
				if (matrix[j][k] != 0) {
					if (road.contains(j) && road.contains(k) && Math.abs(road.indexOf(j) - road.indexOf(k)) == 1) {
						g2.setColor(Color.RED);
					} else {
						g2.setColor(Color.BLACK);
					}
					Circle cf = circles.get(j);
					Circle ct = circles.get(k);
					int xf = cf.getX();
					int yf = cf.getY();
					int xt = ct.getX();
					int yt = ct.getY();
					int x1 = xf;
					int y1 = yf + cf.getHeight() / 2;
					int x2 = xt + ct.getWidth();
					int y2 = yt + ct.getHeight() / 2;
					if (xf < xt) {
						x1 = xf + cf.getWidth();
						x2 = xt;
					}
					// Neu dinh can ve khong nam tren duong di
					g2.drawLine(x1, y1, x2, y2);
					g2.setFont(new Font("Arial", Font.BOLD, 20));
					g2.setColor(Color.BLUE);
					g2.drawString(matrix[j][k] + "", (x1 + x2) / 2, (y1 + y2) / 2);
// Khi can ve ma tran co huong
//					if (true) {
//						g2.setColor(Color.BLUE);
//						int d = 5;
//						int h = 5;
//						int dx = x2 - x1, dy = y2 - y1;
//						double D = Math.sqrt(dx * dx + dy * dy);
//						double xm = D - d, xn = xm, ym = h, yn = -h, x;
//						double sin = dy / D, cos = dx / D;
//
//						x = xm * cos - ym * sin + x1;
//						ym = xm * sin + ym * cos + y1;
//						xm = x;
//
//						x = xn * cos - yn * sin + x1;
//						yn = xn * sin + yn * cos + y1;
//						xn = x;
//
//						int[] xpoints = { x2, (int) xm, (int) xn };
//						int[] ypoints = { y2, (int) ym, (int) yn };
//
//						g2.fillPolygon(xpoints, ypoints, 3);
//					}
				}
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		c = null;
		for (Circle circle : circles) {
			if (circle.isCircle(e.getX(), e.getY())) {
				c = circle;
				circle.setClick(true);
			} else {
				circle.setClick(false);
			}
		}
		this.revalidate();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (c != null) {
			dragX = e.getX();
			dragY = e.getY();
			if (0 <= dragX && dragX <= getWidth() - 20 && 0 <= dragY && dragY <= getHeight() - 20) {
				c.setBounds(dragX, dragY, sizeCircle, sizeCircle);
				this.repaint();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the dragX
	 */
	public int getDragX() {
		return dragX;
	}

	/**
	 * @return the dragY
	 */
	public int getDragY() {
		return dragY;
	}

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	public void printRoad(List<Integer> road) {
		// TODO Auto-generated method stub
		this.road = road;
		this.repaint();
	}

	public void color(List<List<Integer>> colors, List<Color> listColor) {
		// TODO Auto-generated method stub
		List<Color> rdColor = new ArrayList<>();
		if (listColor == null || listColor.isEmpty()) {
			int count = 0;
			while (count < colors.size()) {
				Random random = new Random();

				// Tạo màu ngẫu nhiên
				int red = random.nextInt(256);
				int green = random.nextInt(256);
				int blue = random.nextInt(256);
				Color randomColor = new Color(red, green, blue);

				if (!rdColor.contains(randomColor)) {
					rdColor.add(randomColor);
					++count;
				}
			}
		} else {
			rdColor = listColor;
		}

		for (int i = 0; i < colors.size(); i++) {
			for (Integer in : colors.get(i)) {
				circles.get(in).setHasColor(rdColor.get(i));
			}
		}
		this.repaint();
	}

}
