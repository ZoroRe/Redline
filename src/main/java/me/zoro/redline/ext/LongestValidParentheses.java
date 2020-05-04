package me.zoro.redline.ext;

import java.util.Stack;

/**
 * @author luguanquan
 * @date 2020-05-03 17:28
 * <p>
 * leetcode 题32 变形，要求返回最长有效括号,leetcode32 只是返回长度
 */
public class LongestValidParentheses {

	public String find(String s) {
		if (s == null || s.length() == 1) {
			return "";
		}
		int start = -1;
		int maxLen = 0;
		int curLen = 0;
		// 最长有效字符串它一定是连续的，只要保证他遇到无效时重新设置下一段的起始位置，遇到有效时先计算当前长度更新，并且保证继续有效还能继续记住位置
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					// 开始设置一个-1,这是如果是空，说明单独 ) 去匹配了，重新设置新串起始位置的前一个
					stack.push(i);
				} else {
					// 不为空的说明 ) 有对应匹配的 (, 这时候弹出来 ( 后的剩下的位置就是用 i 减去它的长度
					curLen = i - stack.peek();
					if (maxLen < curLen) {
						start = stack.peek() + 1;
						maxLen = curLen;
					}
				}
			}
		}
		if (maxLen > 0) {
			return s.substring(start, start + maxLen);
		}
		return "";
	}

}
