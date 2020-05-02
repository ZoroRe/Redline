package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luguanquan
 * @date 2020-05-02 12:46
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
