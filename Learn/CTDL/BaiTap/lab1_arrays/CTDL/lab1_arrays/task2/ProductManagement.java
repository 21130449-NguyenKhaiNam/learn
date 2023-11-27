package lab1_arrays.task2;

public class ProductManagement {
	private Product[] products;

	public ProductManagement(Product[] products) {
		this.products = products.clone();
	}

	// How many domestic products?
	public int howManyDomesticProducts() {
		int count = 0;
		for (Product product : products) {
			if(product.isDomestic()) ++count;
		}
		return count;
	}

	// Get the country name which most products are imported from
	public String getCountryHavingMostImportedProducts() {
		String name = "";
		ImportedProduct[] psNew = layHangNhap();
		int max = 0;
		for (ImportedProduct importedProduct : psNew) {
			int count = demThanhPho(psNew, importedProduct.getCountry());
			if(max < count) {
				name = importedProduct.getCountry();
				max = count;
			}
		}
		return name;
		
	}
	
	private ImportedProduct[] layHangNhap() {
		ImportedProduct[] psNew = new ImportedProduct[products.length - howManyDomesticProducts()];
		int index = 0;
		for (Product product : products) {
			if(!product.isDomestic()) {
				psNew[index] = (ImportedProduct)product;
				++index;
			}
		}
		return psNew;
	}
	
	private int demThanhPho(ImportedProduct[] ps, String nameContry) {
		int count = 0;
		for (ImportedProduct importedProduct : ps) {
			if(importedProduct.getCountry().equals(nameContry))
				++count;
		}
		return count;
	}

	// Filter products having prices higher than a given price
	public Product[] filterProductsByPrice(double price) {
		// TODO
		Product[] psTemp = new Product[products.length];
		int index = 0;
		for (Product product : products) {
			if(product.price >= price) {
				psTemp[index] = product;
				++index;
			}
		}
		Product[] psNew = new Product[index];
		index = 0;
		for (Product product : psTemp) {
			if(product == null)
				break;
			psNew[index] = product;
			++index;
		}
		return psNew;
	}
}
