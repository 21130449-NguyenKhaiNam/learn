package LeetCode;

public class StringtoInteger {
	/*
	 * Chi tra ve so dung dau trong chuoi, neu khong co tra ve 0
	 */
	public static int myAtoi(String s) {
		int result = 0;
		int minus = 1;
		int index = 0;
		int count = 0;
		int count2 = 0;
		while(index < s.length()) {
			int temp = s.charAt(index);
			int temp2 = 0;
			if(temp >= 48 && temp <= 57 || temp == 45 || temp == 43) {
				if(temp == 43) {
					if(count == 1 || count2 != 0)
						return minus*result;
					++count;
					++index;
					continue;
				}
				if(temp == 45) {
					if(count == 1 || count2 != 0)
						return  minus*result;
					minus = -1;
					++count;
					++index;
					continue;
				}
				++count2;
				temp2 = result;
				result = result*10 + (temp - 48);
				if((result / 10) != temp2)
					return minus == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				++index;
				continue;
			}
			if(temp == ' ') {
				if(count2 != 0 || count != 0)
					return minus*result;
				++index;
				continue;
			}
			break;
		}
		return minus*result;
	}
	
	public static void main(String[] args) {
		String s = "+ 413";
		System.out.println('1' - 0);
		System.out.println('0' - 0);
		System.out.println('-' - 0);
		System.out.println(myAtoi(s) + " OK");
	}
}
