package model.data.size;

/**
 * Thông số kích thước thay sài
 */
public enum EnumSize {
	ScreenWidth(IScreenWindow.SCREEN_WIDTH), ScreenHeight(IScreenWindow.SCREEN_HEIGHT),
	WidthMenu((int) (IScreenWindow.SCREEN_WIDTH * 0.2)), HeightTitle((int) (IScreenWindow.SCREEN_HEIGHT * 0.055)),
	WidthDialog((int) (IScreenWindow.SCREEN_WIDTH * 0.35)), HeightDialog((int) (IScreenWindow.SCREEN_HEIGHT * 0.34));

	public int size;

	/**
	 * @param size
	 */
	private EnumSize(int size) {
		this.size = size;
	}

}
