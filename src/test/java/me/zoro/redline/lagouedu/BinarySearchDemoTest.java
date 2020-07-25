package me.zoro.redline.lagouedu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020/7/25 11:05 下午
 */
@DisplayName("二分查找的一个变型使用`")
public class BinarySearchDemoTest {

	@Test
	public void solutionTest() {
		BinarySearchDemo binarySearchDemo = new BinarySearchDemo();
		int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
		assertEquals(4, binarySearchDemo.solution(arr, 0));
		assertEquals(5, binarySearchDemo.solution(arr, 1));
		assertEquals(6, binarySearchDemo.solution(arr, 2));
		assertEquals(-1, binarySearchDemo.solution(arr, 3));
		assertEquals(0, binarySearchDemo.solution(arr, 4));
		assertEquals(1, binarySearchDemo.solution(arr, 5));
		assertEquals(2, binarySearchDemo.solution(arr, 6));
		assertEquals(3, binarySearchDemo.solution(arr, 7));
		assertEquals(-1, binarySearchDemo.solution(arr, 8));

	}
}
