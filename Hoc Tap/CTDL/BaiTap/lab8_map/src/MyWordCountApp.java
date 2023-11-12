
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/short.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Count not is alphabet
	private int count = 0;

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		// TODO
		Scanner input = new Scanner(new File("data/short.txt"));

		while (input.hasNext()) {
			String str = input.next();
			int len = str.length();
			int endIsAlphabetic = len;
			int end = len;
			for (int i = 0; i < len; i++) {
				if (!Character.isAlphabetic(str.charAt(i))) {
					if (endIsAlphabetic == len)
						endIsAlphabetic = i;
					end = i + 1;
					++count;
					add(str.charAt(i) + "");
				}
			}
			addStr(end, len, str);
			addStr(endIsAlphabetic, 0, str);
		}
	}

	public void addStr(int num, int checkNum, String str) {
		if (num != checkNum)
			add(checkNum != 0 ? str.substring(num) : str.substring(0, num));
	}

	public void add(String str) {
		map.put(str, (map.containsKey(str) ? map.get(str) : 0) + 1);
	}

	// Returns the number of distinct tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() throws FileNotFoundException {
		// TODO
		return this.count;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// TODO
		for (Map.Entry<String, Integer> entry : map.entrySet())
			if (entry.getValue() == 1)
				System.out.println(entry.getKey() + "=" + entry.getValue());
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		// TODO
		Map<String, Integer> treeMap = new TreeMap<>();
		for (Map.Entry<String, Integer> entry : map.entrySet())
			if (entry.getValue() == 1)
				treeMap.put(entry.getKey(), entry.getValue());
		System.out.println(treeMap.toString());
	}

	/**
	 * @return the map
	 */
	public Map<String, Integer> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	/**
	 * @return the filename
	 */
	public static String getFilename() {
		return fileName;
	}

	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp app = new MyWordCountApp();
		app.loadData();
		System.out.println(app.getMap().toString());
		System.out.println("Count: " + app.countDistinct());
		app.printWordCounts();
		app.printWordCountsAlphabet();
	}
}
