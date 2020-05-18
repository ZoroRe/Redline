package me.zoro.redline.leetcode;

/**
 * @author luguanquan
 * @date 2020/5/18 8:44 下午
 *
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode0152 {

	public int maxProduct(int[] nums) {

		int max = nums[0];
		int cur;
		for(int i = 0; i < nums.length; i++){
			cur = nums[i];
			if(cur > max){
				max = cur;
			}
			for(int j = i + 1;j < nums.length; j++){
				cur = cur * nums[j];
				if(cur > max){
					max = cur;
				}
			}
		}
		return max;
	}
}
