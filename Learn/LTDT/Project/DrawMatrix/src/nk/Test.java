package nk;

public class Test {
	public static void main(String[] args) {
		LoadMatrix load = new LoadMatrix("./src/nk/test.txt");
		int[][] matrix = load.getMatrix();
//		List<Integer> road = Arrays.asList(1, 4, 5, 3, 2, 6);
//		List<List<Integer>> colors = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4));
//		new Frame(load.getMatrix(), road);
//		new Frame(matrix, colors, null);

	}
}
