package me.zoro.redline.leetcode;

/**
 * @author luguanquan
 * @date 2020/5/21 6:42 上午
 * <p>
 * 1371. 每个元音包含偶数次的最长子字符串
 * <p>
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 示例 2：
 * <p>
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 示例 3：
 * <p>
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1371 {

	/**
	 * 看题解才会系列=。=！本答案参见的是: https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even
	 * -counts/solution/xiang-xi-jie-shi-by-will_never_die/
	 * 这个题解可能是答案里最容易理解的，其他答案可能说明涉及知识点：前缀和 + 状态压缩
	 * <p>
	 * 这个重要的一个思路，1是遇到这种奇偶变化的，首先考虑能否利用异或处理
	 * 每一种包含一定数目奇数元音的，我们只需要记住它第一次出现的时候就好，第二次出现异或后它进入另一种状态，只有再异或回来才需要更新这种情况下他的作态
	 *
	 * @param s
	 * @return
	 */
	public int findTheLongestSubstring(String s) {
		int[] dp = new int[32];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		dp[0] = -1;
		int pattern = 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case 'a':
					pattern ^= (1 << 0);
					break;
				case 'e':
					pattern ^= (1 << 1);
					break;
				case 'i':
					pattern ^= (1 << 2);
					break;
				case 'o':
					pattern ^= (1 << 3);
					break;
				case 'u':
					pattern ^= (1 << 4);
					break;
				default:
					break;
			}
			if (dp[pattern] != Integer.MIN_VALUE) {
				res = Math.max(res, i - dp[pattern]);
			} else {
				//只需要记录这种情况第一次出现的位置，下次再出现就直接是更新两者之间的最大长度
				dp[pattern] = i;
			}

		}
		return res;
	}
}
