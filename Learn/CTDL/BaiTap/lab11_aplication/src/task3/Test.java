package task3;

import java.util.Arrays;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p_1 = new Product("Kem", "Thuc An", 5000, new Date());
		Product p_2 = new Product("Sua rua mat", "My Pham", 150000, new Date());
		Product p_3 = new Product("Dua Hau", "Thuc An", 800000, new Date());
		
		OrderItem oi_1 = new OrderItem(p_1, 2);
		OrderItem oi_2 = new OrderItem(p_2, 4);
		OrderItem oi_3 = new OrderItem(p_3, 1);
		
		Order o_1= new Order("01", "Nguyen Van A", "Nhan vien 1", new Date(), Arrays.asList(oi_1, oi_2));
		Order o_2= new Order("02", "Nguyen Van B", "Nhan vien 2", new Date(), Arrays.asList(oi_2, oi_3));
		Order o_3= new Order("03", "Nguyen Van C", "Nhan vien 3", new Date(), Arrays.asList(oi_1, oi_3));
		
		OrderManger om = new OrderManger(Arrays.asList(o_1, o_2, o_3));
		
		System.out.println("Cau 1: " + om.maxProduct());
		System.out.println("Cau 2: " + om.productTypesStatistics());
		System.out.println("Cau 3: " + om.ordersByCost());
	}

}
