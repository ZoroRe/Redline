package me.zoro.redline.leetcode;

/**
 * @author luguanquan
 * @date 2020-05-03 22:33
 * <p>
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1143 {


	/**
	 * 动态规划
	 * 动态规划重要的就是确定状态转移方程，在本例中，比较两个字符串的最后一个字母，一旦相等，那这答案就是各自字符串减去最后一个后的公共子序列长度+1
	 * 一旦不是，这时候状态转移就是 text1去除最后一个字符和 text2 的最长公共子序列 以及 text1 和 text2去除最后一个字符串的最长公共子序列之间最长者
	 *
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence_0(String text1, String text2) {
		if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
			return 0;
		}
		int len1 = text1.length();
		int len2 = text2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[len1][len2];
	}

	/**
	 * 递归暴力破解
	 * <p>
	 * 在leetcode 时间超时，自己也没写完全部测试用例，未必通过
	 *
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
			return 0;
		}
		int last1 = text1.length() - 1;
		int last2 = text2.length() - 1;
		String nextText1 = text1.substring(0, last1);
		String nextText2 = text2.substring(0, last2);
		if (text1.charAt(last1) == text2.charAt(last2)) {
			return longestCommonSubsequence(nextText1, nextText2) + 1;
		}
		return Math.max(longestCommonSubsequence(text1, nextText2), longestCommonSubsequence(nextText1, text2));
	}
}
