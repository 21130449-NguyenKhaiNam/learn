package TowerOfHaNoi;

public class Recursive {
	public static void THN(int disk, String source, String dest, String sqare){
		if(disk == 1) {
			System.out.println(source + "->" + dest);
		}else {
			THN(disk - 1, source, sqare, dest);
			System.out.println(source + "->" + dest);
			THN(disk - 1, sqare, dest, source);
		}
	}
	
	public static void main(String[] args) {
		THN(2, "A", "C", "B");
	}
}
