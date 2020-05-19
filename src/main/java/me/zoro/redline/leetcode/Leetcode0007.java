package me.zoro.redline.leetcode;

/**
 * @author luguanquan
 * @date 2020/5/19 10:28 下午
 * <p>
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode0007 {

	/**
	 * 本来看着很简单的题，结果因为溢出一直没考虑全面，错了好几次
	 *
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		boolean negative = x < 0 ? true : false;
		int newValue = 0;
		int carry = 1;
		if (x < 0) {
			x = -x;
		}
		int nextValue;
		while (x > 0) {
			nextValue = newValue * carry + x % 10;
			// 校验是否溢出,检测溢出是个有意思的东西，好好注意这点
			if (carry == 10 && nextValue / carry != newValue) {
				return 0;
			}
			newValue = nextValue;
			if (newValue > 0 && carry == 1) {
				carry = 10;
			}

			x /= 10;
		}
		return negative ? -newValue : newValue;
	}
}
