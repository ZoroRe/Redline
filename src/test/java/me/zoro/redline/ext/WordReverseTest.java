package me.zoro.redline.ext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author luguanquan
 * @date 2020-05-04 12:14
 */
@DisplayName("单词反转")
public class WordReverseTest {


	@DisplayName("StringBuilder 辅助")
	@Test
	public void reverseTest() {
		WordReverse solution = new WordReverse();

		List<String> source = new ArrayList<>();
		List<String> result = new ArrayList<>();
		source.add("hello world");
		result.add("olleh dlrow");

		source.add(" hello world");
		result.add(" olleh dlrow");

		source.add("hello world ");
		result.add("olleh dlrow ");

		source.add(" hello world ");
		result.add(" olleh dlrow ");

		for (int i = 0; i < source.size(); i++) {
			assertEquals(result.get(i), solution.reverse(source.get(i)));
		}
	}

	@DisplayName("stack方式")
	@Test
	public void reverse_0Test() {
		WordReverse solution = new WordReverse();

		List<String> source = new ArrayList<>();
		List<String> result = new ArrayList<>();
		source.add("hello world");
		result.add("olleh dlrow");

		source.add(" hello world");
		result.add(" olleh dlrow");

		source.add("hello world ");
		result.add("olleh dlrow ");

		source.add(" hello world ");
		result.add(" olleh dlrow ");

		for (int i = 0; i < source.size(); i++) {
			assertEquals(result.get(i), solution.reverse_0(source.get(i)));
		}
	}
}
