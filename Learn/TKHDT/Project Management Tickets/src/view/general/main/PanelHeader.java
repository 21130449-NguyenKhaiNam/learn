package view.general.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import control.observer.Observer;
import control.observer.Subject;
import control.search.ActionSearch;
import model.data.color.EnumColor;
import model.data.img.GetImage;
import model.data.movie.GetMovie;
import model.function.FunctionImg;
import model.movie.InfoMovie;
import view.general.search.SearchDropDown;
import view.general.search.SearchText;
import view.general.staff.IUpdateMovie;
import view.general.staff.LbImg;

/**
 * Trang trí thanh tìm kiếm và các chức năng của nó
 */
public class PanelHeader extends JPanel implements IUpdateMovie, Subject {
	private JLabel lbLogo;
	private JTextField searchText;
	private SearchDropDown searchDropDown;

	private List<InfoMovie> infoMovies;

	private List<Observer> obs;

	public PanelHeader() {
		init();
		initComponents();
	}

	private void init() {
		setBackground(EnumColor.White.color);
		setOpaque(false);
	}

	private void initComponents() {
		obs = new ArrayList<>();

		infoMovies = new ArrayList<>();
		updateMovie(GetMovie.getInfoMovies());

		ActionSearch as = new ActionSearch(this);

		searchDropDown = new SearchDropDown();

		lbLogo = new JLabel();
		setLogo(GetImage.getImgSearch(0));

		searchText = new SearchText();
		searchText.addKeyListener(as);

		searchDropDown.getListItem().addListSelectionListener(as);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lbLogo)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(searchText, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(lbLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(searchText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		g2.fillRect(0, 0, 10, getHeight());
		g2.fillRect(getWidth() - 10, getHeight() - 10, getWidth(), getHeight());
		super.paintComponent(grphcs);
	}

	// lấy ra phim cần tìm kiếm dưới dạng chuỗi
	public String getStringFilm() {
		return searchDropDown.getListItem().getSelectedValue();
	}

	// lấy ra bộ phim cần tìm kiếm dưới dạng class InfoMovie
	public InfoMovie getFilm() {
		for (InfoMovie m : infoMovies) {
			if (m.getMovie().getName().equals(getStringFilm())) {
				notifyAllList(m);
				return m;
			}
		}
		return null;
	}

	// trả về danh sách phim đang có
	public List<InfoMovie> listFilm() {
		return infoMovies;
	}

	// Thiết lập logo search theo kích thước cố định
	public void setLogo(Image img) {
		lbLogo.setIcon(FunctionImg.scaleImg(img, 24, 24));
	}

	public JTextField getSearchText() {
		return searchText;
	}

	public SearchDropDown getSearchDropDown() {
		return searchDropDown;
	}

	@Override
	public void updateMovie(List<InfoMovie> movies) {
		// TODO Auto-generated method stub
		infoMovies.addAll(movies);
	}

	@Override
	public void updateClickMovie(LbImg item) {
		// TODO Auto-generated method stub
		System.out.println("Error");
	}

	@Override
	public void register(Observer com) {
		// TODO Auto-generated method stub
		obs.add(com);
	}

	@Override
	public void remove(Observer com) {
		// TODO Auto-generated method stub
		obs.remove(com);
	}

	@Override
	public void notifyAllList(Object obj) {
		// TODO Auto-generated method stub
		for (Observer ob : obs) {
			ob.update(obj);
		}
	}

}
