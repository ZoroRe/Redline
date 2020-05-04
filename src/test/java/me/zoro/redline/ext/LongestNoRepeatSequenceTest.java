package me.zoro.redline.ext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020-05-04 00:25
 */
@DisplayName("最长无重复子串")
public class LongestNoRepeatSequenceTest {

	@DisplayName("使用Set解决")
	@Test
	public void findTest() {
		String s = null;
		String result = null;
		LongestNoRepeatSequence solution = new LongestNoRepeatSequence();

		s = "abc";
		result = "abc";
		assertEquals(result, solution.find(s));

		s = "aaaaaaaa";
		result = "a";
		assertEquals(result, solution.find(s));

		s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		result = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		assertEquals(result, solution.find(s));

		s = "abbbbbbba";
		result = "ab";
		assertEquals(result, solution.find(s));

		s = "abccbaxyzabc";
		result = "cbaxyz";
		assertEquals(result, solution.find(s));

		s = "abbc";
		result = "ab";
		assertEquals(result, solution.find(s));

		s = "abcccc";
		result = "abc";
		assertEquals(result, solution.find(s));

	}
}
