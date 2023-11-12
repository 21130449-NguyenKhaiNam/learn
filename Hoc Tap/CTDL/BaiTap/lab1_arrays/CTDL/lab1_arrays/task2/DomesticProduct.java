package lab1_arrays.task2;

public class DomesticProduct extends Product {

	public DomesticProduct(String id, String name, double price) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDomestic() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "]";
	}
	
	
}
