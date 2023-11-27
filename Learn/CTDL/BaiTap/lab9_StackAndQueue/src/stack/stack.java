package stack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack {
	public static <E> void reserve(E[] arr) {
		// TODO
		Stack<E> stack = new Stack<>();
		int i = 0;
		for (E var : arr)
			stack.add(var);
		while (!stack.isEmpty())
			arr[i++] = stack.pop();
	}

	public static boolean isCorrect(String input) {
		// TODO
		Stack<Character> stack = new Stack<>();
		for (Character ch : input.toCharArray()) {
			if (ch != ' ') {
				if (ch == '(' || ch == '[' || ch == '{') {
					stack.add(ch);
				} else {
					if (stack.isEmpty() || ch - stack.peek() > 2)
						return false;
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	public static void checkStepOne(Character ch, Stack<Character> stack, Queue<String> queue) {
		if (stack.isEmpty() || stack.peek() == '(' || level(ch) - level(stack.peek()) > 0) {
			stack.add(ch);
		} else {
			queue.add(stack.pop() + "");
			checkStepOne(ch, stack, queue);
		}
	}

	public static void checkStepThree(Character ch, Stack<Character> stack, Queue<String> queue) {
		if (stack.peek() == '(') {
			stack.pop();
			return;
		}
		queue.add(stack.pop() + "");
		checkStepThree(ch, stack, queue);
	}

	public static void checkByStep(Character ch, String str, Stack<Character> stack, Queue<String> queue) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
			checkStepOne(ch, stack, queue);
		} else if (ch == '(') {
			// Step 2
			stack.push(ch);
		} else if (ch == ')') {
			checkStepThree(ch, stack, queue);
		} else {
			// Step 4
			queue.add(str);
		}
	}

	public static boolean checkOparetor(Character ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	public static int evaluateExpression(String expression) {
		// TODO
		Stack<Character> stack = new Stack<>();
		Queue<String> queue = new ArrayDeque<>();
		String text = "";
		for (int i = 0; i < expression.length(); ++i) {
			char ch = expression.charAt(i);
			if (ch != ' ') {
				if (!(checkOparetor(ch) || ch == '(' || ch == ')')) {
					text = (text.length() >= 1 ? text : "") + ch;
					int index = i < expression.length() - 1 ? i + 1 : i;
					if (index != i) {
						char temp = expression.charAt(index);
						if (temp == ' ')
							checkByStep(ch, text, stack, queue);
						if (!(checkOparetor(temp) || temp == '(' || temp == ')'))
							continue;
					}
				}
				checkByStep(ch, text, stack, queue);
				text = "";
			}
		}
		while (!stack.isEmpty())
			queue.add(stack.pop() + "");
		String re = "";
		for (String str : queue)
			re += str + " ";
		re = re.trim();
		return calc(new Stack<Integer>(), re);
	}

	public static int level(Character ch) {
		return ch == '*' || ch == '/' ? 2 : 1;
	}

	public static int calc(Stack<Integer> stack, String needCalc) {
		char ch = needCalc.charAt(0);
		if (needCalc.length() == 1) {
			calcStack(ch, stack);
			return stack.pop();
		}
		int index = needCalc.indexOf(' ');
		if (checkOparetor(ch)) {
			calcStack(ch, stack);
		} else {
			stack.add(Integer.valueOf(needCalc.substring(0, index)));
		}
		needCalc = needCalc.substring(index + 1);
		return calc(stack, needCalc);
	}

	private static void calcStack(Character ch, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		int num1 = stack.pop();
		int num2 = stack.pop();
		int re = 0;
		if (ch == '+') {
			re = num2 + num1;
		} else if (ch == '-') {
			re = num2 - num1;
		} else if (ch == '*') {
			re = num2 * num1;
		} else {
			re = num2 / num1;
		}
		stack.add(re);
	}

	// This method checks the well-defined of a given HTML or XML file
	public static boolean isWell_Defined(String fileName) throws IOException {
		Stack<String> stack_tags = new Stack<>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String text = tokens.nextToken();
				int index = text.indexOf('>');
				if (index != -1) {
					text = text.substring(0, index + 1);
					int index_close = text.indexOf('/');
					if (index_close != -1) {
						if(stack_tags.isEmpty())
							return false;
						String text_open = stack_tags.pop();
						text_open = text_open.replace("<", "").replace(">", "");
						text_open = text_open.replace("<", "").replace(">", "");
						if (!text.contains(text_open))
							return false;
					} else {
						stack_tags.add(text);
					}
				}
			}
		}
		reader.close();
		return stack_tags.isEmpty();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 5 7 4 - * 4 5 3 - * +
		// 5 * (7-4) + 4*(5 - 3)
		System.out.println(evaluateExpression("757*2"));
//		System.out.println(isWell_Defined("src/stack/html.txt"));
	}

}
