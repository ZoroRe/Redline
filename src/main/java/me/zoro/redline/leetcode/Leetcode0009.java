package me.zoro.redline.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luguanquan
 * @date 2020/5/19 9:51 下午
 * <p>
 * 9. 回文数
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode0009 {

	/**
	 * 没转字符串，用一个列表当做栈来处理
	 * 最开始处理过同样求模后再计算回原值，结果遇到10发现不对劲
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		List<Integer> number = new ArrayList<>();
		int value = x;
		while (value > 0) {
			number.add(value % 10);
			value /= 10;
		}
		while (number.size() > 0) {
			if (number.size() == 1) {
				return true;
			}
			if (number.get(0).equals(number.get(number.size() - 1))) {
				return false;
			}
			number.remove(0);
			number.remove(number.size() - 1);
		}
		return true;
	}

	/**
	 * 转成字符串
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindrome0(int x) {
		String value = "" + x;
		if (value.length() <= 1) {
			return true;
		}
		int start = 0;
		int end = value.length() - 1;
		while (start < end) {
			if (value.charAt(start++) != value.charAt(end--)) {
				return false;
			}
		}
		return true;

	}
}
