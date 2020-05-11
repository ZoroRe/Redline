package me.zoro.redline.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author luguanquan
 * @date 2020-05-11 21:40
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 通过次数95,508提交次数215,683
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Leetcode0300 {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int i = 0;
		// 方便打日志看变化
		int oldI = 0;
		int length = 0;
		for (int num : nums) {
			// 传入的 dp 从 fromIndex-toIndex 必须是已排好序的,如果传入的值比dp都小，返回-1，如果比dp都大，返回 -[length + 1]
			// 【length从 fromIndex 到 toIndex 的总数量】,如果在中间，返回它应该插入的位置,这样在在比如[1,3]序列遇到2,
			// 自增序列变成【1，2】自动替换为同长度更小的值，从而最终得到最长自增序列
			i = Arrays.binarySearch(dp, 0, length, num);
			oldI = i;
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == length) {
				length++;
			}
			log.info("oldI={},i={},num={},dp={}", oldI, i, num, dp);
		}
		return length;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 6, 2, 9, 3, 7, 4, 5};
		Leetcode0300 solution = new Leetcode0300();
		log.info("result:{}", solution.lengthOfLIS(nums));
	}
}
