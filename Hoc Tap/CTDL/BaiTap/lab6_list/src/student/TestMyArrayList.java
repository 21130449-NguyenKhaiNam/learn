package student;

public class TestMyArrayList {
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			list.add(i + 1);
		}
		
		System.out.println(list.toString());
	}
}
