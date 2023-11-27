package view.scroll;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * Thay đổi ui cho thanh trượt
 */
public class ModernScrollBarUI extends BasicScrollBarUI {
	private final int THUMB_SIZE = 100;

	@Override
	protected Dimension getMaximumThumbSize() {
		if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			return new Dimension(0, THUMB_SIZE);
		} else {
			return new Dimension(THUMB_SIZE, 0);
		}
	}

	@Override
	protected Dimension getMinimumThumbSize() {
		if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			return new Dimension(0, THUMB_SIZE);
		} else {
			return new Dimension(THUMB_SIZE, 0);
		}
	}

	@Override
	protected JButton createIncreaseButton(int i) {
		return new ScrollBarButton();
	}

	@Override
	protected JButton createDecreaseButton(int i) {
		return new ScrollBarButton();
	}

	@Override
	protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int orientation = scrollbar.getOrientation();
		int size;
		int x;
		int y;
		int width;
		int height;
		if (orientation == JScrollBar.VERTICAL) {
			size = rctngl.width / 2;
			x = rctngl.x + ((rctngl.width - size) / 2);
			y = rctngl.y;
			width = size;
			height = rctngl.height;
		} else {
			size = rctngl.height / 2;
			y = rctngl.y + ((rctngl.height - size) / 2);
			x = 0;
			width = rctngl.width;
			height = size;
		}
		g2.setColor(new Color(240, 240, 240));
		g2.fillRect(x, y, width, height);
	}

	@Override
	protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = rctngl.x;
		int y = rctngl.y;
		int width = rctngl.width;
		int height = rctngl.height;
		if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			y += 8;
			height -= 16;
		} else {
			x += 8;
			width -= 16;
		}
		g2.setColor(scrollbar.getForeground());
		g2.fillRoundRect(x, y, width, height, 10, 10);
	}

	private class ScrollBarButton extends JButton {

		public ScrollBarButton() {
			setBorder(BorderFactory.createEmptyBorder());
		}

		@Override
		public void paint(Graphics grphcs) {
		}
	}
//
//    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
//    private static final int SCROLL_BAR_ALPHA = 50;
//    private static final int THUMB_SIZE = 8;
//    private static final Color THUMB_COLOR = Color.BLACK;
//
//    public ModernScrollBarUI() {
//
//    }
//
//    @Override
//    protected JButton createDecreaseButton(int orientation) {
//        return new InvisibleScrollBarButton();
//    }
//
//    @Override
//    protected JButton createIncreaseButton(int orientation) {
//        return new InvisibleScrollBarButton();
//    }
//
//    @Override
//    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
//    }
//
//    @Override
//    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
//        int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
//        int orientation = scrollbar.getOrientation();
//        int x = thumbBounds.x;
//        int y = thumbBounds.y;
//
//        int width = orientation == JScrollBar.VERTICAL ? THUMB_SIZE : thumbBounds.width;
//        width = Math.max(width, THUMB_SIZE);
//
//        int height = orientation == JScrollBar.VERTICAL ? thumbBounds.height : THUMB_SIZE;
//        height = Math.max(height, THUMB_SIZE);
//
//        Graphics2D graphics2D = (Graphics2D) g.create();
//        graphics2D.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
//        graphics2D.fillRect(x, y, width, height);
//        graphics2D.dispose();
//    }
//
//    private static class InvisibleScrollBarButton extends JButton {
//
//        private InvisibleScrollBarButton() {
//            setOpaque(false);
//            setFocusable(false);
//            setFocusPainted(false);
//            setBorderPainted(false);
//            setBorder(BorderFactory.createEmptyBorder());
//        }
//    }
}
