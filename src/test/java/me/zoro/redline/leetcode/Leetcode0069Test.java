package me.zoro.redline.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020-05-09 17:07
 */
@DisplayName("题69:计算并返回 x 的平方根")
public class Leetcode0069Test {

	@Test
	@DisplayName("暴力破解")
	public void mySqrt0Test() {

		Leetcode0069 solution = new Leetcode0069();
		assertEquals(0, solution.mySqrt0(0));
		assertEquals(1, solution.mySqrt0(1));
		assertEquals(1, solution.mySqrt0(2));
		assertEquals(2, solution.mySqrt0(4));
		assertEquals(2, solution.mySqrt0(8));
		assertEquals(3, solution.mySqrt0(9));

	}

	@Test
	@DisplayName("适当优化")
	public void mySqrtTest() {

		Leetcode0069 solution = new Leetcode0069();
		assertEquals(0, solution.mySqrt(0));
		assertEquals(1, solution.mySqrt(1));
		assertEquals(1, solution.mySqrt(2));
		assertEquals(2, solution.mySqrt(4));
		assertEquals(2, solution.mySqrt(8));
		assertEquals(3, solution.mySqrt(9));
		assertEquals(46339, solution.mySqrt(2147395599));

	}
}
