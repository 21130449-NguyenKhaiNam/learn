package lab1_arrays.task2;

public class ImportedProduct extends Product {
	private String country;
	
	/**
	 * @param country
	 */
	public ImportedProduct(String id, String name, double price, String country) {
		super(id, name, price);
		this.country = country;
	}

	@Override
	public boolean isDomestic() {
		return false;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return  super.toString() + "country=" + country + "]";
	}
	
	

}
