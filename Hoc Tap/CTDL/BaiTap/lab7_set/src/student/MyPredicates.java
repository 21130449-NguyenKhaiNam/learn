package student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		// TODO
		coll.removeIf(p);
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		// TODO
		coll.removeIf(p);
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		Set<T> set = new HashSet<>();
		Iterator<T> itr = coll.iterator();
		while (itr.hasNext())
			set.add(itr.next());
		return set;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		int index = 0;
		Iterator<T> itr = coll.iterator();
		while (itr.hasNext()) {
			if(p.test(itr.next()))
				return index;
			++index;
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 9; i++)
			list.add(i + 1);
		list.add(7);
		
//		MyPredicates.remove(list, x -> (x % 2 == 0));
//		MyPredicates.retain(list, x -> !(x% 2 == 0));
//		MyPredicates.collect(list, x -> (true));
		System.out.println(MyPredicates.find(list, x -> (x == 7)));
		System.out.println(list.toString());
	}
}
