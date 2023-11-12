
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// Word count in the file
	private int size = 1;

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		// TODO
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		while (line != null) {
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String temp = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(temp, -size);
				} else {
					add(temp, size);
				}
				++size;
			}
			line = reader.readLine();
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		if(!map.containsKey(word))
			map.put(word, new ArrayList<Integer>());
		map.get(word).add(position);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		// TODO
		Map<String, ArrayList<Integer>> treeMap = new TreeMap<>();
		treeMap.putAll(map);
		for (Map.Entry<String, ArrayList<Integer>> entry : treeMap.entrySet())
			System.out.println(entry.getKey() + "=" + entry.getValue().toString());
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		// TODO
		String[] textFile = new String[size - 1];
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String key = entry.getKey();
			for (int index : entry.getValue()) {
				if (index < 0) {
					textFile[-index - 1] = key + "\n";
				} else {
					textFile[index - 1] = key + " ";
				}
			}
		}

		for (String string : textFile)
			System.out.print(string);
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		// TODO
		int maxLen = -1;
		String most = "";
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			int valLen = entry.getValue().size();
			if(maxLen < valLen) {
				most = entry.getKey();
				maxLen = valLen;
			}
		}
		return most;
	}

	/**
	 * @return the map
	 */
	public Map<String, ArrayList<Integer>> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, ArrayList<Integer>> map) {
		this.map = map;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer analyzer = new TextAnalyzer();
		analyzer.load("data/short.txt");
		System.out.println(analyzer.getMap().toString());
//		analyzer.displayWords();
//		analyzer.displayText();
//		System.out.println(analyzer.mostFrequentWord());
	}

}
