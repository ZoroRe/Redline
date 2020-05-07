package me.zoro.redline.leetcode;

/**
 * @author luguanquan
 * @date 2020-05-07 19:27
 *
 * 983.最低票价
 *
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode0983 {

	public int mincostTickets(int[] days, int[] costs) {
		if( days == null || days.length == 0){
			return 0;
		}
		int endDay = days[days.length - 1];
		int startDay = days[0];
		//dp[i] 表示一年中第 i 和开始到本年结束一共需要花费多少旅行,加31是避免溢出，后面溢出的值都是0不影响取值
		int[] dp = new int[endDay + 31];
		int dpCosts1 = 0;
		int dpCosts2 = 0;
		int dpCosts3 = 0;
		int dayIndex = days.length - 1;
		for(int i = endDay; i >= startDay; i--){
			if(i == days[dayIndex]){
				dpCosts1 = dp[i + 1] + costs[0];
				dpCosts2 = dp[i + 7] + costs[1];
				dpCosts3 = dp[i + 30] + costs[2];
				//第 i 天最小花费
				dp[i] = Math.min(Math.min(dpCosts1, dpCosts2), dpCosts3);
				dayIndex --;
			}else{
				//不需要出门的,那这天花费就相当于下一天的花费
				dp[i] = dp[i + 1];
			}
		}
		return dp[startDay];
	}
}
