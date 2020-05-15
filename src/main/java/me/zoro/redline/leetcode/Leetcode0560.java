package me.zoro.redline.leetcode;

/**
 * @author luguanquan
 * @date 2020/5/15 10:55 下午
 * <p>
 * 560. 和为K的子数组
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 通过次数46,080提交次数104,476
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode0560 {

	/**
	 * 暴力破解可通过但时间效率都低
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		int current = 0;
		int count = 0;
		// 因为有负数，所以可能前面和大于k后面加上负数就可以等于,这里用暴力破解
		for (int i = 0; i < nums.length; i++) {
			current = 0;
			for (int j = i; j < nums.length; j++) {
				current += nums[j];
				if (current == k) {
					count++;
				}
			}
		}
		return count;
	}


	/**
	 * dp 计算所有总和并存储，超出内存限制
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum0(int[] nums, int k) {
		// 直接计算全部从i到j子数组的和，此方法到测试用例58就报超出内存限制
		int[][] dp = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i][i] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				dp[i][j] = dp[i][j - 1] + nums[j];
			}
		}
		int count = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp[0].length; j++) {
				if (dp[i][j] == k) {
					count++;
				}
			}
		}
		return count;
	}
}
