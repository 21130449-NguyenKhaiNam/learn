package Model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import View.Frame;

/**
 * Lớp xử lý các vấn đề liên quan đến ma trận
 *
 */
public class MatrixProcessing {
	private Frame frame;

	// Số đỉnh
	int top = 0;

	// Mảng chứa dữ liệu ban đầu
	private int[][] matrix;

	// Mảng chứa dữ liệu với trọng số không âm
	private int[][] matrixNonNegative;

	// Mảng chứa dữ liệu với trọng số không âm và vô hướng
	private int[][] matrixNonNegativeAndUndirected;

	// ma trận chứa các ma trận hiện có
	int[][][] arrayMatrix = new int[3][][];

	// Đường dẫn tên file khi xuất
	String[] endFileNames = { "input_nonnegative.txt", "input_nonnegative_nondirected.txt" };

	// Dùng trong việc kiểm tra đồ thị euler
	private int firstEven = 0;

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * @return the matrixNonNegative
	 */
	public int[][] getMatrixNonNegative() {
		return matrixNonNegative;
	}

	/**
	 * @return the matrixNonNegativeAndUndirected
	 */
	public int[][] getMatrixNonNegativeAndUndirected() {
		return matrixNonNegativeAndUndirected;
	}

	/**
	 * Contructor
	 * 
	 * @param read
	 * @param frame
	 * @throws IOException
	 */
	public MatrixProcessing(BufferedReader read, Frame frame) throws IOException {
		this.frame = frame;
		loadMatrix(read);
	}

	public MatrixProcessing(BufferedReader read) throws IOException {
		loadMatrix(read);
	}

	/**
	 * Đọc ma trận từ file lên và chuyển thành ma trận từ file, ma trận không có
	 * trọng số âm, ma trận không có trọng số âm và là vô hướng
	 * 
	 * @param read
	 * @throws IOException
	 */
	private void loadMatrix(BufferedReader read) throws IOException {
		// TODO Auto-generated method stub
		String line = null;
		int row = -1;
		boolean checkError = true;
		while ((line = read.readLine()) != null) {
			String[] str = line.split(" ");
			int len = str.length;
			// Ban đầu không nhập đỉnh hoặc số cột không ứng với số đỉnh đã nhập
			if (row == -1 && len != 1 || row != -1 && top != len) {
				this.frame.errorStructure();
				this.frame.previousPanel();
				checkError = false;
				return;
			} else if (row == -1) {
				this.top = Integer.parseInt(str[0]);
				this.matrix = new int[top][top];
				this.matrixNonNegative = new int[top][top];
				this.matrixNonNegativeAndUndirected = new int[top][top];
			} else {
				for (int i = 0; i < str.length; i++) {
					int num = Integer.parseInt(str[i]);
					this.matrix[row][i] = num;
					this.matrixNonNegative[row][i] = Math.abs(num);
					if (matrixNonNegative[row][i] != 0) {
						int temp = matrixNonNegative[row][i];
						matrixNonNegativeAndUndirected[row][i] = temp;
						matrixNonNegativeAndUndirected[i][row] = temp;
					}
				}
			}
			++row;
		}
		if (checkError) {
			addMatrixToArray();
		}
	}

	/**
	 * Thêm ma trận để xử lý chỉ cần duyệt không cần phải thực hiện từng ma trận
	 */
	private void addMatrixToArray() {
		// TODO Auto-generated method stub
		arrayMatrix[0] = matrix;
		arrayMatrix[1] = matrixNonNegative;
		arrayMatrix[2] = matrixNonNegativeAndUndirected;
	}

	public int getTop() {
		return top;
	}

	/**
	 * Ghi các ma trận vào file tương ứng và in ra màn hình kết quả
	 * 
	 * @throws IOException
	 */
	public void writeFileAndShow() throws IOException {
		// TODO Auto-generated method stub
		if (arrayMatrix[0] != null) {
			for (int i = 0; i < arrayMatrix.length; i++) {
				int[][] arr = arrayMatrix[i];
				String strMatrix = strMatrix(arr);
				if (i != 0) {
					String fileName = frame.getPathFile();
					String subFileName = fileName.substring(0, fileName.lastIndexOf("\\") + 1);
					FileWriter w = new FileWriter(subFileName + endFileNames[i - 1]);

					w.write(arr.length + "\n");
					w.write(strMatrix + "\n");
					w.close();
				}
				// Hiển thị ma trận đã đọc ra vị trí tương ứng
				frame.showMatrix(i, strMatrix);
			}
		}
	}

	/**
	 * Ma trận ở dạng một chuỗi để ghi vào file
	 * 
	 * @param arr
	 * @return
	 */
	private String strMatrix(int[][] arr) {
		String str = "";
		for (int[] i : arr) {
			for (int j : i) {
				str += j + " ";
			}
			str += "\n";
		}
		return str;
	}

	/**
	 * Thuật toán tìm đường đi theo chiều sâu, thay vì mỗi lần chạy phải làm mới thì
	 * để luôn kiểu trả về là boolean[]
	 * 
	 * @param v
	 * @param arr
	 * @param visisted
	 * @return
	 */
	public boolean[] dfs(int v, int[][] arr, boolean[] visisted) {
		visisted[v] = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[v][i] != 0 && !visisted[i]) {
				dfs(i, arr, visisted);
			}
		}
		return visisted;
	}

	public int checkEuler(int[][] arr) {
		boolean[] visisted = dfs(0, arr, new boolean[top]);
		int even = 0;
		int odd = 0;
		for (int i = 1; i < arr.length; i++) {
			if (!visisted[i]) {
				return -1;
			}
			int sum = 0;
			for (int j = 0; j < top; j++) {
				if (arr[i][j] != 0) {
					sum += (i == j ? 2 : 1);
				}
			}
			if (sum % 2 == 0) {
				++even;
			} else {
				if (odd == 0)
					firstEven = i;
				++odd;
			}
			if (even >= arr.length) {
				return 1;
			} else if (odd > 2) {
				return -1;
			}
		}
		return odd == 1 ? -1 : 0;
	}

	/**
	 * Tìm đường đi cho đồ thị euler, checkEuler cho biết đồ thị có phải euler hay
	 * nửa euler hay không
	 * 
	 * @param arr
	 * @return
	 */
	/**
	 * @param arr
	 * @return
	 */
	public List<Integer> findRoadEuler(int[][] arr, int checkEuler) {
		int k = checkEuler;
		List<Integer> ec = new ArrayList<>();
		if (k >= 0) {
			Stack<Integer> st = new Stack<>();
			int v = firstEven;
			st.add(v);
			while (!st.isEmpty()) {
				v = st.peek();
				int adjacentSide = adjacentSide(v, arr);
				if (adjacentSide >= 0) {
					int first = adjacentSide;
					st.add(first);
					arr[v][first] = 0;
					arr[first][v] = 0;
				} else {
					v = st.pop();
					ec.add(v);
				}
			}
			Collections.reverse(ec);
		}
		return ec;
	}

	/**
	 * Trả về đỉnh kề gần nhất nếu có
	 * 
	 * @param t
	 * @param arr
	 * @return
	 */
	private int adjacentSide(int t, int[][] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if (arr[t][i] != 0)
				return i;
		}
		return -1;
	}

	public void coppyMatrix(int[][] matrixFrom, int[][] matrixTo) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrixFrom.length; i++) {
			for (int j = 0; j < matrixFrom.length; j++) {
				matrixTo[i][j] = matrixFrom[i][j];
			}
		}
	}

	// danh sách kề của ma trận
	public List<Edge>[] edges(int[][] arr) {
		List<Edge>[] list = new List[top];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			for (int j = 0; j < list.length; j++) {
				if (arr[i][j] > 0) {
					list[i].add(new Edge(i, j, arr[i][j]));
				}
			}
		}
		return list;
	}

	// thuật toán Dijkstra
	public List<Integer> dijkstra(int s, int t) {
		if (isNegativeWeight(matrix))
			return null;
		int[] prev = new int[top];
		// mảng d dùng để lưu khoảng cách hiện tại của đỉnh
		int[] d = new int[top];
		for (int i = 0; i < d.length; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[s] = 0;

		/**
		 * dùng để lưu trữ các cặp chưa được xét, lấy cặp có khoảng cách bé nhất, nằm
		 * đầu tiên vì đây là PriorityQueue
		 * 
		 * 1 cặp bao gồm: (khoảng cách, đỉnh) --> xem lớp PairDijkstra
		 */
		Queue<PairDijkstra> q = new PriorityQueue<>();

		// đưa cặp xét đầu tiên vào queue và khởi tạo khoảng cách bằng 0
		q.add(new PairDijkstra(0, s));

		// lặp cho tới khi queue rỗng
		while (!q.isEmpty()) {
			// lấy ra cặp đầu tiên
			PairDijkstra top = q.poll();
			// u là đỉnh của cặp đầu tiên
			int u = top.getV();
			// kc là khoảng cách cặp đầu tiên
			int kc = top.getD();

			// waiting ...
			if (kc > d[u])
				continue;

			// lặp qua các cạnh kề của cặp đỉnh đầu tiên
			for (Edge edge : edges(matrix)[u]) {
				// v là đỉnh đích của cạnh
				int v = edge.getDestination();
				// w là trọng số của cạnh đó
				int w = edge.getWeight();

				/*
				 * cập nhập lại khoảng cách của đỉnh nếu khoảng cách ban đầu lớn hơn khoảng cách
				 * từ đỉnh trước nó + trọng số của cạnh đó thì câp nhập lại khoảng cách là
				 * khoảng cách từ đỉnh trước nó + trọng số của cạnh đó
				 */
				if (d[v] > d[u] + w) {
					d[v] = d[u] + w;
					// thêm vào queue
					q.add(new PairDijkstra(d[v], v));
					// lưu đỉnh trước nó
					prev[v] = u;
				}
			}
		}

		// lặp qua mảng d, nếu đỉnh nào có khoảng cách
		// là vô cùng(nghĩa là không có đường đi tới nó) thì lưu đỉnh trước nó là -1
		for (int i = 0; i < d.length; i++) {
			if (d[i] == Integer.MAX_VALUE) {
				prev[i] = -1;
			}
		}

		List<Integer> result = new ArrayList<>();
		// lặp qua mảng đã lưu đỉnh trước nó
		// lấy ra đường đi giữa 2 đỉnh s và t
		for (int i = 0; i < prev.length; i++) {
			if (t == -1)
				break;
			result.add(t + 1);
			if (t == s)
				break;
			t = prev[t];
		}

		return result;
	}

	// kiểm tra ma trận kề có trọng số âm hay không
	// có return true, không return false
	public boolean isNegativeWeight(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] < 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean[] BFS(int vertex) {
		boolean[] visited = new boolean[top];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		while (!queue.isEmpty()) {
			int start = queue.poll();
			visited[start] = true;
			for (int i = 0; i < matrixNonNegativeAndUndirected.length; i++) {
				if (matrixNonNegativeAndUndirected[start][i] > 0 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

		return visited;
	}

	public boolean isCorrect() {
		boolean[] visited = BFS(0);
		for (int i = 0; i < top; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	public int[] primMST() {
		boolean[] visited = new boolean[top];
		int[] parents = new int[top];
		int[] key = new int[top];
		Arrays.fill(key, Integer.MAX_VALUE);
		parents[0] = -1;
		key[0] = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(top, Comparator.comparingInt(i -> key[i]));
		queue.add(0);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			visited[u] = true;
			for (int v = 0; v < top; v++) {
				if (matrixNonNegativeAndUndirected[u][v] != 0 && !visited[v]
						&& matrixNonNegativeAndUndirected[u][v] < key[v]) {
					parents[v] = u;
					key[v] = matrixNonNegativeAndUndirected[u][v];
					queue.add(v);
				}
			}
		}
		return parents;
	}

	public void printMST() {
		int[] parents = primMST();
		String text = "Edge \t Weight\n";
		int totalWeight = 0;
		for (int i = 1; i < top; i++) {
			text += (parents[i] + 1) + " - " + (i + 1) + " \t      " + matrixNonNegativeAndUndirected[i][parents[i]]
					+ "\n";

			totalWeight += matrixNonNegativeAndUndirected[i][parents[i]];
		}
		text += "Total weights " + totalWeight;
		this.frame.showPrim(text);
	}

	// thuat toan kiem tra huong
	public boolean checkDirectAlgorithm(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i][j] != arr[j][i])
					return true;
			}
		}
		return false;
	}

	public int numberOfEdge(int arr[][]) {
		int countEdge = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0) {
					countEdge++;
				}
			}
		}
		return (checkDirectAlgorithm(arr) ? countEdge : countEdge / 2);
	}

	public String countDegInDegOut(int arr[][]) {
		int[] degIn = new int[arr.length];
		int[] degOut = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0) {
					degOut[i]++;
					degIn[j]++;
				}
			}
		}
		String re = "";
		for (int i = 0; i < arr.length; i++) {
			re += "Vertices " + (i + 1) + ": degIn = " + degIn[i] + ", degOut = " + degOut[i] + "\n";
		}
		return re;
	}

	public String countDeg(int[][] arr) {
		int[] deg = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < deg.length; j++) {
				if (arr[i][j] != 0) {
					++deg[i];
				}
			}
		}
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += "Vertices " + (i + 1) + ": deg  = " + deg[i] + "\n";
		}
		return str;
	}

	public boolean checkCompleteGraphAlgorithm(int arr[][]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// in ra ket qua thuat toan
	public String checkCompleteGraph(int arr[][]) {
		int numberOfVertex = arr.length;
		int numberOfEdge = (numberOfVertex * (numberOfVertex - 1)) / 2;
		if (checkCompleteGraphAlgorithm(arr)) {
			return "This is a complete graph of K" + numberOfVertex + " vertices with " + numberOfEdge + " edges";
		}
		return "This isn't a complete graph of K";
	}
}
