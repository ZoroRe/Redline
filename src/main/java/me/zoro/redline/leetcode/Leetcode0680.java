package me.zoro.redline.leetcode;

/**
 * @author luguanquan
 * @date 2020/5/19 8:27 下午
 * <p>
 * 680. 验证回文字符串 Ⅱ
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode0680 {

	/**
	 * 找到第一个不一致之后，尝试删除某一边后剩下是否还是回文
	 *
	 * @param s
	 * @return
	 */
	public boolean validPalindrome(String s) {
		//找出不相等的字符，删除后是否相等
		if (s.length() == 1) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				if (s.charAt(start + 1) == s.charAt(end)) {
					// 这里删除左边字符，end + 1 是因为右开
					if (isPalindrome(s.substring(start + 1, end + 1))) {
						return true;
					}
				}
				// 这里删除右边字符，end 不用减1是因为右开
				if (s.charAt(start) == s.charAt(end - 1)) {
					if (isPalindrome(s.substring(start, end))) {
						return true;
					}
				}
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 暴力破解，超出时间限制
	 *
	 * @param s
	 * @return
	 */
	public boolean validPalindrome0(String s) {
		if (s.length() == 1) {
			return true;
		}
		int start;
		int end;
		for (int i = -1; i < s.length(); i++) {
			// i 表示要移除的字符串
			start = 0;
			end = s.length() - 1;
			while (start < end) {
				if (start == i) {
					start++;
				}
				if (end == i) {
					end--;
				}
				if (s.charAt(start) != s.charAt(end)) {
					break;
				}
				start++;
				end--;
				if (start >= end) {
					return true;
				}
			}
		}
		return false;
	}
}
