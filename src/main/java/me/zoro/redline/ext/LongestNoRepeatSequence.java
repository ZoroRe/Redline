package me.zoro.redline.ext;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luguanquan
 * @date 2020-05-04 00:10
 * <p>
 * 最长无重复子串
 */
public class LongestNoRepeatSequence {

	public String find(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		Set<Character> set = new HashSet<>();
		int start = 0;
		int curStart = 0;
		int max = 0;
		int last = s.length() - 1;
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (set.contains(c)) {
				if (set.size() > max) {
					start = curStart;
					max = set.size();
				}
				// 遇到有重复字符，要重修修改起止值
				for (int j = curStart; j < i; j++) {
					if (s.charAt(j) == c) {
						curStart = j + 1;
						break;
					}
					set.remove(s.charAt(j));
				}
			} else {
				set.add(c);
				if (i == last && set.size() > max) {
					max = set.size();
					start = curStart;
				}
			}
		}
		return s.substring(start, start + max);
	}

	public static void main(String[] args) {
		LongestNoRepeatSequence solution = new LongestNoRepeatSequence();
		System.out.println("result is : " + solution.find("abccbaxyzabc"));
	}
}
