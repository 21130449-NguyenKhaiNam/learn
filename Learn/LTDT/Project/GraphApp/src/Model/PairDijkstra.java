package Model;

public class PairDijkstra implements Comparable<PairDijkstra> {
	// khoảng cách
	private int d;
	// đỉnh
	private int v;

	public PairDijkstra(int d, int v) {
		this.d = d;
		this.v = v;
	}

	public int getD() {
		return d;
	}

	public int getV() {
		return v;
	}

	@Override
	public int compareTo(PairDijkstra o) {
		// TODO Auto-generated method stub
		return this.d - o.d;
	}

	@Override
	public String toString() {
		return "(" + d + ", " + v + ")";
	}

}
