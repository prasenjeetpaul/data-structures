package practice;

import java.util.Stack;

public class StringSolution {
	/**
	 * Given a string, checks whether the string is an balanced expression or not;
	 * @param str	input string
	 * @return		true if expression is valid, else false
	 */
	public static boolean isExpressionValid(String str) {
		if(str.length()%2 == 1) return false;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
			} else {
				//Closing Bracket
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
	
	/**
	 * Given a string, returns the longest valid substring which represents an valid expression;
	 * @param str	input string
	 * @return		longest valid substring
	 */
	public static String longestValidExpression(String str) {
		Stack<Integer> stack = new Stack<Integer>();
		String ans = null;
		int max = 0;
		stack.push(-1);
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				} else {
					//Valid Case
					int lastIndex = stack.peek();
					if(i - lastIndex > max) {
						max = i-lastIndex;
						ans = str.substring(lastIndex, i);
					}
				}
			}
			
		}
		return ans;
	}
	
	/**
	 * Returns the minimum reversal of an item to make entire expression valid
	 * @param str	input expression
	 * @return		minimum no. of reversals required
	 */
	public static int getMinReversalToMakeExpressionValid(String str) {
		if(str.length()%2 == 1) return -1;
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<str.length();i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				stack.push(c);
			} else {
				if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
				else stack.push(')');
			}
		}
		
		int totalLength = stack.size();
		int openingCount = 0;
		while(!stack.isEmpty() && stack.peek()=='(') {
			stack.pop();
			openingCount++;
		}
		
		return (totalLength/2) + (openingCount%2);
	}
	
	private static String placeCharToLast(String str, char ch, int currIndex, int count) {
		if(currIndex == str.length()) {
			String last = "";
			for(int i=0; i<count; i++) last += ch;
			return last;
		}
		if(str.charAt(currIndex) == ch) return placeCharToLast(str, ch, currIndex+1, count+1);
		else return str.charAt(currIndex) + placeCharToLast(str, ch, currIndex+1, count);
	}
	
	/**
	 * Shifts all the 'ch' character to the end of the string using recursion
	 * @param str	input string
	 * @param ch	character to be shifted
	 * @return		output string
	 */
	public static String placeCharToLast(String str, char ch) {
		return placeCharToLast(str, 'b', 0, 0);
	}

}
