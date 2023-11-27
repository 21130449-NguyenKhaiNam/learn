package Model;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JPanel;

import View.Frame;

public class PanelDraw extends JPanel implements MouseListener, MouseMotionListener {
	private Frame frame;
	private int[][] arr;
	protected static int r = 30;
	private Map<Point, Integer> locations;
	private List<Circle> circles;
	private int sizeCircle;

	private int dragX;
	private int dragY;
	private Circle c;
	private boolean checkDirect;

	/**
	 * @param frame
	 */
	public PanelDraw(Frame frame) {
		this.frame = frame;
		this.setBackground(new Color(244, 244, 244));
	}

	/**
	 * @param matrix the matrix to set
	 */
	public void setMatrix(int[][] arr, boolean checkDirect) {
		this.arr = arr;
		this.checkDirect = checkDirect;
		this.removeAll();
		create();
		this.revalidate();
		this.repaint();
	}

	private void create() {
		// TODO Auto-generated method stub
		int top = arr.length;
		dragX = 0;
		dragY = 0;
		this.locations = new HashMap<>();
		this.circles = new ArrayList<>();
		c = null;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setLayout(null);
//		this.setPreferredSize(new Dimension(Frame.SCREEN_WIDTH, Frame.SCREEN_HEIGHT));
		sizeCircle = r + 1;
		Random random = new Random();
		int i = 0;
		while (i < top) {
			int x = random.nextInt(getWidth() - r * 5 + 1) + r;
			int y = random.nextInt(getHeight() - r * 5 + 1) + r;
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

		for (int j = 0; j < arr.length; j++) {
			for (int k = 0; k < arr.length; k++) {
				if (arr[j][k] != 0) {
					g2.setColor(Color.BLACK);
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
					g2.drawLine(x1, y1, x2, y2);
					g2.setFont(new Font("Arial", Font.BOLD, 20));
					g2.setColor(Color.BLUE);
					g2.drawString(arr[j][k] + "", (x1 + x2) / 2, (y1 + y2) / 2);

					if (checkDirect) {
						g2.setColor(Color.BLUE);
						int d = 5;
						int h = 5;
						int dx = x2 - x1, dy = y2 - y1;
						double D = Math.sqrt(dx * dx + dy * dy);
						double xm = D - d, xn = xm, ym = h, yn = -h, x;
						double sin = dy / D, cos = dx / D;

						x = xm * cos - ym * sin + x1;
						ym = xm * sin + ym * cos + y1;
						xm = x;

						x = xn * cos - yn * sin + x1;
						yn = xn * sin + yn * cos + y1;
						xn = x;

						int[] xpoints = { x2, (int) xm, (int) xn };
						int[] ypoints = { y2, (int) ym, (int) yn };

						g2.fillPolygon(xpoints, ypoints, 3);
					}
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
}
