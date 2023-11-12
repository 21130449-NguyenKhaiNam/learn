package view.field;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import model.info.IDataNameField;

/**
 * Lấy ra trường ghi tương ứng
 */
public class FactoryField implements IFactoryField {
	// Mỗi loại trường ghi có tên riêng
	private Map<String, JTextField> mapField;

	public FactoryField() {
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		mapField = new HashMap<>();
		mapField.put(IDataNameField.PASS, new PasswordField());
		mapField.put(IDataNameField.USER, new TextField());
	}

	@Override
	public JTextField getField(String name) {
		// TODO Auto-generated method stub
		return mapField.get(name);
	}

}
