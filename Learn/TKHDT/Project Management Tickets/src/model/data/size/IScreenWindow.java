package model.data.size;

import java.awt.Toolkit;

/**
 * Kích thước cửa sổ chương trình của máy hiện đang sài
 */
public interface IScreenWindow {
	int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
}
