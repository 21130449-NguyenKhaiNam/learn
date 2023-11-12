package lab1_arrays.task2;

import java.util.Arrays;

public class TestProduct {
	public static void main(String[] args) {
		Product product_1 = new DomesticProduct("01", "Mat hang 1", 200.0);
		Product product_2 = new DomesticProduct("02", "Mat hang 2", 400.0);
		
		Product product_3 = new ImportedProduct("03", "Mat hang 3", 300.0, "VN");
		Product product_4 = new ImportedProduct("04", "Mat hang 4", 400.0, "VN");
		Product product_5 = new ImportedProduct("05", "Mat hang 5", 500.0, "Thai");
		Product product_6 = new ImportedProduct("06", "Mat hang 6", 600.0, "My");
		
		Product[] products_list = {product_1, product_2, product_3, product_4, product_5, product_6};
		
		ProductManagement productManagement = new ProductManagement(products_list);
		
		//So noi dia la
		System.out.println("So san pham noi dia la: " + productManagement.howManyDomesticProducts() + "\n") ;
		
		//Nuoc co nhieu san pham nhap khau nhat
		System.out.println("Nuoc co nhieu san pham nhap khau nhat: " + productManagement.getCountryHavingMostImportedProducts() + "\n");
		
		//So san pham co gia cao hon gia tri nhat dinh
		int giaThu = 300;
		System.out.println("So san pham co gia cao hon " + giaThu + " " + Arrays.toString(productManagement.filterProductsByPrice(giaThu)));
	}
}
