package me.zoro.redline;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luguanquan
 * @date 2020-05-14 20:21
 * <p>
 * 136. 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 通过次数207,058提交次数303,308
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode0136 {

	/**
	 * 异或 & 直接修改原数组第一位
	 *
	 * @param nums
	 * @return
	 */
	public int singlenNumber(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		nums[0] ^= nums[1];
		for (int i = 2; i < nums.length; i++) {
			nums[0] ^= nums[i];
		}
		return nums[0];
	}


	/**
	 * 异或
	 *
	 * @param nums
	 * @return
	 */
	public int singleNumber0(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}


	/**
	 * 此解法用额外空间
	 *
	 * @param nums
	 * @return
	 */
	public int singleNumber1(int[] nums) {
		//还没想到不用额外空间，暂时使用额外空间
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
		return set.iterator().next();
	}
}
