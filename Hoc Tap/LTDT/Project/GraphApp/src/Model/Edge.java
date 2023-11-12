package Model;

public class Edge {
	private int source;
	private int destination;
	private int weight;
	public Edge(int source, int destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	public int getSource() {
		return source;
	}
	
	public int getDestination() {
		return destination;
	}
	
	public int getWeight() {
		return weight;
	}
}	
