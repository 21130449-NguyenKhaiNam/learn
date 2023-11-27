package view.general.search;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import model.data.font.IDataFont;
import model.data.size.EnumSize;

public class SearchDropDown extends JPopupMenu {
	private JPanel panelListSearch;
	private JList<String> listItem;
	private DefaultListModel<String> mod;
	private JScrollPane sp;

	public SearchDropDown() {
		init();
		addElement();
	}

	public void init() {
		setFocusable(false);
		
		mod = new DefaultListModel<>();
		panelListSearch = new JPanel();

		listItem = new JList<>();
		sp = new JScrollPane(listItem);
		sp.setPreferredSize(new Dimension(EnumSize.ScreenWidth.size - EnumSize.WidthMenu.size, 100));
	}

	public void addElement() {
		listItem.setModel(mod);

		listItem.setFont(IDataFont.NORMAL);

		panelListSearch.add(sp);

		this.add(panelListSearch);
	}

	public JList<String> getListItem() {
		return listItem;
	}

	public DefaultListModel<String> getMod() {
		return mod;
	}

	public JPanel getPanelListSearch() {
		return panelListSearch;
	}

	public void setPanelListSearch(JPanel panelListSearch) {
		this.panelListSearch = panelListSearch;
	}

	public JScrollPane getSp() {
		return sp;
	}

	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}

	public void setListItem(JList<String> listItem) {
		this.listItem = listItem;
	}

	public void setMod(DefaultListModel<String> mod) {
		this.mod = mod;
	}

}
