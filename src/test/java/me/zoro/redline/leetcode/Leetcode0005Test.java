package me.zoro.redline.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020-05-02 18:18
 */
@DisplayName("题5:最长回文字符串")
public class Leetcode0005Test {

	@DisplayName("中心扩散法")
	@Test
	public void longestPalingrome_2Test() {
		Leetcode0005 solution = new Leetcode0005();
		String s = null;
		String result = null;

		s = "abba";
		result = "abba";
		assertEquals(result, solution.longestPalingrome_2(s));

		s = "abbaa";
		result = "abba";
		assertEquals(result, solution.longestPalingrome_2(s));
	}
}
