package me.zoro.redline.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020-05-03 22:36
 */
@DisplayName("最长公共子序列")
public class Leetcode1143Test {

	@DisplayName("递归暴力破解")
	@Test
	public void longestCommonSubsequenceTest() {
		String text1 = null;
		String text2 = null;
		String result = null;
		Leetcode1143 solution = new Leetcode1143();

		text1 = "pmjghexybyrgzczy";
		text2 = "hafcdqbgncrcbihkd";
		result = "";
		System.out.println(solution.longestCommonSubsequence(text1, text2));
	}
}
