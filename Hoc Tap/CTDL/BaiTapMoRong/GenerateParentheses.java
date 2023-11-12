package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		recurse(res, 0, 0, "", n);
		return res;
	}

	public static void recurse(List<String> res, int left, int right, String s, int n) {
		if (s.length() == n * 2)
			res.add(s);
		if (left < n)
			recurse(res, left + 1, right, s + "(", n);
		if (right < left)
			recurse(res, left, right + 1, s + ")", n);
	}

//	public static List<String> generateParenthesis(int n) {
//		List<String> list = randomParenthesis(n*2);
//		Iterator<String> itr = list.iterator();
//		while(itr.hasNext()) {
//			if(!checkParenthesis(itr.next())) {
//				itr.remove();
//			}
//		}
//		return list;
//	}
//
//	private static boolean checkParenthesis(String str) {
//		// TODO Auto-generated method stub
//		while(str.contains("()"))
//			str = str.replace("()", "");
//		return str.isEmpty();
//	}
//
//	private static List<String> randomParenthesis(int num) {
//		// TODO Auto-generated method stub
//		Set<String> set = new HashSet<>();
//		String[] parenthesis = {"(", ")"};
//		for (int i = 0; i < (int) Math.pow(2, num); i++) {
//			String str = "";
//			for (int j = 0; j < num; j++) {
//				str += parenthesis[(int) (Math.random()*2)];
//			}
//			if(!set.add(str))
//				--i;
//		}
//		return new ArrayList<>(set);
//	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(4).toString());
	}
}
