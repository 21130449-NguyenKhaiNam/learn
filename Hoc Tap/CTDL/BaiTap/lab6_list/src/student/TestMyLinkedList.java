package student;

public class TestMyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		
		for (int i = 18; i >= 1; i--) 
			linkedList.addFirst(i);
		for (int i = 19; i <= 36; i++) 
			linkedList.addLast(i);
		linkedList.removeLast();
		System.out.println(linkedList.toString());
		
	}

}
