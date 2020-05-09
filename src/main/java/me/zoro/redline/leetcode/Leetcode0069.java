package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luguanquan
 * @date 2020-05-09 17:05
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 通过次数136,494提交次数356,162
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Leetcode0069 {


	public int mySqrt(int x) {
		// 大学白上系列，居然忘记夹逼方法,看了下题解
		if (x == 0 || x == 1) {
			return x;
		}
		int i = 0;
		int temp = x;
		while (temp > 0) {
			temp = temp >> 1;
			i++;
		}
		// 选择最接近的右侧值
		int right = x >> (i / 2 - 1);
		int left = right >> 2;
		long middlePow = 1L * left * left;
		// 选择最合适的左边值 (但发现性能并没有比从1开始快，甚至可能慢)
		while (middlePow > x) {
			left = left >> 1;
		}
		int middle = left;
		while (left < right) {
			// 无符号右移 >>>
			middle = (int) ((left + right + 1L) >> 1);
			middlePow = 1L * middle * middle;
			if (middlePow > x || middlePow < 0) {
				right = middle - 1;
			} else {
				left = middle;
			}
		}
		return left;
	}


	/**
	 * 暴力破解会超时
	 *
	 * @param x
	 * @return
	 */
	public int mySqrt0(int x) {
		//暴力破解
		if (x == 0 || x == 1) {
			return x;
		}
		int xPow = 0;
		int i;
		for (i = 1; i <= x; i++) {
			xPow = i * i;
			if (xPow == x) {
				return i;
			}
			if (xPow > x) {
				return i - 1;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		Leetcode0069 solution = new Leetcode0069();
//		log.info("Xxxxxxx {} =? {}", solution.mySqrt(2147395599), 46339);
		log.info("Xxxxxxx {} ", solution.mySqrt(9));
	}
}
