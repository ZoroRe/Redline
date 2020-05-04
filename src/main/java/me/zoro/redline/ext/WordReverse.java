package me.zoro.redline.ext;

import java.util.Stack;

/**
 * @author luguanquan
 * @date 2020-05-04 12:06
 * <p>
 * 单词反转，如 hello world 反转为 olleh dlrow
 */
public class WordReverse {

	public String reverse(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		StringBuilder word = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int last = s.length() - 1;
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == ' ') {
				result.append(word.reverse().toString());
				result.append(' ');
				word.delete(0, word.length());
			} else {
				word.append(c);
			}
			if (i == last && word.length() > 0) {
				result.append(word.reverse().toString());
			}
		}
		return result.toString();
	}

	public String reverse_0(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == ' ') {
				while (!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append(c);
			} else {
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.toString();
	}
}
