package me.zoro.redline.leetcode;

import java.util.Stack;

/**
 * @author luguanquan
 * @date 2020-05-02 23:25
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class Leetcode0032 {

	public int longestValidParentheses_0(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		// 添加一个初始-1的索引，如果整个栈被弹出为空，说明是多处一个 ) 的子串，不符合，因此可以把当前这个位置入栈，做为一个新传起始点之前，如开始的-1
		// 如果弹出后非空,说明这一段是符合的，计算最新串的长度和此前最长，两者比较
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					max = Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}

	/**
	 * 利用数组记录所有匹配的括号，然后找出最大连续的括号。
	 * 对于这种括号匹配，大概率会用到栈匹配每组，还要关注是有记录匹配下的值
	 *
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		byte[] bitmap = new byte[s.length()];
		Stack<Integer> stack = new Stack();
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '(') {
				stack.add(i);
			} else {
				if (!stack.isEmpty()) {
					bitmap[stack.pop()] = 1;
					bitmap[i] = 1;
				}
			}
		}
		int max = 0;
		int current = 0;
		int last = bitmap.length - 1;
		for (int i = 0; i < bitmap.length; i++) {
			if (bitmap[i] == 1) {
				current++;
				if (i == last && current > max) {
					max = current;
				}
			} else {
				if (current > max) {
					max = current;
				}
				current = 0;
			}

		}
		return max;
	}
}
