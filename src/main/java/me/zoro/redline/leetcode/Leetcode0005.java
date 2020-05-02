package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luguanquan
 * @date 2020-05-02 12:46
 *
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
@Slf4j
public class Leetcode0005 {


	/**
	 * 暴力破解，
	 * 在判断是否回文字符串时如果用递归 isPalingrome, leetcode 时间不通过
	 * 换成非递归形式的 isPalingrome_0 后通过，但效率极低
	 *
	 * @param s
	 * @return
	 */
	public String longestPalingrome_1(String s) {
		if (s == null) {
			return null;
		}
		if (s.length() < 2) {
			return s;
		}
		//暴力破解,但是相比所有都遍历然后记录最长字符串，如果每次遍历的都是当前最长字符串，只要找到第一个符合就立刻返回
		String current = "";
		// i 表示需要去除总共多少个字符,left 表示左边要去除多少个字符，right表示右边去除多少个字符，i = left + right
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			for (left = 0, right = i; left <= i; left++, right--) {
				current = s.substring(left, s.length() - right);
				if (isPalingrome_0(current)) {
					return current;
				}
			}
		}
		return s.substring(0, 1);
	}

	/**
	 * 中心扩散法
	 *
	 * @param s
	 * @return
	 */
	public String longestPalingrome_2(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		int left;
		int right;
		int maxLen = 1;
		int start = 0;
		int curLen = 1;
		int strLen = s.length();
		for (int i = 0; i < s.length(); i++) {
			curLen = 1;
			left = i - 1;
			right = i + 1;
			//向左寻找和当前字符不一样的，如果一样那这部分一定能作为回文，比如奇数的 aaa, 偶数的 aaaa
			while (left >= 0 && s.charAt(i) == s.charAt(left)) {
				left--;
				curLen++;
			}
			// 向右寻找和当前字符不一样的
			while (right < strLen && s.charAt(i) == s.charAt(right)) {
				right++;
				curLen++;
			}
			// 左右对比扩散
			while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
				curLen += 2;
			}
			if (curLen > maxLen) {
				// 加1是因为真正开始已经进行一次移动，每次比较符合又进行一次移动，最终的left其实是第一个不符合的(或者-1)
				start = left + 1;
				maxLen = curLen;
			}
		}
		return s.substring(start, start + maxLen);
	}

	/**
	 * 递归判断一个字符串是否是回文字符串
	 *
	 * @param s
	 * @return
	 */
	private boolean isPalingrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}
		if (s.length() == 2) {
			return s.charAt(0) == s.charAt(1);
		}
		int last = s.length() - 1;
		log.info("{}, {}", s.charAt(0) == s.charAt(last), s.substring(1, last));
		return s.charAt(0) == s.charAt(last) && isPalingrome(s.substring(1, last));
	}

	/**
	 * 非递归判断是否回文字符串
	 *
	 * @param s
	 * @return
	 */
	private boolean isPalingrome_0(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}
		int start = (s.length() - 1) / 2;
		int end = start + 1;
		if (s.length() % 2 == 1) {
			start--;
		}
		while (start >= 0) {
			if (s.charAt(start--) != s.charAt(end++)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Leetcode0005 solution = new Leetcode0005();
		String s = "";
		String result = solution.longestPalingrome_1(s);
	}
}
