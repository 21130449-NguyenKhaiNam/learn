package BaiTap20;

import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import java.awt.*;


public class DrawShape extends JPanel implements MouseMotionListener{
	private Graphics g;
	public static boolean nameColor;
	public static boolean nameShape;
	public static boolean FillOrEmpty;
	
	public DrawShape() {
		this.addMouseMotionListener(this);
	}

	
	/*
	 * Ve theo di chuyen chuot
	 * Ve gi thi se duoc cac thuoc tinh boolean quyet dinh
	 * kiem va ve theo yeu cau
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		g = getGraphics();
		if(nameColor == false) {
			g.setColor(Color.BLUE);
			if(nameShape == false) {
				if(FillOrEmpty == false) {
					g.drawRect(x,y,30,30);
				}else if(FillOrEmpty == true){
					g.fillRect(x,y,30,30);
				}
			}else if(nameShape == true) {
				if(FillOrEmpty == false) {
					g.drawOval(x,y,30,30);
				}else if(FillOrEmpty == true){
					g.fillOval(x,y,30,30);
				}
			}
		}else if(nameColor == true){
			g.setColor(Color.RED);
			if(nameShape == false) {
				if(FillOrEmpty == false) {
					g.drawRect(x,y,30,30);
				}else if(FillOrEmpty == true){
					g.fillRect(x,y,30,30);
				}
			}else if(nameShape == true) {
				if(FillOrEmpty == false) {
					g.drawOval(x,y,30,30);
				}else if(FillOrEmpty == true){
					g.fillOval(x,y,30,30);
				}
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
