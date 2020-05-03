package me.zoro.redline.ext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020-05-03 17:39
 */
@DisplayName("最长有效括号")
public class LongestValidParenthesesTest {

	@DisplayName("栈方案")
	@Test
	public void findTest() {
		String s = null;
		String result = null;
		LongestValidParentheses solution = new LongestValidParentheses();

		s = "(()))";
		result = "(())";
		assertEquals(result, solution.find(s));

		s = ")))(()))";
		result = "(())";
		assertEquals(result, solution.find(s));

		s = ")))))";
		result = "";
		assertEquals(result, solution.find(s));

		s = "()()((()))()";
		result = "()()((()))()";
		assertEquals(result, solution.find(s));
	}
}
