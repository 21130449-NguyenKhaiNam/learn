package student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data\\hamlet.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		// TODO
		ArrayList<WordCount> list = new ArrayList<>();
		for (String word : words) {
			WordCount wc = new WordCount(word, 1);
			if (list.contains(wc)) {
				updateCount(list, wc.getWord());
			} else {
				list.add(wc);
			}
		}
		return list;
	}

	private void updateCount(ArrayList<WordCount> list, String word) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			WordCount wc = list.get(i);
			if (wc.getWord().equals(word)) {
				wc.setCount(wc.getCount() + 1);
				break;
			}
		}

	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> set = new HashSet<>();
		for (WordCount wordCount : getWordCounts())
			if (wordCount.getCount() == 1)
				set.add(wordCount.getWord());
		return set;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		Set<String> set = new HashSet<>();
		for (WordCount wordCount : getWordCounts())
			set.add(wordCount.getWord());
		return set;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		// TODO
		Set<WordCount> set = new TreeSet<WordCount>((x, y) -> (x.getWord().compareTo(y.getWord())));
		set.addAll(getWordCounts());
		return set;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		// TODO
		Set<WordCount> set = new TreeSet<WordCount>((x, y) -> (y.getWord().compareTo(x.getWord())));
		set.addAll(getWordCounts());
		return set;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		// TODO
		Set<String> set = new HashSet<>();
		for (String word : words)
			if (word.startsWith(pattern))
				set.add(word);
		return set;
	}

	public static void main(String[] args) {
		MyWordCount myc = new MyWordCount();
//		System.out.println(myc.getWordCounts().toString());
//		System.out.println(myc.getUniqueWords().toString());
//		System.out.println(myc.getDistinctWords().toString());
//		System.out.println(myc.printWordCounts().toString());
		System.out.println(myc.exportWordCountsByOccurence().toString());
//		System.out.println(myc.filterWords("B").toString());
	}
}
