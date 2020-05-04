package me.zoro.redline.ext;

/**
 * @author luguanquan
 * @date 2020-05-04 10:16
 * <p>
 * 十进制转62进制，作用，可以考虑一些短域名方案。给域名存数据库给定一个 id,将此id转62进制，6位(62的6次方，有五百六十亿)就足以
 */
public class DecimalTo62 {
	final static char[] NUMBERS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z'};

	public String convert(long number) {
		StringBuilder builder = new StringBuilder();
		do {
			builder.append(NUMBERS[(int) (number % NUMBERS.length)]);
			number = number / NUMBERS.length;
		} while (number > 0);
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		DecimalTo62 solution = new DecimalTo62();
		System.out.println(solution.convert(0));
		System.out.println(solution.convert(1));
		System.out.println(solution.convert(61));
		System.out.println(solution.convert(62));
		System.out.println(solution.convert(63));
	}

}
